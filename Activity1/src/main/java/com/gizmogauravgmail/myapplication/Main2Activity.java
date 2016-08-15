package com.gizmogauravgmail.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    private Button btnClose;
    private TextView txtName,txtEmail, gestureView;
    private ListView listView;
    String [] names = {"Gaurav","Nona","Nonu","Sona","Mona"};

    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDataFromFirstActivity();
        setOnClickListener();
        setListView();
        gestureSetUp();
    }


    private void gestureSetUp(){

        gestureView = (TextView) findViewById(R.id.gestureView);
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
    }
    private void setListView(){

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String>  stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.names_list,names);
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String value = (String)listView.getItemAtPosition(position);
                Toast.makeText(Main2Activity.this,"Position " + position + "Item is " + value, Toast.LENGTH_SHORT).show();
            }
        });

    }

private void setDataFromFirstActivity() {

    txtName = (TextView) findViewById(R.id.txtName);
    txtEmail = (TextView) findViewById(R.id.txtEmail);
    Intent intent = getIntent();
    txtName.setText(intent.getExtras().get("name").toString());
    txtEmail.setText(intent.getExtras().get("email").toString());

       }
    public void setOnClickListener() {

        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
               // Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                //startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }



    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        gestureView.setText("onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        gestureView.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        gestureView.setText("onDoubleTapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        gestureView.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        gestureView.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        gestureView.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        gestureView.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        gestureView.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        gestureView.setText("onFling");
        return false;
    }
}
