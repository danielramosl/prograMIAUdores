/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

/**
 *
 * @author PrograMIAUdores
 */
public class Asiento {
    private int id;
    private Boolean ocupado;

    public Asiento(int id, Boolean ocupado) {
        this.id = id;
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}
