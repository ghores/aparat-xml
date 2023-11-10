package com.example.aparat.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.api.WebServiceCaller;
import com.example.aparat.model.IResponseListener;

public class HomeFragment extends Fragment {

    WebServiceCaller webServiceCaller;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        webServiceCaller = new WebServiceCaller();
        webServiceCaller.getBestVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("", "");

            }
        });

        return view;
    }
}