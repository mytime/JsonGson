package com.example.administrator.jsongson.bean;



import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Book {

    //实体属性名称要和json返回的标签名一致
    private String title;
    private String publisher;
    private String summary;
    private ArrayList<Tag> tags; //Tag.java， json数组

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
