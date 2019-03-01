package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.CollBookBean;
import com.read.booklibrary.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-5-8.
 */

public interface BookShelfContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<CollBookBean> collBookBeans);
        void finishUpdate();
        void showErrorTip(String error);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshCollBooks();
        void createDownloadTask(CollBookBean collBookBean);
        void updateCollBooks(List<CollBookBean> collBookBeans);
        void loadRecommendBooks(String gender);
    }
}
