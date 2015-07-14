package ru.jewelline.tutorials;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import ru.jewelline.tutorials.ui.NavigationDrawerItem;
import ru.jewelline.tutorials.ui.NavigationDrawerItemsAdapter;

public class MainScreenActivity extends AppCompatActivity {

    private Toolbar mToolbar = null;
    private DrawerLayout mNavigationDrawer = null;
    private ActionBarDrawerToggle mNavigationDrawerToggle = null;
    private ListView mNavigationDrawerListView = null;
    private NavigationDrawerItemsAdapter mNavigationDrawerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);

        mToolbar = (Toolbar) findViewById(R.id.mainScreenToolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigationDrawer);
        mNavigationDrawerListView = (ListView) findViewById(R.id.navigationDrawerItems);

        initializeToolbar();
        initializeNavigationDrawer();
        initializeNavigationDrawerListView();
        fillNavigationDrawerItems();
    }

    private void initializeToolbar() {
        setToolbarTitle(R.string.application_title);
        if (mNavigationDrawer != null) {
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchNavigationDrawerState();
                }
            });
        }
        setSupportActionBar(mToolbar);
    }

    private void initializeNavigationDrawer() {
        if (mNavigationDrawer != null) {
            mNavigationDrawerToggle = new ActionBarDrawerToggle(
                    this,
                    mNavigationDrawer,
                    mToolbar,
                    R.string.accessibility_open_navigation_drawer,
                    R.string.accessibility_close_navigation_drawer) {

                public void onDrawerClosed(View view) {
                    setToolbarTitle(R.string.application_title);
                    // refresh toolbar action buttons
                    supportInvalidateOptionsMenu();
                }

                public void onDrawerOpened(View drawerView) {
                    setToolbarTitle(R.string.application_title);
                    // refresh toolbar action buttons
                    supportInvalidateOptionsMenu();
                }
            };
            mNavigationDrawer.setDrawerListener(mNavigationDrawerToggle);
        }
    }

    private void initializeNavigationDrawerListView() {
        if (mNavigationDrawerListView != null) {
            mNavigationDrawerAdapter = new NavigationDrawerItemsAdapter(this);
            mNavigationDrawerListView.setAdapter(mNavigationDrawerAdapter);
        }
    }

    private void setToolbarTitle(int resourceId) {
        if (mToolbar != null) {
            mToolbar.setTitle(resourceId);
        }
    }

    private void switchNavigationDrawerState() {
        if (mNavigationDrawer != null) {
            if (mNavigationDrawer.isDrawerOpen(GravityCompat.START)) {
                mNavigationDrawer.closeDrawer(GravityCompat.END);
            } else {
                mNavigationDrawer.openDrawer(GravityCompat.START);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean navigationDrawerIsOpen = mNavigationDrawer != null
                && mNavigationDrawer.isDrawerOpen(GravityCompat.START);
        MenuItem searchToolBarItem = menu.findItem(R.id.searchToolbarButton);
        if (searchToolBarItem != null) {
            searchToolBarItem.setVisible(!navigationDrawerIsOpen);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void fillNavigationDrawerItems(){
        mNavigationDrawerAdapter.addHeader(new NavigationDrawerItem("Section 1"));
        mNavigationDrawerAdapter.addItem(new NavigationDrawerItem("Item 1"));
        mNavigationDrawerAdapter.addItem(new NavigationDrawerItem("Item 2"));
        mNavigationDrawerAdapter.addHeader(new NavigationDrawerItem("Section 2"));
        mNavigationDrawerAdapter.addItem(new NavigationDrawerItem("Item 1"));
        mNavigationDrawerAdapter.addItem(new NavigationDrawerItem("Item 2"));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        if (mNavigationDrawerToggle != null) {
            mNavigationDrawerToggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        if (mNavigationDrawerToggle != null) {
            mNavigationDrawerToggle.onConfigurationChanged(newConfig);
        }
    }
}
