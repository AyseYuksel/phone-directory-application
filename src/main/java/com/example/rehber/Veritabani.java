package com.example.rehber;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Veritabani extends SQLiteOpenHelper {


    public Veritabani(@Nullable Context context) {
        super(context, "telefonvt", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table telefon(id integer primary key,adsoyad text,numara text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists telefon");
        this.onCreate(db);
    }

    void ekle(String adsoyad,String numara){
        SQLiteDatabase vt=this.getWritableDatabase();
        vt.execSQL("insert into telefon(adsoyad,numara) values('"+adsoyad+"','"+numara+"')");
        vt.close();
    }

    ArrayList<String> tumunulistele(){
        SQLiteDatabase vt=this.getWritableDatabase();
        ArrayList<String> liste=new ArrayList<>();
        Cursor c=vt.rawQuery("select * from telefon order by id desc",null);
        if(c.moveToFirst()){
            do{
                String s=c.getString(1)+" : "+c.getString(2);
                liste.add(s);
            }while(c.moveToNext());
        }
        return liste;
    }




}
