package kr.co.tjeit.instacopyproject02.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjoeun on 2017-09-06.
 */

public class Reply {
    private int id;
    private User writer;
    private String content;
    private Posting post;

    List<User> likeUsers =new ArrayList<>();

    public Reply() {
    }

    public Reply(int id, User writer, String content, Posting post) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Posting getPost() {
        return post;
    }

    public void setPost(Posting post) {
        this.post = post;
    }

    public List<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(List<User> likeUsers) {
        this.likeUsers = likeUsers;
    }
}
