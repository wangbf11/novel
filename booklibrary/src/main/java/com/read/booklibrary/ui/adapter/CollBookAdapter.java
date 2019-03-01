package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.CollBookBean;
import com.read.booklibrary.ui.adapter.view.CollBookHolder;
import com.read.booklibrary.ui.base.adapter.IViewHolder;
import com.read.booklibrary.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-5-8.
 */

public class CollBookAdapter extends WholeAdapter<CollBookBean> {

    @Override
    protected IViewHolder<CollBookBean> createViewHolder(int viewType) {
        return new CollBookHolder();
    }

}
