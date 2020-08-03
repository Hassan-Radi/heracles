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
package io.pleo.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.pleo.au_framework.core.DriverManager;
import io.pleo.data.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

/** A page object that represents the main page of the Android app. */
public class HomeView extends BaseView {

  private static final Logger LOGGER = LogManager.getLogger(HomeView.class);

  @AndroidFindBy(id = "editTextMoneyValue")
  private WebElement moneyValueTextField;

  @AndroidFindBy(id = "textViewMoneyValue")
  private WebElement moneyValueLabel;

  /**
   * Types the provided number and presses on the 'Done' button on the softKeyboard.
   *
   * @param number A String representation to the requested number.
   * @return A String representing the text displayed in the label.
   */
  public String formatMoneyValue(String number) {
    LOGGER.debug(String.format(Constants.TYPING_TEXT_MESSAGE, number));
    moneyValueTextField.sendKeys(number);
    /**
     * TODO: this is platform dependent code. Need to change it later on to make it work on both
     * platforms (Android/iOS).
     */
    ((AndroidDriver) DriverManager.getInstance().getDriver())
        .executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
    return moneyValueLabel.getText();
  }
}
