package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-05.
 */

public class PostingNoticeFragment extends Fragment {

    private android.widget.ListView noticeListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_notice, container, false);
        this.noticeListView = (ListView) v.findViewById(R.id.noticeListView);
        return v;
    }

}
