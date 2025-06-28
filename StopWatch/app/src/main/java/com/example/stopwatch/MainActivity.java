package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;
 
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            chronometer = findViewById(R.id.time_view);
            chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometerChanged) {
                    chronometer = chronometerChanged;
                }
            });
        }
        public void startStopChronometer(View view){
            if(start){
                chronometer.stop();
                start = false;
                ((Button)view).setText("Start");
            }
            else{
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                start = true;
                ((Button)view).setText("Stop");
            }
        }
    }




//<androidx.appcompat.widget.AppCompatButton
//        android:id="@+id/start"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:background="@drawable/start_btn"
//        android:text="Start"
//        android:textColor="@color/white"
//        android:textStyle="bold"
//        android:textSize="15sp"
//        android:paddingLeft="30sp"
//        android:paddingRight="30sp"
//        android:layout_centerHorizontal="true"
//        android:layout_below="@+id/min"
//        android:layout_marginTop="100sp"
//        />



//<Button
//        android:id="@+id/startbutton"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_gravity="center_horizontal"
//                android:layout_marginTop="50sp"
//                android:onClick="onClickStart"
//                android:text="Start"
//                android:textStyle="bold"
//                android:background="@drawable/start_btn"
//                android:paddingLeft="30sp"
//                android:paddingRight="30sp"
//                />
//
//<Button
//        android:id="@+id/stop_button"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_gravity="center_horizontal"
//                android:layout_marginTop="50sp"
//                android:onClick="onClickStop"
//                android:text="Stop"
//                android:textStyle="bold"
//                android:background="@drawable/start_btn"
//                android:paddingLeft="30sp"
//                android:paddingRight="30sp"
//                />
//
//<Button
//        android:id="@+id/reset_button"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_gravity="center_horizontal"
//                android:layout_marginTop="50sp"
//                android:onClick="onClickStart"
//                android:text="Reset"
//                android:background="@drawable/start_btn"
//                android:paddingLeft="30sp"
//                android:paddingRight="30sp"
//                />