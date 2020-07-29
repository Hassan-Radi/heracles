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
    final EditText textPersonName = (EditText) findViewById(R.id.editTextPersonName);
    textPersonName.setOnEditorActionListener(
        new EditText.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || event != null
                    && event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
              if (event == null || !event.isShiftPressed()) {
                ((TextView) findViewById(R.id.moneyValue))
                    .setText(
                        MoneyFormatterHelper.formatString(textPersonName.getText().toString()));

                // TODO: handle exception when the value is not a number

                return true; // consume.
              }
            }
            return false; // pass on to other listeners.
          }
        });
  }
}
