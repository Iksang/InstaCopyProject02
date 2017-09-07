package kr.co.tjeit.instacopyproject02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject02.util.ServerUtil;

public class SignupAcitivity extends BaseAcitivity {

    private android.widget.EditText idEdt;
    private android.widget.Button checkDuplBtn;
    private android.widget.EditText nameEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button signUpBtn;
    private EditText nickNameEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("가입 실패");
                builder.setPositiveButton("확인", null);

                if (idEdt.getText().toString().equals("")) {
                    builder.setMessage("아이디가 입력되지 않았습니다.");
                    builder.show();
                    return;
                } else if (nameEdt.getText().toString().equals("")) {
                    builder.setMessage("이름이 입력되지 않았습니다.");
                    builder.show();
                    return;
                } else if (pwEdt.getText().toString().equals("")) {
                    builder.setMessage("비밀번호가 입력되지 않았습니다.");
                    builder.show();
                    return;
                }  else if (nickNameEdt.getText().toString().equals("")) {
                builder.setMessage("닉네임이 입력되지 않았습니다.");
                builder.show();
                return;
            }
                ServerUtil.sign_up(mContext, idEdt.getText().toString(),
                        pwEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        nickNameEdt.getText().toString(),
                        "URL",
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {
                                        Toast.makeText(mContext, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(SignupAcitivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        LoginActivity.activity.finish();
                                    } else {
                                        Toast.makeText(mContext, "회원가입에 실패했습니다. 아이디 변경후에 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.nickNameEdt = (EditText) findViewById(R.id.nickNameEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.checkDuplBtn = (Button) findViewById(R.id.checkDuplBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
