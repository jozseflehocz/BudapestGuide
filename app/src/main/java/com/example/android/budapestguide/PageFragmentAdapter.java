package com.example.android.budapestguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private Context context;
    private String tabTitles[] = new String[] { context.getString(R.string.category_restaurant), context.getString(R.string.category_sightseeing), context.getString(R.string.category_spa), context.getString(R.string.category_hotel) };

    public PageFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
