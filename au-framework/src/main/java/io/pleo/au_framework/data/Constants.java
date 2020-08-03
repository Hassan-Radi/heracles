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
  public static final String NO_WEBDRIVER_IS_CREATED_YET_MESSAGE =
      "No WebDriver instance has been created yet. Attempting to create a new one...";
  public static final String WEBDRIVER_INSTANCE_EXISTS_MESSAGE =
      "An instance of WebDriver already exists, using it...";
  public static final String FAILED_TO_READ_JSON_FILE_MESSAGE =
      "Failed to read the Json file. Exception: %s";
  public static final String VALUES_DONT_MATCH_MESSAGE = "Values don't match.";
  public static final String MANDATORY_SYSTEM_PROPERTY_NOT_DECLARED_MESSAGE =
      "The mandatory system property [%s] wasn't declared. Stopping execution...";
  public static final String FOUND_SYSTEM_PROPERTY_MESSAGE = "Found a system property [%s = %s].";
  public static final String WEBDRIVER_NOT_SUPPORTED_MESSAGE =
      "Failed to find a suitable WebDriver creator to handle the request. The requested WebDriver is probably not supported yet!";
  public static final String ADDING_NEW_WEBDRIVER_CREATOR_MESSAGE =
      "Added another WebDriver creator to the chain [%s]...";
  public static final String ADDED_FIRST_WEBDRIVER_CREATOR_MESSAGE =
      "Added the first WebDriver creator to the chain [%s]...";
  public static final String GOT_NEW_CREATE_WEBDRIVER_REQUEST_MESSAGE =
      "Got a request to create a new WebDriver. Checking if the request can be handled...";
  public static final String SESSION_ID_MESSAGE = "Session ID: %s";
  public static final String EXCEPTION_THROWN_WHILE_CREATING_WEBDRIVER_MESSAGE =
      "An exception was thrown while attempting to create the WebDriver.\nException: %s";
  public static final String COULD_NOT_PROCESS_WEBDRIVER_REQUEST_MESSAGE =
      "Couldn't process this request to create the WebDriver. Passing it to the next item in the chain...";
  public static final String WEBDRIVER_CREATED_SUCCESSFULLY_MESSAGE =
      "An instance of [%s, %s] WebDriver has been created successfully.";
  public static final String INCORRECT_WEBDRIVER_TYPE_MESSAGE =
      "Incorrect WebDriver type returned.";
  public static final String BUILDING_WEBDRIVER_CREATORS_CHAIN_MESSAGE =
      "Started to build the WebDriver's creators chain...";
  public static final String CHAIN_CREATION_IS_COMPLETE_MESSAGE =
      "Chain creation is complete. Returning reference to the first item in the chain...";

  // System properties
  public static final String DRIVER_CONFIG_PROPERTY_NAME = "driverConfig";

  // Hub URLs
  public static final String LOCAL_APPIUM_DRIVER_URL = "http://localhost:4723/wd/hub";
}
