/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.testsuite.ui.test.settings;

import org.junit.Before;
import org.junit.Test;
import org.keycloak.testsuite.ui.AbstractKeyCloakTest;
import org.keycloak.testsuite.ui.model.Theme;
import org.keycloak.testsuite.ui.page.settings.ThemesSettingsPage;


/**
 *
 * @author Filip Kiss
 */
public class ThemesSettingsTest extends AbstractKeyCloakTest<ThemesSettingsPage> {

    @Before
    public void beforeThemeTest() {
        navigation.themes();
    }

    @Test
    public void changeLoginThemeTest() {
        page.changeLoginTheme(Theme.BASE.getName());
        page.saveTheme();
        logOut();
        page.verifyBaseTheme();

        loginAsAdmin();
        navigation.themes();
        page.changeLoginTheme(Theme.KEYCLOAK.getName());
        page.saveTheme();
        logOut();
        page.verifyKeycloakTheme();

        loginAsAdmin();
    }

}