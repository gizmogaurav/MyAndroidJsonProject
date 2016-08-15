package com.gizmogauravgmail.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MyViewPagerFragment extends Fragment {

    public MyViewPagerFragment() {
        // Required empty public constructor
    }

    public static MyViewPagerFragment newInstance(int position, int imageId){
        MyViewPagerFragment myViewPagerFragment = new MyViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imagePosition",position);
        bundle.putInt("imageId",imageId);
        myViewPagerFragment.setArguments(bundle);
        return myViewPagerFragment;
    }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_pager,container,false);

            ImageView imageView = (ImageView)view.findViewById(R.id.pagerImageButton);
            int imageId = getArguments().getInt("imageId");
            int position = getArguments().getInt("imagePosition");


            imageView.setImageResource(imageId);
            Button simpleFragment = (Button) view.findViewById(R.id.pagerFragmentbutton);
            Toast.makeText(getActivity(),"Image position " + position , Toast.LENGTH_SHORT).show();
            simpleFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),"You clicked View Pager Fragment", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }



}

