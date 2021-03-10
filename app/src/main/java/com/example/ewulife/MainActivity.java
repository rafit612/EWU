package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar bar;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.nav_ewu);


        if(savedInstanceState ==null){
            bar.setItemSelected(R.id.home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment =new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frag_page,homeFragment)
                    .commit();
        }
        bar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {


            @Override
            public void onItemSelected(int id) {
                Fragment fragment =null;
                switch (id){
                    case R.id.newsfeed:
                        fragment = new FeedFragment();
                        break;
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                }
                if(fragment!=null){
                    fragmentManager =getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frag_page,fragment)
                            .commit();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error opening frag",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}