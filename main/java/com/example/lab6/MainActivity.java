package com.example.lab6;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_equals(View view){

        TextView textView = findViewById(R.id.result);

        ArrayList<Float> numbers = new ArrayList<Float>();
        ArrayList<String> symbols = new ArrayList<String>();

        float result = 0f;
        String str = textView.getText().toString() + "=";
        String ch = "_";

        boolean forExit = false;
        while(str.length() > 0) {
            int nextPlus = str.indexOf('+');
            int nextMinus = str.indexOf('-');

            if(nextPlus != -1 && nextMinus != -1){
                if (nextPlus < nextMinus)
                    ch = "+";
                else
                    ch ="-";
            }
            else if(nextPlus != -1)
                ch = "+";
            else if(nextMinus != -1)
                ch ="-";
            else {
                ch = "=";
                forExit = true;
            }

            numbers.add(Float.parseFloat(str.substring(0, str.indexOf(ch))));

            if(!forExit)
                symbols.add(ch);

            str = str.substring(str.indexOf(ch) + 1);

            if(forExit)
                break;
        }

        result = numbers.get(0);
        for(int i = 0; i < symbols.size(); i++){
            switch (symbols.get(i)) {
                case "+":
                    result += numbers.get(i + 1);
                    break;

                case "-":
                    result -= numbers.get(i + 1);
                    break;

                default:
                    textView.setText("ERROR");
            }
        }
        textView.setText(Float.toString(result));
    }

    public void click_1(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "1");
    }

    public void click_2(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "2");
    }

    public void click_3(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "3");
    }

    public void click_4(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "4");
    }

    public void click_5(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "5");
    }

    public void click_6(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "6");
    }

    public void click_7(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "7");
    }

    public void click_8(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "8");
    }

    public void click_9(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "9");
    }

    public void click_plus(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "+");
    }

    public void click_minus(View view){
        TextView textView = findViewById(R.id.result);
        textView.setText(textView.getText() + "-");
    }

    public void click_del(View view){
        TextView textView = findViewById(R.id.result);

        if(textView.getText().length() > 0)
            textView.setText(textView.getText().toString().substring(0, textView.getText().length() - 1));
    }
}