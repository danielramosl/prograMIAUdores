/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author danieltron
 */
public class CajaComida extends Caja {
    ArrayList<VentaComida> listaVenta;

    public CajaComida() {
        super(1);
        this.listaVenta = new ArrayList<>();
    }

    @Override
    public void nuevaVenta(int id_caja, float total, Boolean tipoPago, ArrayList<Boleto> listaBoleto) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
