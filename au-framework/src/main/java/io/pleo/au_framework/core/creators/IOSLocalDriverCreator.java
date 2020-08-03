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
package io.pleo.au_framework.core.creators;

import io.appium.java_client.ios.IOSDriver;
import io.pleo.au_framework.data.Constants;
import io.pleo.au_framework.data.JsonConfig;
import io.pleo.au_framework.enums.ExecutionMode;
import io.pleo.au_framework.enums.Platform;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/** A concrete class that can create local iOS WebDrivers only. */
public class IOSLocalDriverCreator extends BaseDriverCreator {

  private static final Logger LOGGER = LogManager.getLogger(IOSLocalDriverCreator.class);

  /**
   * Each creator checks whether it can process the WebDriver creation request when you call this
   * method; If it can create the WebDriver, it consumes the request, otherwise it passes it to the
   * next creator in the chain of responsibility.
   *
   * @param jsonConfig The JSON file that contains all the necessary information to create the
   *     WebDriver.
   * @return A WebDriver instance.
   */
  @Override
  public WebDriver createDriver(JsonConfig jsonConfig) {
    WebDriver driver;

    LOGGER.debug(Constants.GOT_NEW_CREATE_WEBDRIVER_REQUEST_MESSAGE);
    if (jsonConfig.getExecutionMode().equals(ExecutionMode.LOCAL)
        && jsonConfig.getPlatform().equals(Platform.IOS)) {
      try {
        driver =
            new IOSDriver(new URL(Constants.LOCAL_APPIUM_DRIVER_URL), jsonConfig.getCapabilities());
      } catch (Exception e) {
        throw new RuntimeException(
            String.format(
                Constants.EXCEPTION_THROWN_WHILE_CREATING_WEBDRIVER_MESSAGE,
                ExceptionUtils.getStackTrace(e)));
      }
      LOGGER.debug(
          String.format(
              Constants.WEBDRIVER_CREATED_SUCCESSFULLY_MESSAGE, Platform.IOS, ExecutionMode.LOCAL));
      logSessionID(driver);
      return driver;
    } else {
      LOGGER.debug(Constants.COULD_NOT_PROCESS_WEBDRIVER_REQUEST_MESSAGE);
      return super.createDriver(jsonConfig);
    }
  }
}
