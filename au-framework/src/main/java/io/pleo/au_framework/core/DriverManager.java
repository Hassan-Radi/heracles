/**
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
package io.pleo.au_framework.core;

import io.pleo.au_framework.core.creators.AndroidLocalDriverCreator;
import io.pleo.au_framework.core.creators.DriverCreator;
import io.pleo.au_framework.core.creators.IOSLocalDriverCreator;
import io.pleo.au_framework.data.Constants;
import io.pleo.au_framework.data.JsonConfig;
import io.pleo.au_framework.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Responsible for acting as a single point of access to the instantiated WebDriver instance. This
 * class is implemented using the Singleton design pattern as one single WebDriver instance can
 * exist at any point in time within the code.
 */
public class DriverManager {

  private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
  private static DriverManager instance;
  private WebDriver driver;

  /** The constructor is made private, so no one can create an instance of this class. */
  private DriverManager() {}

  /**
   * Returns an instance of this class if it already exists, otherwise it creates a new one. The
   * instance can be used later on to access other methods implemented by this class.
   *
   * @return An instance of DriverManager.
   */
  public static DriverManager getInstance() {
    if (instance == null) {
      return new DriverManager();
    }
    return instance;
  }

  /**
   * Returns the WebDriver instance that is currently running or creates a new one if none exists.
   * Keep in mind that only one single WebDriver instance can exist at any point in time.
   *
   * @return A WebDriver instance that represents the platform we are currently executing on.
   */
  public WebDriver getDriver() {
    if (driver == null) {
      // create the driver instance by calling the chain of responsibility
      LOGGER.debug(Constants.NO_WEBDRIVER_IS_CREATED_YET_MESSAGE);

      // fetch the driver config information
      JsonConfig jsonConfig =
          JsonUtils.readJson(
              DriverManager.class
                  .getClassLoader()
                  .getResource(SystemProperties.getDriverConfig())
                  .getPath());
      driver = createChainOfResponsibility().createDriver(jsonConfig);
    } else {
      // driver is already created, just return it
      LOGGER.debug(Constants.WEBDRIVER_INSTANCE_EXISTS_MESSAGE);
    }

    return driver;
  }

  /**
   * Creates the chain of responsibility and then returns a reference to the first item in the
   * chain.
   *
   * @return A reference to the first DriverCreator.
   */
  private static DriverCreator createChainOfResponsibility() {
    // create the chain
    LOGGER.debug(Constants.BUILDING_WEBDRIVER_CREATORS_CHAIN_MESSAGE);
    AndroidLocalDriverCreator androidLocalDriverCreator = new AndroidLocalDriverCreator();
    IOSLocalDriverCreator iosLocalDriverCreator = new IOSLocalDriverCreator();

    LOGGER.debug(
        String.format(
            Constants.ADDED_FIRST_WEBDRIVER_CREATOR_MESSAGE,
            AndroidLocalDriverCreator.class.getSimpleName()));
    androidLocalDriverCreator.setNext(iosLocalDriverCreator);

    // return a reference to the first item
    LOGGER.debug(Constants.CHAIN_CREATION_IS_COMPLETE_MESSAGE);
    return androidLocalDriverCreator;
  }
}
