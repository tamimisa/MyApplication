package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AddPost;
import com.example.myapplication.EditPostActivity;
import com.example.myapplication.Model.Post;
import com.example.myapplication.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private static final String TAG = "NotificationAdapter";
    private final ArrayList<Post> posts;
    private final Context context;

    public PostAdapter(ArrayList<Post> posts, Context context) {

        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.post_cell, null);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post p = posts.get(position);
        holder.setItems(p, context);
    }

    @Override
    public void onViewRecycled(@NonNull PostAdapter.PostViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postImageView;
        TextView tvDatetime, tvDescription;
        Button btnEditPost;

        public PostViewHolder(View view) {
            super(view);
            postImageView = view.findViewById(R.id.image_view_post_cell);
            tvDatetime = view.findViewById(R.id.text_view_timestamp);
            tvDescription = view.findViewById(R.id.text_view_description);
            btnEditPost = view.findViewById(R.id.btn_edit_post_cell);
        }

        public void setItems(Post post, Context context) {
            tvDatetime.setText(post.getDateTime().toString());
            tvDescription.setText(post.getDescription());
            try {
                //postImageView.setImageURI(Uri.parse(post.getImage_url()));
            } catch (Exception e) {
                Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            btnEditPost.setOnClickListener(view -> {
                Intent intent = new Intent(context, EditPostActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("post", post.toString());
                intent.putExtras(bundle);

                //Toast.makeText(context, bundle.toString(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);

            });
        }
    }
}
