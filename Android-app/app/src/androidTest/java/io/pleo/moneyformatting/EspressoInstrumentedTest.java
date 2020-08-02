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

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.pleo.moneyformatting.data.Constants;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EspressoInstrumentedTest {

  @Rule
  public ActivityScenarioRule<MainActivity> activityScenarioRule =
      new ActivityScenarioRule<>(MainActivity.class);

  @Test
  public void testMoneyFormatIsCorrect() {
    // Type text and then press the action button on the soft keyboard
    onView(withId(R.id.editTextMoneyValue))
        .perform(typeText(Constants.TEST_INPUT_1), pressImeActionButton(), closeSoftKeyboard());

    // Check that the money value has been formatted correctly
    onView(withId(R.id.textViewMoneyValue)).check(matches(withText(Constants.TEST_OUTPUT_1)));
  }

  @Test
  public void testAlertIsShown() {
    // Type text and then press the action button on the soft keyboard
    onView(withId(R.id.editTextMoneyValue))
        .perform(typeText(Constants.TEST_INVALID_INPUT_1), pressImeActionButton());

    // Check that an alert is shown with the correct message
    onView(withText(R.string.alert_message)).check(matches(isDisplayed()));
  }
}
