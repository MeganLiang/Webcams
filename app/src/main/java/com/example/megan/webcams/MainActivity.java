package com.example.megan.webcams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSeekBar();
    }



    public void setSeekBar() {
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        count = (TextView)findViewById(R.id.count);
        count.setText("Count: " + seekBar.getProgress() + " / " + seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progressValue = i;
                        count.setText("Count: " + i + " / " + seekBar.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in startTracking", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        count.setText("Count: " + progressValue + " / " + seekBar.getMax());

                        Toast.makeText(MainActivity.this, "SeekBar in stopTracking", Toast.LENGTH_LONG).show();                    }
                }
        );

    }
}
