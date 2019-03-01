package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.packages.SearchBookPackage;
import com.read.booklibrary.ui.adapter.view.SearchBookHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-6-2.
 */

public class SearchBookAdapter extends BaseListAdapter<SearchBookPackage.BooksBean>{
    @Override
    protected IViewHolder<SearchBookPackage.BooksBean> createViewHolder(int viewType) {
        return new SearchBookHolder();
    }
}
