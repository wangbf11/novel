package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.BookListDetailBean;
import com.read.booklibrary.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-5-1.
 */

public interface BookListDetailContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookListDetailBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookListDetail(String detailId);
    }
}
