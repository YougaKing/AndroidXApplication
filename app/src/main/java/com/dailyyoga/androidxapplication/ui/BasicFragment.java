package com.dailyyoga.androidxapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author: YougaKingWu@gmail.com
 * @created on: 4/19/21 10:16 AM
 * @description:
 */
public class BasicFragment extends Fragment implements FragmentVisibleHint {

    public static final String TAG = FragmentVisibleHint.STACK_TAG;
    private boolean mFirst = true;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.w(TAG, this.getClass().getSimpleName() + "-onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, this.getClass().getSimpleName() + "-onCreate()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.w(TAG, this.getClass().getSimpleName() + "-onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w(TAG, this.getClass().getSimpleName() + "-onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w(TAG, this.getClass().getSimpleName() + "-onResume()");
        if (mFirst) {
            onUserVisibleHintCreate();
            mFirst = false;
        } else {
            onUserVisibleHintShow();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mFirst) return;
        onUserVisibleHintHide();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w(TAG, this.getClass().getSimpleName() + "-onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w(TAG, this.getClass().getSimpleName() + "-onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG, this.getClass().getSimpleName() + "-onDestroy()");
    }
}
