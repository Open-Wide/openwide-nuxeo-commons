/*******************************************************************************
 * (C) Copyright 2013 Open Wide (http://www.openwide.fr/) and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 ******************************************************************************/
package fr.openwide.nuxeo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import com.google.inject.Inject;

/**
 * 
 * @author mkalam-alami
 *
 */
@RunWith(FeaturesRunner.class)
@Features(PlatformFeature.class)
public class AbstractNuxeoTest {

    @Inject
    protected CoreSession documentManager;

    protected RepositoryLogger repositoryLogger;

    protected static boolean logRepositoryAfterEachTest = true;

    @Rule
    public TestName name = new TestName();

    @Before
    public void setUpAbstractNuxeoTest() {
        repositoryLogger = new RepositoryLogger(documentManager);
    }

    @After
    public void logRepository() throws ClientException {
        if (logRepositoryAfterEachTest) {
            documentManager.save();
            repositoryLogger.logAllRepository(name.getMethodName());
        }
    }

    public static void setLogRepositoryAfterEachTest(boolean logRepositoryAfterEachTest) {
        AbstractNuxeoTest.logRepositoryAfterEachTest = logRepositoryAfterEachTest;
    }

}