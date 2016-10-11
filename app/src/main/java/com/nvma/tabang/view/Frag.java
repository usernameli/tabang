package com.nvma.tabang.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nvma.tabang.R;

public class Frag extends Fragment {
    private View parentView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        int flag = Integer.parseInt(getArguments().getString("key"));
       // System.out.println(flag + "sssssssss");

                parentView = inflater.inflate(R.layout.progressdialog, container,
                        false);
                return parentView;

    }
}