package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Kaneki extends AppCompatActivity {

    Button button;
    Animation anim_fade_out, anim_fade_in;
    ImageView kaneki,kaneki2;
    Boolean clicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.getWindow().getDecorView().setSystemUiVisibility(View.INVISIBLE);

        button = findViewById(R.id.button);

        kaneki = findViewById(R.id.kaneki);
        kaneki2 = findViewById(R.id.kaneki2);

        anim_fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clicked) {
                    kaneki.startAnimation(anim_fade_out);
                    kaneki.setVisibility(View.INVISIBLE);
                    kaneki2.startAnimation(anim_fade_in);
                    kaneki2.setVisibility(View.VISIBLE);
                    clicked = false;
                }else{
                    kaneki2.startAnimation(anim_fade_out);
                    kaneki2.setVisibility(View.INVISIBLE);
                    kaneki.startAnimation(anim_fade_in);
                    kaneki.setVisibility(View.VISIBLE);
                    clicked = true;
                }
            }
        });
    }
}