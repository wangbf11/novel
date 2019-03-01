package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.HotCommentBean;
import com.read.booklibrary.ui.adapter.view.HotCommentHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-4.
 */

public class HotCommentAdapter extends BaseListAdapter<HotCommentBean>{
    @Override
    protected IViewHolder<HotCommentBean> createViewHolder(int viewType) {
        return new HotCommentHolder();
    }
}
