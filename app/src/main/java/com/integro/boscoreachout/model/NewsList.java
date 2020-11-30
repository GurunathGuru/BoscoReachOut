package com.integro.boscoreachout.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsList {
    @SerializedName("bosco_news")
    private ArrayList<News>newsArrayList;

    private int success;
    private String message;

    public ArrayList<News>getNewsArrayList(){
        return newsArrayList;
    }
    public void setNewsArrayList(ArrayList<News>newsArrayList){
        this.newsArrayList=newsArrayList;
    }

    public int getSuccess ()
    {
        return success;
    }

    public void setSuccess (int success)
    {
        this.success = success;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }
}
