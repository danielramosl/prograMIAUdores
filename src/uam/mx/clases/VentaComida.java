/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author danieltron
 */
public class VentaComida extends Venta {
    ArrayList<LineaComida> listaComida;

    public VentaComida(ArrayList<LineaComida> listaComida, int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago) {
        super(id, id_caja, fecha, total, tipoPago);
        this.listaComida = listaComida;
    }
}
