package com.example.ilhamsuaib.materialtab;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FloatingActionMenu actionMenu;
    private FloatingActionButton fab_add_class, fab_add_schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        actionMenu = (FloatingActionMenu) findViewById(R.id.floating_action_menu);
        fab_add_class = (FloatingActionButton) findViewById(R.id.fab_add_class);
        fab_add_schedule = (FloatingActionButton) findViewById(R.id.fab_add_schedule);

        fabListener();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ClassFragment());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new ScheduleFragment());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
    }

    private void fabListener(){
        fab_add_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionMenu.close(true);
                startActivity(new Intent(getApplicationContext(), NewClassActivity.class));
            }
        });
        fab_add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionMenu.close(true);
                startActivity(new Intent(getApplicationContext(), NewScheduleActivity.class));
            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        List<Fragment> listFragment = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        public void addFragment(Fragment fragment){
            listFragment.add(fragment);
        }
    }
}
