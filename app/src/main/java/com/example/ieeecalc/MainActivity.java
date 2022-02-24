package com.example.ieeecalc;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.textView2);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.textview).equals(display.getText().toString()))
                    display.setText("");
            }
        });
        display.setShowSoftInputOnFocus(false);

    };

    private void update(String strToAdd) {
        String OldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String LeftStr = OldStr.substring(0, cursor);
        String RightStr = OldStr.substring(cursor);
        if (getString(R.string.textview).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursor + 1);
        } else {
            display.setText(String.format("%s%s%s", LeftStr, strToAdd, RightStr));
            display.setSelection(cursor + 1);
        }
    }
    public void ZERO(View view){
        update("0");
    }
    public void ONE(View view){
        update("1");
    }
    public void TWO(View view){
        update("2");
    }
    public void THREE(View view){
        update("3");
    }
    public void FOUR(View view){
        update("4");
    }
    public void FIVE(View view){
        update("5");
    }
    public void SIX(View view){
        update("6");
    }
    public void SEVEN(View view){
        update("7");
    }
    public void EIGHT(View view){
        update("8");
    }
    public void NINE(View view){
        update("9");
    }
    public void AC(View view){
        display.setText("");
    }
    public void BACKSPACE(View view){
        int cursor=display.getSelectionStart();
        int len=display.getText().length();
        if(cursor!=0 && len!=0){
            SpannableStringBuilder text= (SpannableStringBuilder) display.getText();
            text.replace(cursor-1,cursor,"");
            display.setText(text);
            display.setSelection(cursor-1);
        }
    }
    public void PERCENTAGE(View view){
        update("%");
    }
    public void DIVIDE(View view){
        update("÷");
    }
    public void MULTIPLY(View view){
        update("×");
    }
    public void ADD(View view){
        update("+");
    }
    public void SUBTRACT(View view){
        update("-");
    }
    public void EQUALTO(View view){
        String ToCalaculate=display.getText().toString();
        ToCalaculate=ToCalaculate.replaceAll("÷","/");
        ToCalaculate=ToCalaculate.replaceAll("×","*");
        Expression ToSolve= new Expression(ToCalaculate);
        String Ans=String.valueOf(ToSolve.calculate());
        display.setText(Ans);
        display.setSelection(Ans.length());
    }
    public void EXP(View view){
        update("^");
    }
    public void DECIMAL(View view){
        update(".");
    }

}