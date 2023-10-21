package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    Button add_btn;
    Button edit_btn;

    Button profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.addbtn);
        edit_btn = findViewById(R.id.btneditpost);

        profile = findViewById(R.id.mypostbtn);

        add_btn.setOnClickListener(v ->

        {


            Intent intent = new Intent(getApplicationContext(), AddPost.class);
            startActivity(intent);

        });
        edit_btn.setOnClickListener(v ->
        {
            Intent intent = new Intent(getApplicationContext(), ShowPostActivity.class);
            startActivity(intent);

        });


    }


}

class userInfo {
    String userID;
    String img_url;

    String desc;

    int timespamp;


    public userInfo(String userID, String img_url, String desc, int timespamp) {
        this.userID = userID;
        this.img_url = img_url;
        this.desc = desc;
        this.timespamp = timespamp;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTimespamp() {
        return timespamp;
    }

    public void setTimespamp(int timespamp) {
        this.timespamp = timespamp;
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "userID='" + userID + '\'' +
                ", img_url='" + img_url + '\'' +
                ", desc='" + desc + '\'' +
                ", timespamp=" + timespamp +
                '}';
    }
}


