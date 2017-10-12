package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-06.
 */

public class GalleryAdapter extends BaseAdapter {
    Context mContext;
    int layout;
    int img[];
    LayoutInflater inf;

    public GalleryAdapter(Context context, int layout, int[] img) {
        // 어댑터 생성자의 인자값으로 layout자체와 img id배열을 받고 이를 토대로
        // getView에서 그려준다
        this.mContext = context;
        this.layout = layout;
        this.img = img;

        inf = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView gridImageView = (ImageView) convertView.findViewById(R.id.gridImageView);

        gridImageView.setImageResource(img[position]);
        return convertView;
    }
}


