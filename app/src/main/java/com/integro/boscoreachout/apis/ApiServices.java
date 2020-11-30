package com.integro.boscoreachout.apis;

import com.integro.boscoreachout.activities.OurProjectsActivity;
import com.integro.boscoreachout.model.DirectorMsgList;
import com.integro.boscoreachout.model.NewsImageList;
import com.integro.boscoreachout.model.NewsList;
import com.integro.boscoreachout.model.NotificationList;
import com.integro.boscoreachout.model.OurProjectsList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {
    @FormUrlEncoded
    @POST("bosco_news.php")
    Call<NewsList> getNewsList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("bosco_notification.php")
    Call<NotificationList> getNotificationList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("bosco_newsimages.php")
    Call<NewsImageList> getNewsImageLIst(@Field("news_id")String updated_at);

    @FormUrlEncoded
    @POST("bosco_projects.php")
    Call<OurProjectsList> getOueProjectsList(@Field("updated_at")String updated_at);

    @FormUrlEncoded
    @POST("bosco_directormsg.php")
    Call<DirectorMsgList> getDirectorMsgList(@Field("updated_at")String updated_at);




}
