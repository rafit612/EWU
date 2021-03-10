package com.example.ewulife;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Fragment1();
            case 1 : return new Fragment2();
            case 2 : return new Fragment3();
            case 3 : return new Fragment4();
            case 4 : return new Fragment5();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
