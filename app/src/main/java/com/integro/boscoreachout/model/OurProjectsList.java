package com.integro.boscoreachout.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OurProjectsList {
    @SerializedName("bosco_projects")
    ArrayList<OurProjects>ourProjectsArrayList;

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

    public ArrayList<OurProjects>getOurProjectsArrayList(){
        return ourProjectsArrayList;
    }
    public void setOurProjectsArrayList(ArrayList<OurProjects>ourProjectsArrayList){
        this.ourProjectsArrayList=ourProjectsArrayList;
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
