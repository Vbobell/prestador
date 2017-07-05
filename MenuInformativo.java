package com.lucas.senac.topicosavancados;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucas.senac.topicosavancados.adapter.MyFragmentPagerAdapter;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;

public class MenuInformativo extends AppCompatActivity implements TarefaInterface {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView img;
    private String json = "";
    private Boolean aux = true;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_informativo);

        long idSelected = getIntent().getLongExtra("ID", 0);
        int positionSelected = getIntent().getIntExtra("POSITION", 0);

        Log.e("test", idSelected+"");
        Log.e("test", positionSelected+"");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        img = (ImageView) findViewById(R.id.imagem);

        HttpConnection tarefa = new HttpConnection(this, this);
        tarefa.execute("https://prestadorservico.herokuapp.com", "teste");
        while (aux) ;
        ActPrincipal ac = new ActPrincipal();
        ac.setPesquisa(ac.degenerateJSON(getJson()));
        PrestadorServico ps = ac.getPesquisa().get(positionSelected);
        img.setImageResource(ps.getImagem());

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titler_tab),ps));

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void depoisDownload(String retorno) {

        setJson(retorno);
        this.aux = false;
    }
}
