package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String value="", total = "", previousVal="", equation = "";
    boolean decimals = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaration

        TextView textView = findViewById(R.id.textView);

        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);

        Button ac = findViewById(R.id.AC);
        Button sign = findViewById(R.id.plusSlashMinus);
        Button modulo = findViewById(R.id.modulo);
        Button dot = findViewById(R.id.dot);

        Button divide = findViewById(R.id.divide);
        Button multiply = findViewById(R.id.multiply);
        Button substract = findViewById(R.id.substract);
        Button add = findViewById(R.id.Add);
        Button equals = findViewById(R.id.equals);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.zero){
                    value+="0";
                    textView.setText(value);

                }
                else if (v.getId() == R.id.one){
                    value+="1";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.two){
                    value+="2";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.three){
                    value+="3";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.four){
                    value+="4";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.five){
                    value+="5";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.six){
                    value+="6";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.seven){
                    value+="7";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.eight){
                    value+="8";
                    textView.setText(value);
                }
                else if (v.getId() == R.id.nine){
                    value+="9";
                    textView.setText(value);
                }
                else if(v.getId() == R.id.AC){
                    value = "";
                    total="";
                    previousVal="";
                    equation="";
                    decimals = false;
                    textView.setText("0");

                }
                else if(v.getId() == R.id.divide) {
                    equation="/";
                    MoveValToPreviousVal();
                }
                else if(v.getId() == R.id.multiply) {
                    equation="*";
                    MoveValToPreviousVal();
                }
                else if(v.getId() == R.id.substract) {
                    equation="-";
                    MoveValToPreviousVal();

                }
                else if(v.getId() == R.id.Add) {
                    equation="+";
                    MoveValToPreviousVal();

                }
                else if (v.getId() == R.id.modulo) {
                    value = PercentageSign(value);
                    textView.setText(value);

                }
                else if (v.getId() == R.id.dot) {
                    decimals = true;
                    if(!value.contains(".")){
                        value+=".";
                        textView.setText(value);
                    }
                }
                else if(v.getId() == R.id.plusSlashMinus) {
                    if (textView.getText().toString().equals(value)) {
                        value = ChangeSign(value);
                        textView.setText(value);
                    }
                    else{
                        total = ChangeSign(total);
                        textView.setText(total);
                    }
                }
                else if(v.getId() == R.id.equals){

                    total=EqualsSign(value,previousVal);
                    textView.setText(total);
                    value = "";
                }
                }


        };
        zero.setOnClickListener(listener);
        one.setOnClickListener(listener);
        two.setOnClickListener(listener);
        three.setOnClickListener(listener);
        four.setOnClickListener(listener);
        five.setOnClickListener(listener);
        six.setOnClickListener(listener);
        seven.setOnClickListener(listener);
        eight.setOnClickListener(listener);
        nine.setOnClickListener(listener);
        ac.setOnClickListener(listener);
        divide.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        substract.setOnClickListener(listener);
        add.setOnClickListener(listener);
        sign.setOnClickListener(listener);
        equals.setOnClickListener(listener);
        dot.setOnClickListener(listener);
        modulo.setOnClickListener(listener);
    }

    public void MoveValToPreviousVal(){
        if(!total.equals("")) {
            previousVal = total;
        }

        else {
            previousVal = value;
        }
        value = "";
    }

    public  String EqualsSign(String val, String total){

        if (!decimals){
        switch (equation) {
            case "+":
                return Integer.toString(Integer.parseInt(total) + Integer.parseInt(val));
            case "-":
                return Integer.toString(Integer.parseInt(total) - Integer.parseInt(val));
            case "*":
                return Integer.toString(Integer.parseInt(total) * Integer.parseInt(val));
            case "/":
                return Integer.toString(Integer.parseInt(total) / Integer.parseInt(val));

            default:
                return "";
        }
        }
        else{
            switch (equation) {
                case "+":
                    return Double.toString(Double.parseDouble(total) + Double.parseDouble(val));
                case "-":
                    return Double.toString(Double.parseDouble(total) - Double.parseDouble(val));
                case "*":
                    return Double.toString(Double.parseDouble(total) * Double.parseDouble(val));
                case "/":
                    return Double.toString(Double.parseDouble(total) / Double.parseDouble(val));

                default:
                    return "";
            }
        }
    }

    public String ChangeSign(String val){
        if(!decimals)
        return Integer.toString( Integer.parseInt(val) * -1 );
        else {
            return Double.toString( Double.parseDouble(val) * -1 );
        }
    }
    public String PercentageSign(String val){
        return Double.toString(Double.parseDouble(val) / 100);
    }

}