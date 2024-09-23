/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.util.ArrayList;

/**
 *
 * @author prograMIAUdores
 */
public class Caja {
    private ArrayList<Object> listaVentas;
    private float total;

    public Caja(ArrayList<Object> listaVentas, float total) {
        this.listaVentas = listaVentas;
        this.total = total;
    }

    public void NuevaVenta() {
        Venta venta = new Venta();
        //Cosas
        listaVentas.add(venta);
    }
}
