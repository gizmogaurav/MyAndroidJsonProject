package com.gizmogauravgmail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MultiFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_fragment);

        if(savedInstanceState == null){


            getSupportFragmentManager().beginTransaction().add(R.id.menuContainer,new MenuFragment()).commit();
        }
    }
}
