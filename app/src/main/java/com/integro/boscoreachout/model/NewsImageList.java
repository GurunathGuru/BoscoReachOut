package com.integro.boscoreachout.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsImageList {
    @SerializedName("newsimages")
     private ArrayList<NewsImage>newsImageArrayList;

    private String success;
    private String message;

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public ArrayList<NewsImage>getNewsImageArrayList(){
        return newsImageArrayList;
    }
    public void setNewsImageArrayList(ArrayList<NewsImage>newsImageArrayList){
        this.newsImageArrayList=newsImageArrayList;
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
