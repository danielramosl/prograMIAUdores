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
public final class Sala {
    private final int id;
    private ArrayList<Asiento> asientos;

    public Sala(int id, String asientos) {
        this.id = id;
        leerAsientos(asientos);
    }
    
    public void leerAsientos(String s) {
        asientos = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) {
            Asiento a = new Asiento(i + 1, toBool(s.charAt(i)));
            asientos.add(a);
        }
    }
    
    private int toInt(Boolean b) {
        return (b ? 1 : 0);
    }
    
    private Boolean toBool(char b) {
        return (b == '1');
    }
    
    public int getID() {
        return id;
    }
    
    @Override
    public String toString() {
        String s = Integer.toString(id) + ",";
        for(int i = 0; i < asientos.size(); ++i) {
            s += Integer.toString(toInt(asientos.get(i).getOcupado()));
        }
        return s;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }
    
    public void seleccionarAsiento(int i) {
        asientos.get(i).setOcupado(true);
    }
}