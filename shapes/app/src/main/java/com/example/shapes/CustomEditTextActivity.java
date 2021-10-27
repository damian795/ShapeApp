package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CustomEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_edit_text);
    }

    private final int REQUEST_CODE = 1;

    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("val1", "wiadomość 1");
        intent.putExtra("val2", "inna wiadomość");
        EditText editText = (EditText) findViewById(R.id.textToSend);
        String message = editText.getText().toString();
        intent.putExtra("val3", message);
        editText.clearFocus();
        editText.setText("");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // sprawdzamy czy przyszło odpowiednie żądanie
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // sprawdzamy czy intencja przyniosła odpowiednią wiadomość
            if (intent.hasExtra("msg")) {
                // tutaj uzyskujemy obiekt o tym samym id
                // ale dotyczy pliku activity_main.xml
                TextView textView = (TextView) findViewById(R.id.message);
                textView.setText( intent.getStringExtra("msg") );
            }
        }
    }


    public void openBrowser(View view) {
        String url = "https://www.youtube.com/?hl=pl&gl=PL";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}