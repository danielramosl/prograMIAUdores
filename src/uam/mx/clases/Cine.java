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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author prograMIAUdores
 */
public class Cine {
    private String nombre;
    private String dirección;
    private CajaBoleto cajaBoleto;
    private CajaComida cajaComida;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Película> listaPelículas;
    private ArrayList<Función> listaFunciones;
    private Cartelera cartelera;
    private ArrayList<Comida> listaComida;
    private ArrayList<Sala> listaSalas;

    public Cine() throws IOException {
        nombre = "PrograMIAUdores";
        dirección = "MICHIgan";
        listaUsuarios = leerUsuarios();
        listaEmpleados = leerEmpleados();
        listaClientes = leerClientes();
    }
    
    private ArrayList<Usuario> leerUsuarios() throws FileNotFoundException, IOException {
        ArrayList<Usuario> al = new ArrayList<>();
        FileReader fr;
        fr = new FileReader("src/uam/mx/datos/usuarios.dat");
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
        FileReader fr;
        fr = new FileReader("src/uam/mx/datos/empleados.dat");
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
        FileReader fr;
        fr = new FileReader("src/uam/mx/datos/clientes.dat");
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
}