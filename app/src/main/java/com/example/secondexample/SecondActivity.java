package com.example.secondexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        showAlert();
    }

    private void showAlert()
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setIcon(R.drawable.ic_action_name);
        alertBuilder.setTitle("Back");
        alertBuilder.setMessage("Do You Want To Go Back??");
        alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
              finish();
            }
        });
        alertBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
        AlertDialog mAlertDialoug =  alertBuilder.create();
        mAlertDialoug.show();
    }
}
