package kr.co.tjeit.instacopyproject02.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.data.User;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<User> userList;

    // 뷰홀더클래스를 Adapter안에 클래스를 정의함.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImg;


        public MyViewHolder(View view) {
            super(view);
            profileImg = (ImageView)view.findViewById(R.id.profileImg);

        }
    }


    public RecyclerViewAdapter(Context context, List<User> userList) {
        mContext = context;
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Glide.with(mContext).load(R.drawable.mina_1).into(holder.profileImg);

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
 
 