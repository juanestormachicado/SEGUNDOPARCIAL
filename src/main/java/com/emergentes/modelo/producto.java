
package com.emergentes.modelo;


public class producto {
    private int id;
    private String descripcion;
    private int cantidad;
    private float precio;
     private String categoria;

    public producto() {
        this.id =0;
        this.descripcion = "";
        this.categoria= "";
        this.cantidad =0;
        this.precio=0;
        
        
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    
}
