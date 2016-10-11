package com.nvma.tabang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.nvma.tabang.R;
import com.nvma.tabang.view.Frag;

public class FragmentMainMission extends Fragment {

    private View v;
    ViewPager viewPager;
    PagerSlidingTabStrip tabs;
    MyPagerAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pageslider, null);
        tabs = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setViewPager(viewPager);

        return v;
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"最新任务", "跑腿代做", "文案写作", "平面设计",
                "辅导培训", "家电维修", "软件开发", "网站制作", "传单配发", "模特主持", "艺术指导", "导游导购",
                "照看陪护", "宠物寄养", "网络营销", "其他服务"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @SuppressWarnings("finally")
        @Override
        public Fragment getItem(int position) {
            //	return new FragmentMission(TITLES[position]);
            return new Frag();
        }
    }

}
