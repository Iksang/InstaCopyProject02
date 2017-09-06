package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-05.
 */

public class PostingNoticeFragment extends Fragment {


    private android.support.v4.view.ViewPager postingnoticeViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_posting_notice, container, false);
        this.postingnoticeViewPager = (ViewPager) v.findViewById(R.id.posting_notice_ViewPager);
        return v;
    }

//    class MyPagerAdapter extends FragmentStatePagerAdapter{
//
//        public MyPagerAdapter(FragmentManager fm){
//            super fm;
//        }
//
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        @Override
//        public android.support.v4.app.Fragment getItem(int position) {
//            if (position == 0) {
//                return new PostingFragment();
//            }
//            else if (position == 1) {
//                return new NoticeFragment();
//            }
//        }
//    }

}
