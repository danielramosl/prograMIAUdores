/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.mx.interfaces;

import java.awt.Color;
import java.awt.Dialog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uam.mx.clases.Empleado;

/**
 *
 * @author Laura
 */
public final class GestionarEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form GestionarEmpleado
     */
    public GestionarEmpleados() {
        initComponents();
        LlenarEmpleados();
        LlenarRoles();
        rbtn_RegistrarCliente.setEnabled(false);
        rbtn_VentaBoletos.setEnabled(false);
        rbtn_VentaComida.setEnabled(false);
    }
    
    public void LlenarEmpleados() {
        cmb_Empleado.removeAllItems();
        ArrayList<Empleado> al = InicioSesión.cine.getSistemaUsuarios().getListaEmpleados();
        cmb_Empleado.addItem("-Seleccionar-");
        for(Empleado e : al) {
            if(e.getTipoEmpleado() == 0) {
                continue;
            }
            cmb_Empleado.addItem(InicioSesión.cine.getSistemaUsuarios().buscarUsuarioID(e.getId_usuario()).getUsuario());
        }
    }
    
    public void LlenarRoles() {
        cmb_Roles.removeAllItems();
        cmb_Roles.addItem("-Seleccionar-");
        cmb_Roles.addItem("Empleado de Taquilla");
        cmb_Roles.addItem("Empleado de Dulcería");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_EliminarEmpleado = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lbl_TituloEliminar = new javax.swing.JLabel();
        lbl_EliminarPregunta = new javax.swing.JLabel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmb_Empleado = new javax.swing.JComboBox<>();
        loguito = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_EliminarEmpleado = new javax.swing.JButton();
        lbl_Seleccionar = new javax.swing.JLabel();
        lbl_Titulo = new javax.swing.JLabel();
        btn_Regresar = new javax.swing.JButton();
        btn_ModificarEmpleado1 = new javax.swing.JButton();
        txt_Nombre = new javax.swing.JTextField();
        lbl_IdEmpleado = new javax.swing.JLabel();
        lbl_Rol = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Permisos = new javax.swing.JLabel();
        rbtn_VentaBoletos = new javax.swing.JRadioButton();
        rbtn_VentaComida = new javax.swing.JRadioButton();
        rbtn_RegistrarCliente = new javax.swing.JRadioButton();
        cmb_Roles = new javax.swing.JComboBox<>();
        lbl_Mensaje = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbl_TituloEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TituloEliminar.setText("Eliminar empleado");

        lbl_EliminarPregunta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_EliminarPregunta.setText("¿Deseas eliminar el empleado seleccionado?");

        btn_Cancelar.setBackground(new java.awt.Color(143, 29, 32));
        btn_Cancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("Eliminar");
        btn_Cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Cancelar.setBorderPainted(false);

        btn_Eliminar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Eliminar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Eliminar.setText("Cancelar");
        btn_Eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Eliminar.setBorderPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_EliminarPregunta)
                    .addComponent(lbl_TituloEliminar))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_TituloEliminar)
                .addGap(18, 18, 18)
                .addComponent(lbl_EliminarPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout dlg_EliminarEmpleadoLayout = new javax.swing.GroupLayout(dlg_EliminarEmpleado.getContentPane());
        dlg_EliminarEmpleado.getContentPane().setLayout(dlg_EliminarEmpleadoLayout);
        dlg_EliminarEmpleadoLayout.setHorizontalGroup(
            dlg_EliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlg_EliminarEmpleadoLayout.setVerticalGroup(
            dlg_EliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmb_Empleado.setBackground(java.awt.SystemColor.control);
        cmb_Empleado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Empleado.setToolTipText("");
        cmb_Empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmb_Empleado.setFocusable(false);
        cmb_Empleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_EmpleadoItemStateChanged(evt);
            }
        });

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uam/mx/interfaces/imagenes/loguito.png"))); // NOI18N

        lbl_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbl_Usuario.setText("Administrador");

        btn_EliminarEmpleado.setBackground(new java.awt.Color(143, 29, 32));
        btn_EliminarEmpleado.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_EliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btn_EliminarEmpleado.setText("Eliminar empleado");
        btn_EliminarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_EliminarEmpleado.setBorderPainted(false);
        btn_EliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarEmpleadoActionPerformed(evt);
            }
        });

        lbl_Seleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Seleccionar.setForeground(new java.awt.Color(57, 105, 138));
        lbl_Seleccionar.setText("Seleccionar empleado");

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_Titulo.setText("GESTIONAR EMPLEADOS");

        btn_Regresar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Regresar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Regresar.setText("Regresar");
        btn_Regresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Regresar.setBorderPainted(false);
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });

        btn_ModificarEmpleado1.setBackground(new java.awt.Color(57, 105, 138));
        btn_ModificarEmpleado1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_ModificarEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        btn_ModificarEmpleado1.setText("Modificar empleado");
        btn_ModificarEmpleado1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ModificarEmpleado1.setBorderPainted(false);
        btn_ModificarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarEmpleado1ActionPerformed(evt);
            }
        });

        txt_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_IdEmpleado.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbl_IdEmpleado.setText("user_empleado");

        lbl_Rol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Rol.setText("Rol:");

        lbl_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Nombre.setText("Nombre:");

        lbl_Permisos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Permisos.setText("Permisos:");

        rbtn_VentaBoletos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtn_VentaBoletos.setText("Venta de boletos");

        rbtn_VentaComida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtn_VentaComida.setText("Venta de comida");

        rbtn_RegistrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtn_RegistrarCliente.setText("Registrar cliente");

        cmb_Roles.setBackground(java.awt.SystemColor.control);
        cmb_Roles.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Roles.setToolTipText("");
        cmb_Roles.setBorder(null);
        cmb_Roles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_RolesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_Seleccionar)
                .addGap(345, 345, 345))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loguito)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(lbl_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_IdEmpleado)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_Permisos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbtn_RegistrarCliente)
                                        .addComponent(cmb_Roles, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbtn_VentaBoletos)
                                        .addComponent(rbtn_VentaComida)))))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Mensaje)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_ModificarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_EliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmb_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(loguito)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Usuario)
                        .addGap(41, 41, 41)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Titulo)
                .addGap(18, 18, 18)
                .addComponent(lbl_Seleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_IdEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Nombre))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Roles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Rol))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Permisos)
                    .addComponent(rbtn_VentaBoletos))
                .addGap(18, 18, 18)
                .addComponent(rbtn_VentaComida)
                .addGap(18, 18, 18)
                .addComponent(rbtn_RegistrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_EliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ModificarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Mensaje)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarEmpleadoActionPerformed
        dlg_EliminarEmpleado.setSize(400, 215);
        dlg_EliminarEmpleado.setLocationRelativeTo(this);
        dlg_EliminarEmpleado.setVisible(true);
    }//GEN-LAST:event_btn_EliminarEmpleadoActionPerformed

    private void cmb_EmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_EmpleadoItemStateChanged
        // TODO add your handling code here:
        if(cmb_Empleado.getSelectedIndex() == 0) {
            lbl_IdEmpleado.setText("user_empleado");
            txt_Nombre.setText("");
            cmb_Roles.removeAllItems();
            rbtn_VentaBoletos.setSelected(false);
            rbtn_VentaComida.setSelected(false);
            rbtn_RegistrarCliente.setSelected(false);
            txt_Nombre.setEditable(false);
            txt_Nombre.setCaretColor(Color.white);
        } else if(cmb_Empleado.getSelectedIndex() > 0) {
            LlenarRoles();
            txt_Nombre.setEditable(true);
            txt_Nombre.setCaretColor(Color.black);
            Empleado e = InicioSesión.cine.getSistemaUsuarios().getEmpleadoLista(cmb_Empleado.getSelectedIndex());
            lbl_IdEmpleado.setText(InicioSesión.cine.getSistemaUsuarios().buscarUsuarioID(e.getId_usuario()).getUsuario());
            txt_Nombre.setText(e.getNombre());
            cmb_Roles.setSelectedIndex(e.getTipoEmpleado());
            if(e.getTipoEmpleado() == 1) {
                rbtn_VentaBoletos.setSelected(true);
                rbtn_VentaComida.setSelected(false);
                rbtn_RegistrarCliente.setSelected(true);
            } else if(e.getTipoEmpleado() == 2) {
                rbtn_VentaBoletos.setSelected(false);
                rbtn_VentaComida.setSelected(true);
                rbtn_RegistrarCliente.setSelected(false);
            }
        }
    }//GEN-LAST:event_cmb_EmpleadoItemStateChanged

    private void btn_ModificarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarEmpleado1ActionPerformed
        try {
            // TODO add your handling code here:
            Empleado e = InicioSesión.cine.getSistemaUsuarios().getEmpleadoLista(cmb_Empleado.getSelectedIndex());
            e.setNombre(txt_Nombre.getText());
            e.setTipoEmpleado(cmb_Roles.getSelectedIndex());
            InicioSesión.cine.getSistemaUsuarios().actualizarEmpleado(cmb_Empleado.getSelectedIndex(), e);
            lbl_Mensaje.setText("El empleado se modificó correctamente");
        } catch (IOException ex) {
            Logger.getLogger(GestionarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ModificarEmpleado1ActionPerformed

    private void cmb_RolesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_RolesItemStateChanged
        // TODO add your handling code here:
        if(cmb_Roles.getSelectedIndex() < 1) {
            rbtn_VentaBoletos.setSelected(false);
            rbtn_VentaComida.setSelected(false);
            rbtn_RegistrarCliente.setSelected(false);
        } else if(cmb_Roles.getSelectedIndex() == 1) {
            rbtn_VentaBoletos.setSelected(true);
            rbtn_VentaComida.setSelected(false);
            rbtn_RegistrarCliente.setSelected(true);
        } else if(cmb_Roles.getSelectedIndex() == 2) {
            rbtn_VentaBoletos.setSelected(false);
            rbtn_VentaComida.setSelected(true);
            rbtn_RegistrarCliente.setSelected(false);
        }
    }//GEN-LAST:event_cmb_RolesItemStateChanged

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        this.dispose();
        InicioAdministrador ia = new InicioAdministrador();
        ia.setVisible(true);
    }//GEN-LAST:event_btn_RegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_EliminarEmpleado;
    private javax.swing.JButton btn_ModificarEmpleado1;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JComboBox<String> cmb_Empleado;
    private javax.swing.JComboBox<String> cmb_Roles;
    private javax.swing.JDialog dlg_EliminarEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_EliminarPregunta;
    private javax.swing.JLabel lbl_IdEmpleado;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Permisos;
    private javax.swing.JLabel lbl_Rol;
    private javax.swing.JLabel lbl_Seleccionar;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_TituloEliminar;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel loguito;
    private javax.swing.JRadioButton rbtn_RegistrarCliente;
    private javax.swing.JRadioButton rbtn_VentaBoletos;
    private javax.swing.JRadioButton rbtn_VentaComida;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables
}
