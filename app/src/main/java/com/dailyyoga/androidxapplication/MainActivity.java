package com.dailyyoga.androidxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dailyyoga.androidxapplication.databinding.ActivityMainBinding;
import com.dailyyoga.androidxapplication.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        mBinding.bottomNavigation.setOnClickListener(view -> {
            Intent intent = new Intent(this, BottomNavigationActivity.class);
            startActivity(intent);
        });

        mBinding.tabbed.setOnClickListener(view -> {
            Intent intent = new Intent(this, TabbedActivity.class);
            startActivity(intent);
        });

        mBinding.loginDialog.setOnClickListener(v -> new LoginFragment()
                .show(getSupportFragmentManager(), LoginFragment.class.getSimpleName()));
    }
}