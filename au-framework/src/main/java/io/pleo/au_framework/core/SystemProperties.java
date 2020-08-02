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
package io.pleo.au_framework.core;

import io.pleo.au_framework.data.Constants;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Responsible for acting as a single point of access to the declared system properties. All the
 * declared system properties will live in this class, that's why one instance of it can exist.
 */
public class SystemProperties {

  private static final Logger LOGGER = LogManager.getLogger(SystemProperties.class);
  @Getter private static String driverConfig;

  /** The constructor is made private, so no one can create an instance of this class. */
  private SystemProperties() {}

  /**
   * Fetch all the declared system properties before you do anything else. This is only done for the
   * mandatory ones; if the system property is optional, it shouldn't be fetched here.
   */
  static {
    initialiseDriverConfig();
  }

  /** Fetches the declared driverConfig system property value and stores it to be used later on. */
  private static void initialiseDriverConfig() {
    driverConfig = System.getProperty(Constants.DRIVER_CONFIG_PROPERTY_NAME);

    /**
     * This is a mandatory system property, which means that if the user didn't provide it, we need
     * to halt the execution as we can't move on without it.
     */
    if (driverConfig == null) {
      throw new RuntimeException(
          String.format(
              Constants.MANDATORY_SYSTEM_PROPERTY_NOT_DECLARED_MESSAGE,
              Constants.DRIVER_CONFIG_PROPERTY_NAME));
    }
    LOGGER.debug(
        String.format(
            Constants.FOUND_SYSTEM_PROPERTY_MESSAGE,
            Constants.DRIVER_CONFIG_PROPERTY_NAME,
            driverConfig));
  }
}
