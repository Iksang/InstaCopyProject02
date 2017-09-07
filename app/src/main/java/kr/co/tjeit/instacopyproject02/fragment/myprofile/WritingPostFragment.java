package kr.co.tjeit.instacopyproject02.fragment.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kr.co.tjeit.instacopyproject02.R;

/**
 * Created by the on 2017-09-07.
 */

public class WritingPostFragment extends Fragment {

    final int RESULT_GERRELY = 1;

    private android.widget.ImageView postingImg;
    private android.widget.EditText contentEdt;
    private android.widget.Button postSentbtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_writing_post, container, false);
        this.postSentbtn = (Button) v.findViewById(R.id.postSentbtn);
        this.contentEdt = (EditText) v.findViewById(R.id.contentEdt);
        this.postingImg = (ImageView) v.findViewById(R.id.postingImg);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvent();
    }

    private void setupEvent() {
        postingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                myIntent.setType("image/+");
                myIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(myIntent, RESULT_GERRELY);
            }
        });
    }

}
