/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

/**
 *
 * @author prograMIAUdores
 */
public class LineaComida {
    private int id;
    private int id_comida;
    private int cantidad;
    private float subtotal;

    public LineaComida(int id, int id_comida, int cantidad) {
        this.id = id;
        this.id_comida = id_comida;
        this.cantidad = cantidad;
    }
}
