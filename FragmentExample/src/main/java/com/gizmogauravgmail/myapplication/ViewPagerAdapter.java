package com.gizmogauravgmail.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by gauravgupta01 on 15-08-2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

int[] images = {R.mipmap.baby_image,R.mipmap.ic_launcher,R.mipmap.kitty_image,R.mipmap.mickey_mouse};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyViewPagerFragment.newInstance(position,images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }
}
