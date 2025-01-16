package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;


public class ClassScActivity extends AppCompatActivity {
    Toolbar toolbar;
     ViewPager viewPager;
     TabLayout tabLayout;
     Button button;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    public static final String EXTRA_CREDIT= "com.hm.roktojoddha.EXTRA_CREDIT";
    public static final String EXTRA_DROP = "com.hm.roktojoddha.EXTRA_DROP";
    public static final String EXTRA_SEMISTER   = "com.hm.roktojoddha.EXTRA_SEMISTER";

    String credit10,drop10,semi10;
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
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID =fAuth.getCurrentUser().getUid();
        viewPager = findViewById(R.id.view_pager2);
        tabLayout = findViewById(R.id.tab_layout1);
        button = findViewById(R.id.button17);

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DocumentReference documentReference2 = fstore.collection("EWU_student").document(userID);
                documentReference2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {

                        final String credit=(documentSnapshot.getString("Credit"));

                        final String   drop=(documentSnapshot.getString("Drop"));
                        final String   semister=(documentSnapshot.getString("Semister"));

                        documentReference2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(ClassScActivity.this, SemisterEndActivity.class);
                                    intent.putExtra(EXTRA_CREDIT, credit);
                                    intent.putExtra(EXTRA_DROP, drop);
                                    intent.putExtra(EXTRA_SEMISTER, semister);
                                    startActivity(intent);



                                }
                                else{
                                    Toast.makeText(ClassScActivity.this, "Error", Toast.LENGTH_LONG).show();
                                }
                            }
                        });



                    }
                });

            }
        });

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