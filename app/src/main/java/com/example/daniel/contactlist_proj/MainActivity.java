package com.example.daniel.contactlist_proj;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniel.contactlist_proj.ui.DetailFragment;
import com.example.daniel.contactlist_proj.ui.RecyclerFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        RecyclerFragment recyclerFragment = new RecyclerFragment();

        transaction.add(R.id.activity_main, recyclerFragment);
        transaction.commit();
    }
}
