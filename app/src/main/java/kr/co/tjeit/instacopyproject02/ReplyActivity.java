package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.adapter.ReplyAdapter;
import kr.co.tjeit.instacopyproject02.data.Reply;

public class ReplyActivity extends BaseAcitivity{

    ReplyAdapter mAdpater;
    private android.widget.ListView replyListView;
    List<Reply> mReplyList = new ArrayList<>();
    private android.widget.ImageView backBtn;
    private android.widget.EditText replyEdt;
    private android.widget.ImageView replySendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void setValues() {

        mAdpater = new ReplyAdapter(mContext, mReplyList);
        replyListView.setAdapter(mAdpater);

    }

    @Override
    public void bindViews() {
        this.replySendBtn = (ImageView) findViewById(R.id.replySendBtn);
        this.replyEdt = (EditText) findViewById(R.id.replyEdt);
        this.replyListView = (ListView) findViewById(R.id.replyListView);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);

    }
}
