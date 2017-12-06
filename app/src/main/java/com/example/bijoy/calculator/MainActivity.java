package com.example.bijoy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,btnAns;
    private TextView t1,t2;
    private Button opr1,opr2,opr3,opr4,equalBtn,btnC;
    private final char EQU = 0;
    private final char ADDITION = '+';
    private final char  SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private double mValue1=Double.NaN;
    //private double mValue1=0;
    private double mValue2;
    private char Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString() + "1");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"0");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+"9");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString()+".");
            }
        });

        opr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().isEmpty()){
                    if (t2.getText().toString().isEmpty()){
                        return;
                    }
                    else {
                        t1.setText(t1.getText().toString()+mValue1);
                    }

                }
                else {
                    t2.setText(null);
                    Action = ADDITION;
                    compute();

                    t1.setText(t1.getText().toString()+"+");
                    t1.setText(null);


                }

            }
        });
        opr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().isEmpty()){
                    if (t2.getText().toString().isEmpty()){
                        return;
                    }
                    else {
                        t1.setText(t1.getText().toString()+mValue1);
                    }
                }
                else {
                    t2.setText(null);
                    Action = SUBTRACTION;
                    compute();
                    t1.setText(t1.getText().toString() + "-");
                    t1.setText(null);
                }
            }
        });
        opr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().isEmpty()){
                    if (t2.getText().toString().isEmpty()){
                        return;
                    }
                    else {
                        t1.setText(t1.getText().toString()+mValue1);
                    }
                }
                else {
                    t2.setText(null);
                    compute();
                    Action = MULTIPLICATION;
                    t1.setText(t1.getText().toString()+"*");
                    t1.setText(null);
                }
            }
        });
        opr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().isEmpty()){
                    if (t2.getText().toString().isEmpty()){
                        return;
                    }
                    else {
                        t1.setText(t1.getText().toString()+mValue1);
                    }
                }
                else {
                    t2.setText(null);
                    compute();
                    Action = DIVISION;
                    t1.setText(t1.getText().toString() + "/");
                    t1.setText(null);
                }
            }
        });
        //btnC
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t2.setText(" ");
                t1.setText(" ");
                mValue1 = 0;

            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().isEmpty()){
                    return;
                }
                else {
                    compute();
                    Action = EQU;
                    t2.setText(t2.getText().toString() + "= " + String.valueOf(mValue1));
                }
            }
        });

        //btnANS
       AnsValue();



    }
    private void AnsValue(){
        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(" " + mValue1);
                t2.setText("");
            }
        });
    }
    private void setupUIViews(){
        b0 =(Button) findViewById(R.id.zerro);
        b9 =(Button) findViewById(R.id.nine);
        b8 =(Button) findViewById(R.id.eight);
        b7 =(Button) findViewById(R.id.seven);
        b6 =(Button) findViewById(R.id.six);
        b5 =(Button) findViewById(R.id.five);
        b4 =(Button) findViewById(R.id.four);
        b3 =(Button) findViewById(R.id.three);
        b2 =(Button) findViewById(R.id.two);
        b1 =(Button) findViewById(R.id.one);
        bdot = (Button) findViewById(R.id.point);

        opr1 =(Button) findViewById(R.id.plus);
        opr2 =(Button) findViewById(R.id.min);
        opr3 =(Button) findViewById(R.id.mult);
        opr4 =(Button) findViewById(R.id.div);

        equalBtn =(Button) findViewById(R.id.bEqual);
        btnC = (Button) findViewById(R.id.C_btn);
        btnAns = (Button) findViewById(R.id.ANSWER);


        t1 = (TextView) findViewById(R.id.viewOne);
        t2 = (TextView) findViewById(R.id.viewTwo);
    }

    private void compute(){
        if (!Double.isNaN(mValue1)) {
            mValue2 = Double.parseDouble(t1.getText().toString());
            t1.setText(null);
            switch (Action){
                case ADDITION:
                    mValue1 = mValue1+mValue2;
                    break;
                case SUBTRACTION:
                    mValue1 = mValue1-mValue2;
                    break;
                case MULTIPLICATION:
                    mValue1 = mValue1*mValue2;
                    break;
                case DIVISION:
                    mValue1 = mValue1/mValue2;
                    break;
                case EQU:
                    break;
            }

        }
        else {
            mValue1 = Double.parseDouble(t1.getText().toString());
        }
    }

}
