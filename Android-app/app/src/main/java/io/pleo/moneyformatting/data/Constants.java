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
package io.pleo.moneyformatting.data;

public class Constants {
  // test data
  public static final String TEST_INPUT_1 = "1458.789";
  public static final String TEST_OUTPUT_1 = "1 458.79";
  public static final String TEST_INVALID_INPUT_1 = "qwerty";

  // messages
  public static final String INCORRECT_INPUT_VALUE = "The value provided is not a valid number.";
  public static final String VALUES_DONT_MATCH = "The values don't match";
  public static final String EXPECTED_TO_THROW_AN_EXCEPTION_MESSAGE =
      "An exception was expected to be thrown!";
}
