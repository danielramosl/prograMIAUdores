/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.mx.interfaces;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.mx.clases.Función;
import uam.mx.clases.Película;

/**
 *
 * @author Laura
 */
public class GestionarCartelera extends javax.swing.JFrame {

    /**
     * Creates new form GestionarCartelera
     */
    public GestionarCartelera() {
        initComponents();
        llenarPelícula();
        llenarSala();
        llenarFecha();
        cmb_Horario.removeAllItems();
        cmb_Horario.addItem("-Seleccionar-");
        llenarFormato();
    }
    
    public void llenarPelícula() {
        cmb_Pelicula.removeAllItems();
        ArrayList<Película> al = InicioSesión.cine.getListaPelículas();
        cmb_Pelicula.addItem("-Seleccionar-");
        for(Película p : al) {
            cmb_Pelicula.addItem(p.getNombre());
        }
    }
    
    public void llenarSala() {
        cmb_Sala.removeAllItems();
        cmb_Sala.addItem("-Seleccionar-");
        for(int i = 0; i < 5; ++i) {
            cmb_Sala.addItem("Sala " + (i + 1));
        }
    }
    
    public void llenarFecha() {
        cmb_Fecha.removeAllItems();
        cmb_Fecha.addItem("-Seleccionar-");
        LocalDate ld = LocalDate.now();
        ld = ld.minusDays(1);
        for(int i = 0; i < 5; ++i) {
            ld = ld.plusDays(1);
            cmb_Fecha.addItem(ld.toString());
        }
    }
    
    public void llenarHorario() {
        cmb_Horario.removeAllItems();
        cmb_Horario.addItem("-Seleccionar-");
        LocalTime lt = LocalTime.of(7,0,0);
        LocalDate ld = LocalDate.parse((String)cmb_Fecha.getSelectedItem());
        for(int i = 0; i < 5; ++i) {
            lt = lt.plusHours(3);
            LocalDateTime ldt = LocalDateTime.of(ld, lt);
            if(ldt.isAfter(LocalDateTime.now())) {
                if(InicioSesión.cine.horarioFunciónDisponible(cmb_Sala.getSelectedIndex() - 1, ld, lt) == true) {
                    cmb_Horario.addItem(lt.toString());
                }
            }
        }
    }
    
