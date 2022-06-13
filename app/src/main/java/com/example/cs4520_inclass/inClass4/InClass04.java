package com.example.cs4520_inclass.inClass4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.cs4520_inclass.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InClass04 extends AppCompatActivity {

    Button genNum;
    TextView compDisp, maxDisp, minDisp, avgDisp;
    SeekBar complexitySlider;
    ProgressBar progressBar;
    private ExecutorService threadPool;
    private Handler handler;
    private int complexity;
    int donePercent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclass04);

        genNum = findViewById(R.id.button_generateNum);

        compDisp = findViewById(R.id.textView_complexity);
        maxDisp = findViewById(R.id.textView_maxDisp);
        minDisp = findViewById(R.id.textView_minDisp);
        avgDisp = findViewById(R.id.textView_avgDisp);

        complexitySlider = findViewById(R.id.seekBar_complexitySlider);
        progressBar = findViewById(R.id.progressBar_generateNum);

        threadPool = Executors.newFixedThreadPool(2);

        complexitySlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                compDisp.setText(progress+" times");
                complexity = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        genNum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                threadPool.execute(new HeavyWork(complexity, handler));
            }
        });

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case HeavyWork.STATUS_START:
                        // work here
                        break;

                    case HeavyWork.STATUS_FINAL:
                        Bundle receivedFinalData = msg.getData();
                        double max = receivedFinalData.getDouble("max");
                        double min = receivedFinalData.getDouble("min");
                        double avg = receivedFinalData.getDouble("avg");
                        Log.d("demo", "handleMessage: "+max);
                        maxDisp.setText(String.valueOf(max));
                        minDisp.setText(String.valueOf(min));
                        avgDisp.setText(String.valueOf(avg));
                        break;

                    case HeavyWork.STATUS_PROGRESS:

                        Bundle receivedProgressData = msg.getData();
                        //donePercent = receivedProgressData.getInt("progress_key");
                        Log.d("TAG", "status progress"+donePercent);
                        //progressBar.setProgress(donePercent*100/complexity);
                        break;
                }
                return false;
            }
        });




    }
}
