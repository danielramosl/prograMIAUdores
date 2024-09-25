/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.mx.interfaces;

import java.awt.Component;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import uam.mx.clases.Función;
import uam.mx.clases.Película;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Laura
 */
public class Cartelera extends javax.swing.JFrame {

    /**
     * Creates new form Cartelera
     */
    
     private class ImageRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JLabel) {
                JLabel label = (JLabel) value;
                return label;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
     
    public void llenarTablaPorFecha() {
        Date selectedDate = jdc_Fecha.getDate();
        LocalDate fechaSeleccionada = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        DefaultTableModel modelo = new DefaultTableModel(new String[] {"Portada", "Título", "Duración", "Clasificación", "Sala", "Horario", "Formato"}, 0);
        ArrayList<Función> lista = InicioSesión.cine.getCartelera().getListaFunciones();
        ArrayList<Película> peliculas = InicioSesión.cine.getCartelera().getListaPelículas();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        try {
            
            for (Función funcion : lista){
                if (funcion.getFecha().equals(fechaSeleccionada)) {
                JLabel portada = new JLabel();
                int id_pelicula = funcion.getId_película();
                
                portada.setIcon(new javax.swing.ImageIcon(getClass().getResource(peliculas.get(id_pelicula).getPortada2())));
                
                    modelo.addRow(new Object[] { 
                        portada, 
                        peliculas.get(id_pelicula).getNombre(), 
                        peliculas.get(id_pelicula).getDuración(), 
                        peliculas.get(id_pelicula).getClasificación(), 
                        funcion.getSala().getID(), 
                        funcion.getHorario(), 
                        formatoToString(funcion.getFormato())
                    });
                }   
            }
            
            tbl_Cartelera.setModel(modelo);
            tbl_Cartelera.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            tbl_Cartelera.setRowHeight(100);
            
            tbl_Cartelera.getColumnModel().getColumn(0).setPreferredWidth(114 ); // Portada
            tbl_Cartelera.getColumnModel().getColumn(1).setPreferredWidth(240); // Título
            tbl_Cartelera.getColumnModel().getColumn(2).setPreferredWidth(80); // Duración
            tbl_Cartelera.getColumnModel().getColumn(3).setPreferredWidth(100); // Clasificación
            tbl_Cartelera.getColumnModel().getColumn(4).setPreferredWidth(70);  // Sala
            tbl_Cartelera.getColumnModel().getColumn(5).setPreferredWidth(70); // Horario
            tbl_Cartelera.getColumnModel().getColumn(6).setPreferredWidth(70); // Formato
            
            tbl_Cartelera.getTableHeader().setDefaultRenderer(centerRenderer); 
            
            for (int i = 1; i < tbl_Cartelera.getColumnCount(); i++) {
                tbl_Cartelera.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
            
        } catch (Exception ex) {
          System.err.println("Ha ocurrido un error" + ex.getMessage());
        }    
    }
      
        private String formatoToString(int formato) {
            return (formato == 1) ? "3D" : "2D";
        }
   
    
    public Cartelera() {
        initComponents();
        jdc_Fecha.setDate(new Date());
        llenarTablaPorFecha();
        jdc_Fecha.addPropertyChangeListener("date", evt -> llenarTablaPorFecha());
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
        btn_Cancelar = new javax.swing.JButton();
        loguito = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Titulo = new javax.swing.JLabel();
        jdc_Fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cartelera = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_Cancelar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Cancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("Regresar");
        btn_Cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Cancelar.setBorderPainted(false);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uam/mx/interfaces/imagenes/loguito.png"))); // NOI18N

        lbl_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbl_Usuario.setText("Vendedor de taquilla");

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_Titulo.setText("CARTELERA");

        jScrollPane1.setBackground(java.awt.SystemColor.control);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl_Cartelera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Cartelera);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loguito)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Titulo)
                        .addGap(378, 378, 378))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(59, 59, 59)
                .addComponent(lbl_Titulo)
                .addGap(43, 43, 43)
                .addComponent(jdc_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
       this.dispose();
       InicioVentaBoletos inicioVentaBoletos = new InicioVentaBoletos();
       inicioVentaBoletos.setVisible(true);
    }//GEN-LAST:event_btn_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cartelera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdc_Fecha;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel loguito;
    private javax.swing.JTable tbl_Cartelera;
    // End of variables declaration//GEN-END:variables
}
