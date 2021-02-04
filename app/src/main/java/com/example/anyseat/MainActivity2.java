package com.example.anyseat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CrewFragment crewFragment;
    BoardFragment boardFragment;
    StudyFragment studyFragment;
    HomeFragment homeFragment;
    String Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Password = getIntent().getStringExtra("Password");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        crewFragment = new CrewFragment();
        boardFragment = new BoardFragment();
        studyFragment = new StudyFragment();
        homeFragment = new HomeFragment(Password);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_frame_layout, homeFragment)
                .commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.main_frame_layout, homeFragment)
                                .commitAllowingStateLoss();
                        return true;

                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.main_frame_layout, crewFragment)
                                .commitAllowingStateLoss();
                        return true;

                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.main_frame_layout, studyFragment)
                                .commitAllowingStateLoss();
                        return true;

                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.main_frame_layout, boardFragment)
                                .commitAllowingStateLoss();


                        return true;
                }
                return false;
            }
        });

    }
}