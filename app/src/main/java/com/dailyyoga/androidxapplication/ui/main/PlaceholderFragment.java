package com.dailyyoga.androidxapplication.ui.main;

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
import com.dailyyoga.androidxapplication.ui.main.child.FourFragment;
import com.dailyyoga.androidxapplication.ui.main.child.OneFragment;
import com.dailyyoga.androidxapplication.ui.main.child.ThreeFragment;
import com.dailyyoga.androidxapplication.ui.main.child.TwoFragment;
import com.dailyyoga.androidxapplication.ui.main.child.ZeroFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BasicFragment {

    private FragmentPlaceholderBinding mBinding;
    private ViewPager2Adapter mAdapter;
//    private ViewPagerAdapter mAdapter;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

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
        super.onUserVisibleHintCreate();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());

        mAdapter = new ViewPager2Adapter(this, fragments);
//        mAdapter =new ViewPagerAdapter(getChildFragmentManager(),fragments);
        mBinding.viewPager.setAdapter(mAdapter);
        mBinding.viewPager.setOffscreenPageLimit(4);

        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("One"), 0);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Two"), 1);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Three"), 2);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Four"), 3);

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

    @Override
    public void onUserVisibleHintShow() {
        super.onUserVisibleHintShow();

        if (mAdapter.getItemCount() == 5) return;
        mBinding.tabs.removeAllTabs();
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Zero"), 0);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("One"), 1);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Two"), 2);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Three"), 3);
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Four"), 4);
        mAdapter.addFragment(0, new ZeroFragment());
    }
}