package kr.co.tjeit.instacopyproject02.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.adapter.NewsFeedAdapter;
import kr.co.tjeit.instacopyproject02.data.Posting;
import kr.co.tjeit.instacopyproject02.util.GlobalData;
import kr.co.tjeit.instacopyproject02.util.ServerUtil;

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


    @Override
    public void onResume() {
        super.onResume();
        getAllPosting();
    }

    public void getAllPosting() {

        ServerUtil.get_all_postings(getActivity(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                // 가져온 데이터들을 저장하기위해 GlobalData에있는 storeList를 비워둠
                GlobalData.POSTING_LIST.clear();

                try {
                    // JSONArray형태로 저장되있는 데이터들을 stores에 저장
                    JSONArray postings = json.getJSONArray("postings");
                    for (int i = 0; i < postings.length() ; i++ ) {
                        Posting posting = Posting.getPostingFromJSON(postings.getJSONObject(i));
                        GlobalData.POSTING_LIST.add(posting);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                postingList.clear();

                postingList.addAll(GlobalData.POSTING_LIST);

                mAdapter.notifyDataSetChanged();

            }
        });
    }

    private void setValues() {
//        게시물 리스트를 받아서 어댑터를 만들고 해당 리스트뷰에 setAdapter한다.
        mAdapter = new NewsFeedAdapter(getActivity(), postingList);
        newsfeedListView.setAdapter(mAdapter);
        getAllPosting();
    }

    private void setupEvents() {
    }
}
