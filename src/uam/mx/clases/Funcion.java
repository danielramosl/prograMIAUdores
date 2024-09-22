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
public class Funcion {
    private int id;
    private int id_película;
    private int id_sala;
    private LocalDate fecha;
    private LocalTime horario;
    private int formato;
    private float costoBoleto;

    public Funcion(int id, int id_película, int id_sala, LocalDate fecha, LocalTime horario, int formato) {
        this.id = id;
        this.id_película = id_película;
        this.id_sala = id_sala;
        this.fecha = fecha;
        this.horario = horario;
        this.formato = formato;
        costoBoleto = 50 + formato * 25;
    }

    @Override
    public String toString() {
        return id + "," + id_película + "," + id_sala + "," + fecha + "," + horario + "," + formato + '\n';
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
    
    public int getId_sala() {
        return id_sala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }
    
    
}
