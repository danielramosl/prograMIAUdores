/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.Duration;
/**
 *
 * @author PrograMIAUdores
 */
public class Película {
    private int id;
    private String nombre;
    private String descripción;
    private int duración;
    private String clasificación;
    String portada;

    public Película(int id, String nombre, String descripción, int duración, String clasificación, String portada) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.duración = duración;
        this.clasificación = clasificación;
        this.portada = portada;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public int getDuración() {
        return duración;
    }

    public String getClasificación() {
        return clasificación;
    }

    public String getPortada() {
        return portada;
    }
    
}
