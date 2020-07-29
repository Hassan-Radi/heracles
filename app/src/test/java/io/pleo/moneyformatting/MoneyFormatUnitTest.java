package io.pleo.moneyformatting;

import org.junit.Test;

import io.pleo.moneyformatting.core.MoneyFormatterHelper;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MoneyFormatUnitTest {

  @Test
  public void bigNumberWithDecimalPoint() {
    String input = "12342321.9877";
    String output = MoneyFormatterHelper.formatString(input);

    // TODO: add parameterized tests here
    assertEquals(4, 2 + 2);
  }
}
