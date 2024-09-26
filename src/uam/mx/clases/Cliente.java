/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.time.LocalDate;

/**
 *
 * @author PrograMIAUdores
 */
public class Cliente {
    private int id;
    private int id_usuario;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String correo;
    private int puntos;

    public Cliente(int id, int id_usuario, String nombre, LocalDate fechaNacimiento, String correo, int puntos) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return id + "," + id_usuario + "," + nombre + "," + fechaNacimiento + "," + correo + "," + puntos + '\n';
    }
    
    
}
