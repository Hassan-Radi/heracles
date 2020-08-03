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
package io.pleo.data;

/** A class to host all the public constants */
public class Constants {
  // files
  public static final String LOCAL_SONY_PHONE_FILE_NAME = "local-sony-xperia-z5-premium.json";

  // test data
  public static final String INPUT_1 = "2310000.159897";
  public static final String OUTPUT_1 = "2 310 000.16";

  // Messages
  public static final String STARTING_NEW_TEST =
      "Starting a new test. Instantiating a new WebDriver instance..";
  public static final String TEAR_DOWN_CURRENT_TEST =
      "Tearing down the current test. Terminating any existing WebDrivers...";
  public static final String WEBDRIVER_INSTANCE_TERMINATED =
      "WebDriver instance has been terminated. Test tear down is complete.";
  public static final String TESTING_VALUES_MESSAGE =
      "Testing the following pair of values [Input: %s, Output: %s].";
  public static final String TYPING_TEXT_MESSAGE = "Typing text [%s]...";
  public static final String VALUES_DONT_MATCH_MESSAGE = "Values don't match.";
  public static final String TEXT_VALUE_FROM_LABEL =
      "Fetched the following value from the money formatted label [%s].";
}
