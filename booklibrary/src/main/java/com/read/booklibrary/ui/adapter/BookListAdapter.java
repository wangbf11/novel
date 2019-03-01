package com.read.booklibrary.ui.adapter;

import android.content.Context;

import com.read.booklibrary.model.bean.BookListBean;
import com.read.booklibrary.ui.adapter.view.BookListHolder;
import com.read.booklibrary.ui.base.adapter.IViewHolder;
import com.read.booklibrary.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-5-1.
 */

public class BookListAdapter extends WholeAdapter<BookListBean> {
    public BookListAdapter() {
    }

    public BookListAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookListBean> createViewHolder(int viewType) {
        return new BookListHolder();
    }
}
