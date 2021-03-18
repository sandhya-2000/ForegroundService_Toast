package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;


public class MainActivity extends AppCompatActivity {
    CountDownTimer countdowntimer = null;
    private Toast mToastToShow;
    Button button;
    Toast toastMessage;
    TextView textView;
    Button btnStartService, btnStopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.ToastButton);

        button = (Button)findViewById(R.id.ToastButton);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Creating toast message.
                toastMessage = new Toast(MainActivity.this);

                //Creating TextView.
                textView = new TextView(MainActivity.this);

                //Setting up Toast Message Text.
                textView.setText("Displaying Toast message");

                //Adding TextView into Toast.
                toastMessage.setView(textView);

                //Access toast message as View.
                View toastView = toastMessage.getView();


                countdowntimer = new CountDownTimer(1000000, 999999999)
                {
                    public void onTick(long millisUntilFinished)
                    {
                        toastMessage.show();
                    }
                    public void onFinish()
                    {
                        toastMessage.cancel();
                    }

                }.start();
            }

        });










        btnStartService = findViewById(R.id.buttonStartService);
        btnStopService = findViewById(R.id.buttonStopService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
    }

    public void startService() {
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
        ContextCompat.startForegroundService(this, serviceIntent);
    }
    public void stopService() {
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        stopService(serviceIntent);
    }

}
