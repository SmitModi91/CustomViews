package com.smit.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmailAddress,edtPasswrordName;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmailAddress = (EditText) findViewById(R.id.edtEmailAddress);
        edtPasswrordName= (EditText) findViewById(R.id.edtPasswrordName);

        btnSubmit  = (Button) findViewById(R.id.btnSubmit);

        edtEmailAddress.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        edtPasswrordName.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        edtPasswrordName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }
        });




    }
}
