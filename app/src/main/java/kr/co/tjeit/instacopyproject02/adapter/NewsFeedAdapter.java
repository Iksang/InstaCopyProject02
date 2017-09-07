package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.ReplyActivity;
import kr.co.tjeit.instacopyproject02.data.Posting;

/**
 * Created by tjoeun on 2017-09-05.
 */

public class NewsFeedAdapter extends ArrayAdapter<Posting>{
    private Context mContext;
    List<Posting> mList;
    LayoutInflater inf;

    public NewsFeedAdapter (Context context, List<Posting> list){
        super(context, R.layout.newsfeed_list_item,list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row==null){
            row = inf.inflate(R.layout.newsfeed_list_item,null);
        }

        TextView allReplyBtn = (TextView)row.findViewById(R.id.allReplyBtn);


        allReplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyActivity.class);
                mContext.startActivity(intent);
            }
        });



        return row;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
