package com.read.booklibrary.model.local;

import com.read.booklibrary.model.bean.AuthorBean;
import com.read.booklibrary.model.bean.BookCommentBean;
import com.read.booklibrary.model.bean.BookHelpfulBean;
import com.read.booklibrary.model.bean.BookHelpsBean;
import com.read.booklibrary.model.bean.BookReviewBean;
import com.read.booklibrary.model.bean.ReviewBookBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface DeleteDbHelper {
    void deleteBookComments(List<BookCommentBean> beans);
    void deleteBookReviews(List<BookReviewBean> beans);
    void deleteBookHelps(List<BookHelpsBean> beans);
    void deleteAuthors(List<AuthorBean> beans);
    void deleteBooks(List<ReviewBookBean> beans);
    void deleteBookHelpful(List<BookHelpfulBean> beans);
    void deleteAll();
}
