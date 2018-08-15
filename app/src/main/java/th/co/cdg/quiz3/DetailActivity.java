package th.co.cdg.quiz3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import th.co.cdg.quiz3.model.Comment;

public class DetailActivity extends AppCompatActivity {

    private Comment commemt;
    private TextView tvPostId, tvId, tvName, tvEmail, tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvPostId = findViewById(R.id.tv_post_id);
        tvId = findViewById(R.id.tv_id);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvBody = findViewById(R.id.tv_body);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                commemt = null;
            } else {
                commemt = extras.getParcelable("DETAIL");
            }
        } else {
            commemt = savedInstanceState.getParcelable("DETAIL");
        }
//        Toast.makeText(getApplicationContext(), "Selete comment: " + commemt.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvPostId.setText(String.format("Post Id: %s", String.valueOf(commemt.getPostId())));
        tvId.setText(String.format("Id: %s", String.valueOf(commemt.getId())));
        tvName.setText(String.format("Name: %s", commemt.getName()));
        tvEmail.setText(String.format("Email: %s", commemt.getEmail()));
        tvBody.setText(String.format("Body: %s", commemt.getBody()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("DETAIL", commemt);
        super.onSaveInstanceState(outState);
    }
}
