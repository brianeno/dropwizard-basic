package com.sense.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sense.common.util.SenseEnv;
import com.sense.persistence.core.Template;
import com.sense.persistence.dao.PropertyDao;
import com.sense.server.auth.SenseAuthenticator;
import com.sense.server.cli.RenderCommand;
import com.sense.server.filter.RequestIdFilter;
import com.sense.server.filter.ResponseIdFilter;
import com.sense.server.filter.SecurityFilter;
import com.sense.server.health.TemplateHealthCheck;
import com.sense.server.module.DaoFactory;
import com.sense.server.module.SenseModule;
import com.sense.server.resources.DomainResource;
import com.sense.server.resources.PropertyResource;
import com.sense.service.service.PropertyService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import lombok.extern.slf4j.Slf4j;
import org.skife.jdbi.v2.DBI;

@Slf4j
public class SenseApplication extends Application<SenseConfiguration> {

    private static SenseEnv senseEnv;
    private Injector senseInjector;

    public static void main(String[] args) throws Exception {
        senseEnv = getSenseEnv(args);
        args = new String[] {args[0], args[1]};
        new SenseApplication().run(args);
    }

    /**
     * Get environment.
     *
     * @param args
     * @return
     */
    private static SenseEnv getSenseEnv(String[] args) {

        // At least 1 parameter. first parameter is environment information.
        //TODO(PARSER) add a command line parser
        if (args == null || args.length < 3) {
            log.error("At least 3 parameters required for application, third should be environment");
            return null;
        }
        String env = args[2].toUpperCase();
        SenseEnv senseEnv = SenseEnv.valueOf(env);
        return senseEnv;
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SenseConfiguration> bootstrap) {
        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());

        bootstrap.addBundle(new MigrationsBundle<SenseConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SenseConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(SenseConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final Template template = configuration.buildTemplate();

        final DBIFactory factory = new DBIFactory();

        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        final PropertyDao propertyDao = jdbi.onDemand(PropertyDao.class);

        DaoFactory daoFactory = new DaoFactory(propertyDao);
        if (senseInjector == null) {
            senseInjector = Guice.createInjector(new SenseModule(senseEnv, daoFactory));
        }

        environment.healthChecks().register("template", new TemplateHealthCheck(template));

        environment.jersey().register(new DomainResource());
        environment.jersey().register(new PropertyResource(senseInjector.getInstance(PropertyService.class)));

        environment.jersey().register(new BasicAuthProvider<>(new SenseAuthenticator(), null));
        environment.jersey().getResourceConfig().getContainerRequestFilters().add(new SecurityFilter());
        environment.jersey().getResourceConfig().getContainerRequestFilters().add(new RequestIdFilter());
        environment.jersey().getResourceConfig().getContainerResponseFilters().add(new ResponseIdFilter());
    }
}
