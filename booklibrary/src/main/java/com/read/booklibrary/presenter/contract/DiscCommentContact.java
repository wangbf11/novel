package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.BookCommentBean;
import com.read.booklibrary.model.flag.BookDistillate;
import com.read.booklibrary.model.flag.BookSort;
import com.read.booklibrary.model.flag.CommunityType;
import com.read.booklibrary.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-4-20.
 */

public interface DiscCommentContact {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BookCommentBean> beans);
        void finishLoading(List<BookCommentBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void firstLoading(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void refreshComment(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void loadingComment(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void saveComment(List<BookCommentBean> beans);
    }
}
