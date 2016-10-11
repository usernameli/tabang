package com.nvma.tabang.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import com.nvma.tabang.R;
import com.nvma.tabang.fragment.FragmentMainMission;
import com.nvma.tabang.view.Frag;

public class Activity_main extends BaseFragmentActivity {
    private ViewPager mPager;
    private RadioGroup mGroup;

    @Override
    public void setView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        mPager = (ViewPager) findViewById(R.id.content);
        mGroup = (RadioGroup) findViewById(R.id.group);

        mGroup.check(R.id.one);


        mPager.setOffscreenPageLimit(4);
     //   init();
    }

    @Override
    public void initParams() {
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void setAction() {
        mGroup.setOnCheckedChangeListener(new CheckedChangeListener());
        mPager.setOnPageChangeListener(new PageChangeListener());
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentMainMission();
                case 1:
                    return new Frag();
                case 2:
                    return new Frag();
                case 3:
                    return new Frag();

                default:
                    return null;
            }
            // Frag frag = new Frag();
            // Bundle bundle = new Bundle();
            // bundle.putString("key", "" + position);
            // frag.setArguments(bundle);
            // return frag;
        }

        public int getCount() {
            return 4;
        }
    }

    private class CheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.one:
                    mPager.setCurrentItem(0);
                    //  reset(1);
                    break;
                case R.id.two:
                    mPager.setCurrentItem(1);
                    //  reset(2);
                    break;
                case R.id.three:
                    mPager.setCurrentItem(2);
                    //   reset(3);
                    break;

                // long a=System.currentTimeMillis();
                case R.id.four:
                    // if (!Config.LOGIN) {
                    // Toast.makeText(Activity_main.this, "���ȵ�¼", 0).show();
                    // startActivity(new Intent().setClass(Activity_main.this,
                    // Activity_register.class));
                    // return;
                    // }
                    mPager.setCurrentItem(4);
                    //   reset(4);
                    break;
            }
        }
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mGroup.check(R.id.one);
                    break;
                case 1:
                    mGroup.check(R.id.two);
                    break;
                case 2:
                    mGroup.check(R.id.three);
                    break;
                case 3:
                    mGroup.check(R.id.four);
                    break;

            }
        }

        public void onPageScrollStateChanged(int arg0) {
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    }

}
