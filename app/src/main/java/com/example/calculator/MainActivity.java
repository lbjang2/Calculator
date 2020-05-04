package com.example.calculator;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

/**
 * Main Activity that handles the creation of buttons as well as functionality of the Statistics Calculator
 * The calculator handles the calculations of Mean, Standard Deviation, Median, and Variance while also utilizing SoundPool to play sounds when buttons are pressed
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Instance variables for buttons used on the calculator
     */
    Button num0, num1, num2, num3, num4, num5, num6, num7,
            num8, num9, mean, variance, stdev, median, decimal, comma, clear;
    /**
     * Initializes an Edit Text object to show user the inputted text for the Calculator
     */
    EditText editor;
    /**
     * Initializes a SoundPool object to handle the implementation of sound effects
     */
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


        // Button Creation for the calculator
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
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "3");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "4");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "5");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "6");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "7");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "8");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "9");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + ".");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + ",");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "0");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.setText(editor.getText() + "");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });

        mean.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(mean(buttonArray())));
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        median.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(median(buttonArray())));
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        stdev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(stdev(buttonArray())));
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        variance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText(Double.toString(variance(buttonArray())));
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.setText("");
                soundPool.play(fartSound, 1, 1, 0, 0, 1);
            }
        });
        /**
         * Using SoundPool to implement sounds. Initially it checks the version of Android in which the application is running on
         * It then establishes the sound attributes using the AudioAttributes class
         * We then set attributes to our SoundPool object for it to build/handle the usage of sound effects
         * Tutorial/Documentation on using SoundPool: https://developer.android.com/reference/android/media/SoundPool
         */


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
        // Fart sound sound effect, located in the raw folder within the project
        fartSound = soundPool.load(this, R.raw.fart, 1);


    }

    /**
     * Handles the user inputs by the buttons and displays the inputted commands through text.
     * @return data - A string array containing the commands the user inputs through the calculator
     */
    public double[] buttonArray() {
        String stringData = editor.getText().toString();
        String[] splitData = stringData.split(",");
        double[] data = new double[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            data[i] = Double.parseDouble(splitData[i]);
        }
        return data;
    }

    /**
     * Handles the actual calculation of the mean of inputted numbers
     * @param array - the array containing the values of the inputted user sample by the calculator
     * @return The calculation of the mean
     */
    public double mean(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / (array.length);
    }

    /**
     * Handles the calculation of the variance if inputted numbers
     * @param array the array containing the values of the inputted user sample by the calculator
     * @return The calculation of the variance
     */
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

    /**
     * Handles the calculation of the standard deviation of the inputted user sample
     * @param array the array containing the values of the inputted user sample by the calculator
     * @return The Standard Deviation of the sample
     */
    public double stdev(double[] array) {
        double variance = findVariance(array);
        return Math.sqrt(variance);
    }

    /**
     * Returns the variance using the variance helper function
     * @param array the array containing the values of the inputted user sample by the calculator
     * @return The variance of the user inputted sample
     */
    public double variance(double[] array) {
        return findVariance(array);
    }

    /**
     * calculates the median of the user inputted sample
     * @param array the array containing the values of the inputted user sample by the calculator
     * @return The median of the user inputted sample
     */
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
