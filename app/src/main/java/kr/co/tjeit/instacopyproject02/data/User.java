package kr.co.tjeit.instacopyproject02.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class User {
    private int id;
    private String userId;
    private String name;
    private String nickName;
    private String profileImgURL;

//    나를 팔로잉 하는사람들
    private List<User> followers = new ArrayList<>();
//    내가 팔로잉 하는 사람(뉴스피드에서 팔로잉 게시물 띄움)
    private List<User> followings = new ArrayList<>();

//    내가 작성한 게시물
    private List<Posting> myPostings = new ArrayList<>();

//    내가 작성한 댓글
    private List<Reply> myReplies = new ArrayList<>();


    public User() {
    }

    public User(int id, String userId, String name, String nickName, String profileImgURL) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.nickName = nickName;
        this.profileImgURL = profileImgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public List<Posting> getMyPostings() {
        return myPostings;
    }

    public void setMyPostings(List<Posting> myPostings) {
        this.myPostings = myPostings;
    }

    public List<Reply> getMyReplies() {
        return myReplies;
    }

    public void setMyReplies(List<Reply> myReplies) {
        this.myReplies = myReplies;
    }
}
