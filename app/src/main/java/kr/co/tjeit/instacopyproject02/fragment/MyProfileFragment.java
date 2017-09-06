package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-05.
 */

public class MyProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_my_profile, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
    }

    private void setupEvents() {
//
//        final LinearLayout[] frags = {homeFragmentLayout,
//                postingNoticeFragmentLayout, myProfileFragmentLayout};
//
//        View.OnClickListener tabListner = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                for (LinearLayout linearLayout : frags) {
//                    linearLayout.setVisibility(View.GONE);
//
//                }
//
//
//                int index = Integer.parseInt(v.getTag().toString());
//
//                frags[index].setVisibility(View.VISIBLE);
//                if (index == 0) {
//                    homeBtnImgView.setImageResource(R.drawable.home_black);
//                    postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
//                    myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
//                }
//                if (index == 1) {
//                    postingNoticeBtnImgView.setImageResource(R.drawable.notice_black);
//                    homeBtnImgView.setImageResource(R.drawable.home_gray);
//                    myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
//                }
//                if (index == 2) {
//                    myProfileBtnImgView.setImageResource(R.drawable.profile_black);
//                    homeBtnImgView.setImageResource(R.drawable.home_gray);
//                    postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
//                }
//
//            }
//        };
//
//        homeBtnImgView.setOnClickListener(tabListner);
//        postingNoticeBtnImgView.setOnClickListener(tabListner);
//        myProfileBtnImgView.setOnClickListener(tabListner);
    }
}
