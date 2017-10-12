package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.instacopyproject02.EditMyProfileActivity;
import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.util.ContextUtil;

/**
 * Created by the on 2017-09-05.
 */
//
public class MyProfileFragment extends Fragment {
    private de.hdodenhof.circleimageview.CircleImageView profileimage;
    private de.hdodenhof.circleimageview.CircleImageView profileplusimage;
    private android.widget.ImageView gridBtn;
    private android.widget.ImageView alignBtn;
    private android.widget.ImageView profileBtn;
    private LinearLayout gridFragmentLayout;
    private LinearLayout AlignFragmentLayout;
    private LinearLayout manFragmentLayout;
    private android.widget.Spinner nickNameSpinner;
    private android.widget.TextView postingCountTxt;
    private android.widget.TextView followerCountTxt;
    private android.widget.TextView followingCountTxt;
    private android.widget.Button profileEditBtn;
    private android.widget.TextView nickNameTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_my_profile, container, false);
        this.nickNameTxt = (TextView) v.findViewById(R.id.nickNameTxt);
        this.profileEditBtn = (Button) v.findViewById(R.id.profileEditBtn);
        this.followingCountTxt = (TextView) v.findViewById(R.id.followingCountTxt);
        this.followerCountTxt = (TextView) v.findViewById(R.id.followerCountTxt);
        this.postingCountTxt = (TextView) v.findViewById(R.id.postingCountTxt);
        this.nickNameSpinner = (Spinner) v.findViewById(R.id.nickNameSpinner);
        this.manFragmentLayout = (LinearLayout) v.findViewById(R.id.manFragmentLayout);
        this.AlignFragmentLayout = (LinearLayout) v.findViewById(R.id.AlignFragmentLayout);
        this.gridFragmentLayout = (LinearLayout) v.findViewById(R.id.gridFragmentLayout);
        this.profileBtn = (ImageView) v.findViewById(R.id.profileBtn);
        this.alignBtn = (ImageView) v.findViewById(R.id.alignBtn);
        this.gridBtn = (ImageView) v.findViewById(R.id.gridBtn);
        this.profileplusimage = (CircleImageView) v.findViewById(R.id.profile_plus_image);
        this.profileimage = (CircleImageView) v.findViewById(R.id.profile_image);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        //TODO 바인딩
        postingCountTxt.setText(null);
        followerCountTxt.setText(null);
        followingCountTxt.setText(null);
        nickNameTxt.setText(null);
    }

    private void setupEvents() {
        // 프로필수정 버튼을 클릭시 프로필수정 화면을 띄운다
        profileEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), EditMyProfileActivity.class);
                // TODO 프로필이름, 닉네임변경.
                startActivity(myIntent);
            }
        });


        // 프래그먼트를 가진 LinearLayout들을 배열에 담아둔다
        final LinearLayout[] frags = {gridFragmentLayout,
                AlignFragmentLayout, manFragmentLayout};

        // 탭이 눌렸을때 해당 LinearLayout의 setVisibility를 Visible로 바꾸고 나머지는 Gone으로 바꾼다
        View.OnClickListener tabListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (LinearLayout linearLayout : frags) {
                    linearLayout.setVisibility(View.GONE);
                }


                // 탭에 해당하는 태그를 불러와서 몇번 탭인지 알아낸다다
                int index = Integer.parseInt(v.getTag().toString());

                frags[index].setVisibility(View.VISIBLE);
                if (index == 0) {
                    gridBtn.setImageResource(R.drawable.profile_grid_icon_blue);
                    alignBtn.setImageResource(R.drawable.profile_align_icon_gray);
                    profileBtn.setImageResource(R.drawable.profile_man_icon_gray);
                }
                if (index == 1) {
                    gridBtn.setImageResource(R.drawable.profile_grid_icon_gray);
                    alignBtn.setImageResource(R.drawable.profile_align_icon_blue);
                    profileBtn.setImageResource(R.drawable.profile_man_icon_gray);
                }
                if (index == 2) {
                    gridBtn.setImageResource(R.drawable.profile_grid_icon_gray);
                    alignBtn.setImageResource(R.drawable.profile_align_icon_gray);
                    profileBtn.setImageResource(R.drawable.profile_man_icon_blue);
                }

            }
        };

        gridBtn.setOnClickListener(tabListner);
        alignBtn.setOnClickListener(tabListner);
        profileBtn.setOnClickListener(tabListner);
    }
}
