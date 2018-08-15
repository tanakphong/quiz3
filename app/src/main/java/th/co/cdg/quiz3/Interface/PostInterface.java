package th.co.cdg.quiz3.Interface;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import th.co.cdg.quiz3.model.Comment;

public interface PostInterface {
    @GET("comments")
    Call<List<Comment>> getCommentbyPostId(@Query("postId") String postId);
}
