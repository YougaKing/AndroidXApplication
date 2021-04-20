package com.dailyyoga.androidxapplication.ui;

import android.util.Log;

/**
 * @author: YougaKingWu@gmail.com
 * @created on: 4/19/21 11:09 AM
 * @description:
 */
public interface FragmentVisibleHint {
    String STACK_TAG = "FragmentStack";

    /** fragment创建并且可见,只调用一次 */
    default void onUserVisibleHintCreate() {
        Log.e(STACK_TAG, String.format("%s onUserVisibleHintCreate()", this.getClass().getSimpleName()));
    }

    /** fragment创建后并且可见 */
    default void onUserVisibleHintShow() {
        Log.e(STACK_TAG, String.format("%s onUserVisibleHintShow()", this.getClass().getSimpleName()));
    }

    /** fragment创建后并且不可见 */
    default void onUserVisibleHintHide() {
        Log.e(STACK_TAG, String.format("%s onUserVisibleHintHide()", this.getClass().getSimpleName()));
    }
}
