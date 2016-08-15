package com.gizmogauravgmail.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button, button4,pagerBtn, menuDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonListener();
    }


    public void onButtonListener(){

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SimpleFragmentActivity.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MultiFragmentActivity.class);
                startActivity(intent);
            }
        });

        pagerBtn = (Button) findViewById(R.id.pagerBtn);
        pagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PagerFragmentActivity.class);
                startActivity(intent);
            }
        });
        menuDrawer = (Button) findViewById(R.id.menuDrawer);
        menuDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PagerFragmentActivity.class);
                startActivity(intent);
            }
        });




    }
}
