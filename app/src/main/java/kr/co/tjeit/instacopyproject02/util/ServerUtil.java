package kr.co.tjeit.instacopyproject02.util;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by the on 2017-09-07.
 */

public class ServerUtil {
    private static final String TAG = ServerUtil.class.getSimpleName();
    private final static String BASE_URL = "http://13.124.214.118/"; // 라이브서버


    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
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
        data.put("nickname", "");
        data.put("profileImgURL", "");
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
}
