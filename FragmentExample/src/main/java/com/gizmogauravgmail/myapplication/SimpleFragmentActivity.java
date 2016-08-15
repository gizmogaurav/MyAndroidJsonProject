package com.gizmogauravgmail.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SimpleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        if(savedInstanceState == null){


            getSupportFragmentManager().beginTransaction().add(R.id.container,new PlaceHolderFragment()).commit();
        }
    }



    public static class PlaceHolderFragment extends Fragment {


        public PlaceHolderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_simple,container,false);
            Button simpleFragment = (Button) view.findViewById(R.id.simpleFragmentbutton);
            simpleFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),"You clicked Simple Fragment", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }
}
