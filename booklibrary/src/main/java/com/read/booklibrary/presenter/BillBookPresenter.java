package com.read.booklibrary.presenter;

import com.read.booklibrary.model.remote.RemoteRepository;
import com.read.booklibrary.presenter.contract.BillBookContract;
import com.read.booklibrary.ui.base.RxPresenter;
import com.read.booklibrary.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by newbiechen on 17-5-3.
 */

public class BillBookPresenter extends RxPresenter<BillBookContract.View>
        implements BillBookContract.Presenter {
    private static final String TAG = "BillBookPresenter";
    @Override
    public void refreshBookBrief(String billId) {
        Disposable remoteDisp = RemoteRepository.getInstance()
                .getBillBooks(billId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (beans)-> {
                            mView.finishRefresh(beans);
                            mView.complete();
                        }
                        ,
                        (e) ->{
                            mView.showError();
                            LogUtils.e(e);
                        }
                );
        addDisposable(remoteDisp);
    }
}
