package kr.co.tjeit.instacopyproject02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import kr.co.tjeit.instacopyproject02.data.User;
import kr.co.tjeit.instacopyproject02.util.ContextUtil;
import kr.co.tjeit.instacopyproject02.util.ServerUtil;

public class LoginActivity extends BaseAcitivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText passwordEdt;
    private android.widget.Button loginBtn;
    private android.widget.TextView signupBtn;
    public static LoginActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;

        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.sign_in(mContext,
                        idEdt.getText().toString(),
                        passwordEdt.getText().toString(),

                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {

                                        User temp = new User();
                                        temp.setId(json.getJSONObject("user").getInt("id"));
                                        temp.setUserId(json.getJSONObject("user").getString("userId"));
                                        temp.setName(json.getJSONObject("user").getString("name"));
                                        temp.setNickName(json.getJSONObject("user").getString("nickname"));

                                        String welcomMessageStr = String.format(Locale.KOREA, "%s님이 로그인 했습니다.", temp.getName());
                                        Toast.makeText(mContext, welcomMessageStr, Toast.LENGTH_SHORT).show();

                                        ContextUtil.login(mContext, temp);

                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        startActivity(intent);
                                        finish();


                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                        builder.setTitle("로그인 실패");
                                        builder.setMessage("아이디와 비밀번호를 확인해 주세요.");
                                        builder.setPositiveButton("확인", null);
                                        builder.show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(mContext, SignupAcitivity.class);
                                             startActivity(intent);
                                             finish();
                                         }
                                     }
        );
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signupBtn = (TextView) findViewById(R.id.signupBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
