package kr.co.tjeit.instacopyproject02.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.adapter.NewsFeedAdapter;
import kr.co.tjeit.instacopyproject02.data.Posting;

/**
 * Created by tjoeun on 2017-09-05.
 */
//
public class NewsfeedFragment extends Fragment {

    ListView newsfeedListView;
    NewsFeedAdapter mAdapter;
    List<Posting> postingList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_newsfeed,container, false);

        newsfeedListView = (ListView)view.findViewById(R.id.newsfeedListView);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();

    }

    private void setValues() {
        mAdapter = new NewsFeedAdapter(getActivity(), postingList);
        newsfeedListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
    }
}
