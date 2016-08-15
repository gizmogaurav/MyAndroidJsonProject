package com.example.gauravgupta01.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {

    TextView userName;
    EditText password;
    Button button1, button2,button3,button4;
    CheckBox checkBox,checkBox2,checkBox3;
    RadioGroup radioG;
RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        radioG = (RadioGroup)findViewById(R.id.radioG);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent  = getIntent();
        String userNameFromLogin = intent.getStringExtra("name");
        if(!userNameFromLogin.isEmpty()){
            Toast.makeText(MainActivity.this,"Welcome " + userNameFromLogin + " to next Page",Toast.LENGTH_LONG).show();
        }

        password = (EditText) findViewById(R.id.password);
        userName = (TextView) findViewById(R.id.userName);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        setOnClickListener();
        onTextChangelistener();
        setOnClickListenerOnCheckBox(ratingBar);
        View.OnFocusChangeListener ofcListener = new MyFocusChangeListener();
        password.setOnFocusChangeListener(ofcListener);
        userName.setOnFocusChangeListener(ofcListener);
    }


    public void setOnClickListenerOnCheckBox(RatingBar ratingBar){
        final RatingBar  ratingBar1 = ratingBar;
        ratingBar1.setVisibility(View.GONE);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox c1 = ((CheckBox) view);
                boolean isChecked = c1.isChecked();
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    ratingBar1.setRating(2);
                    ratingBar1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Try Android !!",Toast.LENGTH_LONG).show();
                }
                else{
                    ratingBar1.setVisibility(View.GONE);
                }
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox c1 = ((CheckBox) view);
                boolean isChecked = c1.isChecked();
                if(isChecked){
                    checkBox.setChecked(false);
                    checkBox3.setChecked(false);
                    ratingBar1.setRating(4);
                    ratingBar1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,c1.getText().toString() + "is Checked ",Toast.LENGTH_LONG).show();
                }
                else{
                    ratingBar1.setVisibility(View.GONE);
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox c1 = ((CheckBox) view);
                boolean isChecked = c1.isChecked();
                if(isChecked){
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                    ratingBar1.setRating(5);
                    ratingBar1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,c1.getText().toString() + "is Checked ",Toast.LENGTH_LONG).show();
                }
                else{
                    ratingBar1.setVisibility(View.GONE);
                }
            }
        });



    }

    public void setOnClickListener() {
        userName = (TextView) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        button4 = (Button)findViewById(R.id.button4);
        userName.requestFocus();
        userName.setFocusableInTouchMode(true);
        userName.setFocusable(true);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userName.getText().toString().isEmpty()) {
                    if(isValidTextBox(userName.getText().toString())) {
                        Toast.makeText(MainActivity.this, userName.getText(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        userName.setError("Invalid username");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter the username", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, password.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Password is blank", Toast.LENGTH_SHORT).show();
                }


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Item Selected are : ");
                stringBuffer.append("\n" + checkBox.getText().toString() + " is : " + checkBox.isChecked());
                stringBuffer.append("\n" +checkBox2.getText().toString() + " is : " + checkBox2.isChecked());
                stringBuffer.append("\n" +checkBox3.getText().toString() + " is : " + checkBox2.isChecked());

                int id = radioG.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                stringBuffer.append("\n" + radioButton.getText().toString()+ " is :" + radioButton.isChecked() );
               Toast.makeText(MainActivity.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
              }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setMessage("Do you want to close this App").setIcon(R.mipmap.ic_close);
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Alert Box !!!");
                alertDialog.show();
            }

        });












    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    // validating password with retype password
    private boolean isValidTextBox(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
    int MAX_LENGTH = 3;

    public void onTextChangelistener() {
        password = (EditText) findViewById(R.id.password);
        userName = (TextView) findViewById(R.id.userName);
        button1 = (Button) findViewById(R.id.button);
        userName.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged (CharSequence s,int start, int count, int after){
        }

        @Override
        public void onTextChanged (CharSequence s,int start, int before, int count){
            if (s.length() == 7) {
                password.requestFocus(View.FOCUS_DOWN);
            }
        }
        @Override
        public void afterTextChanged (Editable s){
        }
    }
          );
        password.addTextChangedListener(new TextWatcher() {
                                            @Override
                                            public void beforeTextChanged (CharSequence s,int start, int count, int after){
                                            }

                                            @Override
                                            public void onTextChanged (CharSequence s,int start, int before, int count){
                                                if (s.length() == MAX_LENGTH) {
                                                    button1.requestFocus();
                                                    Toast.makeText(MainActivity.this, userName.getText(), Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            @Override
                                            public void afterTextChanged (Editable s){
                                            }
                                        }




        );
}
    private class MyFocusChangeListener implements View.OnFocusChangeListener {

        public void onFocusChange(View v, boolean hasFocus){
            //Toast.makeText(MainActivity.this,"focus gain",Toast.LENGTH_SHORT).show();
            if((v.getId() == R.id.password || v.getId() == R.id.userName)   && !hasFocus) {
            //Toast.makeText(MainActivity.this,"lOST",Toast.LENGTH_LONG).show();
                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
