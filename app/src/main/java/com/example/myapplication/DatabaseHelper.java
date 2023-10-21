package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.Model.Post;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DishDive.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_POSTS = "posts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE_URL = "image_url";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_POSTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_IMAGE_URL + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_USER_ID + " INTEGER, " +
                COLUMN_TIMESTAMP + " INTEGER" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades
    }

    public ArrayList<Post> getPosts() {
        try {
            ArrayList<Post> notifications = new ArrayList<>();
            String query = "select * from " + TABLE_POSTS;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Post post = new Post();
                post.setId(c.getInt(0));
                post.setImage_url(c.getString(1));
                post.setDescription(c.getString(2));
                post.setUserId(c.getInt(3));
                post.setTimeStamp(c.getLong(4));
                notifications.add(post);
                c.moveToNext();
            }
            c.close(); // Close the cursor after use
            return notifications;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; // Return null in case of exception
        }
    }


    public void UpdatePost(Post post) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, post.getDescription());
        db.update(TABLE_POSTS, values, COLUMN_ID + "=?", new String[]{post.getId() + ""});
        db.close();
    }


}