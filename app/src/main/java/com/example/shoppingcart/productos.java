package com.example.shoppingcart;

import java.io.Serializable;

public class productos implements Serializable {
    private String name, quantity;

    public productos(String nombre, String cantidad) {
        this.name = nombre;
        this.quantity = cantidad;
    }

    public String getNombre() {
        return name;
    }

    public String getCantidad() {
        return quantity;
    }
}
