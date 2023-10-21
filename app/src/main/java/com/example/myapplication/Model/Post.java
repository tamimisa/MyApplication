package com.example.myapplication.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    int id;
    String image_url;
    String description;

    int userId;

    long timeStamp;

    Date dateTime;


    public Date getDateTime() {
        return new Date(this.timeStamp);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }


    public static Post parsePostFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.getInt("id");
            long timeStamp = jsonObject.getLong("timeStamp");
            int userId = jsonObject.getInt("userId");
            String description = jsonObject.getString("description");
            String image_url = jsonObject.getString("image_url");

            Post post = new Post();
            post.setId(id);
            post.setUserId(userId);
            post.setDescription(description);
            post.setImage_url(image_url);
            post.setTimeStamp(timeStamp);


            return post;
        } catch (JSONException e) {
            e.printStackTrace();
            return null; // Handle the exception as needed
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id + "," +
                "\"image_url\":\"" + image_url + "\"," +
                "\"description\":\"" + description + "\"," +
                "\"userId\":" + userId + "," +
                "\"timeStamp\":" + timeStamp +
                "}";
    }
}
