package com.lucas.senac.topicosavancados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucas.senac.topicosavancados.R;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;
import java.util.ArrayList;

public class PrestadorServicoAdapter extends ArrayAdapter<PrestadorServico> {

    private final Context context;
    private final ArrayList<PrestadorServico> elementos;
    private ArrayList<PrestadorServico> itens_exibicao;

    public PrestadorServicoAdapter(Context context, ArrayList<PrestadorServico> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        TextView profissao = (TextView) rowView.findViewById(R.id.profissao);
        TextView cidade = (TextView) rowView.findViewById(R.id.cidade);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);

        imagem.setImageResource(elementos.get(position).getImagem());
        nome.setText(elementos.get(position).getNome());
        profissao.setText(elementos.get(position).getProfissao());
        cidade.setText(elementos.get(position).getCidade());
        endereco.setText(elementos.get(position).getEndereco());

        return rowView;
    }


}
