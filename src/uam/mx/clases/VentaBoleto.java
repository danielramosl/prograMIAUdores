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
public class VentaBoleto {
    private int id;
    private int id_caja;
    private ArrayList<Boleto> listaBoletos;
    private float descuento;
    private LocalDateTime fecha;
    private float total;
    private Boolean tipoPago;

    public VentaBoleto(int id, int id_caja, ArrayList<Boleto> listaBoletos, float descuento, LocalDateTime fecha, float total, Boolean tipoPago) {
        this.id = id;
        this.id_caja = id_caja;
        this.listaBoletos = listaBoletos;
        this.descuento = descuento;
        this.fecha = fecha;
        this.total = total;
        this.tipoPago = tipoPago;
        
        
    }

    public VentaBoleto(int id, int id_caja, ArrayList<Boleto> listaBoletos, float descuento, LocalDateTime fecha, Boolean tipoPago) {
        this.id = id;
        this.id_caja = id_caja;
        this.listaBoletos = listaBoletos;
        this.descuento = descuento;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
    }
}
