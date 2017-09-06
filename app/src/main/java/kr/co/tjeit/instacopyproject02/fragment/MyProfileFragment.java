package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-05.
 */

public class MyProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.frag_my_profile, container, false);

        return row;
    }
}
