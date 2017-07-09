package com.lucas.senac.topicosavancados.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucas.senac.topicosavancados.R;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;

public class FragmentB extends Fragment {

    private TextView txtEmail1;
    private TextView txtTelefone1;
    private TextView txtWhats1;


    private PrestadorServico ps;

    public PrestadorServico getPs() {
        return ps;
    }

    public void setPs(PrestadorServico ps) {
        this.ps = ps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, null);

        txtEmail1 = (TextView) view.findViewById(R.id.txtEmail1);
        txtTelefone1 = (TextView) view.findViewById(R.id.txtTelefone1);
        txtWhats1 = (TextView) view.findViewById(R.id.txtWhats1);

        txtEmail1.setText(getPs().getEmail());
        txtTelefone1.setText("("+getPs().getDddT()+") "+getPs().getTelefone());
        txtWhats1.setText("("+getPs().getDddW()+") "+getPs().getWhats());

        return view;
    }
}
