package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.co.tjeit.instacopyproject02.data.User;
import kr.co.tjeit.instacopyproject02.util.ContextUtil;

public class EditMyProfileActivity extends BaseAcitivity {

    User myInfo;

    private android.widget.EditText nameEdt;
    private android.widget.EditText nickNameEdt;
    private android.widget.Button editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_profile);
        myInfo = ContextUtil.getLoginUserData(mContext);
        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 불러온데이터를 변경해서 서버유틸로 넘겨주기
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.editProfileBtn = (Button) findViewById(R.id.editProfileBtn);
        this.nickNameEdt = (EditText) findViewById(R.id.nickNameEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);

    }
}
