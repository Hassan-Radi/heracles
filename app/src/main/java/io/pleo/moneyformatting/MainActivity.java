package io.pleo.moneyformatting;

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
    final EditText textPersonName = findViewById(R.id.editTextPersonName);
    textPersonName.setOnEditorActionListener(
        (v, actionId, event) -> {
          if (actionId == EditorInfo.IME_ACTION_SEARCH
              || actionId == EditorInfo.IME_ACTION_DONE
              || event != null
                  && event.getAction() == KeyEvent.ACTION_DOWN
                  && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            if (event == null || !event.isShiftPressed()) {
              ((TextView) findViewById(R.id.moneyValue))
                  .setText(MoneyFormatterHelper.formatMoney(textPersonName.getText().toString()));

              // TODO: handle exception when the value is not a number

              return true; // consume.
            }
          }
          return false; // pass on to other listeners.
        });
  }
}
