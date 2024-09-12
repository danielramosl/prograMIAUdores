/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.util.ArrayList;

/**
 *
 * @author PrograMIAUdores
 */
public class Sala {
    private int id;
    private ArrayList<Asiento> asientos;

    public Sala(int id, ArrayList<Asiento> asientos) {
        this.id = id;
        this.asientos = asientos;
    }
}
