package ru.jewelline.tutorials.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ru.jewelline.tutorials.R;

public class NavigationDrawerItemsAdapter extends BaseAdapter {

    private static final int TYPE_COUNT = 2;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private List<NavigationDrawerItem> mListData = new ArrayList<NavigationDrawerItem>();
    private Set<Integer> mListHeaders = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public NavigationDrawerItemsAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final NavigationDrawerItem item) {
        mListData.add(item);
        notifyDataSetChanged();
    }

    public void addHeader(final NavigationDrawerItem item) {
        mListData.add(item);
        mListHeaders.add(mListData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mListHeaders.contains(position) ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public NavigationDrawerItem getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) == TYPE_ITEM;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.navigation_drawer_item_layout, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.listItemText);
                    break;
                case TYPE_HEADER:
                    convertView = mInflater.inflate(R.layout.navigation_drawer_header_layout, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.listHeaderText);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mListData.get(position).getTitle());

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }
}
