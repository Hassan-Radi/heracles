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
package io.pleo.au_framework.data;

/** A class to host all the public constants that are shared within the automation framework. */
public class Constants {
  // files
  public static final String LOCAL_SONY_PHONE_FILE_NAME = "local-sony-xperia-z5-premium.json";

  // messages
  public static final String NO_WEBDRIVER_IS_CREATED_YET =
      "No WebDriver instance is created yet. Starting to create a new one...";
  public static final String WEBDRIVER_INSTANCE_EXISTS =
      "An instance of WebDriver already exists, using it...";
  public static final String FAILED_TO_READ_JSON_FILE =
      "Failed to read the Json file. Exception: %s";
  public static final String VALUES_DONT_MATCH = "Values don't match.";
  public static final String MANDATORY_SYSTEM_PROPERTY_NOT_DECLARED_MESSAGE =
      "The mandatory system property [%s] wasn't declared. Stopping execution...";
  public static final String FOUND_SYSTEM_PROPERTY_MESSAGE = "Found a system property [%s = %s].";

  // System properties
  public static final String DRIVER_CONFIG_PROPERTY_NAME = "driverConfig";
}
