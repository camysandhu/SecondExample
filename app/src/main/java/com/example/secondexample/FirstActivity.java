package com.example.secondexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtName;
    private Button btnGoNxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edtName = findViewById(R.id.editPersonName);
        btnGoNxt = findViewById(R.id.buttonLogin);

        btnGoNxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        //view.getId() == R.id.btnNe for multiple buttons
        if(edtName.getText().toString().trim().length() != 0)
        {
              Intent mIntent = new Intent(FirstActivity.this, SecondActivity.class);
              mIntent.putExtra("name", edtName.getText().toString());
              startActivity(mIntent);
        }
        else
        {
            edtName.setError("Please Enter name");
            showAlert();
        }
    }
    private void showAlert()
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setIcon(R.drawable.ic_action_name);
        alertBuilder.setTitle("Login Error");
        alertBuilder.setMessage("Plz Enter Your Name");
        alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
        AlertDialog mAlertDialoug =  alertBuilder.create();
        mAlertDialoug.show();
    }
}
