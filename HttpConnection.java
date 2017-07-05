package com.lucas.senac.topicosavancados;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.lucas.senac.topicosavancados.bean.PrestadorServico;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpConnection extends AsyncTask<String, Void, Boolean> {

    private Context context;
    private TarefaInterface ti;
    private ProgressDialog progress;

    public HttpConnection(Context context, TarefaInterface ti) {
        this.context = context;
        this.ti = ti;
    }

    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(context);
        progress.setMessage("Carregando json...");
        progress.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Boolean json = true;

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://prestadorservico.herokuapp.com");
            String answer = "";
            HttpResponse resposta = httpClient.execute(httpGet);
            answer = EntityUtils.toString(resposta.getEntity());
            Log.e("test", "9 " + answer);

            json = true;
            onPostExecute(answer);
        } catch (IOException e) {
            json = false;
        }

        return (json);
    }

    protected void onProgressUpdate(String... params) {
        progress.setMessage("encerrado");
    }

    protected void onPostExecute(String params) {
        ti.depoisDownload(params);
        progress.dismiss();
    }
}
