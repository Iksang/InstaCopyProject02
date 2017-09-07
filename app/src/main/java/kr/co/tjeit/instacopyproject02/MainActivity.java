package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends BaseAcitivity {


    private LinearLayout homeFragmentLayout;
    private LinearLayout searchFragmentLayout;
    private LinearLayout viewMoreFragmentLayout;
    private LinearLayout postingNoticeFragmentLayout;
    private LinearLayout myProfileFragmentLayout;
    private ImageView homeBtnImgView;
    private ImageView searchBtnImgView;
    private ImageView viewMoreBtnImgView;
    private ImageView postingNoticeBtnImgView;
    private ImageView myProfileBtnImgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {

        final LinearLayout[] frags = {homeFragmentLayout, searchFragmentLayout, viewMoreFragmentLayout,
                postingNoticeFragmentLayout, myProfileFragmentLayout};


        View.OnTouchListener tabtouchListner = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
//
                    case MotionEvent.ACTION_DOWN:
                        int index = Integer.parseInt(v.getTag().toString());
                        if (index == 0) {
                            homeBtnImgView.setImageResource(R.drawable.home_black);
                        }
                        if (index == 1) {
                            searchBtnImgView.setImageResource(R.drawable.search_black);
                        }
                        if (index == 2) {
                            viewMoreBtnImgView.setImageResource(R.drawable.more_black);
                        }
                        if (index == 3) {
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_black);
                        }
                        if (index == 4) {
                            myProfileBtnImgView.setImageResource(R.drawable.profile_black);
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                        for (LinearLayout linearLayout : frags) {
                            linearLayout.setVisibility(View.GONE);
                        }
                        index = Integer.parseInt(v.getTag().toString());
                        frags[index].setVisibility(View.VISIBLE);

                        if (index == 0) {
                            homeBtnImgView.setImageResource(R.drawable.home_black);
                            searchBtnImgView.setImageResource(R.drawable.search_gray);
                            viewMoreBtnImgView.setImageResource(R.drawable.more_gray);
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
                            myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
                        }
                        if (index == 1) {
                            searchBtnImgView.setImageResource(R.drawable.search_black);
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
                            viewMoreBtnImgView.setImageResource(R.drawable.more_gray);
                            homeBtnImgView.setImageResource(R.drawable.home_gray);
                            myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
                        }
                        if (index == 2) {
                            viewMoreBtnImgView.setImageResource(R.drawable.more_black);
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
                            homeBtnImgView.setImageResource(R.drawable.home_gray);
                            searchBtnImgView.setImageResource(R.drawable.search_gray);
                            myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
                        }
                        if (index == 3) {
                            myProfileBtnImgView.setImageResource(R.drawable.profile_gray);
                            homeBtnImgView.setImageResource(R.drawable.home_gray);
                            viewMoreBtnImgView.setImageResource(R.drawable.more_gray);
                            searchBtnImgView.setImageResource(R.drawable.search_gray);
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_black);
                        }
                        if (index == 4) {
                            myProfileBtnImgView.setImageResource(R.drawable.profile_black);
                            homeBtnImgView.setImageResource(R.drawable.home_gray);
                            viewMoreBtnImgView.setImageResource(R.drawable.more_gray);
                            searchBtnImgView.setImageResource(R.drawable.search_gray);
                            postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
                        }
                        break;

                    default:
                        break;
                }
                return true;
            }

        };

        homeBtnImgView.setOnTouchListener(tabtouchListner);
        searchBtnImgView.setOnTouchListener(tabtouchListner);
        viewMoreBtnImgView.setOnTouchListener(tabtouchListner);
        postingNoticeBtnImgView.setOnTouchListener(tabtouchListner);
        myProfileBtnImgView.setOnTouchListener(tabtouchListner);

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.myProfileBtnImgView = (ImageView) findViewById(R.id.myProfileBtnImgView);
        this.postingNoticeBtnImgView = (ImageView) findViewById(R.id.postingNoticeBtnImgView);
        this.viewMoreBtnImgView = (ImageView) findViewById(R.id.viewMoreBtnImgView);
        this.searchBtnImgView = (ImageView) findViewById(R.id.searchBtnImgView);
        this.homeBtnImgView = (ImageView) findViewById(R.id.homeBtnImgView);
        this.myProfileFragmentLayout = (LinearLayout) findViewById(R.id.myProfileFragmentLayout);
        this.postingNoticeFragmentLayout = (LinearLayout) findViewById(R.id.postingNoticeFragmentLayout);
        this.viewMoreFragmentLayout = (LinearLayout) findViewById(R.id.viewMoreFragmentLayout);
        this.searchFragmentLayout = (LinearLayout) findViewById(R.id.searchFragmentLayout);
        this.homeFragmentLayout = (LinearLayout) findViewById(R.id.homeFragmentLayout);
    }
}
