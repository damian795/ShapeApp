package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // uzyskujemy intencję, która wywołała tę aktywność
        Intent intent = getIntent();

        // uzyskujemy dane wg. klucza
        String val1 = intent.getStringExtra("val1");
        String val2 = intent.getStringExtra("val2");
        String val3 = intent.getStringExtra("val3");

        // uzyskujemy odniesienie do pola tekstowego w layoucie
        // jest to element z activity_second.xml
        TextView textView=(TextView) findViewById(R.id.message);
        // zmieniamy treść pola tekstowego
        textView.setText(val1+"\n"+val2+"\n"+val3);

    }

    public void closeActivity(View view) {
        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("msg", "Wiadomość powrotna");
        setResult(RESULT_OK, intent);
        super.finish();
    }
}