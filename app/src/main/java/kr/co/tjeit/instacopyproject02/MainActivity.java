package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends BaseAcitivity {

    private android.widget.LinearLayout homeFragmentLayout;
    private android.widget.LinearLayout postingNoticeFragmentLayout;
    private android.widget.LinearLayout myProfileFragmentLayout;
    private android.widget.ImageView tabBtn1;
    private android.widget.ImageView tabBtn2;
    private android.widget.ImageView tabBtn3;
    private android.widget.ImageView tabBtn4;
    private android.widget.ImageView tabBtn5;
    private ImageView homeBtnLayout;
    private ImageView searchBtnLayout;
    private ImageView viewMoreBtnLayout;
    private ImageView postingNoticeBtnLayout;
    private ImageView myProfileBtnLayout;
    private LinearLayout searchFragmentLayout;
    private LinearLayout viewMoreFragmentLayout;
    private ImageView homeBtnImgView;
    private ImageView searchBtnImgView;
    private ImageView viewMoreBtnImgView;
    private ImageView postingNoticeBtnImgView;
    private ImageView myProfileBtnImgView;

    // 리셋
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {

        final LinearLayout[] frags = {homeFragmentLayout,
                postingNoticeFragmentLayout, myProfileFragmentLayout};

        View.OnClickListener tabListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (LinearLayout linearLayout : frags) {
                    linearLayout.setVisibility(View.GONE);
                }


                int index = Integer.parseInt(v.getTag().toString());

                frags[index].setVisibility(View.VISIBLE);

            }
        };

        homeBtnImgView.setOnClickListener(tabListner);
        postingNoticeBtnImgView.setOnClickListener(tabListner);
        myProfileBtnImgView.setOnClickListener(tabListner);

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
