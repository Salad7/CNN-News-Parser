package com.example.mohamed.inclass05;

import android.os.AsyncTask;
import android.util.Log;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.in;

/**
 * Created by mohamed on 2/13/17.
 */
//Passing in a String through params, Void return, Data will be indiviual Entry
public class GetEntryAsync extends AsyncTask<String,Void, ArrayList<Entry>> {

    private IData activity;
    GetEntryAsync(IData activity){
        this.activity = activity;

    }
    //Progress update
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    //Handle dialog here
    protected void onPreExecute() {
        super.onPreExecute();
    }
    //

    @Override
    protected void onPostExecute(ArrayList<Entry> entries) {
        super.onPostExecute(entries);
        Log.d("dLLL",entries.get(0).getTitle());
        activity.setupData(entries);
    }

    @Override
    protected ArrayList<Entry> doInBackground(String... strings) {

            BufferedReader reader = null;

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect(); //N
                //reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                //StringBuilder sb = new StringBuilder();
                //String line = "";
                //while ((line = reader.readLine()) != null ) {
                  //  sb.append(line);
                //}
                int statusCode = con.getResponseCode();
                if(statusCode == HttpURLConnection.HTTP_OK){
                    InputStream in = con.getInputStream();
                   // Log.d("dd","ssssssss"); WOrks
                    return EntryUtils.EntriesSAXParser.parseEntries(in);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
            }finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return null;
    }
    static public interface IData {
        public void setupData(ArrayList<Entry> s);
    }
}
