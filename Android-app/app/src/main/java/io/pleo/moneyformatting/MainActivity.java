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

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.pleo.moneyformatting.core.MoneyFormatterHelper;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Add the action listener to update the text
    final EditText textPersonName = findViewById(R.id.editTextMoneyValue);
    textPersonName.setOnEditorActionListener(
        (v, actionId, event) -> {
          if (actionId == EditorInfo.IME_ACTION_SEARCH
              || actionId == EditorInfo.IME_ACTION_DONE
              || event != null
                  && event.getAction() == KeyEvent.ACTION_DOWN
                  && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            if (event == null || !event.isShiftPressed()) {
              try {
                // got some text, let's try to format them
                ((TextView) findViewById(R.id.textViewMoneyValue))
                    .setText(MoneyFormatterHelper.formatMoney(textPersonName.getText().toString()));
              } catch (RuntimeException ex) {
                // Catch the exception and show an alert to describe what went wrong
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.alert_title)
                    .setMessage(R.string.alert_message)
                    .setNegativeButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
              }
              return true; // consume.
            }
          }
          return false; // pass on to other listeners.
        });
  }
}
