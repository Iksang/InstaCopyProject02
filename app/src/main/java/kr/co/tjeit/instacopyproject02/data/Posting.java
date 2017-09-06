package kr.co.tjeit.instacopyproject02.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjoeun on 2017-09-05.
 */

public class Posting {

    private int id;
    private User writer;
    private String postImgURL;
    private String content;

//    게시글에 좋아요 누른 사람 명단
    List<User> likeUsers = new ArrayList<>();

//    게시글에 달린 댓글
    List<Reply> replies = new ArrayList<>();

    public Posting() {
    }

    public Posting(int id, User writer, String postImgURL, String content) {
        this.id = id;
        this.writer = writer;
        this.postImgURL = postImgURL;
        this.content = content;
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

    public String getPostImgURL() {
        return postImgURL;
    }

    public void setPostImgURL(String postImgURL) {
        this.postImgURL = postImgURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(List<User> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
