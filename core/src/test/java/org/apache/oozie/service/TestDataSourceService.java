/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.oozie.service;

import org.apache.oozie.test.XTestCase;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestDataSourceService extends XTestCase {

    public void testDataSource() throws Exception {
        Services services = new Services();
        services.init();
        assertNotNull(services.get(DataSourceService.class));
        services.destroy();
    }

    public void testRawConnection() throws Exception {
        Services services = new Services();
        services.init();
        assertNotNull(services.get(DataSourceService.class));
        Connection conn = services.get(DataSourceService.class).getRawConnection();
        assertNotNull(conn);
        conn.close();
        services.destroy();
    }

    public void testManageConnection() throws Exception {
        Services services = new Services();
        services.init();
        assertNotNull(services.get(DataSourceService.class));
        Connection conn = services.get(DataSourceService.class).getConnection();
        assertNotNull(conn);
        conn.close();
        services.destroy();
    }
}
