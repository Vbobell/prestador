package com.lucas.senac.topicosavancados.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucas.senac.topicosavancados.ActPrincipal;
import com.lucas.senac.topicosavancados.R;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;

public class FragmentA extends Fragment {
    private TextView txtNome1;
    private TextView txtProfissao1;
    private TextView txtCidade1;
    private TextView txtBairro1;
    private TextView txtEndereco1;


    private PrestadorServico ps;

    public PrestadorServico getPs() {
        return ps;
    }

    public void setPs(PrestadorServico ps) {
        this.ps = ps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);

        txtNome1 = (TextView) view.findViewById(R.id.txtNome1);
        txtProfissao1 = (TextView) view.findViewById(R.id.txtProfissao1);
        txtCidade1 = (TextView) view.findViewById(R.id.txtCidade1);
        txtBairro1 = (TextView) view.findViewById(R.id.txtBairro1);
        txtEndereco1 = (TextView) view.findViewById(R.id.txtEndereco1);

        txtNome1.setText(getPs().getNome());
        txtProfissao1.setText(getPs().getProfissao());
        txtCidade1.setText(getPs().getCidade());
        txtBairro1.setText(getPs().getBairro());
        txtEndereco1.setText(getPs().getEndereco());

        return view;
    }
}
