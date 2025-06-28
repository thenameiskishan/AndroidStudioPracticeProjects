package com.example.tik_for_tak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9,background;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        i4=findViewById(R.id.i4);
        i5=findViewById(R.id.i5);
        i6=findViewById(R.id.i6);
        i7=findViewById(R.id.i7);
        i8=findViewById(R.id.i8);
        i9=findViewById(R.id.i9);
        background=findViewById(R.id.background);


        for (;i<=9;)
        {   if (i1.callOnClick()||
                i2.callOnClick()||
                i3.callOnClick()||
                i4.callOnClick()||
                i5.callOnClick()||
                i6.callOnClick()||
                i7.callOnClick()||
                i8.callOnClick()||
                i9.callOnClick())
                {
                    i++;
                }

             i1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (i%2==0)
                     {
                         i1.setImageResource(R.drawable.cross);
                     }
                     else
                     {
                         i1.setImageResource(R.drawable.circle);
                     }
                 }
             });

            i2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i2.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i2.setImageResource(R.drawable.circle);
                    }
                }
            });

            i3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i3.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i3.setImageResource(R.drawable.circle);
                    }
                }
            });

            i4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i4.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i4.setImageResource(R.drawable.circle);
                    }
                }
            });

            i5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i5.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i5.setImageResource(R.drawable.circle);
                    }
                }
            });

            i6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i6.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i6.setImageResource(R.drawable.circle);
                    }
                }
            });

            i7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i7.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i7.setImageResource(R.drawable.circle);
                    }
                }
            });

            i8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i8.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i8.setImageResource(R.drawable.circle);
                    }
                }
            });

            i9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i%2==0)
                    {
                        i9.setImageResource(R.drawable.cross);
                    }
                    else
                    {
                        i9.setImageResource(R.drawable.circle);
                    }
                }
            });
        }




    }


}

