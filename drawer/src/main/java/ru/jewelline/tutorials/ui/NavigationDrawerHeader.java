package ru.jewelline.tutorials.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ru.jewelline.tutorials.R;

public class NavigationDrawerHeader {
    private TextView mUser = null;
    private TextView mMail = null;
    private ImageView mPhoto = null;

    private View mRootView = null;

    public NavigationDrawerHeader (View navigationDrawerHeader){
        this.mRootView = navigationDrawerHeader;

        this.mUser = (TextView) navigationDrawerHeader.findViewById(R.id.userNameLabel);
        this.mMail = (TextView) navigationDrawerHeader.findViewById(R.id.userEmailLabel);
        this.mPhoto = (ImageView) navigationDrawerHeader.findViewById(R.id.userPhoto);
    }

    public void setUser(CharSequence userName){
        this.mUser.setText(userName);
    }

    public void setMail(CharSequence userEmail){
        this.mMail.setText(userEmail);
    }

    public void setPhoto(Bitmap userPhoto){
        this.mPhoto.setImageBitmap(userPhoto);
    }

    public View getView(){
        return mRootView;
    }
}
