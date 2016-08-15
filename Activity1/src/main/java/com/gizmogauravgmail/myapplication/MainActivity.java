package com.gizmogauravgmail.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button, switchbutton;
    private EditText name,email;
    private ImageButton imageView;
    private int currIndex;
    int[] imagearray = {R.mipmap.ic_launcher,R.mipmap.ic_launcher_1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setOnClickListener();

    }

    public void setOnClickListener(){
        switchbutton = (Button) findViewById(R.id.switchimage);
        button = (Button) findViewById(R.id.btnNextScreen);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);

        imageView = (ImageButton)findViewById(R.id.imageButton) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);
            }
        });
        switchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currIndex++;
                currIndex = currIndex % imagearray.length;
                imageView.setImageResource(imagearray[currIndex]);
            }
        });


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
