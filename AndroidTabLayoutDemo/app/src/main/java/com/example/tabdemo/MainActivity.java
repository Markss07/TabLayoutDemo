package com.example.tabdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.tabdemo.Fragments.FirstFragment;
import com.example.tabdemo.Fragments.SecondFragment;
import com.example.tabdemo.Fragments.ThirdFragment;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    TabLayout simpleTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVeiws();
    }

    public void initVeiws(){
        simpleFrameLayout = findViewById(R.id.simpleFrameLayout);
        simpleTabLayout = findViewById(R.id.simpleTabLayout);

        //Create New Tab Named as FirstTab
        TabLayout.Tab firstTab = simpleTabLayout.newTab();
        firstTab.setText("FirstTab");
        firstTab.setIcon(R.drawable.ic_launcher_background);
        //First Tab
        simpleTabLayout.addTab(firstTab);

        //Create Second Tab Named as SecondTab
        TabLayout.Tab secondTab = simpleTabLayout.newTab();
        secondTab.setText("SecondTab");
        secondTab.setIcon(R.drawable.ic_launcher_background);
        //Second Tab
        simpleTabLayout.addTab(secondTab);

        //Create Third Tab Named as ThirdTab
        TabLayout.Tab thirdTab = simpleTabLayout.newTab();
        thirdTab.setText("ThirdTab");
        thirdTab.setIcon(R.drawable.ic_launcher_background);
        //Third Tab
        simpleTabLayout.addTab(thirdTab);


        simpleTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //get the Current selected tab's position and replace the Fragment accordingly
                Fragment fragment = null;

                switch (tab.getPosition()){
                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        fragment = new SecondFragment();
                        break;
                    case 2:
                        fragment = new ThirdFragment();
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.simpleFrameLayout,fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
