//package com.dailyyoga.androidxapplication.ui.main;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import java.util.List;
//
///**
// * A [FragmentPagerAdapter] that returns a fragment corresponding to
// * one of the sections/tabs/pages.
// */
//public class ViewPagerAdapter extends FragmentPagerAdapter {
//
//
//    private final List<Fragment> mFragmentList;
//
//    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
//        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        mFragmentList = fragmentList;
//    }
//
//    public List<Fragment> getFragmentList() {
//        return mFragmentList;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        return mFragmentList.get(position);
//    }
//
//    @Override
//    public int getCount() {
//        return mFragmentList.size();
//    }
//}
