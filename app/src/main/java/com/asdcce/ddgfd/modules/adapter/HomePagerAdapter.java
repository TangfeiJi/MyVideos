package com.asdcce.ddgfd.modules.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> titeList;


    public HomePagerAdapter(FragmentManager fm,List<Fragment> mFragments,List<String> titeList) {
        super(fm);
        this.mFragments=mFragments;
        this.titeList=titeList;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titeList.get(position);
    }
}
