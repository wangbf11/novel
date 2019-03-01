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

import io.reactivex.Single;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface GetDbHelper {
    Single<List<BookCommentBean>> getBookComments(String block, String sort, int start, int limited, String distillate);
    Single<List<BookHelpsBean>> getBookHelps(String sort, int start, int limited, String distillate);
    Single<List<BookReviewBean>> getBookReviews(String sort, String bookType, int start, int limited, String distillate);
    BookSortPackage getBookSortPackage();
    BillboardPackage getBillboardPackage();

    AuthorBean getAuthor(String id);
    ReviewBookBean getReviewBook(String id);
    BookHelpfulBean getBookHelpful(String id);

    /******************************/
    List<DownloadTaskBean> getDownloadTaskList();
}
