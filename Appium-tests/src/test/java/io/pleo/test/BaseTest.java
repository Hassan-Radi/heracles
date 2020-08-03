/*
 * Copyright (c) 2020 Hassan Radi
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * <p>See the License for the specific language governing permissions and limitations under the
 * License.
 */

package io.pleo.test;

import io.pleo.au_framework.core.DriverManager;
import io.pleo.data.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/** A base test class to contain the necessary setup/teardown needed to get the code to work. */
public class BaseTest {

  private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
  protected WebDriver webdriver;

  @BeforeMethod
  public void setup() {
    LOGGER.info(Constants.STARTING_NEW_TEST);
    webdriver = DriverManager.getInstance().getDriver();
  }

  @AfterMethod
  public void tearDown() {
    LOGGER.info(Constants.TEAR_DOWN_CURRENT_TEST);
    if (webdriver != null) {
      webdriver.quit();
      LOGGER.info(Constants.WEBDRIVER_INSTANCE_TERMINATED);
    }
  }
}
