package com.read.booklibrary.ui.adapter;

import com.read.booklibrary.model.bean.DownloadTaskBean;
import com.read.booklibrary.ui.adapter.view.DownloadHolder;
import com.read.booklibrary.ui.base.adapter.BaseListAdapter;
import com.read.booklibrary.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-12.
 */

public class DownLoadAdapter extends BaseListAdapter<DownloadTaskBean>{

    @Override
    protected IViewHolder<DownloadTaskBean> createViewHolder(int viewType) {
        return new DownloadHolder();
    }
}
