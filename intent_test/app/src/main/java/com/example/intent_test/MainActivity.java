package com.example.intent_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity{

    Button mButton;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(onclick);
        mTextView = (TextView)findViewById(R.id.textView);
    }

    OnClickListener onclick = new OnClickListener(){
        @Override
        public void onClick(View view){
            Intent mIntent = new Intent();
            mIntent.setAction("myAction");
            mIntent.putExtra("text","hello world");
            startActivityForResult(mIntent,1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(resultCode == RESULT_OK) {
            String text = intent.getExtras().getString("text");
            if(requestCode == 1)
                mTextView.setText(text);
        }
    }

}
