package com.example.adventura.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.adventura.R;
import com.example.adventura.fragments.RacersFragment;
import com.example.adventura.fragments.TrackFragment;
import com.example.adventura.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        openFragment(new TrackFragment());
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId())
                {
                    case R.id.track:
                        fragment=new TrackFragment();
                        break;
                    case R.id.racers:
                        fragment=new RacersFragment();
                        break;
                }
                openFragment(fragment);
                return true;
            }
        });
    }
    public void openFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.fragmentLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}