package com.example.secondexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtName;
    private Button btnGoNxt;
    private ToggleButton toggleButton;
    private TextView txtChange;
    private Switch switchChange;
    private TextView txtChange2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edtName = findViewById(R.id.editPersonName);
        btnGoNxt = findViewById(R.id.buttonLogin);
        toggleButton = findViewById(R.id.toggleStatus);
        txtChange = findViewById(R.id.txtColor);
        switchChange = findViewById(R.id.switchRem);
        txtChange2 = findViewById(R.id.txtRem);

        switchChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)   //toggleButton.isChecked() or compundButton.isChecked()
                {
                    txtChange2.setBackgroundColor(Color.YELLOW);
                    txtChange2.setTextColor(Color.BLUE);
                    txtChange2.setText("Yes");
                }
                else
                {
                    txtChange2.setBackgroundColor(Color.BLACK);
                    txtChange2.setTextColor(Color.RED);
                    txtChange2.setText("No");
                }

            }
        });
        //txtChange.setBackgroundColor(Color.YELLOW);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                  if(b)   //toggleButton.isChecked() or compundButton.isChecked()
                  {
                      txtChange.setBackgroundColor(Color.YELLOW);
                      txtChange.setTextColor(Color.BLUE);
                  }
                  else
                  {
                      txtChange.setBackgroundColor(Color.BLACK);
                      txtChange.setTextColor(Color.RED);
                  }
            }
        });

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
        alertBuilder.setTitle("Back");
        alertBuilder.setMessage("Plz Enter Your Name");
        alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });
        alertBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
        AlertDialog mAlertDialoug =  alertBuilder.create();
        mAlertDialoug.show();
    }
}
