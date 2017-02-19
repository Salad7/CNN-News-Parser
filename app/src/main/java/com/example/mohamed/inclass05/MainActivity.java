package com.example.mohamed.inclass05;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  GetEntryAsync.IData, GetImageAsync.IData{

    private Button getNewsBtn;
    Button get_news_btn, finish;
    ImageButton first_btn, prev_btn, next_btn, last_btn;
    int current_article;
    Spinner news_source;
    String source, created_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_btn = (ImageButton) findViewById(R.id.btn_first);
        prev_btn = (ImageButton) findViewById(R.id.btn_prev);
        next_btn = (ImageButton) findViewById(R.id.btn_next);
        last_btn = (ImageButton) findViewById(R.id.btn_last);
        getNewsBtn = (Button) findViewById(R.id.get_news_btn);
        getNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("hit","dadasda");
                new GetEntryAsync(MainActivity.this).execute("http://rss.cnn.com/rss/cnn_tech.rss");
            }
        });
    }

    public void setupData(final ArrayList<Entry> s) {
        if (s != null) {

            setArticleInformation(current_article, s);

            //new SetImageAsync(MainActivity.this).execute(s.get(0).getUrlToImage().toString());


            first_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_article = 0;
                    setArticleInformation(current_article, s);
                }
            });

            prev_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(current_article > 0) {
                        current_article--;
                        setArticleInformation(current_article, s);
                    } else {
                        Toast.makeText(MainActivity.this, "You are already on the first article.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(current_article < s.size()-1 ) {
                        current_article++;
                        setArticleInformation(current_article, s);
                    } else {
                        Toast.makeText(MainActivity.this, "You are already on the last article.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            last_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_article = s.size()-1;
                    setArticleInformation(current_article, s);
                }
            });

        } else {
            //Log.d("DEMO","");
        }
    }

    public void setArticleInformation(int number, ArrayList<Entry> s) {

        ScrollView sv = (ScrollView) findViewById(R.id.news_data);

        LinearLayout ll;


        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv = (ScrollView) this.findViewById(R.id.news_data);
        sv.removeAllViews();

        TextView tvTitle = new TextView(this);
       // TextView tvAuthor = new TextView(this);
        TextView tvCreatedOn = new TextView(this);
        TextView tvDescription = new TextView(this);

        tvTitle.setText(s.get(number).getTitle().toString());
       // tvAuthor.setText("Description: " + s.get(number).getDesc().toString());
        tvCreatedOn.setText("Published On: " + s.get(number).getPubDate().toString());
        tvDescription.setText("\nDescription: \n" + s.get(number).getDesc().toString());

        ll.addView(tvTitle);
       // ll.addView(tvAuthor);
        ll.addView(tvCreatedOn);
        ll.addView(tvDescription);

        sv.addView(ll);

        //new SetImageAsync(MainActivity.this).execute(s.get(number).getUrlToImage().toString());

    }

    @Override
    public void sendImage(Bitmap b) {
        ImageView article_image;
        article_image = (ImageView) this.findViewById(R.id.article_image);
        article_image.setImageBitmap(b);
    }
}

