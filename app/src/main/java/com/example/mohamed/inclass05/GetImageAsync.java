package com.example.mohamed.inclass05;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by mohamed on 2/19/17.
 */

public class GetImageAsync extends AsyncTask<String, Void, Bitmap> {
    IData activity;

    GetImageAsync(IData activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
       // activity.sendImage(); //From here we can send the image
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    static public interface IData{
        void sendImage(Bitmap b);
    }

}

