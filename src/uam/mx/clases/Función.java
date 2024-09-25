/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author PrograMIAUdores
 */
public class Función {
    private int id;
    private int id_película;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime horario;
    private int formato;
    private float costoBoleto;

    public Función(int id, int id_película, LocalDate fecha, LocalTime horario, int formato, Sala sala) {
        this.id = id;
        this.id_película = id_película;
        this.sala = sala;
        this.fecha = fecha;
        this.horario = horario;
        this.formato = formato;
        costoBoleto = 50 + formato * 25;
    }

    @Override
    public String toString() {
        return id + "," + id_película + "," + fecha + "," + horario + "," + formato + "," + sala + '\n';
    }

    public int getId_película() {
        return id_película;
    }

    public int getFormato() {
        return formato;
    }

    public float getCostoBoleto() {
        return costoBoleto;
    }
    
    public int getId() {
        return id;
    }
    
    public Sala getSala() {
        return sala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }
    
    
}
