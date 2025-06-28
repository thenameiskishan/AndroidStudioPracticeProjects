package com.example.ratingbar20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        TextView emoji;
        RatingBar ratingbar;
        Button btn;
        TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingbar=findViewById(R.id.ratingbar);
        btn=findViewById(R.id.btn);
        text=findViewById(R.id.text);
        emoji=findViewById(R.id.emoji);
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ratings please...", Toast.LENGTH_SHORT).show();
            }
        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratings, boolean input) {
                if(input)
                {
                    text.setText(ratings+"");
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+ratingbar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}