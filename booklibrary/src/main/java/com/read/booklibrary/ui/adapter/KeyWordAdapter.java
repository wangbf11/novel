package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.ui.adapter.view.KeyWordHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-6-2.
 */

public class KeyWordAdapter extends BaseListAdapter<String> {
    @Override
    protected IViewHolder<String> createViewHolder(int viewType) {
        return new KeyWordHolder();
    }
}
