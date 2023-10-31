package com.coddelord.borsa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText para,day;
     Button hesaplaBtn;
    double miktar,sonuc;
    int gun,textCount = 0;

    ScrollView scrollView;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        para = findViewById(R.id.money);
        day = findViewById(R.id.day);
        scrollView = findViewById(R.id.scrollView);
        layout = findViewById(R.id.linearLayout);
    }

    public void hesapla(View view){
        miktar = Double.parseDouble(para.getText().toString());
        gun = Integer.parseInt(day.getText().toString());
        layout.removeAllViews();
        for (int i =1; i<=gun; i++){
            miktar = miktar + (miktar * 0.10);
            sonuc = miktar;
            System.out.println(sonuc);
            System.out.println("tekrar" + i );

            TextView textView = new TextView(MainActivity.this);
            textCount++;
            textView.setText(i+". Gün : " +String.format("%.2f", miktar) + " TL" );
            textView.setTextColor(Color.rgb(255,127,0));
            textView.setTextSize(18);

            layout.addView(textView);



            View line = new View(MainActivity.this);
            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    2
            );
            line.setBackgroundColor(Color.BLACK);
            line.setLayoutParams(lineParams);


            layout.addView(line);

            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        }


    }
}