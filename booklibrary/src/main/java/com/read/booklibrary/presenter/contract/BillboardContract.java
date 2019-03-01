package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.packages.BillboardPackage;
import com.read.booklibrary.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-4-23.
 */

public interface BillboardContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BillboardPackage beans);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void loadBillboardList();
    }
}
