package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import kr.co.tjeit.instacopyproject02.fragment.WritingPostFragment;

public class MainActivity extends BaseAcitivity {

    public static MainActivity mainActivity;

    long backPressedTimeInMillis = 0;

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
    private LinearLayout tab0;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private LinearLayout tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
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
                            Glide.with(mContext).load(R.drawable.home_black).into(homeBtnImgView);
                        }
                        if (index == 1) {
                            Glide.with(mContext).load(R.drawable.search_black).into(searchBtnImgView);
                        }
                        if (index == 2) {
                            Glide.with(mContext).load(R.drawable.more_black).into(viewMoreBtnImgView);
                        }
                        if (index == 3) {
                            Glide.with(mContext).load(R.drawable.notice_black).into(postingNoticeBtnImgView);
                        }
                        if (index == 4) {
                            Glide.with(mContext).load(R.drawable.profile_black).into(myProfileBtnImgView);
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
                        Glide.with(mContext).load(R.drawable.home_gray).into(homeBtnImgView);
                        Glide.with(mContext).load(R.drawable.search_gray).into(searchBtnImgView);
                        Glide.with(mContext).load(R.drawable.more_gray).into(viewMoreBtnImgView);
                        Glide.with(mContext).load(R.drawable.notice_gray).into(postingNoticeBtnImgView);
                        Glide.with(mContext).load(R.drawable.profile_gray).into(myProfileBtnImgView);

                        if (!(index == 2)) {
                            WritingPostFragment.contentEdt.setText("");
                            WritingPostFragment.postingImg.setImageBitmap(null);
                            WritingPostFragment.GuideTxt.setVisibility(View.VISIBLE);
                        }

                        // 저장된 index에따라 이미지버튼 보여주기
                        if (index == 0) {
                            Glide.with(mContext).load(R.drawable.home_black).into(homeBtnImgView);
                        }
                        if (index == 1) {
                            Glide.with(mContext).load(R.drawable.search_black).into(searchBtnImgView);
                        }
                        if (index == 2) {
                            Glide.with(mContext).load(R.drawable.more_black).into(viewMoreBtnImgView);
                        }
                        if (index == 3) {
                            Glide.with(mContext).load(R.drawable.notice_black).into(postingNoticeBtnImgView);
                        }
                        if (index == 4) {
                            Glide.with(mContext).load(R.drawable.profile_black).into(myProfileBtnImgView);
                        }
                        break;

                    default:
                        break;
                }
                return true;
            }

        };

        tab0.setOnTouchListener(tabtouchListner);
        tab1.setOnTouchListener(tabtouchListner);
        tab2.setOnTouchListener(tabtouchListner);
        tab3.setOnTouchListener(tabtouchListner);
        tab4.setOnTouchListener(tabtouchListner);

    }


    public void changeNewsfeed(){
        final LinearLayout[] frags = {homeFragmentLayout, searchFragmentLayout, viewMoreFragmentLayout,
                postingNoticeFragmentLayout, myProfileFragmentLayout};
        for (LinearLayout linearLayout : frags) {
            linearLayout.setVisibility(View.GONE);
        }
        frags[0].setVisibility(View.VISIBLE);
        homeBtnImgView.setImageResource(R.drawable.home_black);
        searchBtnImgView.setImageResource(R.drawable.search_gray);
        viewMoreBtnImgView.setImageResource(R.drawable.more_gray);
        postingNoticeBtnImgView.setImageResource(R.drawable.notice_gray);
        myProfileBtnImgView.setImageResource(R.drawable.profile_gray);

    }

    @Override
    public void setValues() {

    }

    @Override
    public void onBackPressed() {
        long currentTimeInMillis = System.currentTimeMillis();

        if (currentTimeInMillis - backPressedTimeInMillis < 2000) {
//            2초 이내에 백버튼을 다시 눌렀으니 종료해야 함.
            finish();
            return;
        }
        else {
//            최초로 백버튼을 눌렀거나, 혹은 2초 이상의 시간이 지난 후에 누름.
            Toast.makeText(mContext, "한번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeInMillis = currentTimeInMillis;
    }

    @Override
    public void bindViews() {
        this.tab4 = (LinearLayout) findViewById(R.id.tab4);
        this.myProfileBtnImgView = (ImageView) findViewById(R.id.myProfileBtnImgView);
        this.tab3 = (LinearLayout) findViewById(R.id.tab3);
        this.postingNoticeBtnImgView = (ImageView) findViewById(R.id.postingNoticeBtnImgView);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.viewMoreBtnImgView = (ImageView) findViewById(R.id.viewMoreBtnImgView);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.searchBtnImgView = (ImageView) findViewById(R.id.searchBtnImgView);
        this.tab0 = (LinearLayout) findViewById(R.id.tab0);
        this.homeBtnImgView = (ImageView) findViewById(R.id.homeBtnImgView);
        this.myProfileFragmentLayout = (LinearLayout) findViewById(R.id.myProfileFragmentLayout);
        this.postingNoticeFragmentLayout = (LinearLayout) findViewById(R.id.postingNoticeFragmentLayout);
        this.viewMoreFragmentLayout = (LinearLayout) findViewById(R.id.viewMoreFragmentLayout);
        this.searchFragmentLayout = (LinearLayout) findViewById(R.id.searchFragmentLayout);
        this.homeFragmentLayout = (LinearLayout) findViewById(R.id.homeFragmentLayout);
    }
}
