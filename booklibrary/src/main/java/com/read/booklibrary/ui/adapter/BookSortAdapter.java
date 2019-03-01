package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.BookSortBean;
import com.read.booklibrary.ui.adapter.view.BookSortHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-23.
 */

public class BookSortAdapter extends BaseListAdapter<BookSortBean>{

    @Override
    protected IViewHolder<BookSortBean> createViewHolder(int viewType) {
        return new BookSortHolder();
    }
}
