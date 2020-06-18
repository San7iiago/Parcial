package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText lnombre;
    private EditText lcantidad;
    connectionDB conn;

    private ListView listItems;
    private ProductoAdaptador adaptador;
    ArrayList<productos> listItems2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lnombre = findViewById(R.id.nameProduct);
        lcantidad = findViewById(R.id.quantity);

        listItems = (ListView) findViewById(R.id.listProducts);
        listItems2 = obtenerDatos();
        adaptador = new ProductoAdaptador(this, listItems2);
        listItems.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
    }

    private ArrayList<productos> obtenerDatos (){

        ArrayList<productos> listItems = new ArrayList<>();

        conn=new connectionDB(this,"market",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();

        Cursor c = market.rawQuery(" Select " +  Utilidades.CAMPO_NOMBRE+", "+ Utilidades.CAMPO_CANTIDAD
                + " FROM " + Utilidades.TABLA_PRODUCTOS, null);
        if (c.moveToFirst()) {
            do {
                listItems.add(new productos(c.getString(0),c.getString(1)));
            } while(c.moveToNext());
        }

        c.close();

        return listItems;
    }

    public void Registrar (View view){
        conn=new connectionDB(this,"market",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();

        String nombre = lnombre.getText().toString();
        String cantidad = lcantidad.getText().toString();

        if (nombre.length() == 0){
            lnombre.setError("Debe escribir un nombre");
        } else if (cantidad.length() == 0){
            lcantidad.setError("Debe escribir una cantidad");
        } else if (nombre.length() != 0 && cantidad.length() != 0) {
            registrarProductos();
        }
    }

    private void registrarProductos() {
        conn=new connectionDB(this,"market",null,1);

        SQLiteDatabase market=conn.getWritableDatabase();

        String nombre = lnombre.getText().toString();
        int cantidad = Integer.parseInt(lcantidad.getText().toString());

        ContentValues pack=new ContentValues();
        pack.put(Utilidades.CAMPO_NOMBRE, nombre);
        pack.put(Utilidades.CAMPO_CANTIDAD, cantidad);

        long insert = market.insert(Utilidades.TABLA_PRODUCTOS, Utilidades.CAMPO_ID, pack);

        Toast.makeText(this, "The product has been registered", Toast.LENGTH_SHORT).show();
        listItems2 = obtenerDatos();
        adaptador = new ProductoAdaptador(this, listItems2);
        listItems.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        market.close();
    }
}
