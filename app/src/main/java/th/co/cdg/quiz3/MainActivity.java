package th.co.cdg.quiz3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.co.cdg.quiz3.Interface.PostInterface;
import th.co.cdg.quiz3.adapter.CommentAdapter;
import th.co.cdg.quiz3.model.Comment;
import th.co.cdg.quiz3.util.RetrofitClient;

public class MainActivity extends AppCompatActivity implements CommentAdapter.ItemClickListener {

    private PostInterface postInterface;
    private CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postInterface = RetrofitClient.getClient().create(PostInterface.class);


        RecyclerView recyclerView = findViewById(R.id.recycler);

        adapter = new CommentAdapter(getApplicationContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        getCommentbyPostId();

    }

    protected void getCommentbyPostId() {

        Call<List<Comment>> call = postInterface.getCommentbyPostId("1");

        call.enqueue(new Callback<List<Comment>>() {

            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    Log.d("dlg", "onResponse: " + response.body().get(0).getEmail());

                    List<Comment> _comments = response.body();

                    for (Comment comment : _comments) {
                        adapter.add(comment);
                        Log.d("dlg", "getEmail: " + comment.getEmail());
                    }
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.e("dlg", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("DETAIL", new Comment(
                adapter.getItem(position).getPostId(),
                adapter.getItem(position).getId(),
                adapter.getItem(position).getName(),
                adapter.getItem(position).getEmail(),
                adapter.getItem(position).getBody()));
        startActivity(intent);
    }
}

