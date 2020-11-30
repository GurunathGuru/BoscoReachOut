package com.integro.boscoreachout.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.integro.boscoreachout.fragments.FragmentWeb;
import com.integro.boscoreachout.fragments.FragmentNews;
import com.integro.boscoreachout.fragments.FragmentHome;
import com.integro.boscoreachout.fragments.FragmentNotifications;

public class SlidePageAdapter extends FragmentPagerAdapter {

    public SlidePageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0) {
            fragment = new FragmentHome();
        }
        if (position == 1) {
            fragment = new FragmentNews();
        }
        if (position == 2) {
            fragment = new FragmentNotifications();
        }
        if (position == 3) {
            fragment = new FragmentWeb();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
