package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-06.
 */

public class GalleryAdapter extends ArrayAdapter<Integer> {
    Context mContext;
    int layout;
    List<Integer> mList;
    LayoutInflater inf;

    public GalleryAdapter(Context context, int layout, List<Integer> list) {
        super(context, layout, list);
        // 어댑터 생성자의 인자값으로 layout자체와 img id배열을 받고 이를 토대로
        // getView에서 그려준다
        this.mContext = context;
        this.layout = layout;
        this.mList = list;

        inf = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView gridImageView = (ImageView) convertView.findViewById(R.id.gridImageView);
        Glide.with(mContext).load(R.drawable.mina_1).into(gridImageView);

        return convertView;
    }
}


