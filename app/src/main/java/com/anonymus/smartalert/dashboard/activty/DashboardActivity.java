package com.anonymus.smartalert.dashboard.activty;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dashboard.fragment.DashboardFragment;
import com.anonymus.smartalert.dashboard.fragment.FragmentEmployee;
import com.anonymus.smartalert.dashboard.fragment.FragmentNotification;
import com.anonymus.smartalert.event.EventChangeFragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.event.EventToolbarColor;
import com.anonymus.smartalert.utils.MainBus;
import com.squareup.otto.Subscribe;


public class DashboardActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigation;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainBus.getInstance().getBus().register(this);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigation = (NavigationView) findViewById(R.id.navigation);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_container, DashboardFragment.newInstance())
                    .commit();
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(DashboardActivity.this,
                drawerLayout,
                R.string.open,
                R.string.cloase);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.employee:
                        MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentEmployee.newInstance()));
                        drawerLayout.closeDrawers();
                        break;
                    default:
                        Toast.makeText(DashboardActivity.this, "Menu Selected",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                }
                return false;
            }
        });

        initToolbar();

    }

    private void initToolbar() {
        if (toolbar != null) {
            toolbar.setTitle("Home");
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onDestroy() {
        MainBus.getInstance().getBus().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEventChangeFragmentBackStack(EventChangeFragmentBackStack data){
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_container, data.getmTargetFragment())
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void onEventChangeFragment(EventChangeFragment data){
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_container, data.getmTargetFragment())
                .commit();
    }
    @Subscribe
    public void onEventChangeTitleToolbar(EventChangeTitleToolbar data){
        toolbar.setTitle(data.getmTitle());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()) {
            case android.R.id.home:
                fragmentManager.popBackStack();
                return true;
            case R.id.feeds :
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentNotification.newInstance()));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Subscribe
    public void onChangeToolbarColor(EventToolbarColor eventToolbarColor){
        toolbar.setBackgroundColor(Color.parseColor(eventToolbarColor.getColor()));
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }
}
