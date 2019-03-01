package com.read.booklibrary.ui.adapter;

import android.content.Context;

import com.read.booklibrary.model.bean.BookListDetailBean;
import com.read.booklibrary.ui.adapter.view.BookListInfoHolder;
import com.read.booklibrary.ui.base.adapter.IViewHolder;
import com.read.booklibrary.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-5-2.
 */

public class BookListDetailAdapter extends WholeAdapter<BookListDetailBean.BooksBean.BookBean> {
    public BookListDetailAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookListDetailBean.BooksBean.BookBean> createViewHolder(int viewType) {
        return new BookListInfoHolder();
    }
}
