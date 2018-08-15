package th.co.cdg.quiz3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import th.co.cdg.quiz3.R;
import th.co.cdg.quiz3.model.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context context;
    private List<Comment> dataList = new ArrayList<>();
    private CommentAdapter.ItemClickListener mClickListener;

    public CommentAdapter(Context context) {
        this.context = context;
    }

    public void add(Comment comment) {
        dataList.add(comment);
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_comment, parent, false);
        return new CommentAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        holder.tvID.setText(String.valueOf(dataList.get(position).getId()));
        holder.tvPostID.setText(String.valueOf(dataList.get(position).getPostId()));
        holder.tvName.setText(dataList.get(position).getName());
        holder.tvEmail.setText(dataList.get(position).getEmail());
        holder.tvBody.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView tvPostID, tvID, tvName, tvEmail, tvBody;

        CommentViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            tvID = itemView.findViewById(R.id.tv_id);
            tvPostID = itemView.findViewById(R.id.tv_post_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvBody = itemView.findViewById(R.id.tv_body);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Comment getItem(int id) {
        return dataList.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
