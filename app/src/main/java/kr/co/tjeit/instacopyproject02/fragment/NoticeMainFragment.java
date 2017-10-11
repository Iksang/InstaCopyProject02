package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-05.
 */

public class NoticeMainFragment extends Fragment {

    private ViewPager postingnoticeViewPager;
    private android.widget.TextView followTxt;
    private android.widget.TextView postingTxt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_notice_main, container, false);
        this.postingTxt = (TextView) v.findViewById(R.id.postingTxt);
        this.followTxt = (TextView) v.findViewById(R.id.followTxt);
        this.postingnoticeViewPager = (ViewPager) v.findViewById(R.id.posting_notice_ViewPager);

        postingnoticeViewPager.setAdapter(new MyPagerAdapter(((AppCompatActivity) getActivity()).getSupportFragmentManager()));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
    }

    private void setupEvents() {
        followTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followTxt.setTypeface(null, Typeface.BOLD);
                postingTxt.setTypeface(null, Typeface.NORMAL);
                postingnoticeViewPager.setCurrentItem(0);
            }
        });
        postingTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postingTxt.setTypeface(null, Typeface.BOLD);
                followTxt.setTypeface(null, Typeface.NORMAL);
                postingnoticeViewPager.setCurrentItem(1);
            }
        });
        postingnoticeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int positon, float positionOffset, int positionOffsetPixels) {
                if (positon==0){
                    followTxt.setTypeface(null, Typeface.BOLD);
                    postingTxt.setTypeface(null, Typeface.NORMAL);
                }else {
                    postingTxt.setTypeface(null, Typeface.BOLD);
                    followTxt.setTypeface(null, Typeface.NORMAL);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public static class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            if (position == 0) {
                return new FollowFragment();
            }
            else{
                return new PostingFragment();
            }
        }
    }

}
