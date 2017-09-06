package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.data.Newsfeed;
import kr.co.tjeit.instacopyproject02.data.Reply;

/**
 * Created by tjoeun on 2017-09-06.
 */

public class ReplyAdapter extends ArrayAdapter<Reply> {
    private Context mContext;
    List<Reply> mList;
    LayoutInflater inf;

    public ReplyAdapter (Context context, List<Reply> list){
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



        return row;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
