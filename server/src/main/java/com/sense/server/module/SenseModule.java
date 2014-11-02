package com.sense.server.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.sense.common.annotation.AuditMethod;
import com.sense.common.annotation.TransactionLogMethod;
import com.sense.common.util.AuditInterceptor;
import com.sense.common.util.SenseEnv;
import com.sense.common.util.TransactionLogInterceptor;
import com.sense.persistence.dao.PropertyDao;
import com.sense.server.SenseConfiguration;
import com.sense.service.service.PropertyService;
import com.sense.service.service.PropertyServiceImpl;
import io.dropwizard.db.DataSourceFactory;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by brianenochson.
 */
@Slf4j
public class SenseModule extends AbstractModule {

    private SenseEnv senseEnv;
    private Properties properties;
    private final DaoFactory daoFactory;

    public SenseModule(SenseEnv senseEnv, DaoFactory daoFactory) {

        this.senseEnv = senseEnv;
        //this.dbi = dbi;
        this.daoFactory = daoFactory;
    }

    @Override
    protected void configure() {
        loadProperties();
        Names.bindProperties(binder(), properties);
        bind(PropertyService.class).to(PropertyServiceImpl.class);
        bind(PropertyDao.class).toInstance(daoFactory.getPropertyDao());
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(AuditMethod.class),
                new AuditInterceptor());
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(TransactionLogMethod.class),
                new TransactionLogInterceptor());
    }

    @SneakyThrows(IOException.class)
    private void loadProperties() {
        this.properties = new Properties();
        String propName = "props/" + this.senseEnv.toString().toLowerCase()
                + "-sense.properties";
        @Cleanup InputStream is = SenseModule.class.getClassLoader().getResourceAsStream(propName);
        this.properties.load(is);
    }

    @Provides
    @Named("template")
    public String provideTemplate(SenseConfiguration configuration) {
        return configuration.getTemplate();
    }

    @Provides
    @Named("defaultName")
    public String provideDefaultName(SenseConfiguration configuration) {
        return configuration.getDefaultName();
    }

    @Provides
    @Named("database")
    public DataSourceFactory provideDatabase(SenseConfiguration configuration) {
        return configuration.getDataSourceFactory();
    }
}
