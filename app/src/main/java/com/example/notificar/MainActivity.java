package com.example.notificar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button notificar;
    private ResultActivity mNotificationUtils;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificar = (Button) findViewById(R.id.Notificar);
        notificar.setOnClickListener(this);

        mNotificationUtils = new ResultActivity(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Notificar:
                Notification.Builder nb = mNotificationUtils.
                        getAndroidChannelNotification("Bienvenido", "Notificaciones realizadas");

                mNotificationUtils.getManager().notify(101, nb.build());
                break;
        }
    }



}