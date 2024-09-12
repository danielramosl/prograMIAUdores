/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

/**
 *
 * @author PrograMIAUdores
 */
public class Empleado {
    private int id;
    private int id_usuario;
    private String nombre;
    private int tipoEmpleado;

    public Empleado(int id, int id_usuario, String nombre, int tipoEmpleado) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.tipoEmpleado = tipoEmpleado;
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

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }
    
    
}
