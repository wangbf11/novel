package com.read.booklibrary.event;

import com.read.booklibrary.model.flag.BookDistillate;
import com.read.booklibrary.model.flag.BookSort;
import com.read.booklibrary.model.flag.BookType;

/**
 * Created by newbiechen on 17-4-21.
 */

public class SelectorEvent {

    public BookDistillate distillate;

    public BookType type;

    public BookSort sort;

    public SelectorEvent(BookDistillate distillate,
                         BookType type,
                         BookSort sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }
}
