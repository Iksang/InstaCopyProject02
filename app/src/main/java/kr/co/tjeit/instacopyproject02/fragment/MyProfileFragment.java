package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.instacopyproject02.R;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_my_profile, container, false);
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
    }

    private void setupEvents() {

        final LinearLayout[] frags = {gridFragmentLayout,
                AlignFragmentLayout, manFragmentLayout};

        View.OnClickListener tabListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (LinearLayout linearLayout : frags) {
                    linearLayout.setVisibility(View.GONE);

                }


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
