package kr.co.tjeit.instacopyproject02.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject02.R;
import kr.co.tjeit.instacopyproject02.adapter.GalleryAdapter;
import kr.co.tjeit.instacopyproject02.adapter.RecyclerViewAdapter;
import kr.co.tjeit.instacopyproject02.data.User;

//import android.support.v7.widget.RecyclerView;

/**
 * Created by the on 2017-09-06.
 */

public class SearchFragment extends Fragment {


    private android.support.v7.widget.RecyclerView recyclerView;
    private android.widget.GridView galleryGridView;
    List<User> users = new ArrayList<>();
    int[] imgs = {R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2, R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2, R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2, R.drawable.mina_1, R.drawable.mina_2};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search, container, false);
        this.galleryGridView = (GridView) v.findViewById(R.id.galleryGridView);
        this.recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(users);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(recyclerViewAdapter);

        GalleryAdapter galleryAdapter = new GalleryAdapter(getActivity(), R.layout.gallery_list_item, imgs);
        galleryGridView.setAdapter(galleryAdapter);

    }

}



