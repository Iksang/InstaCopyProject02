package kr.co.tjeit.instacopyproject02.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.tjeit.instacopyproject02.MainActivity;
import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.util.ContextUtil;
import kr.co.tjeit.instacopyproject02.util.ServerUtil;

/**
 * Created by the on 2017-09-07.
 */

public class WritingPostFragment extends Fragment {

    final int RESULT_GERRELY = 1;

    private android.widget.ImageView postingImg;
    private android.widget.EditText contentEdt;
    private android.widget.TextView postSendBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_writing_post, container, false);
        this.postSendBtn = (TextView) v.findViewById(R.id.postSendBtn);
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

                               TedPermission.with(getActivity()).setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        // 모든 퍼미션이 허가를 받았을때 실행

                        Toast.makeText(getActivity(), "모든 허가가 완료 되었다.", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent();
                        myIntent.setType("image/+");
                        myIntent.setAction(Intent.ACTION_PICK);
                        startActivityForResult(myIntent, RESULT_GERRELY);

                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        // 퍼미션이 거부 당한 경우에
                        // 어떤 어떤 퍼미션이 거부됐는지 deniedPermissions에 담겨옴
                        Toast.makeText(getActivity(), "거부된 권한 :"+deniedPermissions.get(0), Toast.LENGTH_SHORT).show();
                    }
                })
                        .setDeniedMessage("퍼미션을 겨부할 경우, 프로필 사진 수정 기능을 활용할 수 없습니다. 설정 -> 권한앱에서 수정해주세요")
                        .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE).check();

            }
        });
        postSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.makePosting(getActivity(), ContextUtil.getLoginUserData(getActivity()).getUserId(), contentEdt.getText().toString(),
                        postingImg.getDrawingCache(), new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")){
                                        Intent myIntent = new Intent(getActivity(), MainActivity.class);
                                        startActivity(myIntent);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_GERRELY) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    postingImg.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
