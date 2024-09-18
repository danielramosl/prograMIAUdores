/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author prograMIAUdores
 */
public class Venta {
    private int id;
    private int id_caja;
    private ArrayList<Object> lineaVenta;
    private LocalTime fecha;
    private float total;
    private Boolean tipoPago;

    public Venta(int id, int id_caja, ArrayList<Object> lineaVenta, LocalTime fecha, float total, Boolean tipoPago) {
        this.id = id;
        this.id_caja = id_caja;
        this.lineaVenta = lineaVenta;
        this.fecha = fecha;
        this.total = total;
        this.tipoPago = tipoPago;
    }
}
