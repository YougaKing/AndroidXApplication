package com.dailyyoga.androidxapplication.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPager2Adapter extends FragmentStateAdapter {


    private final List<Fragment> mFragmentList;
    private final Set<Long> mFragmentIds = new HashSet<>();

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        mFragmentList = fragmentList;
    }

    public ViewPager2Adapter(@NonNull Fragment fragment, List<Fragment> fragmentList) {
        super(fragment);
        mFragmentList = fragmentList;
    }

    public void removeFragment(int position) {
        mFragmentList.remove(position);
        notifyItemRangeChanged(position, mFragmentList.size());
        notifyDataSetChanged();
    }

    public void addFragment(int position, Fragment fragment) {
        mFragmentList.add(position, fragment);
        notifyItemRangeChanged(position, mFragmentList.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = mFragmentList.get(position);
        mFragmentIds.add((long) fragment.hashCode());
        return fragment;
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }

    //make sure notifyDataSetChanged() works
    @Override
    public long getItemId(int position) {
        return mFragmentList.get(position).hashCode();
    }

    @Override
    public boolean containsItem(long itemId) {
        return mFragmentIds.contains(itemId);
    }
}
