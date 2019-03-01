package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.BillBookBean;
import com.read.booklibrary.ui.adapter.view.BillBookHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-3.
 */

public class BillBookAdapter extends BaseListAdapter<BillBookBean> {
    @Override
    protected IViewHolder<BillBookBean> createViewHolder(int viewType) {
        return new BillBookHolder();
    }
}
