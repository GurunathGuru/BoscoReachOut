package com.integro.boscoreachout.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DirectorMsgList {
    @SerializedName("bosco_news")
    ArrayList<DirectorMsg>directorMsgArrayList;

    private String success;

    private String message;

    public ArrayList<DirectorMsg>getDirectorMsgArrayList(){
        return directorMsgArrayList;
    }

  public void setDirectorMsgArrayList(ArrayList<DirectorMsg>directorMsgArrayList){
        this.directorMsgArrayList=directorMsgArrayList;
  }

        public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
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
