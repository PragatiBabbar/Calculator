package com.pragati.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;

    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for hiding status bar and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_a);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_a);

        //hooks
        image=findViewById(R.id.image);
        app=findViewById(R.id.app);

        image.setAnimation(topAnim);
        app.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Welc.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}