package com.example.mohamed.inclass05;

/**
 * Created by mohamed on 2/13/17.
 */

public class Entry {

    private String title;
    private String desc;
    //NEed date
    private String imgUrl;

    Entry(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
