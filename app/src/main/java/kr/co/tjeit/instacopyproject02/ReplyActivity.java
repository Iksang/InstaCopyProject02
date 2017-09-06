package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.adapter.ReplyAdapter;
import kr.co.tjeit.instacopyproject02.data.Reply;

public class ReplyActivity extends BaseAcitivity{

    ReplyAdapter mAdpater;
    private android.widget.ListView replyListView;
    List<Reply> mReplyList = new ArrayList<>();


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

    }

    @Override
    public void setValues() {

        mAdpater = new ReplyAdapter(mContext, mReplyList);
        replyListView.setAdapter(mAdpater);

    }

    @Override
    public void bindViews() {
        this.replyListView = (ListView) findViewById(R.id.replyListView);

    }
}
