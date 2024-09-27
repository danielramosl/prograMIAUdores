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
    private String portada;
  
    public Comida(int id, String nombre, float precio, int inventario, String imagen, String portada) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.imagen = imagen;
        this.portada = portada;
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

    public String getPortada() {
        return portada;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

}
