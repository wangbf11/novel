package com.read.booklibrary.presenter.contract;

import com.read.booklibrary.model.bean.BookDetailBean;
import com.read.booklibrary.model.bean.BookListBean;
import com.read.booklibrary.model.bean.CollBookBean;
import com.read.booklibrary.model.bean.HotCommentBean;
import com.read.booklibrary.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-5-4.
 */

public interface BookDetailContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(BookDetailBean bean);
        void finishHotComment(List<HotCommentBean> beans);
        void finishRecommendBookList(List<BookListBean> beans);

        void waitToBookShelf();
        void errorToBookShelf();
        void succeedToBookShelf();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookDetail(String bookId);
        //添加到书架上
        void addToBookShelf(CollBookBean collBook);
    }
}
