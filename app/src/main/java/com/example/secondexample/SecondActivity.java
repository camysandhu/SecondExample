package com.example.secondexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null)
        {
            String name = mBundle.getString("name");
            Log.d("Name", name);
        }
    }
}
