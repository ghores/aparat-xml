package com.example.aparat.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.adapter.VideoAdapter;
import com.example.aparat.databinding.FragmentFavoriteBinding;
import com.example.aparat.db.AppDatabase;

public class FavoriteFragment extends Fragment {

    //Binding
    FragmentFavoriteBinding binding;

    public FavoriteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());

        AppDatabase appDatabase = AppDatabase.getInstance(getActivity());

        VideoAdapter adapter = new VideoAdapter(getActivity(), appDatabase.iDao().getVideoList());

        binding.recyclerFavorite.setAdapter(adapter);
        binding.recyclerFavorite.setLayoutManager(new GridLayoutManager(getActivity(),2));

        return binding.getRoot();
    }
}