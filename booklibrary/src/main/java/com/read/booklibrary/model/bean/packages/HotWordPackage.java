package com.read.booklibrary.model.bean.packages;

import com.read.booklibrary.model.bean.BaseBean;

import java.util.List;

/**
 * Created by newbiechen on 17-6-2.
 */

public class HotWordPackage extends BaseBean {


    private List<String> hotWords;

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }
}
