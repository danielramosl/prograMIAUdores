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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author danieltron
 */
public class CajaComida extends Caja {
    ArrayList<VentaComida> listaVenta;

    public CajaComida() throws IOException {
        super(1);
        llenarDulcería();
    }
    
    private void llenarDulcería() throws FileNotFoundException, IOException {
        listaVenta = new ArrayList<>();
        FileReader fr = new FileReader("src/uam/mx/datos/dulcería.dat");
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
            VentaComida vc = new VentaComida(id, id_caja, fecha, tot, tipoPago);
            while(st.hasMoreTokens()) {
                vc.AñadirLineaComida(st.nextToken());
            }
            listaVenta.add(vc);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    
    private int nuevoIDVenta() {
        if(listaVenta.isEmpty()) return 0;
        return listaVenta.getLast().getId() + 1;
    }
    
    public void nuevaVenta(int id_caja, float total, Boolean tipoPago, ArrayList<LineaComida> listaComida) throws FileNotFoundException, IOException {
        int id = nuevoIDVenta();
        VentaComida vb = new VentaComida(id, id_caja, LocalDateTime.now(), total, tipoPago, listaComida);
        listaVenta.add(vb);
        super.total += vb.getTotal();
        FileWriter fw = new FileWriter("src/uam/mx/datos/dulcería.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = super.total + "\n";
        for(VentaComida v : listaVenta) {
            nueva += v.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
}