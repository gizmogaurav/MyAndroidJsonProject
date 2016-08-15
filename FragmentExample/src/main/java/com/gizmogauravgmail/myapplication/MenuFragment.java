package com.gizmogauravgmail.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    public MenuFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_fragment,container,false);

        Button button1 = (Button) view.findViewById(R.id.fragment1);
        Button button2 = (Button) view.findViewById(R.id.fragment2);
        Button button3 = (Button) view.findViewById(R.id.fragment3);

        fragment = new MultiFragment2();
        fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.container,fragment);
        fragmentTransaction.commit();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new MultiFragment1();
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new MultiFragment2();
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new MultiFragment3();
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
