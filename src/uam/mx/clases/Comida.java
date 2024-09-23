/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

/**
 *
 * @author prograMIAUdores
 */
public class Comida {
    private int id;
    private String nombre;
    private float precio;
    private int inventario;
    private String imagen;
  
    public Comida(int id, String nombre, float precio, int inventario, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getInventario() {
        return inventario;
    }

    public String getImagen() {
        return imagen;
    }
    
}