    public void llenarFormato() {
        cmb_Formato.removeAllItems();
        cmb_Formato.addItem("-Seleccionar-");
        cmb_Formato.addItem("2D");
        cmb_Formato.addItem("3D");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        loguito = new javax.swing.JLabel();
        btn_Regresar = new javax.swing.JButton();
        lbl_Usuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_SeleccionarPelicula = new javax.swing.JLabel();
        cmb_Pelicula = new javax.swing.JComboBox<>();
        lbl_SeleccionarFormato = new javax.swing.JLabel();
        cmb_Sala = new javax.swing.JComboBox<>();
        lbl_SeleccionarSala = new javax.swing.JLabel();
        cmb_Horario = new javax.swing.JComboBox<>();
        lbl_Horario = new javax.swing.JLabel();
        cmb_Fecha = new javax.swing.JComboBox<>();
        btn_Agregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_Portada = new javax.swing.JLabel();
        lbl_TituloPelicula = new javax.swing.JLabel();
        lbl_DescripcionPelicula = new javax.swing.JLabel();
        lbl_ClasificacionPelicula = new javax.swing.JLabel();
        lbl_DuraciónPelícula = new javax.swing.JLabel();
        cmb_Formato = new javax.swing.JComboBox<>();
        lbl_SeleccionarFormato1 = new javax.swing.JLabel();
        lbl_Mensaje = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uam/mx/interfaces/imágenes/loguito.png"))); // NOI18N

        btn_Regresar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Regresar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Regresar.setText("Regresar");
        btn_Regresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Regresar.setBorderPainted(false);

        lbl_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbl_Usuario.setText("Administrador");

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_Titulo.setText("NUEVA FUNCIÓN");

        lbl_SeleccionarPelicula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_SeleccionarPelicula.setText("Seleccionar película:");

        cmb_Pelicula.setBackground(java.awt.SystemColor.control);
        cmb_Pelicula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Pelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Pelicula.setToolTipText("");
        cmb_Pelicula.setBorder(null);
        cmb_Pelicula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_PeliculaItemStateChanged(evt);
            }
        });
        cmb_Pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_PeliculaActionPerformed(evt);
            }
        });

        lbl_SeleccionarFormato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_SeleccionarFormato.setText("Horario");

        cmb_Sala.setBackground(java.awt.SystemColor.control);
        cmb_Sala.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Sala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Sala.setBorder(null);
        cmb_Sala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_SalaItemStateChanged(evt);
            }
        });

        lbl_SeleccionarSala.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_SeleccionarSala.setText("Seleccionar sala:");

        cmb_Horario.setBackground(java.awt.SystemColor.control);
        cmb_Horario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Horario.setBorder(null);
        cmb_Horario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_HorarioItemStateChanged(evt);
            }
        });

        lbl_Horario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Horario.setText("Fecha");

        cmb_Fecha.setBackground(java.awt.SystemColor.control);
        cmb_Fecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Fecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Fecha.setBorder(null);
        cmb_Fecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_FechaItemStateChanged(evt);
            }
        });

        btn_Agregar.setBackground(new java.awt.Color(57, 105, 138));
        btn_Agregar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Agregar.setText("Agregar");
        btn_Agregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Agregar.setBorderPainted(false);
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(57, 105, 138));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_TituloPelicula.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbl_TituloPelicula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TituloPelicula.setText("Título");

        lbl_DescripcionPelicula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_DescripcionPelicula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DescripcionPelicula.setText("Descripción");
        lbl_DescripcionPelicula.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_ClasificacionPelicula.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbl_ClasificacionPelicula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ClasificacionPelicula.setText("Clasificación");

        lbl_DuraciónPelícula.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbl_DuraciónPelícula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DuraciónPelícula.setText("Duración");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Portada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_DescripcionPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbl_TituloPelicula))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_DuraciónPelícula)
                                    .addComponent(lbl_ClasificacionPelicula))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Portada, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_TituloPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_DescripcionPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ClasificacionPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_DuraciónPelícula)
                .addContainerGap())
        );

        cmb_Formato.setBackground(java.awt.SystemColor.control);
        cmb_Formato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Formato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Formato.setBorder(null);

        lbl_SeleccionarFormato1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_SeleccionarFormato1.setText("Seleccionar formato:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loguito)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Mensaje)
                        .addGap(383, 383, 383)
                        .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_SeleccionarFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmb_Horario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmb_Fecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_SeleccionarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmb_Sala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_SeleccionarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmb_Pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_SeleccionarFormato1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmb_Formato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(lbl_Titulo)))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lbl_Titulo)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_SeleccionarPelicula)
                            .addComponent(cmb_Pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_Sala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SeleccionarSala))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Horario))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_SeleccionarFormato)
                            .addComponent(cmb_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_SeleccionarFormato1)
                            .addComponent(cmb_Formato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Mensaje))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_PeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_PeliculaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_PeliculaActionPerformed

    private void cmb_PeliculaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_PeliculaItemStateChanged
        // TODO add your handling code here:
        if(cmb_Pelicula.getSelectedIndex() > 0) {
            int id = cmb_Pelicula.getSelectedIndex() - 1;
            Película p = InicioSesión.cine.getListaPelículas().get(id);
            lbl_TituloPelicula.setText(p.getNombre());
            lbl_DescripcionPelicula.setText("<html>" + p.getDescripción() + "</html>");
            lbl_ClasificacionPelicula.setText(p.getClasificación());
            lbl_DuraciónPelícula.setText(Integer.toString(p.getDuración()) + "min");
            lbl_Portada.setIcon(new javax.swing.ImageIcon(getClass().getResource(p.getPortada())));
        }
    }//GEN-LAST:event_cmb_PeliculaItemStateChanged

    private void cmb_SalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_SalaItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_SalaItemStateChanged

    private void cmb_FechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_FechaItemStateChanged
        // TODO add your handling code here:
        if(cmb_Fecha.getSelectedIndex() > 0) {
            llenarHorario();
        }
    }//GEN-LAST:event_cmb_FechaItemStateChanged

    private void cmb_HorarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_HorarioItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_HorarioItemStateChanged

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        // TODO add your handling code here:
        int id = InicioSesión.cine.nuevoIdFunción();
        int id_película = cmb_Pelicula.getSelectedIndex() - 1;
        int id_sala = cmb_Sala.getSelectedIndex() - 1;
        LocalDate fecha = LocalDate.parse((String)cmb_Fecha.getSelectedItem());
        LocalTime horario = LocalTime.parse((String)cmb_Horario.getSelectedItem());
        int formato = cmb_Formato.getSelectedIndex();
        Función f = new Función(id, id_película, id_sala, fecha, horario, formato);
        try {
            InicioSesión.cine.nuevaFunción(f);
        } catch (IOException ex) {
            Logger.getLogger(GestionarCartelera.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_Mensaje.setText("La función se agregó con éxito");
    }//GEN-LAST:event_btn_AgregarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarCartelera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JComboBox<String> cmb_Fecha;
    private javax.swing.JComboBox<String> cmb_Formato;
    private javax.swing.JComboBox<String> cmb_Horario;
    private javax.swing.JComboBox<String> cmb_Pelicula;
    private javax.swing.JComboBox<String> cmb_Sala;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_ClasificacionPelicula;
    private javax.swing.JLabel lbl_DescripcionPelicula;
    private javax.swing.JLabel lbl_DuraciónPelícula;
    private javax.swing.JLabel lbl_Horario;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Portada;
    private javax.swing.JLabel lbl_SeleccionarFormato;
    private javax.swing.JLabel lbl_SeleccionarFormato1;
    private javax.swing.JLabel lbl_SeleccionarPelicula;
    private javax.swing.JLabel lbl_SeleccionarSala;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_TituloPelicula;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel loguito;
    // End of variables declaration//GEN-END:variables
}
