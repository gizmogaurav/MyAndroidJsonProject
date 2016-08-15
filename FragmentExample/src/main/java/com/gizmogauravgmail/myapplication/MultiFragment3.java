package com.gizmogauravgmail.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MultiFragment3 extends Fragment {


    public MultiFragment3(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_multi3,container,false);

        Button button = (Button)view.findViewById(R.id.mickeyFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"You clicked Mickey Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
