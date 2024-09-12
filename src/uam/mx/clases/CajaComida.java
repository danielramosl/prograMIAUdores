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
public class CajaComida {
    private ArrayList<VentaComida> listaVentas;
    private float total;

    public CajaComida(ArrayList<VentaComida> listaVentas, float total) {
        this.listaVentas = listaVentas;
        this.total = total;
    }
}
