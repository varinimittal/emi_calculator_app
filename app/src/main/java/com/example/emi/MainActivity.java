package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.view.View;
import android.text.TextUtils;



public class MainActivity extends AppCompatActivity {
    SeekBar customSeekBar;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSeekBar =(SeekBar)findViewById(R.id.seek_bar);
        textView = findViewById(R.id.text1);
        final EditText et= (EditText)findViewById(R.id.edit1) ;
        final TextView ti=(TextView)findViewById(R.id.t1);
        final TextView result=(TextView)findViewById(R.id.t);
        final Button btn1=(Button)findViewById(R.id.b2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==btn1) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });
        // perform seek bar change listener event used for getting the progress value
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    //Update Seekbar value after entering a number
                    customSeekBar.setProgress(Integer.parseInt(s.toString()));
                    textView.setText(Integer.parseInt(et.toString())+"/200L");
                } catch(Exception ex) {}
            }
        });
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               try {
                   et.setText(String.valueOf(progress));
                   textView.setText(progress + "/200");
               }
               catch(Exception ex){}

            }
        });
        final SeekBar customSeekBar1 =(SeekBar)findViewById(R.id.seek_bar1);
        final TextView textView1 = findViewById(R.id.text2);
        final EditText et1= (EditText)findViewById(R.id.edit2) ;
        // perform seek bar change listener event used for getting the progress value
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    //Update Seekbar value after entering a number
                    customSeekBar1.setProgress(Integer.parseInt(s.toString()));
                    textView1.setText(Integer.parseInt(et1.toString())+"/360");
                } catch(Exception ex) {}
            }
        });
        customSeekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    et1.setText(String.valueOf(progress));
                    textView1.setText(progress + "/360");
                }
                catch(Exception ex){}

            }
        });
        final SeekBar customSeekBar2 =(SeekBar)findViewById(R.id.seek_bar2);
        final TextView textView2 = findViewById(R.id.text3);
        final EditText et2= (EditText)findViewById(R.id.edit3) ;
        // perform seek bar change listener event used for getting the progress value
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    //Update Seekbar value after entering a number
                    customSeekBar2.setProgress(Integer.parseInt(s.toString()));
                    textView2.setText(Integer.parseInt(et2.toString())+"/20");
                } catch(Exception ex) {}
            }
        });
        customSeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    et2.setText(String.valueOf(progress));
                    textView2.setText(progress + "/20");
                }
                catch(Exception ex){}

            }
        });
        btn=(Button) findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1 = et.getText().toString();
                String st2 = et1.getText().toString();
                String st3 = et2.getText().toString();

                if (TextUtils.isEmpty(st1)) {
                    et.setError("Enter Loan Amount");
                    et.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st3)) {
                    et2.setError("Enter Interest Rate");
                    et2.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st2)) {
                    et1.setError("Enter Years");
                    et1.requestFocus();
                    return;
                }

                float p = Float.parseFloat(st1);
                float m = Float.parseFloat(st2);
                float i = Float.parseFloat(st3);
                float rate = (float) (i/(12*100));
                float power = (float) (Math.pow(1 + rate, m));
                float pri = (float) (p * 100000);
                float emi = (float) ((pri * rate * power) / (power - 1));
                float Ti=(float)(emi*m - pri);
                  result.setText(String.valueOf(emi));
                  ti.setText(String.valueOf(Ti));
            }
            });

            }


}
