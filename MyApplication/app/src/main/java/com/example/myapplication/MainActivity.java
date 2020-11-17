package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;
    LinearLayout linearSearch;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearSearch = findViewById(R.id.linearSreach);
        toolbar = findViewById(R.id.toolbar);



        bottomNavigationView = findViewById(R.id.bottom_nav);

        displayFragment(R.id.mnuInfo);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                displayFragment(item.getItemId());
                return true;
            }
        });

       // setSupportActionBar(toolbar);
    }



    private void displayFragment(int itemId) {
        Fragment fragment = null;

        switch (itemId){
            case R.id.mnuHome:
                toolbar.setVisibility(View.GONE);
                linearSearch.setVisibility(View.VISIBLE);
                fragment = new HomeFragment();
                if(menuItem != null) {
                    menuItem.setVisible(false);
                }
                break;
            case R.id.mnuAccount:
                toolbar.setVisibility(View.GONE);
                linearSearch.setVisibility(View.VISIBLE);
                fragment = new AccountFragment();


                break;
            case R.id.mnuInfo:
                toolbar.setVisibility(View.VISIBLE);
                linearSearch.setVisibility(View.GONE);

                setSupportActionBar(toolbar);
                fragment = InfoFragment.newInstance("name", "name");

                break;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();

    }




}
