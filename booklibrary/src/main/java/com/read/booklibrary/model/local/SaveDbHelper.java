package com.read.booklibrary.model.local;

import com.read.booklibrary.model.bean.AuthorBean;
import com.read.booklibrary.model.bean.BookCommentBean;
import com.read.booklibrary.model.bean.BookHelpfulBean;
import com.read.booklibrary.model.bean.BookHelpsBean;
import com.read.booklibrary.model.bean.BookReviewBean;
import com.read.booklibrary.model.bean.DownloadTaskBean;
import com.read.booklibrary.model.bean.ReviewBookBean;
import com.read.booklibrary.model.bean.packages.BillboardPackage;
import com.read.booklibrary.model.bean.packages.BookSortPackage;

import java.util.List;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface SaveDbHelper {
    void saveBookComments(List<BookCommentBean> beans);
    void saveBookHelps(List<BookHelpsBean> beans);
    void saveBookReviews(List<BookReviewBean> beans);
    void saveAuthors(List<AuthorBean> beans);
    void saveBooks(List<ReviewBookBean> beans);
    void saveBookHelpfuls(List<BookHelpfulBean> beans);

    void saveBookSortPackage(BookSortPackage bean);
    void saveBillboardPackage(BillboardPackage bean);
    /*************DownloadTask*********************/
    void saveDownloadTask(DownloadTaskBean bean);
}
