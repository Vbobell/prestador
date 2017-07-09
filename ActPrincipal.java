package com.lucas.senac.topicosavancados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.lucas.senac.topicosavancados.adapter.PrestadorServicoAdapter;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TarefaInterface {

    public ArrayList<PrestadorServico> getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(ArrayList<PrestadorServico> pesquisa) {
        this.pesquisa = pesquisa;
    }

    private ArrayList<PrestadorServico> pesquisa = new ArrayList<PrestadorServico>();
    private ListView lView;
    private EditText eText;
    private ArrayAdapter adapter;
    private Boolean aux = true;

    public void setAux(Boolean aux) {
        this.aux = aux;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getJson();

        lView = (ListView) findViewById(R.id.lView);
        eText = (EditText) findViewById(R.id.eText);
        adapter = new PrestadorServicoAdapter(this, pesquisa);
        lView.setAdapter(adapter);


        eText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("test", pesquisa.toString());
                adapter = new PrestadorServicoAdapter(ActPrincipal.this, filtrar(s));
                lView.setAdapter(adapter);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MenuInformativo.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });
    }

    public void sendJson(ArrayList<PrestadorServico> pesquisa) {
        //callServer("send-json", json);
        String json = generateJSON(pesquisa);
        Log.e("test", json);
    }

    public void getJson() {
        callServer("get-json", "");
    }

    private String generateJSON(ArrayList<PrestadorServico> pesquisa) {
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        try {
            for (int i = 0, tam = pesquisa.size(); i < tam; i++) {
                JSONObject aux = new JSONObject();
                aux.put("imagem", pesquisa.get(i).getImagem());
                aux.put("nome", pesquisa.get(i).getNome());
                aux.put("profissao", pesquisa.get(i).getProfissao());
                aux.put("cidade", pesquisa.get(i).getCidade());
                aux.put("bairro", pesquisa.get(i).getBairro());
                aux.put("endereco", pesquisa.get(i).getEndereco());
                aux.put("dddT", pesquisa.get(i).getDddT());
                aux.put("telefone", pesquisa.get(i).getTelefone());
                aux.put("dddW", pesquisa.get(i).getDddW());
                aux.put("whats", pesquisa.get(i).getWhats());
                aux.put("email", pesquisa.get(i).getEmail());

                ja.put(aux);
            }
            jo.put("prestadorSevico", ja);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (jo.toString());
    }

    public ArrayList<PrestadorServico> degenerateJSON(String data) {
        ArrayList<PrestadorServico> pesquisa = new ArrayList<PrestadorServico>();
        try {
            JSONObject jo = new JSONObject(data);
            JSONArray ja;
            ja = jo.getJSONArray("prestadorServico");
            for (int i = 0; i < ja.length(); i++) {
                PrestadorServico prestadorServico = new PrestadorServico();
                prestadorServico.setImagem(Integer.parseInt(ja.getJSONObject(i).getString("imagem")));
                prestadorServico.setNome(ja.getJSONObject(i).getString("nome"));
                prestadorServico.setProfissao(ja.getJSONObject(i).getString("profissao"));
                prestadorServico.setCidade(ja.getJSONObject(i).getString("cidade"));
                prestadorServico.setBairro(ja.getJSONObject(i).getString("bairro"));
                prestadorServico.setEndereco(ja.getJSONObject(i).getString("endereco"));
                prestadorServico.setDddT(Integer.parseInt(ja.getJSONObject(i).getString("dddt")));
                prestadorServico.setTelefone(Integer.parseInt(ja.getJSONObject(i).getString("telefone")));
                prestadorServico.setDddW(Integer.parseInt(ja.getJSONObject(i).getString("dddw")));
                prestadorServico.setWhats(Integer.parseInt(ja.getJSONObject(i).getString("whats")));
                prestadorServico.setEmail(ja.getJSONObject(i).getString("email"));

                pesquisa.add(prestadorServico);
            }
            Log.e("test", pesquisa.toString());

            for (PrestadorServico p : pesquisa) {
                Log.e("test", "imagem: " + p.getImagem());
                Log.e("test", "nome: " + p.getNome());
                Log.e("test", "profissao: " + p.getProfissao());
                Log.e("test", "cidade: " + p.getCidade());
                Log.e("test", "bairro: " + p.getBairro());
                Log.e("test", "endereco: " + p.getEndereco());
                Log.e("test", "dddT: " + p.getDddT());
                Log.e("test", "telefone: " + p.getTelefone());
                Log.e("test", "dddW: " + p.getDddW());
                Log.e("test", "whats: " + p.getWhats());
                Log.e("test", "email: " + p.getEmail());
            }
            setAux(false);
        } catch (JSONException e) {
            Log.i("test", e.toString());
            e.printStackTrace();
        }
        return pesquisa;
    }

    private void callServer(final String method, final String data) {
        HttpConnection tarefa = new HttpConnection(this, this);
        tarefa.execute();
    }

    public ArrayList<PrestadorServico> adicionarPrestadorServico() {
        ArrayList<PrestadorServico> prestadorServicos = new ArrayList<PrestadorServico>();
        PrestadorServico e = new PrestadorServico(R.drawable.eletricista, "Pedro", "Eletricista", "Porto Alegre - RS", "Praia de Belas", "Rua Pacatuba, 105", 51, 999887744, 51,  88997711, "pedro@eletricista.com.br");
        prestadorServicos.add(e);
        e = new PrestadorServico(R.drawable.empregada, "Renata", "Empregada", "Caxias - RS", "Floresta", "Rua Sergipe, 415", 54, 744741452, 54,  852524645, "renata@empregada.com.br");
        prestadorServicos.add(e);
        e = new PrestadorServico(R.drawable.marceneiro, "Joao", "Marceneiro", "Pelotas - RS", "Floresta", "Rua dos Marceneiros, 1154", 53, 665566332, 53,  445541451, "joao@marceneiro.com.br");
        prestadorServicos.add(e);
        e = new PrestadorServico(R.drawable.pedreiro, "Ricardo", "Pedreiro", "Porto Alegre - RS", "Floresta", "R. Franklin de Campos Sobral, 1675", 55, 11110212, 53,  654456212, "joao@marceneiro.com.br");
        prestadorServicos.add(e);

        Log.e("test", prestadorServicos.toString());

        for (PrestadorServico ps : prestadorServicos) {
            ps.getNome().equals("a");
        }
        return prestadorServicos;
    }

    private ArrayList<PrestadorServico> filtrar(CharSequence s) {
        ArrayList<PrestadorServico> prestadorServicos = getPesquisa();
        ArrayList<PrestadorServico> aux = new ArrayList<PrestadorServico>();

        for (int i = 0; i < prestadorServicos.size(); i++) {
            if (s.length() < prestadorServicos.get(i).getNome().length()) {
                if (prestadorServicos.get(i).getNome().substring(0, s.length()).toLowerCase().equals(s.toString())) {
                    aux.add(prestadorServicos.get(i));
                }
            }
        }
        return aux;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.act_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void depoisDownload(String retorno) {
        setPesquisa(degenerateJSON(retorno));
    }
}
