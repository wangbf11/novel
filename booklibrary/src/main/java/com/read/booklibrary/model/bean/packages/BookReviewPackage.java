package com.read.booklibrary.model.bean.packages;

import com.read.booklibrary.model.bean.BaseBean;
import com.read.booklibrary.model.bean.BookReviewBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-21.
 */

public class BookReviewPackage extends BaseBean {

    private List<BookReviewBean> reviews;

    public List<BookReviewBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<BookReviewBean> reviews) {
        this.reviews = reviews;
    }
}
