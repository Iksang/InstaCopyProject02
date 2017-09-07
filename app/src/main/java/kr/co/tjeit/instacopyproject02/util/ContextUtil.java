package kr.co.tjeit.instacopyproject02.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instacopyproject02.data.User;


public class ContextUtil {

    private static User loginUser = null;

    private static final String prefName = "instaPref";


    private static final String ID = "ID";
    private static final String USER_NICKNAME = "USER_NICKNAME";
    private static final String USER_NAME = "USER_NAME";


    public static void logout(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, 0).commit();
        pref.edit().putString(USER_NICKNAME, "").commit();
        pref.edit().putString(USER_NAME, "").commit();

    }

    public static void login(Context context, User loginUser) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, loginUser.getId()).commit();
        pref.edit().putString(USER_NICKNAME, loginUser.getNickName()).commit();
        pref.edit().putString(USER_NAME, loginUser.getName()).commit();


    }

    public static User getLoginUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getString(USER_NICKNAME, "").equals("")) {

            loginUser = null;
        } else {
            loginUser = new User();
            loginUser.setId(pref.getInt(ID, 0));
            loginUser.setNickName(pref.getString(USER_NICKNAME, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));

        }


        return loginUser;
    }

}
