package io.pleo.moneyformatting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import io.pleo.moneyformatting.core.MoneyFormatterHelper;
import io.pleo.moneyformatting.data.Constants;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MoneyFormatUnitTest {

  @ParameterizedTest
  @MethodSource("inputOutputValuesProvider")
  public void parameterizedTest(String input, String output) {
    Assertions.assertEquals(
        output, MoneyFormatterHelper.formatMoney(input), Constants.VALUES_DONT_MATCH);
    // TODO: maybe use CSV file here
  }

  // TODO: implement test cases where the input is invalid

  private static Stream inputOutputValuesProvider() {
    return Stream.of(
        Arguments.of("1564.890", "1 564.89"),
        Arguments.of("1564.899", "1 564.90"),
        Arguments.of("1564.99", "1 564.99"),
        Arguments.of("1564", "1 564.00"),
        Arguments.of("164", "164.00"),
        Arguments.of("2310000.159897", "2 310 000.16"),
        Arguments.of("1600", "1 600.00"),
        Arguments.of("3476367.679086", "3 476 367.68"));
  }
}
