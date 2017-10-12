package kr.co.tjeit.instacopyproject02.util;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by the on 2017-09-07.
 */

public class ServerUtil {
    private static final String TAG = ServerUtil.class.getSimpleName();
    private final static String BASE_URL = "http://13.124.240.139/";


    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    // 로그인
    public static void sign_in(final Context context, String id, String pw, final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/sign_in";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("userId", id);
        data.put("password", pw);

        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    // 회원 가입 기능
    public static void sign_up(final Context context, final String id,
                               final String pw,
                               final String name, final String nickname, final String profileImgUrl,
                               final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/sign_up";


        Map<String, String> data = new HashMap<String, String>();
        data.put("userId", id);
        data.put("password", pw);
        data.put("name", name);
        data.put("nickname", nickname);
        data.put("profileImgURL", profileImgUrl);
        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    // 포스팅목록불러오기
    public static void get_all_postings(final Context context,final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/get_all_postings";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();

        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    // 이미지 올리기
    public static void makePosting(final Context context, final int id,
                                   final String content,
                                   Bitmap bitmap,
                                   final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/make_posting";


        Map<String, String> data = new HashMap<String, String>();
        data.put("user_Id", id+"");
        data.put("content", content);
        AsyncHttpRequest.postWithImageFile(context, url, data, bitmap, "post", new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

}
