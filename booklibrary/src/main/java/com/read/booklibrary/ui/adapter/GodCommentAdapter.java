package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.CommentBean;
import com.read.booklibrary.ui.adapter.view.CommentHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-29.
 */

public class GodCommentAdapter extends BaseListAdapter<CommentBean>{
    @Override
    protected IViewHolder<CommentBean> createViewHolder(int viewType) {
        return new CommentHolder(true);
    }
}
