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
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author prograMIAUdores
 */
public class SistemaUsuarios {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;

    public SistemaUsuarios() throws IOException {
        listaUsuarios = new ArrayList<>();
        leerUsuarios();
        listaEmpleados = new ArrayList<>();
        leerEmpleados();
        listaClientes = new ArrayList<>();
        leerClientes();
    }
    
    private void leerUsuarios() throws FileNotFoundException, IOException {
        listaUsuarios.clear();
        FileReader fr = new FileReader("src/uam/mx/datos/usuarios.dat");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int id = Integer.parseInt(st.nextToken());
            String usuario = st.nextToken();
            String contraseña = st.nextToken();
            Usuario u = new Usuario(id, usuario, contraseña);
            listaUsuarios.add(u);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    private void leerEmpleados() throws FileNotFoundException, IOException {
        listaEmpleados.clear();
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
            listaEmpleados.add(e);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    private void leerClientes() throws FileNotFoundException, IOException {
        listaClientes.clear();
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
            listaClientes.add(c);
            s = br.readLine();
        }
        br.close();
        fr.close();
    }
    
    public Usuario buscarUsuario(String usuario, String contraseña) {
        for(Usuario u : listaUsuarios) {
            if(u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return u;
            }
        }
        return null;
    }
    
    public int buscarIDUsuario(String s) {
        for(Usuario u : listaUsuarios) {
            if(u.getUsuario().equals(s)) {
                return u.getId();
            }
        }
        return -1;
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
    
    public Boolean usuarioExiste(String usuario) {
        for(Usuario u : listaUsuarios) {
            if(u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
    
    public int crearUsuario(String usuario, String contraseña) throws IOException {
        int i = nuevoUsuarioID();
        Usuario u = new Usuario(i, usuario, contraseña);
        listaUsuarios.add(u);
        FileWriter fw = new FileWriter("src/uam/mx/datos/usuarios.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Usuario us : listaUsuarios) {
            nueva += us.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
        return i;
    }
    
    public void crearCliente(int usuario_id, String nombre, LocalDate fechaNacimiento, String correo) throws IOException {
        int id = nuevoClienteID();
        Cliente c = new Cliente(id, usuario_id, nombre, fechaNacimiento, correo, 0);
        listaClientes.add(c);
        FileWriter fw = new FileWriter("src/uam/mx/datos/clientes.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Cliente cl : listaClientes) {
            nueva += cl.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    private int nuevoClienteID() {
        return listaClientes.getLast().getId() + 1;
    }
    
    private int nuevoUsuarioID() {
        return listaUsuarios.getLast().getId() + 1;
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
    
    public void actualizarCliente(Cliente c) throws IOException {
        int index = 0;
        for(int i = 0; i < listaClientes.size(); ++i) {
            if(c.getId() == listaClientes.get(i).getId()) {
                index = i;
                break;
            }
        }
        FileWriter fw = new FileWriter("src/uam/mx/datos/clientes.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Cliente cl : listaClientes) {
            nueva += cl.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public Usuario buscarUsuarioID(int id) {
        for(Usuario u : listaUsuarios) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public Empleado getEmpleadoLista(int index) {
        return listaEmpleados.get(index);
    }
    
    public void actualizarEmpleado(int i, Empleado e) throws IOException {
        listaEmpleados.set(i, e);
        FileWriter fw = new FileWriter("src/uam/mx/datos/empleados.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Empleado em : listaEmpleados) {
            nueva += em.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public void eliminarEmpleado(int i) throws IOException {
        eliminarUsuario(listaEmpleados.get(i).getId_usuario());
        listaEmpleados.remove(i);
        FileWriter fw = new FileWriter("src/uam/mx/datos/empleados.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Empleado em : listaEmpleados) {
            nueva += em.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
    
    public void eliminarUsuario(int id) throws IOException {
        for(int i = 0; i < listaUsuarios.size(); ++i) {
            if(listaUsuarios.get(i).getId() == id) {
                listaUsuarios.remove(i);
                break;
            }
        }
        FileWriter fw = new FileWriter("src/uam/mx/datos/usuarios.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        String nueva = "";
        for(Usuario u : listaUsuarios) {
            nueva += u.toString();
        }
        bw.write(nueva);
        bw.close();
        fw.close();
    }
}