package ru.jewelline.tutorials;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

public class MainScreenActivity extends AppCompatActivity {

    private Toolbar mToolbar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);

        mToolbar = (Toolbar) findViewById(R.id.mainScreenToolbar);

        initializeToolbar();
    }

    private void initializeToolbar() {
        mToolbar.setTitle(R.string.application_title);
        mToolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // here we will hide buttons when a navigation drawer is open
        return super.onPrepareOptionsMenu(menu);
    }
}
