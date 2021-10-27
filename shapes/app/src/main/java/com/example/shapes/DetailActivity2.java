package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail2);

            // pobieramy dane wysłane przez aktywność główną
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String url = extras.getString("msg");
                DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

                // ustawiamy tekst fragmentu w tej aktywności
                detailFragment.setText(url);
            }
    }
}