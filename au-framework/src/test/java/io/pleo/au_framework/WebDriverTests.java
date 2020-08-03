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
package io.pleo.au_framework;

import io.appium.java_client.android.AndroidDriver;
import io.pleo.au_framework.core.DriverManager;
import io.pleo.au_framework.data.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/** A class that hosts all the unit test cases for working with WebDrivers. */
public class WebDriverTests {

  @Test
  public void androidLocalWebDriverTest() {
    System.setProperty(Constants.DRIVER_CONFIG_PROPERTY_NAME, Constants.LOCAL_SONY_PHONE_FILE_NAME);
    WebDriver driver = DriverManager.getInstance().getDriver();
    Assert.assertTrue(driver instanceof AndroidDriver, Constants.INCORRECT_WEBDRIVER_TYPE_MESSAGE);
  }
}
