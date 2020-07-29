package io.pleo.moneyformatting.core;

import io.pleo.moneyformatting.data.Constants;

/** A helper class that provides a set of common methods to be used when formatting money values. */
public class MoneyFormatterHelper {

  /**
   * Formats a String value by limiting the number of decimal points to only two points after
   * rounding up. It also adds spaces to make big numbers easier to read.
   *
   * @param value The String value to format.
   * @return A String representation to the final money value.
   */
  public static String formatString(String value) {
    double doubleValue;

    // reject values that are not numerical
    try {
      doubleValue = Double.valueOf(value);
    } catch (NumberFormatException ex) {
      throw new RuntimeException(Constants.INCORRECT_INPUT_VALUE);
    }

    // limit value to only two decimal points add a space for every 3 digits
    return String.format("%,.2f", doubleValue).replaceAll(",", " ");
  }
}
