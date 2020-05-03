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
            num8, num9, mean, variance, stdev, median, decimal, comma, clear, equal;
    EditText editor;
    private double population;
    private double value2;
    char Addition = '+';
    char Subtraction = '-';
    char Multiplication = '*';
    char Division = '/';
    char Equal = '0';
    char function;
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
        equal = findViewById(R.id.equal);
        editor = findViewById(R.id.editor);
        //idk. what is textview vs edittext wtf


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "1");
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
                 = Double.parseDouble(editor.getText());
                editor.setText(null);
            }
        });
        median.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 = Double.parseDouble(editor.getText() + "-");
                function = Subtraction;
                editor.setText(null);
            }
        });
        stdev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                = Double.parseDouble(editor.getText() + "*");
                editor.setText(null);
            }
        });
        variance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                = Double.parseDouble(editor.getText() + "/");
                editor.setText(null);
            }
        });
        equal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        //NEED CLEAR AND EQUAL BUTTON


        //Using SoundPool to implement sounds
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes().Builder()
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

         */

    }
    public void mean(double[] array) {
        double mean = findMean(array);
    }
    public double findMean(double[] array) {
        double mean = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += i;
            mean = sum / (array.length - 1);
        }
        return mean;
    }
    public double findVariance(double[] array) {
        double mean = findMean(array);
        double sum = 0;
        double[] deviance = new double[array.length];
        for (int j = 0; j < array.length; j++) {
            deviance[j] = array[j] - mean;
            deviance[j] *= deviance[j];
            sum += deviance[j];
        }
        return sum / array.length;
    }
    public void stdev(double[] array) {
        double variance = findVariance(array);
        double stdev = Math.sqrt(variance);
    }
    public void variance(double[] array) {
        double variance = findVariance(array);
    }
    public void median(double[] array) {
        double med = 0;
        Arrays.sort(array);
        if (array.length % 2 == 1) {
            med = array[array.length / 2 + 1];
        } else {
            med = array[(array.length / 2 + (array.length / 2 + 1)) / 2];
        }
    }
    public void updateText(double result) {

    }


}
