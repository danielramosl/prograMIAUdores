/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author prograMIAUdores
 */
public class VentaComida {
    private int id;
    private ArrayList<LineaComida> lineaVenta;
    private LocalDateTime fecha;
    private float total;

    public VentaComida(int id, ArrayList<LineaComida> lineaVenta, LocalDateTime fecha) {
        this.id = id;
        this.lineaVenta = lineaVenta;
        this.fecha = fecha;
    }
}
