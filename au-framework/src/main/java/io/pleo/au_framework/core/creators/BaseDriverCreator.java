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

import io.pleo.au_framework.data.Constants;
import io.pleo.au_framework.data.JsonConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * An abstract class that provides some of the common implementation needed to create WebDrivers.
 * This is the base class that should be extended by all the concrete WebDriver creators.
 */
public abstract class BaseDriverCreator implements DriverCreator {

  private static final Logger LOGGER = LogManager.getLogger(BaseDriverCreator.class);
  protected DriverCreator nextCreator;

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
    if (nextCreator != null) {
      return nextCreator.createDriver(jsonConfig);
    }
    throw new RuntimeException(Constants.WEBDRIVER_NOT_SUPPORTED_MESSAGE);
  }

  /**
   * Links the current WebDriver creator to another one that comes after it. This linkage is
   * necessary to create the chain of responsibility of all the supported creators by the automation
   * framework.
   *
   * @param driverCreator A reference to another WebDriver creator.
   */
  @Override
  public void setNext(DriverCreator driverCreator) {
    LOGGER.debug(
        String.format(
            Constants.ADDING_NEW_WEBDRIVER_CREATOR_MESSAGE,
            driverCreator.getClass().getSimpleName()));
    this.nextCreator = driverCreator;
  }

  /**
   * Logs the session ID of the created session. This session ID is a unique identifier that can be
   * used to refer to this session later on.
   *
   * @param driver The currently running WebDriver instance to fetch the session ID from.
   */
  protected void logSessionID(WebDriver driver) {
    LOGGER.info(
        String.format(
            Constants.SESSION_ID_MESSAGE, ((RemoteWebDriver) driver).getSessionId().toString()));
  }
}
