package ru.jewelline.tutorials.ui;

public class NavigationDrawerItem {
    private String mTitle;

    public NavigationDrawerItem(String itemTitle) {
        this.mTitle = itemTitle;
    }

    public String getTitle(){
        return this.mTitle;
    }

    public void setTitle(String itemTitle){
        this.mTitle = itemTitle;
    }
}
