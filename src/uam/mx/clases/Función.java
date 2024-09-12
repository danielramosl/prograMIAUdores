/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDateTime;

/**
 *
 * @author PrograMIAUdores
 */
public class Función {
    private int id;
    private int id_película;
    private Sala sala;
    private float costoBoleto;
    private LocalDateTime fecha;

    public Función(int id, int id_película, Sala sala, float costoBoleto, LocalDateTime fecha) {
        this.id = id;
        this.id_película = id_película;
        this.sala = sala;
        this.costoBoleto = costoBoleto;
        this.fecha = fecha;
    }
}
