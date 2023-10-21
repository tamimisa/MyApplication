package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Model.Post;

public class EditPostActivity extends AppCompatActivity {

    EditText editTextDescription;
    Button btnSaveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);


        Bundle bundle = getIntent().getExtras();
        try {
            if (bundle != null) {
                String postStr = bundle.getString("post");

                Post post = Post.parsePostFromJson(postStr);
                editTextDescription = findViewById(R.id.edit_text_description);
                btnSaveChanges = findViewById(R.id.btn_save_changes_edit_post);

                DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
                if (post != null) {
                    editTextDescription.setText(post.getDescription());
                    btnSaveChanges.setOnClickListener(view -> {
                        post.setDescription(editTextDescription.getText().toString());
                        dbhelper.UpdatePost(post);
                        Toast.makeText(getApplicationContext(), "Post Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    });

                } else {
                   // Toast.makeText(getApplicationContext(), "Post was null", Toast.LENGTH_SHORT).show();

                }

            } else {
                //Toast.makeText(getApplicationContext(), "bundle was null", Toast.LENGTH_SHORT).show();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}