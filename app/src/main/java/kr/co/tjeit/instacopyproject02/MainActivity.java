package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject02.data.Posting;
import kr.co.tjeit.instacopyproject02.fragment.SearchFragment;
import kr.co.tjeit.instacopyproject02.util.GlobalData;
import kr.co.tjeit.instacopyproject02.util.ServerUtil;

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

        // MainActivity에 만들어둔 LinearLayout을 배열에 저장
        final LinearLayout[] frags = {homeFragmentLayout, searchFragmentLayout, viewMoreFragmentLayout,
                postingNoticeFragmentLayout, myProfileFragmentLayout};


        View.OnTouchListener tabtouchListner = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 이벤트종류를 switch문으로 구분
                // 버튼을 클릭했을때 하얀색아이콘이 아닌 검은색아이콘으로 바꾸고싶어서
                switch (event.getAction()) {

                    // 모션이벤트가 눌렀을때
                    case MotionEvent.ACTION_DOWN:
                        // 이미지버튼마다 저장해둔 태그를 먼저 index에 저장해두고
                        int index = Integer.parseInt(v.getTag().toString());
                        // if문으로 어떤 버튼이 눌리는지 판별
                        // 버튼이 눌리면 아이콘을 검은색아이콘으로 바꿔주고
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
                        // break로 빠져나온다
                        break;

                    // 모션이벤트가 손을때는 이벤트일때
                    case MotionEvent.ACTION_UP:
                        // linearLayout에 frags배열을 저장하고 먼저 숨김처리
                        for (LinearLayout linearLayout : frags) {
                            linearLayout.setVisibility(View.GONE);
                        }
                        //  index에 터치한 버튼의 태그를 저장
                        index = Integer.parseInt(v.getTag().toString());
                        //  frags배열에 index번 LinearLayout을 보여주기
                        frags[index].setVisibility(View.VISIBLE);

                        // 저장된 index에따라 이미지버튼 보여주기
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
