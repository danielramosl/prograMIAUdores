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
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author PrograMIAUdores
 */
public class Cartelera {
    private ArrayList<Funcion> listaFunciones;
    private ArrayList<Pelicula> listaPelículas;
    private LocalDate fecha;

    public Cartelera() throws IOException {
        listaFunciones = new ArrayList<>();
        leerFunciones();
        listaPelículas = new ArrayList<>();
        leerPelículas();
        fecha = LocalDate.now();
    }
    
    public Boolean horarioFunciónDisponible(int id_sala, LocalDate fecha, LocalTime horario) {
        for(Funcion f : listaFunciones) {
            if(f.getId_sala() == id_sala && fecha.equals(f.getFecha()) && horario.equals(f.getHorario())) {
                return false;
            }
        }
        return true;
    }
    
    private void leerFunciones() throws FileNotFoundException, IOException {
        listaFunciones.clear();
        FileReader fr = new FileReader("src/uam/mx/datos/funciones.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            int id_película = Integer.parseInt(st.nextToken());
            int id_sala = Integer.parseInt(st.nextToken());
            LocalDate fecha = LocalDate.parse(st.nextToken());
            LocalTime horario = LocalTime.parse(st.nextToken());
            int formato = Integer.parseInt(st.nextToken());
            Funcion f = new Funcion(id, id_película, id_sala, fecha, horario, formato);
            listaFunciones.add(f);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    private void leerPelículas() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("src/uam/mx/datos/películas.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, "|");
            int id = Integer.parseInt(st.nextToken());
            String nombre = st.nextToken();
            String descripción = st.nextToken();
            int duración = Integer.parseInt(st.nextToken());
            String clasificación = st.nextToken();
            String portada = st.nextToken().replace("\"", "");
            String portada2 = st.nextToken().replace("\"", "");
            Pelicula p = new Pelicula(id, nombre, descripción, duración, clasificación, portada, portada2);
            listaPelículas.add(p);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    public int nuevoIdFunción() {
        if(listaFunciones.isEmpty()) {
            return 0;
        }
        return listaFunciones.getLast().getId() + 1;
    }
    
    public void nuevaFunción(Funcion f) throws IOException {
        listaFunciones.add(f);
        FileWriter fw = new FileWriter("src/uam/mx/datos/funciones.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Funcion fn : listaFunciones) {
            nueva += fn.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public ArrayList<Pelicula> getListaPelículas() {
        return listaPelículas;
    }
    
    public ArrayList<Funcion> getListaFunciones(){
        return listaFunciones;
    }
 
}
