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
package io.pleo.moneyformatting.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import io.pleo.moneyformatting.data.Constants;

/** A helper class that provides a set of common methods to be used when formatting money values. */
public class MoneyFormatterHelper {

  /**
   * Formats a money value by limiting the number of decimal points to only two points after
   * rounding up. It also adds spaces to make big numbers easier to read.
   *
   * @param value The String value to format.
   * @return A String representation to the final money value.
   */
  public static String formatMoney(String value) {
    BigDecimal bigDecimalValue;

    // reject values that are not valid
    try {
      bigDecimalValue = new BigDecimal(value);
    } catch (NumberFormatException ex) {
      throw new RuntimeException(Constants.INCORRECT_INPUT_VALUE);
    }

    // limit value to only two decimal points add a space for every 3 digits
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    decimalFormatSymbols.setDecimalSeparator('.');
    decimalFormatSymbols.setGroupingSeparator(' ');
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
    return decimalFormat.format(bigDecimalValue);
  }
}
