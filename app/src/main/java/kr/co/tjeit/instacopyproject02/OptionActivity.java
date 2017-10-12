package kr.co.tjeit.instacopyproject02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.tjeit.instacopyproject02.util.ContextUtil;

public class OptionActivity extends BaseAcitivity {

    private android.widget.TextView logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextUtil.logout(mContext);
                Intent myIntent = new Intent(mContext, LoginActivity.class);
                Toast.makeText(mContext, "로그아웃완료", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.logoutBtn = (TextView) findViewById(R.id.logoutBtn);
    }
}
