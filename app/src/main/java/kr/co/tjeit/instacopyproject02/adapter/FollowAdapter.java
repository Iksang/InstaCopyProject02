package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class FollowAdapter extends ArrayAdapter<User> {

    Context mContext;
    List<User> mList;
    LayoutInflater inf;

    public FollowAdapter(Context context, List<User> list){
        super(context, R.layout.follow_notice_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row =  inf.inflate(R.layout.follow_notice_list_item, null);
        }
        User data = mList.get(position);

        TextView contextTxt = (TextView)row.findViewById(R.id.contentTxt);
        String followingStr = String.format(Locale.KOREA, "%s님이 팔로우 합니다.", data.getFollowings().get(position));
        contextTxt.setText(followingStr);

        return row;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
