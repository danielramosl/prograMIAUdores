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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author PrograMIAUdores
 */
public class Cartelera {
    private ArrayList<Función> listaFunciones;
    private ArrayList<Película> listaPelículas;
    private LocalDateTime ldt;

    public Cartelera() throws IOException {
        ldt = LocalDateTime.now();
        listaFunciones = new ArrayList<>();
        leerFunciones();
        listaPelículas = new ArrayList<>();
        leerPelículas();
    }
    
    public Boolean horarioFunciónDisponible(int id_sala, LocalDate fecha, LocalTime horario) {
        for(Función f : listaFunciones) {
            if(f.getSala().getID() == id_sala && fecha.equals(f.getFecha()) && horario.equals(f.getHorario())) {
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
            LocalDate fecha = LocalDate.parse(st.nextToken());
            LocalTime horario = LocalTime.parse(st.nextToken());
            int formato = Integer.parseInt(st.nextToken());
            int id_sala = Integer.parseInt(st.nextToken());
            Sala sala = new Sala(id_sala,st.nextToken());
            Función f = new Función(id, id_película, fecha, horario, formato, sala);
            if(ldt.isBefore(LocalDateTime.of(f.getFecha(), f.getHorario()))) {
                listaFunciones.add(f);
            }
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
            Película p = new Película(id, nombre, descripción, duración, clasificación, portada, portada2);
            listaPelículas.add(p);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    private int nuevoIDFunción() {
        if(listaFunciones.isEmpty()) {
            return 0;
        }
        return listaFunciones.getLast().getId() + 1;
    }
    
    private String salaVacía() {
        String s = "";
        for(int i = 0; i < 25; ++i) {
            s += '0';
        }
        return s;
    }
    
    public void nuevaFunción(int id_película, LocalDate fecha, LocalTime horario, int formato, int id_sala) throws IOException {
        Sala s = new Sala(id_sala, salaVacía());
        Función f = new Función(nuevoIDFunción(), id_película, fecha, horario, formato, s);
        listaFunciones.add(f);
        FileWriter fw = new FileWriter("src/uam/mx/datos/funciones.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Función fn : listaFunciones) {
            nueva += fn.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public ArrayList<Película> getListaPelículas() {
        return listaPelículas;
    }
    
    public ArrayList<Función> getListaFunciones(){
        return listaFunciones;
    }
    
    public String formato(int i) {
        if(i == 0) {
            return "2D";
        } else {
            return "3D";
        }
    }
    
    public void actualizarSala(Función f) throws IOException {
        int index = 0;
        for(int i = 0; i < listaFunciones.size(); ++i) {
            if(f.getId() == listaFunciones.get(i).getId()) {
                index = i;
                break;
            }
        }
        listaFunciones.remove(index);
        listaFunciones.add(f);
        FileWriter fw = new FileWriter("src/uam/mx/datos/funciones.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Función fn : listaFunciones) {
            nueva += fn.toString();
        }
        bw.write(nueva);
        bw.close();
    }
}
