package com.example.calculator;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button num0, num1, num2, num3, num4, num5, num6, num7,
            num8, num9, mean, variance, stdev, median, decimal, comma, clear;
    EditText editor;
    private double population;
    private double value2;
    private SoundPool soundPool;
    private int fartSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        mean = findViewById(R.id.mean);
        variance = findViewById(R.id.var);
        stdev = findViewById(R.id.sdev);
        median = findViewById(R.id.med);
        decimal = findViewById(R.id.decimal);
        comma = findViewById(R.id.comma);
        clear = findViewById(R.id.clear);
        editor = findViewById(R.id.editor);
        //idk. what is textview vs edittext wtf


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "1");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + ".");
            }
        });
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + ",");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "0");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "");
            }
        });

        mean.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(mean(buttonArray())));
            }
        });
        median.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(median(buttonArray())));
            }
        });
        stdev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(stdev(buttonArray())));
            }
        });
        variance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(variance(buttonArray())));
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText("");
            }
        });
        //Using SoundPool to implement sounds

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
        fartSound = soundPool.load(this, R.raw.fart, 1);


    }
    public double[] buttonArray() {
        String stringData = editor.getText().toString();
        String[] splitData = stringData.split(",");
        double[] data = new double[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            data[i] = Double.parseDouble(splitData[i]);
        }
        return data;
    }

    public double mean(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / (array.length);
    }
    public double findVariance(double[] array) {
        double mean = mean(array);
        double sum = 0;
        double[] deviance = new double[array.length];
        for (int j = 0; j < array.length; j++) {
            deviance[j] = array[j] - mean;
            deviance[j] *= deviance[j];
            sum += deviance[j];
        }
        return sum / array.length;
    }
    public double stdev(double[] array) {
        double variance = findVariance(array);
        return Math.sqrt(variance);
    }
    public double variance(double[] array) {
        return findVariance(array);
    }
    public double median(double[] array) {
        double med = 0;
        Arrays.sort(array);
        if (array.length % 2 == 1) {
            med = array[array.length / 2];
        } else {
            med = (array[(array.length / 2)] + array[(array.length - 1) / 2]) / 2;
        }
        return med;
    }
}
