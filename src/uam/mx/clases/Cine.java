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
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Película> listaPelículas;
    private ArrayList<Función> listaFunciones;
    private Cartelera cartelera;
    private ArrayList<Comida> listaComida;
    private ArrayList<Sala> listaSalas;

    public Cine() throws IOException {
        nombre_cine = "PrograMIAUdores";
        dirección = "MICHIgan";
        listaUsuarios = leerUsuarios();
        listaEmpleados = leerEmpleados();
        listaClientes = leerClientes();
        listaPelículas = leerPelículas();
        listaFunciones = leerFunciones();
    }
    
    public Boolean horarioFunciónDisponible(int id_sala, LocalDate fecha, LocalTime horario) {
        for(Función f : listaFunciones) {
            if(f.getId_sala() == id_sala && fecha.equals(f.getFecha()) && horario.equals(f.getHorario())) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<Función> leerFunciones() throws FileNotFoundException, IOException {
        ArrayList<Función> al = new ArrayList<>();
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
            Función f = new Función(id, id_película, id_sala, fecha, horario, formato);
            al.add(f);
            s = br.readLine();
        }
        br.close();
        fr.close();
        return al;
    }
    
    private ArrayList<Película> leerPelículas() throws FileNotFoundException, IOException {
        ArrayList<Película> al = new ArrayList<>();
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
            Película p = new Película(id, nombre, descripción, duración, clasificación, portada);
            al.add(p);
            s = br.readLine();
        }
        br.close();
        fr.close();
        return al;
    }
    
    private ArrayList<Usuario> leerUsuarios() throws FileNotFoundException, IOException {
        ArrayList<Usuario> al = new ArrayList<>();
        FileReader fr = new FileReader("src/uam/mx/datos/usuarios.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            String usuario = st.nextToken();
            String contraseña = st.nextToken();
            Usuario u = new Usuario(id, usuario, contraseña);
            al.add(u);
            s = br.readLine();
        }
        br.close();
        fr.close();
        return al;
    }
    
    private ArrayList<Empleado> leerEmpleados() throws FileNotFoundException, IOException {
        ArrayList<Empleado> al = new ArrayList<>();
        FileReader fr = new FileReader("src/uam/mx/datos/empleados.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            int id_usuario = Integer.parseInt(st.nextToken());
            String nombreEmpleado = st.nextToken();
            int tipo = Integer.parseInt(st.nextToken());
            Empleado e = new Empleado(id, id_usuario, nombreEmpleado, tipo);
            al.add(e);
            s = br.readLine();
        }
        br.close();
        fr.close();
        return al;
    }
    
    private ArrayList<Cliente> leerClientes() throws FileNotFoundException, IOException {
        ArrayList<Cliente> al = new ArrayList<>();
        FileReader fr = new FileReader("src/uam/mx/datos/clientes.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            int id_usuario = Integer.parseInt(st.nextToken());
            String nombreCliente = st.nextToken();
            LocalDate fechaNacimiento = LocalDate.parse(st.nextToken());
            String correo = st.nextToken();
            int puntos = Integer.parseInt(st.nextToken());
            Cliente c = new Cliente(id, id_usuario, nombreCliente, fechaNacimiento, correo , puntos);
            al.add(c);
            s = br.readLine();
        }
        br.close();
        fr.close();
        return al;
    }
    
    public Usuario buscarUsuario(String usuario, String contraseña) {
        for(Usuario u : listaUsuarios) {
            if(u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return u;
            }
        }
        return null;
    }
    
    public Empleado buscarEmpleado(Usuario u) {
        for(Empleado e : listaEmpleados) {
            if(e.getId_usuario() == u.getId()) {
                return e;
            }
        }
        return null;
    }
    
    public Cliente buscarCliente(Usuario u) {
        for(Cliente c : listaClientes) {
            if(c.getId_usuario() == u.getId()) {
                return c;
            }
        }
        return null;
    }
    
    public int buscarUsuarioID(Usuario u) {
        for(int i = 0; i < listaUsuarios.size(); ++i) {
            if(listaUsuarios.get(i).getId() == u.getId()) {
                return i;
            }
        }
        return -1;
    }
    
    public void actualizarUsuario(int i, Usuario u) throws IOException {
        listaUsuarios.set(i, u);
        FileWriter fw = new FileWriter("src/uam/mx/datos/usuarios.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Usuario us : listaUsuarios) {
            nueva += us.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public int nuevoIdFunción() {
        if(listaFunciones.isEmpty()) {
            return 0;
        }
        return listaFunciones.getLast().getId() + 1;
    }
    
    public void nuevaFunción(Función f) throws IOException {
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
}