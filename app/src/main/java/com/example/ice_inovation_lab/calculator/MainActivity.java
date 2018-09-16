package com.example.ice_inovation_lab.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zero,one,two,three,four,five,six,seven,eight,nine,add,sub,mul,div,dot,
            equal,clear,off,sin,cos,tan;

    TextView  ans;
    boolean b_add,b_sub,b_mul,b_div,b_sin,b_cos,b_tan;
    double  var1,var2;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero=findViewById(R.id.btn0);
        one=findViewById(R.id.btn1);
        two=findViewById(R.id.btn2);
        three=findViewById(R.id.btn3);
        four=findViewById(R.id.btn4);
        five=findViewById(R.id.btn5);
        six=findViewById(R.id.btn6);
        seven=findViewById(R.id.btn7);
        eight=findViewById(R.id.btn8);
        nine=findViewById(R.id.btn9);
        add=findViewById(R.id.btnadd);
        sub=findViewById(R.id.btnsub);
        mul=findViewById(R.id.btnmul);
        div=findViewById(R.id.btndiv);
        dot=findViewById(R.id.btndot);
        off=findViewById(R.id.btnoff);
        equal=findViewById(R.id.btnequal);
        clear=findViewById(R.id.btnclear);
        sin=findViewById(R.id.btnsin);
        cos=findViewById(R.id.btncos);
        tan=findViewById(R.id.btntan);
        ans=findViewById(R.id.resultTV);



        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        off.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try {

            if (v == zero)
                ans.setText(ans.getText() + "0");
            if (v == one)
                ans.setText(ans.getText() + "1");
            if (v == two)
                ans.setText(ans.getText() + "2");
            if (v == three)
                ans.setText(ans.getText() + "3");
            if (v == four)
                ans.setText(ans.getText() + "4");
            if (v == five)
                ans.setText(ans.getText() + "5");
            if (v == six)
                ans.setText(ans.getText() + "6");
            if (v == seven)
                ans.setText(ans.getText() + "7");
            if (v == eight)
                ans.setText(ans.getText() + "8");
            if (v == nine)
                ans.setText(ans.getText() + "9");
            if (v == dot)
                ans.setText(ans.getText() + ".");

            if (v == sin) {
                b_sin = true;
                ans.setText(ans.getText() + "sin(");
            }
            if (v == cos) {
                b_cos = true;
                ans.setText(ans.getText() + "cos(");
            }
            if (v == tan) {
                b_tan = true;
                ans.setText(ans.getText() + "tan(");
            }

            if (v == add) {
                var1 = Double.parseDouble(ans.getText() + "");
                b_add = true;
                ans.setText(null);
            }
            if (v == sub) {
                var1 = Double.parseDouble(ans.getText() + "");
                b_sub = true;
                ans.setText(null);
            }
            if (v == mul) {
                var1 = Double.parseDouble(ans.getText() + "");
                b_mul = true;
                ans.setText(null);
            }
            if (v == div) {
                var1 = Double.parseDouble(ans.getText() + "");
                b_div = true;
                ans.setText(null);
            }


            if (v == equal) {

                if (b_sin == true || b_cos == true || b_tan == true) {

                    if (b_sin == true) {
                        string = ans.getText().toString();
                        string = string.replace("sin(", "");
                        var1 = Double.parseDouble(string);
                        var2 = Math.toRadians(var1);
                        ans.setText(Math.sin(var2) + "");
                        b_sin = false;
                    }
                    if (b_cos == true) {
                        string = ans.getText().toString();
                        string = string.replace("cos(", "");
                        var1 = Double.parseDouble(string);
                        var2 = Math.toRadians(var1);
                        ans.setText(Math.cos(var2) + "");
                        b_cos = false;
                    }
                    if (b_tan == true) {
                        string = ans.getText().toString();
                        string = string.replace("tan(", "");
                        var1 = Double.parseDouble(string);
                        var2 = Math.toRadians(var1);
                        ans.setText(Math.tan(var2) + "");
                        b_tan = false;
                    }
                } else {
                    var2 = Double.parseDouble(ans.getText() + "");


                    if (b_add == true) {
                        ans.setText(var1 + var2 + "");
                        b_add = false;
                    }
                    if (b_sub == true) {
                        ans.setText(var1 - var2 + "");
                        b_sub = false;
                    }
                    if (b_mul == true) {
                        ans.setText(var1 * var2 + "");
                        b_mul = false;
                    }
                    if (b_div == true) {
                        ans.setText(var1 / var2 + "");
                        b_div = false;
                    }
                }
            }

            if (v == clear)
                ans.setText(null);
            if (v == off)
            {
                AlertDialog.Builder alertBuilder=new AlertDialog.Builder(this);
                alertBuilder.setMessage("Do you want to close?");
                alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int btnoff) {
                        Toast.makeText(MainActivity.this, "You have clicked  yes!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int btnoff) {
                        Toast.makeText(MainActivity.this, "You have clicked no!", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog= alertBuilder.create();
                alertDialog.show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT).show();
        }

    }

}
