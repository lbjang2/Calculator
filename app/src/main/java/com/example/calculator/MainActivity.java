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

public class MainActivity extends AppCompatActivity {
    Button num0, num1, num2, num3, num4, num5, num6, num7,
            num8, num9, add, subtract, divide, multiply, decimal, clear, equal;
    EditText editor;
    private double value1 = Double.NaN;
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
        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        decimal = (Button) findViewById(R.id.decimal);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equal);
        editor = (TextView) findViewById(R.id.editor);
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
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "+");
                calculate();
                function = Addition;
                editor.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "-");
                calculate();
                function = Subtraction;
                editor.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "*");
                calculate();
                function = Multiplication;
                editor.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "/");
                calculate();
                function = Division;
                editor.setText(null);
            }
        });
        equal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                function = Equal;
                result.setText(result.getText().toString() + String.valueOf(value2) + "=" + String.valueOf(value1));

            }
        }));
        //NEED CLEAR AND EQUAL BUTTON


        //Using SoundPool to implement sounds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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



    }
    public double calculate() {
        if (!Double.isNaN(value1)) {
            if (function == Addition) {
                return value1 + value2;
            }
            if (function == Subtraction) {
                return value1 - value2;
            }
            if (function == Multiplication) {
                return value1 * value2;
            }
            if (function == Division) {
                return value1 / value2;
            }
        }
        return 0;
    }
}
