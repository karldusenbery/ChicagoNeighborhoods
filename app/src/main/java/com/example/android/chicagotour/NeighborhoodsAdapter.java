package com.example.android.chicagotour;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by admin on 26-06-2016.
 */
public class NeighborhoodsAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Wicker Park", "Andersonville", "Lakeview", "The Loop"};

    public NeighborhoodsAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new WickerParkFragment();
        } else if (position == 1){
            return new AndersonvilleFragment();
        } else if (position == 2) {
            return new LakeviewFragment();
        } else {
            return new TheLoopFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
