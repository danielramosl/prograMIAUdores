/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.mx.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultCaret;
import uam.mx.clases.Cliente;
import uam.mx.clases.Usuario;

class BlankCaret extends DefaultCaret { @Override public void paint(Graphics g) {/* Paint no caret. */}}

/**
 *
 * @author Laura
 */
public class InicioCliente extends javax.swing.JFrame {

    /**
     * Creates new form InicioCliente
     */
    public InicioCliente() {
        initComponents();
        Usuario u = InicioSesión.usuarioActual;
        Cliente c = InicioSesión.cine.getSistemaUsuarios().buscarCliente(u);
        lbl_usuario.setText(u.getUsuario());
        lbl_totalPuntos.setText(Integer.toString(c.getPuntos()));
        txt_Nombre.setText(c.getNombre());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txt_FechaNacimiento.setText(c.getFechaNacimiento().format(dtf));
        txt_Correo.setText(c.getCorreo());
        txt_Contraseña.setText(u.getContraseña());
        txt_Nombre.setEditable(false);
        txt_Nombre.setCaretColor(Color.white);
        txt_FechaNacimiento.setEditable(false);
        txt_FechaNacimiento.setCaretColor(Color.white);
        txt_Correo.setEditable(false);
        txt_Correo.setCaretColor(Color.white);
        txt_Contraseña.setEditable(false);
        txt_Contraseña.setCaretColor(Color.white);
        lbl_NuevaContrasena.setVisible(false);
        txt_NuevaContrasena.setVisible(false);
        btn_Guardar.setVisible(false);
        btn_Cancelar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loguito = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_Puntos = new javax.swing.JLabel();
        lbl_totalPuntos = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_FechaNacimiento = new javax.swing.JLabel();
        lbl_Correo = new javax.swing.JLabel();
        lbl_Contrasena = new javax.swing.JLabel();
        txt_FechaNacimiento = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        txt_Contraseña = new javax.swing.JTextField();
        btn_Cancelar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        lbl_NuevaContrasena = new javax.swing.JLabel();
        txt_NuevaContrasena = new javax.swing.JTextField();
        btn_ModificarContrasena = new javax.swing.JButton();
        btn_CerrarSesion = new javax.swing.JButton();
        lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uam/mx/interfaces/imágenes/loguito.png"))); // NOI18N

        lbl_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbl_Usuario.setText("Cliente");

        lbl_usuario.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_usuario.setText("usuario");

        lbl_Puntos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_Puntos.setText("Puntos:");

        lbl_totalPuntos.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_totalPuntos.setText("totalPuntos");

        lbl_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Nombre.setText("Nombre:");

        lbl_FechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_FechaNacimiento.setText("Fecha de nacimiento:");

        lbl_Correo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Correo.setText("Correo: ");

        lbl_Contrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Contrasena.setText("Contraseña:");

        txt_FechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_FechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Correo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Correo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Contraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Contraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_Cancelar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Cancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Cancelar.setBorderPainted(false);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Guardar.setBackground(new java.awt.Color(57, 105, 138));
        btn_Guardar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Guardar.setText("Guardar");
        btn_Guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Guardar.setBorderPainted(false);
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });

        lbl_NuevaContrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_NuevaContrasena.setText("Nueva contraseña:");

        txt_NuevaContrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_NuevaContrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_ModificarContrasena.setBackground(new java.awt.Color(57, 105, 138));
        btn_ModificarContrasena.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_ModificarContrasena.setForeground(new java.awt.Color(255, 255, 255));
        btn_ModificarContrasena.setText("Modificar contraseña");
        btn_ModificarContrasena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ModificarContrasena.setBorderPainted(false);
        btn_ModificarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarContrasenaActionPerformed(evt);
            }
        });

        btn_CerrarSesion.setBackground(new java.awt.Color(102, 102, 102));
        btn_CerrarSesion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_CerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_CerrarSesion.setText("Cerrar sesión");
        btn_CerrarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_CerrarSesion.setBorderPainted(false);
        btn_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_NuevaContrasena)
                                    .addComponent(lbl_usuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lbl_Puntos)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_totalPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_NuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_ModificarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Mensaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loguito)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_CerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
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
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario)
                    .addComponent(lbl_totalPuntos)
                    .addComponent(lbl_Puntos))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nombre)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_FechaNacimiento)
                    .addComponent(txt_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Correo)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Contrasena)
                    .addComponent(txt_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ModificarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NuevaContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Mensaje))
                .addGap(34, 34, 34)
                .addComponent(btn_CerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarSesionActionPerformed
        try {
            // TODO add your handling code here:
            InicioSesión.usuarioActual = null;
            this.dispose();
            InicioSesión inicioSesión = new InicioSesión();
            inicioSesión.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(InicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_CerrarSesionActionPerformed

    private void btn_ModificarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarContrasenaActionPerformed
        // TODO add your handling code here:
        lbl_NuevaContrasena.setVisible(true);
        txt_NuevaContrasena.setVisible(true);
        btn_Guardar.setVisible(true);
        btn_Cancelar.setVisible(true);
        lbl_Mensaje.setText("");
    }//GEN-LAST:event_btn_ModificarContrasenaActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        // TODO add your handling code here:
        lbl_NuevaContrasena.setVisible(false);
        txt_NuevaContrasena.setVisible(false);
        btn_Guardar.setVisible(false);
        btn_Cancelar.setVisible(false);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
        // TODO add your handling code here:
        String nueva = txt_NuevaContrasena.getText();
        if(nueva.equals(InicioSesión.usuarioActual.getContraseña())) {
            lbl_Mensaje.setText("La contraseña no puede ser la misma que la anterior.");
        } else {
            lbl_Mensaje.setText("La contraseña se ha guardado correctamente.");
            InicioSesión.usuarioActual.setContraseña(nueva);
            int i = InicioSesión.cine.getSistemaUsuarios().buscarUsuarioID(InicioSesión.usuarioActual);
            try {
                InicioSesión.cine.getSistemaUsuarios().actualizarUsuario(i, InicioSesión.usuarioActual);
            } catch (IOException ex) {
                Logger.getLogger(InicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            lbl_NuevaContrasena.setVisible(false);
            txt_NuevaContrasena.setVisible(false);
            btn_Guardar.setVisible(false);
            btn_Cancelar.setVisible(false);
            txt_Contraseña.setText(InicioSesión.usuarioActual.getContraseña());
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(InicioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new InicioCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_CerrarSesion;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_ModificarContrasena;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Contrasena;
    private javax.swing.JLabel lbl_Correo;
    private javax.swing.JLabel lbl_FechaNacimiento;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_NuevaContrasena;
    private javax.swing.JLabel lbl_Puntos;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel lbl_totalPuntos;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel loguito;
    private javax.swing.JTextField txt_Contraseña;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_FechaNacimiento;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_NuevaContrasena;
    // End of variables declaration//GEN-END:variables
}
