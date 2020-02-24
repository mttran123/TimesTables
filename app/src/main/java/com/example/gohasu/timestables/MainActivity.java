package com.example.gohasu.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView numbers ;


    public void generateTimesTable(int timesTableNumber) {
        final ArrayList<String> timesTableContent = new ArrayList<>() ; // new object created everytime this method is called

        for(int y = 1; y<= 10; y++) {
            timesTableContent.add(Integer.toString(y*timesTableNumber));
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        numbers.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numbers = findViewById(R.id.listView);

        final SeekBar multiplier = findViewById(R.id.seekBar);

        int max = 20;
        int startingPosition = 10;

        multiplier.setMax(max);
        multiplier.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        multiplier.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTableNumber;

                if(i < min) {
                    timesTableNumber = min;
                    multiplier.setProgress(min);  // always set seek bar minimum at 1, not lower
                } else {
                    timesTableNumber = i;
                }

                generateTimesTable(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
