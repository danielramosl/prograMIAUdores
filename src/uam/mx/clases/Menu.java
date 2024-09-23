/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Laura
 */
public class Menu {
    private ArrayList<Comida> listaComidas;

    public Menu() throws IOException {
        listaComidas = new ArrayList<>();
        leerComidas();
    }
    
    
    private void leerComidas() throws FileNotFoundException, IOException {
        listaComidas.clear();
        FileReader fr = new FileReader("src/uam/mx/datos/comidas.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, "|");
            int id = Integer.parseInt(st.nextToken());
            String nombre = st.nextToken();
            int precio = Integer.parseInt(st.nextToken());
            int inventario = Integer.parseInt(st.nextToken());
            String imagen = st.nextToken().replace("\"", "");
            String portada = st.nextToken().replace("\"", "");
            Comida c = new Comida(id, nombre, precio, inventario, imagen, portada);
            listaComidas.add(c);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    public ArrayList<Comida> getListaComidas() {
        return listaComidas;
    }
}
