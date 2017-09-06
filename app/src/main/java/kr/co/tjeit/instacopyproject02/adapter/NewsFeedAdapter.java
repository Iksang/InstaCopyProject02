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

/**
 * Created by tjoeun on 2017-09-05.
 */

public class NewsFeedAdapter extends ArrayAdapter<Newsfeed>{
    private Context mContext;
    List<Newsfeed> mList;
    LayoutInflater inf;

    public NewsFeedAdapter (Context context, List<Newsfeed> list){
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
}