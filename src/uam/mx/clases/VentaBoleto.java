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
public class VentaBoleto extends Venta {
    ArrayList<Boleto> listaBoletos;
    
    public VentaBoleto(int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago) {
        super(id, id_caja, fecha, total, tipoPago);
        listaBoletos = new ArrayList<>();
    }

    public VentaBoleto(int id, int id_caja, LocalDateTime fecha, float total, Boolean tipoPago, ArrayList<Boleto> listaBoletos) {
        super(id, id_caja, fecha, total, tipoPago);
        this.listaBoletos = listaBoletos;
    }
    
    public void AñadirBoleto(String s) {
        StringTokenizer st = new StringTokenizer(s, "|");
        int id = Integer.parseInt(st.nextToken());
        int id_función = Integer.parseInt(st.nextToken());
        int id_asiento = Integer.parseInt(st.nextToken());
        Boleto b = new Boleto(id, id_función, id_asiento);
        listaBoletos.add(b);
    }
    
    @Override
    public String toString() {
        String s = super.toString();
        for(Boleto b : listaBoletos) {
            s += "," + b.toString();
        }
        s += "\n";
        return s;
    }
}
