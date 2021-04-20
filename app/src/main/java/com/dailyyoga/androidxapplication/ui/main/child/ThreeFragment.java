
package com.dailyyoga.androidxapplication.ui.main.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.dailyyoga.androidxapplication.R;
import com.dailyyoga.androidxapplication.databinding.FragmentPlaceholderBinding;
import com.dailyyoga.androidxapplication.ui.BasicFragment;
import com.dailyyoga.androidxapplication.ui.main.ViewPager2Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ThreeFragment extends BasicFragment {

    private FragmentPlaceholderBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_placeholder, container, false);
        mBinding = FragmentPlaceholderBinding.bind(root);
        return root;
    }

    @Override
    public void onUserVisibleHintCreate() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FiveFragment());
        fragments.add(new SixFragment());
        fragments.add(new SevenFragment());

        ViewPager2Adapter adapter = new ViewPager2Adapter(this, fragments);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), fragments);
        mBinding.viewPager.setAdapter(adapter);
        mBinding.viewPager.setOffscreenPageLimit(4);

        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Five"), 0);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Six"), 1);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Seven"), 2);

        mBinding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = mBinding.tabs.getSelectedTabPosition();
                mBinding.viewPager.setCurrentItem(position, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mBinding.tabs.getTabAt(position).select();
            }
        });
//        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mBinding.tabs.getTabAt(position).select();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        mBinding.viewPager.setCurrentItem(1, false);
    }
}