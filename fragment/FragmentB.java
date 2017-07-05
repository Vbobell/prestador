package com.lucas.senac.topicosavancados.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucas.senac.topicosavancados.R;

public class FragmentB extends Fragment {

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, null);

        //TextView tv = (TextView) view.findViewById(R.id.textFragment);
        //tv.setText("Fragment 2");

        return view;
    }
}
