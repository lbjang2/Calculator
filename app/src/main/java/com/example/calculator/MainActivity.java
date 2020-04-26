package com.example.calculator;

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
    double value1, value2;
    char Addition = '+';
    char Subtraction = '-';
    char Multiplication = '*';
    char Division = '/';
    char function;

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
                value1 = Double.parseDouble(editor.getText() + "");
                calculate();
                Addition = function;
                editor.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "");
                calculate();
                Subtraction = function;
                editor.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "");
                calculate();
                Multiplication = function;
                editor.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1 = Double.parseDouble(editor.getText() + "");
                calculate();
                Division = function;
                editor.setText(null);
            }
        });
        equal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        //NEED CLEAR AND EQUAL BUTTON




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
