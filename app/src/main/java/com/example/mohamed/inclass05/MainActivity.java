package com.example.mohamed.inclass05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button getNewsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNewsBtn = (Button) findViewById(R.id.button);
        getNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetEntryAsync(MainActivity.this).execute("http://rss.cnn.com/rss/cnn_tech.rss");
            }
        });
    }
}
