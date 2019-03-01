package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.BookHelpsBean;
import com.read.booklibrary.model.flag.BookDistillate;
import com.read.booklibrary.model.flag.BookSort;
import com.read.booklibrary.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-4-21.
 */

public interface DiscHelpsContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BookHelpsBean> beans);
        void finishLoading(List<BookHelpsBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void firstLoading(BookSort sort, int start, int limited, BookDistillate distillate);
        void refreshBookHelps(BookSort sort, int start, int limited, BookDistillate distillate);
        void loadingBookHelps(BookSort sort, int start, int limited, BookDistillate distillate);
        void saveBookHelps(List<BookHelpsBean> beans);
    }
}
