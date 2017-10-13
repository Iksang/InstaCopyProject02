package kr.co.tjeit.instacopyproject02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
        // 로그인 버튼을 눌렀을 경우 Server로 id와 password를 보낸다
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ServerUtil 로그인기능 불러오기
                // 재료는 화면, id, pw , json
                ServerUtil.sign_in(mContext,
                        idEdt.getText().toString(),
                        passwordEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {
//                                        Server에서 받은 Json 데이터를 파싱한후 ContextUtil에 LOGIN 정보를 셋팅한다.
                                        User temp = new User();
                                        temp.setId(json.getJSONObject("user").getInt("id"));
                                        temp.setUserId(json.getJSONObject("user").getString("userId"));
                                        temp.setName(json.getJSONObject("user").getString("name"));
                                        temp.setNickName(json.getJSONObject("user").getString("nickname"));

                                        String welcomMessageStr = String.format(Locale.KOREA, "%s님이 로그인 했습니다.", temp.getName());
                                        Toast.makeText(mContext, welcomMessageStr, Toast.LENGTH_SHORT).show();

                                        // ContextUtil에 로그인 유저 정보 넘겨주기
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

        // 회원가입 화면넘어가기
        signupBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(mContext, SignupAcitivity.class);
                                             startActivity(intent);
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
