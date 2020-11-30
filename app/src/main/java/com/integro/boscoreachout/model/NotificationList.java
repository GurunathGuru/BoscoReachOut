package com.integro.boscoreachout.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NotificationList {
    @SerializedName("bosco_notification")
    private ArrayList<Notification>notificationArrayList;

    private int success;
    private String message;

    public int getSuccess ()
    {
        return success;
    }

    public void setSuccess (int success)
    {
        this.success = success;
    }
    public ArrayList<Notification>getNotificationArrayList(){
        return notificationArrayList;
    }
    public void setNotificationArrayList(ArrayList<Notification>notificationArrayList){
        this.notificationArrayList=notificationArrayList;
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
