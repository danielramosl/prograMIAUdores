/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author prograMIAUdores
 */
public class Cine {
    private String nombre_cine;
    private String dirección;
    private Caja cajaBoleto;
    private Caja cajaComida;
    private SistemaUsuarios sistemaUsuarios;
    private Cartelera cartelera;
    private Menu menu;
    private ArrayList<Sala> listaSalas;

    public Cine() throws IOException {
        nombre_cine = "PrograMIAUdores";
        dirección = "MICHIgan";
        sistemaUsuarios = new SistemaUsuarios();
        cartelera = new Cartelera();
        menu = new Menu();
    }
    
    public Cartelera getCartelera() {
        return cartelera;
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public SistemaUsuarios getSistemaUsuarios() {
        return sistemaUsuarios;
    }
}