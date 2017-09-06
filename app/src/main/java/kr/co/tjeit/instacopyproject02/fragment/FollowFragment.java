package kr.co.tjeit.instacopyproject02.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.adapter.FollowAdapter;
import kr.co.tjeit.instacopyproject02.adapter.PostingAdapter;
import kr.co.tjeit.instacopyproject02.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class FollowFragment extends android.support.v4.app.Fragment {


    private ListView followListView;
    FollowAdapter mAdapter;
    List<User> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_follow, container, false);
        followListView = (ListView) v.findViewById(R.id.followListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
    }


    private void setValues() {
        mAdapter = new FollowAdapter(getActivity(), mList);
        followListView.setAdapter(mAdapter);
    }
}
