package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.SectionBean;
import com.read.booklibrary.ui.adapter.view.SectionHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-16.
 */

public class SectionAdapter extends BaseListAdapter<SectionBean> {
    @Override
    protected IViewHolder<SectionBean> createViewHolder(int viewType) {
        return new SectionHolder();
    }
}
