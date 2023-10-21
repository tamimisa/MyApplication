package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapters.PostAdapter;
import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.Model.Post;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ShowPostActivity extends AppCompatActivity {

    RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        rvPosts = findViewById(R.id.recycler_view_posts);
        DatabaseHelper dbhelper = new DatabaseHelper(this);
        ArrayList<Post> posts = dbhelper.getPosts();
        PostAdapter adapter = new PostAdapter(posts, this);
        rvPosts.setAdapter(adapter);

    }
}