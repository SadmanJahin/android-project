package com.example.voiceofbangladesh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class MapIntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream stream = null;
        try {
            stream = getAssets().open("Chloropath-mapcolor.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GifDecoderView view = new GifDecoderView(this, stream);

        setContentView(view);
        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                   // Intent intent = new Intent(MapIntroActivity.this, IntroActivity.class);

                   // Intent intent = new Intent(MapIntroActivity.this, LoginRegistrationActivity.class);

                    Intent intent = new Intent(MapIntroActivity.this, LoginRegistrationActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        thread.start();
    }

}
