package com.example.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ClassScActivity extends AppCompatActivity {
    Toolbar toolbar;
     ViewPager viewPager;
     TabLayout tabLayout;

    SundayFragment sf;
    private MondayFragment mf;
    private TuesdayFragment tf;
    private WednesdayFragment wf;
    private ThursdayFragment rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_sc);

        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager2);
        tabLayout = findViewById(R.id.tab_layout1);

        sf = new SundayFragment();
        mf = new MondayFragment();
        tf = new TuesdayFragment();
        wf = new WednesdayFragment();
        rf = new ThursdayFragment();

        tabLayout.setupWithViewPager(viewPager);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(sf, "Sunday");
        viewPagerAdapter.addFragment(mf, "Monday");
        viewPagerAdapter.addFragment(tf, "Tuesday");
        viewPagerAdapter.addFragment(wf, "Wednesday");
        viewPagerAdapter.addFragment(rf, "Thursday");

        viewPager.setAdapter(viewPagerAdapter);



    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}