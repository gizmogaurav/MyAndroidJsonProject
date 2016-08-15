package com.gizmogauravgmail.myapplication;

import android.app.ProgressDialog;
import android.content.Entity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView  listView;
    ActorsAdapter actorAdapter;
    ArrayList<Actors> actorses ;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actorses = new ArrayList<Actors>();
        listView = (ListView) findViewById(R.id.list);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading Movies");
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config); // Do it on Application start
        new ActorAsyncTask().execute("http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors");
    }


    public class ActorAsyncTask extends AsyncTask<String,Void,Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {
            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;
try {
            //HttpClient httpClient = new DefaultHttpClient();

    URL url = new URL(params[0]);
    httpURLConnection = (HttpURLConnection)url.openConnection();
    httpURLConnection.connect();
    int status = httpURLConnection.getResponseCode();
    //Toast.makeText(MainActivity.this,"Status is " + String.valueOf(status), Toast.LENGTH_SHORT).show();
    if(status == 200) {
    InputStream inputStream = httpURLConnection.getInputStream();
    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String line = null;
    StringBuffer stringBuffer = new StringBuffer();
    while((line = bufferedReader.readLine()) != null){
        stringBuffer.append(line);
    }
            //HttpPost httpPost = new HttpPost(params[0]);
           // HttpResponse httpResponse = httpClient.execute(httpPost);




        //HttpEntity httpEntity = httpResponse.getEntity();
        //String data = EntityUtils.toString(httpEntity);
        JSONObject jsonObject = new JSONObject(stringBuffer.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("actors");
        Gson gson = new Gson();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject object = jsonArray.getJSONObject(i);
            Actors actor = gson.fromJson(object.toString(),Actors.class);
            /*Actors actor = new Actors();

            actor.setName(object.getString("name"));
            actor.setDescription(object.getString("description"));
            actor.setDob(object.getString("dob"));
            actor.setCountry(object.getString("country"));
            actor.setHeight(object.getString("height"));
            actor.setSpouse(object.getString("spouse"));
            actor.setChildren(object.getString("children"));
            actor.setImage(object.getString("image"));*/

            actorses.add(actor);
        }
    }
        return true;

    } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
}
            finally {
                if(httpURLConnection != null){
                 httpURLConnection.disconnect();
                    try {
                        if(bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
}
            return false;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean == false){
// data was not parsed
            }
            else{
                progressDialog.dismiss();
                ActorsAdapter actorsAdapter = new ActorsAdapter(getApplicationContext(),R.layout.row,actorses);
                listView.setAdapter(actorsAdapter);
            }

        }
    }
}


