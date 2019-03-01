package com.read.booklibrary.ui.adapter;

import android.content.Context;

import com.read.booklibrary.model.bean.SortBookBean;
import com.read.booklibrary.ui.adapter.view.BookSortListHolder;
import com.read.booklibrary.ui.base.adapter.IViewHolder;
import com.read.booklibrary.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-5-3.
 */

public class BookSortListAdapter extends WholeAdapter<SortBookBean>{
    public BookSortListAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<SortBookBean> createViewHolder(int viewType) {
        return new BookSortListHolder();
    }
}
