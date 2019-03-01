package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.packages.BookSortPackage;
import com.read.booklibrary.model.bean.packages.BookSubSortPackage;
import com.read.booklibrary.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-4-23.
 */

public interface BookSortContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookSortPackage sortPackage, BookSubSortPackage subSortPackage);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshSortBean();
    }
}
