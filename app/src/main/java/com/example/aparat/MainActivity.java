package com.example.aparat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aparat.adapter.TabsAdapter;
import com.example.aparat.databinding.ActivityMainBinding;
import com.example.aparat.fragment.CategoryFragment;
import com.example.aparat.fragment.FavoriteFragment;
import com.example.aparat.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Binding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());

        TabsAdapter adapter = new TabsAdapter(this, fragmentList);
        binding.pager.setAdapter(adapter);
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.item_home) {

                    binding.pager.setCurrentItem(0);
                    binding.bottomNav.getMenu().findItem(R.id.item_home).setChecked(true);
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();

                } else if (item.getItemId() == R.id.item_category) {

                    binding.pager.setCurrentItem(1);
                    binding.bottomNav.getMenu().findItem(R.id.item_category).setChecked(true);
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, new CategoryFragment()).commit();

                } else {

                    binding.pager.setCurrentItem(2);
                    binding.bottomNav.getMenu().findItem(R.id.item_favorite).setChecked(true);
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FavoriteFragment()).commit();

                }

                return false;
            }
        });

        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (position == 0) {

                    binding.bottomNav.getMenu().findItem(R.id.item_home).setChecked(true);

                } else if (position == 1) {

                    binding.bottomNav.getMenu().findItem(R.id.item_category).setChecked(true);

                } else {

                    binding.bottomNav.getMenu().findItem(R.id.item_favorite).setChecked(true);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}