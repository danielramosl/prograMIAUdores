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
public class Venta {
    private int id;
    private int id_caja;
    private LocalDateTime fecha;
    private float total;
    private Boolean tipoPago;

    public Venta(int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago) {
        this.id = id;
        this.id_caja = id_caja;
        this.fecha = fecha;
        this.total = total;
        this.tipoPago = tipoPago;
    }

    public int getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }
    
    
    
    @Override
    public String toString() {
        return id + "," + id_caja + "," + fecha + "," + total + "," + tipoPago;
    }
    
    
}
