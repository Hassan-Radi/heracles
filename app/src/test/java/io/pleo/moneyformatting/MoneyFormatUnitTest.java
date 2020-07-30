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
      Assertions.assertEquals(
          output, MoneyFormatterHelper.formatMoney(input), Constants.VALUES_DONT_MATCH);
    }
  }
}
