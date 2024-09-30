/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;
import uam.mx.clases.Caja;

/**
 *
 * @author danieltron
 */
public class CajaTaquilla extends Caja {
    ArrayList<VentaBoleto> listaVenta;

    public CajaTaquilla() throws FileNotFoundException, IOException {
        super(0);
        llenarTaquilla();
    }
    
    private void llenarTaquilla() throws FileNotFoundException, IOException {
        listaVenta = new ArrayList<>();
        FileReader fr = new FileReader("src/uam/mx/datos/taquilla.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        super.total = Float.parseFloat(s);
        s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            int id_caja = Integer.parseInt(st.nextToken());
            LocalDateTime fecha = LocalDateTime.parse(st.nextToken());
            float tot = Float.parseFloat(st.nextToken());
            Boolean tipoPago = Boolean.valueOf(st.nextToken());
            VentaBoleto vb = new VentaBoleto(id, id_caja, fecha, tot, tipoPago);
            while(st.hasMoreTokens()) {
                vb.AñadirBoleto(st.nextToken());
            }
            listaVenta.add(vb);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    private int nuevoIDVenta() {
        if(listaVenta.isEmpty()) return 0;
        return listaVenta.getLast().getId() + 1;
    }
    
    public void nuevaVenta(int id_caja, float total, Boolean tipoPago, ArrayList<Boleto> listaBoleto) throws FileNotFoundException, IOException {
        int id = nuevoIDVenta();
        VentaBoleto vb = new VentaBoleto(id, id_caja, LocalDateTime.now(), total, tipoPago, listaBoleto);
        listaVenta.add(vb);
        super.total += vb.getTotal();
        FileWriter fw = new FileWriter("src/uam/mx/datos/taquilla.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = super.total + "\n";
        for(VentaBoleto v : listaVenta) {
            nueva += v.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
}
