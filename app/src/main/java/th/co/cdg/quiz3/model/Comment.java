package th.co.cdg.quiz3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comment implements Parcelable {

    /**
     * postId : 1
     * id : 1
     * name : id labore ex et quam laborum
     * email : Eliseo@gardner.biz
     * body : laudantium enim quasi est quidem magnam voluptate ipsam eos
     tempora quo necessitatibus
     dolor quam autem quasi
     reiciendis et nam sapiente accusantium
     */

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    protected Comment(Parcel in) {
        postId = in.readInt();
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        body = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(postId);
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(body);
    }
}

