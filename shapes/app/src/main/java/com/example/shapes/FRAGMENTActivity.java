package com.example.shapes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FRAGMENTActivity extends AppCompatActivity implements OverviewFragment.OverviewFragmentActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_r_a_g_m_e_n_t);
    }


    // ta metoda pochodzi z OverviewFragmentActivityListener
    @Override
    public void onItemSelected(String msg) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        // sprawdzamy czy fragment istnieje w tej aktywności
        if (fragment != null && fragment.isInLayout()) {
            // ustawiamy teskt we fragmencie
            fragment.setText(msg);
        }else {
            // w trybie portrait wywołujemy drugą aktywność
            Intent intent = new Intent(getApplicationContext(),
                    DetailActivity.class);
            intent.putExtra("msg", msg);
            startActivity(intent);
        }
    }
}