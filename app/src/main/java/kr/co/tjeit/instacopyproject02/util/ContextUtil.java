package kr.co.tjeit.instacopyproject02.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instacopyproject02.data.User;

/**
 * Created by tjoeun on 2017-09-07.
 */

public class ContextUtil {

    private static User loginUser = null;
    private static final String prefName = "InstaCopyPref";

    //    1. 사용자 숫자 ID
//    2. 사용자 폰번
    private static final String ID = "ID";
    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_NICKNAME = "USER_NICKNAME";
//    private static final String USER_PROFILEIMG_PATH = "USER_PROFILEIMG_PATH";

    public static void login(Context context, User loginUser){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID,loginUser.getId()).commit();
        pref.edit().putString(USER_ID,loginUser.getUserId()).commit();
        pref.edit().putString(USER_NAME,loginUser.getName()).commit();
        pref.edit().putString(USER_NICKNAME,loginUser.getNickName()).commit();
//        pref.edit().putString(USER_PROFILEIMG_PATH,loginUser.getProfileImgURL()).commit();
    }

    public static void logout(Context context){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putInt(ID,0).apply();
        pref.edit().putString(USER_ID,"").apply();
        pref.edit().putString(USER_NAME,"").apply();
        pref.edit().putString(USER_NICKNAME,"").apply();
//        pref.edit().putString(USER_PROFILEIMG_PATH,"").apply();

    }

    public static User getLoginUserData(Context context){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        if(pref.getString(USER_ID,"").equals("")){
            loginUser=null;
        }
        else{
            loginUser = new User();
            loginUser.setId(pref.getInt(ID,0));
            loginUser.setUserId(pref.getString(USER_ID,""));
            loginUser.setName(pref.getString(USER_NAME,""));
            loginUser.setNickName(pref.getString(USER_NICKNAME,""));
//            loginUser.setProfileImgURL(pref.getString(USER_PROFILEIMG_PATH,""));
        }
        return loginUser;

    }

}
