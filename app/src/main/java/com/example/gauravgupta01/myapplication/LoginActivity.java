package com.example.gauravgupta01.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {


    private Button loginButton;
    private EditText editText,editText2;
    private TextView  textView8;
    private AutoCompleteTextView autoCompleteTextView;
    private int attempts = 3;
    String[] countryname = {"Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setText(String.valueOf(attempts));
        setSupportActionBar(toolbar);
        setOnClickListener();
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,countryname);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(stringArrayAdapter);
    }


    private void setOnClickListener(){
        loginButton = (Button)findViewById(R.id.button5);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.valueOf(textView8.getText().toString()) <= 0){
                    textView8.setText("Nikal le yha se");
                    Toast.makeText(LoginActivity.this,"Tumse na ho payega", Toast.LENGTH_LONG).show();
                    loginButton.setEnabled(false);
                    finish();
                    return;

                }
                final String userName = editText.getText().toString();
                String password = editText2.getText().toString();
/*                if(userName.isEmpty() && password.isEmpty()){
                    editText.setError("Invalid User Name");
                    editText2.setError("Invalid Password");
                    attempts--;
                }
                else if(userName.isEmpty()){
                    editText.setError("Invalid User Name");
                    attempts--;
                }
                else if(password.isEmpty()){
                    editText2.setError("Invalid Password");
                    attempts--;
                }*/

                if(!userName.isEmpty() && !password.isEmpty() && userName.equals("gaurav") && password.equals("gizmo")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Login Screen").setCancelable(false).
                    setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("name", userName);
                            startActivity(intent);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).setMessage("Do you want to go to next Screen or Not ");

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                else{
                    editText.setError("Invalid User Name");
                    editText2.setError("Invalid Password");
                    attempts--;
                }
                textView8.setText(String.valueOf(attempts));



            }
        });


    }

}
