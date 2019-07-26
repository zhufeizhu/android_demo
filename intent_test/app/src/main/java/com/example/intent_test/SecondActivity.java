package com.example.intent_test;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity  {

    TextView mTextView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extra = getIntent().getExtras();
        String text = extra.getString("text");

        mTextView = (TextView)findViewById(R.id.textView2);

        mTextView.setText(text);



        mButton = (Button)findViewById(R.id.button2);

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent();

                mIntent.putExtra("text","you guess");

                SecondActivity.this.setResult(RESULT_OK,mIntent);

                SecondActivity.this.finish();
            }
        });


    }
}
