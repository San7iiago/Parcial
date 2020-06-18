package com.example.shoppingcart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class connectionDB extends SQLiteOpenHelper {

    public connectionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        market.execSQL(Utilidades.CREAR_TABLA_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase market, int i, int i1) {
        market.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRODUCTOS);
        onCreate(market);
    }
}
