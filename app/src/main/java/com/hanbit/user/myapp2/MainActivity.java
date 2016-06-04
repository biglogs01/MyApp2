package com.hanbit.user.myapp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button send;

    EditText etName;
    EditText etWeight;
    EditText etHeight;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button) findViewById(R.id.send);
        etName = (EditText) findViewById(R.id.name);
        etWeight = (EditText) findViewById(R.id.weight);
        etHeight = (EditText) findViewById(R.id.height);
        tv = (TextView) findViewById(R.id.tv);

        send.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                double valWeight = Double.parseDouble( etWeight.getText().toString());
                double valHeight = Double.parseDouble( etHeight.getText().toString());

                int result = (int) (valWeight / (valHeight*valHeight))*10000;

                String retVal = "";
                if( result >= 30 )  retVal = "비만";
                if( result < 30 && result >= 24 ) retVal = "과체중";
                if( result < 24 && result >= 20 ) retVal = "정상";
                if( result < 20 && result >= 15 ) retVal = "저체중";
                if( result < 15 && result >= 13 ) retVal = "마름";
                if( result < 13 && result >= 10 ) retVal = "영양실조";
                if( result < 10 ) retVal = "소모증";

                String valName = etName.getText().toString();
                tv.setText( valName + "님은 " + retVal + " 이십니다");

                return false;
            }
        });

    }
}
