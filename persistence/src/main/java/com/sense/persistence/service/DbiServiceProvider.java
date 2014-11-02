/**
 * @preserve Copyright (c) 2014 Home Box Office, Inc. as an unpublished
 * work. Neither this material nor any portion hereof may be copied or
 * distributed without the express written consent of Home Box Office, Inc.
 *
 * This material also contains proprietary and confidential information
 * of Home Box Office, Inc. and its suppliers, and may not be used by or
 * disclosed to any person, in whole or in part, without the prior written
 * consent of Home Box Office, Inc.
 */
package com.sense.persistence.service;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.skife.jdbi.v2.DBI;

/**
 * Class using to encapulate DB interaction using JDBI framework.
 * <p>
 * Created by benochso.
 */
@Slf4j
public class DbiServiceProvider implements DbService {

    @Inject
    private DBI dbi;

    @Inject
    public DbiServiceProvider() {
    }

    protected DBI getDBI() {
        return dbi;
    }

    /*
    @Override
    public PropertyDao getPropertyDao() {
        DBI dbi = getDBI();
        return dbi.open(PropertyDao.class);
    }
*/
 }
