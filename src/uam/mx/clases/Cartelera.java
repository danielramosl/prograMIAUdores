/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PrograMIAUdores
 */
public class Cartelera {
    private ArrayList<Integer> id_funciones;
    private LocalDate fecha;

    public Cartelera(ArrayList<Integer> id_funciones, LocalDate fecha) {
        this.id_funciones = id_funciones;
        this.fecha = fecha;
    }
}
