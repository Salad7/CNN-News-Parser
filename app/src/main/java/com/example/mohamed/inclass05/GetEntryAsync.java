package com.example.mohamed.inclass05;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by mohamed on 2/13/17.
 */
//Passing in a String through params, Void return, Data will be indiviual Entry
public class GetEntryAsync extends AsyncTask<String,Void, ArrayList<Entry>> {
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
    }

    @Override
    protected ArrayList<Entry> doInBackground(String... strings) {
        return null;
    }
}
