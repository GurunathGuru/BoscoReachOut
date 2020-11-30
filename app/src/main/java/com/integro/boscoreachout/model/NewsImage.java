package com.integro.boscoreachout.model;

import java.io.Serializable;

public class NewsImage implements Serializable {

    private String image;

    private String updated_at;

    private String id;

    private String news_id;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getNews_id ()
    {
        return news_id;
    }

    public void setNews_id (String news_id)
    {
        this.news_id = news_id;
    }

}
