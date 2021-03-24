package com.example.rehber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Veritabani vt;
    Context c;
    ListView liste;
    ArrayAdapter uyarlayici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    c=this;
    vt=new Veritabani(c);
    liste=(ListView)findViewById(R.id.listem);

    ((Button)findViewById(R.id.kayitbuton)).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String adsoyad=((EditText)findViewById(R.id.adsoyad)).getText().toString();
            String numara=((EditText)findViewById(R.id.numara)).getText().toString();
            vt.ekle(adsoyad,numara);
            listele();
         //   uyarlayici.insert(adsoyad+" : "+numara,0);

            liste.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(c,"TIKLANAN SECİM : "+(String)parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
                }

            });
        }
        void listele(){
            ArrayList<String> elemanlar=vt.tumunulistele();
            ArrayAdapter uyarlayici=new ArrayAdapter(c, android.R.layout.simple_list_item_1,elemanlar);
            liste.setAdapter(uyarlayici);

        }


    });



    }
}