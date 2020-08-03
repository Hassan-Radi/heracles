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
package io.pleo.test;

import io.pleo.data.Constants;
import io.pleo.pages.HomeView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A class for all implemented UI test cases built using Black-Box method to test the Android app.
 */
public class MoneyFormatTests extends BaseTest {

  private static final Logger LOGGER = LogManager.getLogger(MoneyFormatTests.class);

  @Test
  public void moneyFormatTest() {
    /**
     * TODO: to be changed later on when the new PageViewFactory is implemented in the automation
     * framework.
     */
    HomeView homeView = new HomeView();
    LOGGER.info(
        String.format(Constants.TESTING_VALUES_MESSAGE, Constants.INPUT_1, Constants.OUTPUT_1));
    String output = homeView.formatMoneyValue(Constants.INPUT_1);
    LOGGER.info(String.format(Constants.TEXT_VALUE_FROM_LABEL, output));

    Assert.assertEquals(output, Constants.OUTPUT_1, Constants.VALUES_DONT_MATCH_MESSAGE);
  }
}
