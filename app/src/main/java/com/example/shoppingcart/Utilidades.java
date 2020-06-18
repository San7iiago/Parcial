package com.example.shoppingcart;

public class Utilidades {

    public static final String TABLA_PRODUCTOS="products";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CANTIDAD="cantidad";

    public static final String CREAR_TABLA_PRODUCTOS="CREATE TABLE " +
            ""+TABLA_PRODUCTOS+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE+" TEXT NOT NULL, "
            +CAMPO_CANTIDAD+" INTEGER)";
}
