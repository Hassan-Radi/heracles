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
package io.pleo.moneyformatting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.pleo.moneyformatting.core.MoneyFormatterHelper;
import io.pleo.moneyformatting.data.Constants;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MoneyFormatUnitTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/values.csv")
  public void parameterizedTest(String input, String output) {
    // test invalid values
    if (output == null) {
      Assertions.assertThrows(
          RuntimeException.class,
          () -> MoneyFormatterHelper.formatMoney(input),
          Constants.EXPECTED_TO_THROW_AN_EXCEPTION_MESSAGE);
    } else {
      // test valid values
      Assertions.assertEquals(
          output, MoneyFormatterHelper.formatMoney(input), Constants.VALUES_DONT_MATCH);
    }
  }
}
