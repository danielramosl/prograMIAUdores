/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author danieltron
 */
public class VentaComida extends Venta {
    ArrayList<LineaComida> listaComida;

    public VentaComida(int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago, ArrayList<LineaComida> listaComida) {
        super(id, id_caja, fecha, total, tipoPago);
        this.listaComida = listaComida;
    }

    public VentaComida(int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago) {
        super(id, id_caja, fecha, total, tipoPago);
        listaComida = new ArrayList<>();
    }
    
    public void AñadirLineaComida(String s) {
        StringTokenizer st = new StringTokenizer(s, "|");
        int id = Integer.parseInt(st.nextToken()); 
        int id_comida = Integer.parseInt(st.nextToken());
        int cantidad = Integer.parseInt(st.nextToken());
        listaComida.add(new LineaComida(id, id_comida, cantidad));
    }
    
    @Override
    public String toString() {
        String s = super.toString();
        for(LineaComida b : listaComida) {
            s += "," + b.toString();
        }
        s += "\n";
        return s;
    }
}
