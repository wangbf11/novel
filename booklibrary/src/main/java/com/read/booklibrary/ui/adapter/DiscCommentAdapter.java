package com.read.booklibrary.ui.adapter;

import android.content.Context;

import com.read.booklibrary.model.bean.BookCommentBean;
import com.read.booklibrary.ui.adapter.view.DiscCommentHolder;
import com.read.booklibrary.ui.base.adapter.IViewHolder;
import com.read.booklibrary.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-4-20.
 */

public class DiscCommentAdapter extends WholeAdapter<BookCommentBean> {

    public DiscCommentAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookCommentBean> createViewHolder(int viewType) {
        return new DiscCommentHolder();
    }
}
