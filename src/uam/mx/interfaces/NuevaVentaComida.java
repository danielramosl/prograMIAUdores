/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.mx.interfaces;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import uam.mx.clases.Comida;
import uam.mx.clases.LineaComida;

/**
 *
 * @author Laura
 */
public class NuevaVentaComida extends javax.swing.JFrame {

    /**
     * Creates new form NuevaVentaComida
     */
 DefaultTableModel modelo = new DefaultTableModel(new String[] {"ID", "ID Comida", "Comida", "Cantidad", "Costo", "Subtotal"}, 0);
    ArrayList<Comida> al = InicioSesión.cine.getMenu().getListaComidas();
    int index = 0;
    ArrayList<LineaComida> llc = new ArrayList<>();
    
    public NuevaVentaComida() {
        initComponents();
        llenarComida();
        crearTabla();
        llenarTipoPago();
        pagoEfectivo();
    }
    
    public void llenarComida() {
        cmb_Comida.removeAllItems();
        cmb_Comida.addItem("-Seleccionar-");
        for(Comida c : al) {
            cmb_Comida.addItem(c.getNombre());
        }
    }
    
    public void crearTabla(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        try {
            modelo.addRow(new Object[] { 
                null,
                null,
                null,
                null,
                null,
                null
            });
            
            tbl_Comida.setModel(modelo);
            tbl_Comida.setRowHeight(20);
            
            tbl_Comida.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
            tbl_Comida.getColumnModel().getColumn(1).setPreferredWidth(80); // ID_Comida
            tbl_Comida.getColumnModel().getColumn(2).setPreferredWidth(200); // Comida
            tbl_Comida.getColumnModel().getColumn(3).setPreferredWidth(80); // Cantidad
            tbl_Comida.getColumnModel().getColumn(4).setPreferredWidth(80); // Costo
            tbl_Comida.getColumnModel().getColumn(5).setPreferredWidth(80); // Subtotal
                    
            tbl_Comida.getTableHeader().setDefaultRenderer(centerRenderer); 
            
            for (int i = 1; i < tbl_Comida.getColumnCount(); i++) {
                tbl_Comida.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } 
        catch (Exception ex) {
             System.err.println("Ha ocurrido un error" + ex.getMessage());
        }
    
    }
    
    
    public void AgregarATabla(LineaComida lineaComida) {
        if (modelo.getValueAt(0, 0) == null) {
            modelo.removeRow(0);
        }
        try {
            Comida c = al.get(lineaComida.getId_comida());
            modelo.addRow(new Object[] { 
                lineaComida.getId(),
                lineaComida.getId_comida(),
                c.getNombre(),
                lineaComida.getCantidad(),
                c.getPrecio(),
                lineaComida.getSubtotal(c)
            });
            llc.add(lineaComida);
           ObtenerTotal();
        } 
        catch (Exception ex) {
             System.err.println("Ha ocurrido un error" + ex.getMessage());
        }
    }
    
    public void ObtenerTotal(){
        float total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            float subtotal = Float.parseFloat(modelo.getValueAt(i, 5).toString());
            total += subtotal;       
        }
        lbl_Total.setText(String.valueOf(total));
    }
    
    public int comidaEnTabla(LineaComida lc) {
    int res = -1;
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int idComidaEnTabla = Integer.parseInt(modelo.getValueAt(i, 1).toString());
        if (idComidaEnTabla == lc.getId_comida()) {
            res = i; 
            break;
        }
    }
        return res;
    }
    
    public void cambiarID(int id) {
        for (int i = id; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(id, i, 0);
            id++;
        }
        
    }
    public void llenarTipoPago() {
        cmb_TipoPago.removeAllItems();
        cmb_TipoPago.addItem("-Seleccionar-");
        cmb_TipoPago.addItem("Efectivo");
        cmb_TipoPago.addItem("Tarjeta");
    }
    
    public void pagoEfectivo(){
        txt_monto.addActionListener((ActionEvent e) -> {
            float cambio = Float.parseFloat(txt_monto.getText()) - Float.parseFloat(lbl_Total.getText());
            lbl_CambioDar.setText(String.valueOf(cambio));
        });
    }
    
    /*  public void ActualizarInventario(){
    for (int i = 0; i < modelo.getRowCount(); i++) {
    int pos = Integer.parseInt(modelo.getValueAt(i, 0).toString()); 
    int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
    al.get(pos).setInventario(al.get(pos).getInventario() - cantidad);
    }
    }*/


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_PagoTarjeta = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        lbl_PagoTarjeta = new javax.swing.JLabel();
        txt_NombreCompleto = new javax.swing.JTextField();
        lbl_TipoTarjeta = new javax.swing.JLabel();
        cmb_TipoTarjeta = new javax.swing.JComboBox<>();
        lbl_NumTarjeta = new javax.swing.JLabel();
        lbl_DatosTarjeta = new javax.swing.JLabel();
        lbl_NombreCompleto = new javax.swing.JLabel();
        txt_NumTarjeta = new javax.swing.JTextField();
        btn_Continuar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        dlg_MICHísimasGracias = new javax.swing.JDialog();
        jp_PagoTarjeta1 = new javax.swing.JPanel();
        lbl_PagoTarjeta1 = new javax.swing.JLabel();
        btn_Cerrar = new javax.swing.JButton();
        lbl_Username = new javax.swing.JLabel();
        dlg_PagoEfectivo = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        lbl_PagoEfectivo = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        lbl_Cambio = new javax.swing.JLabel();
        lbl_Monto = new javax.swing.JLabel();
        btn_ContinuarEf = new javax.swing.JButton();
        btn_CancelarEf = new javax.swing.JButton();
        lbl_TarjetaMensaje1 = new javax.swing.JLabel();
        lbl_CambioDar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loguito = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Cantidad = new javax.swing.JLabel();
        lbl_Comida = new javax.swing.JLabel();
        cmb_Comida = new javax.swing.JComboBox<>();
        lbl_TotalT = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_TipoPago = new javax.swing.JLabel();
        sp_Cantidad = new javax.swing.JSpinner();
        lbl_Titulo = new javax.swing.JLabel();
        cmb_TipoPago = new javax.swing.JComboBox<>();
        btn_Regresar = new javax.swing.JButton();
        btn_CompletarVenta = new javax.swing.JButton();
        jp_TablaComida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Comida = new javax.swing.JTable();
        jp_DatosComida = new javax.swing.JPanel();
        lbl_ComidaFoto = new javax.swing.JLabel();
        lbl_NombreComida = new javax.swing.JLabel();
        lbl_CostoComida = new javax.swing.JLabel();
        btn_Agregar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_PagoTarjeta.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_PagoTarjeta.setText("PAGO CON TARJETA");

        txt_NombreCompleto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_NombreCompleto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_TipoTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TipoTarjeta.setText("Tipo de tarjeta:");

        cmb_TipoTarjeta.setBackground(java.awt.SystemColor.control);
        cmb_TipoTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_TipoTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_TipoTarjeta.setToolTipText("");
        cmb_TipoTarjeta.setBorder(null);

        lbl_NumTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_NumTarjeta.setText("Número de la tarjeta:");

        lbl_DatosTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_DatosTarjeta.setText("Datos de la tarjeta:");

        lbl_NombreCompleto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_NombreCompleto.setText("Nombre completo:");

        txt_NumTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_NumTarjeta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_Continuar.setBackground(new java.awt.Color(57, 105, 138));
        btn_Continuar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Continuar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Continuar.setText("Continuar");
        btn_Continuar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Continuar.setBorderPainted(false);
        btn_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ContinuarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_PagoTarjeta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_NumTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_NombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NombreCompleto)
                            .addComponent(txt_NumTarjeta)))
                    .addComponent(lbl_DatosTarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_TipoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(cmb_TipoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_PagoTarjeta)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TipoTarjeta)
                    .addComponent(cmb_TipoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_DatosTarjeta)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NombreCompleto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NumTarjeta)
                    .addComponent(txt_NumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlg_PagoTarjetaLayout = new javax.swing.GroupLayout(dlg_PagoTarjeta.getContentPane());
        dlg_PagoTarjeta.getContentPane().setLayout(dlg_PagoTarjetaLayout);
        dlg_PagoTarjetaLayout.setHorizontalGroup(
            dlg_PagoTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlg_PagoTarjetaLayout.setVerticalGroup(
            dlg_PagoTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jp_PagoTarjeta1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_PagoTarjeta1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_PagoTarjeta1.setText("¡Compra exitosa! Felinamente feliz");

        btn_Cerrar.setBackground(new java.awt.Color(57, 105, 138));
        btn_Cerrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Cerrar.setBorderPainted(false);
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        lbl_Username.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N

        javax.swing.GroupLayout jp_PagoTarjeta1Layout = new javax.swing.GroupLayout(jp_PagoTarjeta1);
        jp_PagoTarjeta1.setLayout(jp_PagoTarjeta1Layout);
        jp_PagoTarjeta1Layout.setHorizontalGroup(
            jp_PagoTarjeta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_PagoTarjeta1Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jp_PagoTarjeta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Username)
                    .addComponent(lbl_PagoTarjeta1))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_PagoTarjeta1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jp_PagoTarjeta1Layout.setVerticalGroup(
            jp_PagoTarjeta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_PagoTarjeta1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lbl_Username)
                .addGap(31, 31, 31)
                .addComponent(lbl_PagoTarjeta1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlg_MICHísimasGraciasLayout = new javax.swing.GroupLayout(dlg_MICHísimasGracias.getContentPane());
        dlg_MICHísimasGracias.getContentPane().setLayout(dlg_MICHísimasGraciasLayout);
        dlg_MICHísimasGraciasLayout.setHorizontalGroup(
            dlg_MICHísimasGraciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_PagoTarjeta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlg_MICHísimasGraciasLayout.setVerticalGroup(
            dlg_MICHísimasGraciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_PagoTarjeta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbl_PagoEfectivo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_PagoEfectivo.setText("PAGO EN EFECTIVO");

        txt_monto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_monto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_Cambio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Cambio.setText("Cambio:");

        lbl_Monto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Monto.setText("Monto recibido:");

        btn_ContinuarEf.setBackground(new java.awt.Color(57, 105, 138));
        btn_ContinuarEf.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_ContinuarEf.setForeground(new java.awt.Color(255, 255, 255));
        btn_ContinuarEf.setText("Continuar");
        btn_ContinuarEf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ContinuarEf.setBorderPainted(false);
        btn_ContinuarEf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ContinuarEfActionPerformed(evt);
            }
        });

        btn_CancelarEf.setBackground(new java.awt.Color(102, 102, 102));
        btn_CancelarEf.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_CancelarEf.setForeground(new java.awt.Color(255, 255, 255));
        btn_CancelarEf.setText("Cancelar");
        btn_CancelarEf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_CancelarEf.setBorderPainted(false);
        btn_CancelarEf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarEfActionPerformed(evt);
            }
        });

        lbl_CambioDar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_CambioDar.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_PagoEfectivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_TarjetaMensaje1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(btn_CancelarEf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ContinuarEf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_Cambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Monto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_monto, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(lbl_CambioDar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_PagoEfectivo)
                        .addGap(201, 201, 201)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ContinuarEf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CancelarEf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Monto)
                            .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Cambio)
                            .addComponent(lbl_CambioDar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_TarjetaMensaje1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlg_PagoEfectivoLayout = new javax.swing.GroupLayout(dlg_PagoEfectivo.getContentPane());
        dlg_PagoEfectivo.getContentPane().setLayout(dlg_PagoEfectivoLayout);
        dlg_PagoEfectivoLayout.setHorizontalGroup(
            dlg_PagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlg_PagoEfectivoLayout.setVerticalGroup(
            dlg_PagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uam/mx/interfaces/imagenes/loguito.png"))); // NOI18N

        lbl_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbl_Usuario.setText("Vendedor de dulcería");

        lbl_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Cantidad.setText("Cantidad:");

        lbl_Comida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Comida.setText("Comida:");

        cmb_Comida.setBackground(java.awt.SystemColor.control);
        cmb_Comida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_Comida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Comida.setToolTipText("");
        cmb_Comida.setBorder(null);
        cmb_Comida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_ComidaItemStateChanged(evt);
            }
        });

        lbl_TotalT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TotalT.setText("TOTAL:");

        lbl_Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Total.setText("total");

        lbl_TipoPago.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TipoPago.setText("Tipo de pago:");

        sp_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sp_Cantidad.setBorder(null);

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbl_Titulo.setText("DATOS DE LA VENTA");

        cmb_TipoPago.setBackground(java.awt.SystemColor.control);
        cmb_TipoPago.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_TipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_TipoPago.setToolTipText("");
        cmb_TipoPago.setBorder(null);

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

        btn_CompletarVenta.setBackground(new java.awt.Color(57, 105, 138));
        btn_CompletarVenta.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_CompletarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_CompletarVenta.setText("Completar venta");
        btn_CompletarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_CompletarVenta.setBorderPainted(false);
        btn_CompletarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CompletarVentaActionPerformed(evt);
            }
        });

        jp_TablaComida.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Comida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Comida);

        javax.swing.GroupLayout jp_TablaComidaLayout = new javax.swing.GroupLayout(jp_TablaComida);
        jp_TablaComida.setLayout(jp_TablaComidaLayout);
        jp_TablaComidaLayout.setHorizontalGroup(
            jp_TablaComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        jp_TablaComidaLayout.setVerticalGroup(
            jp_TablaComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        jp_DatosComida.setBackground(new java.awt.Color(57, 105, 138));
        jp_DatosComida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_NombreComida.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbl_NombreComida.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NombreComida.setText("Comida");

        lbl_CostoComida.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbl_CostoComida.setForeground(new java.awt.Color(255, 255, 255));
        lbl_CostoComida.setText("Costo");

        javax.swing.GroupLayout jp_DatosComidaLayout = new javax.swing.GroupLayout(jp_DatosComida);
        jp_DatosComida.setLayout(jp_DatosComidaLayout);
        jp_DatosComidaLayout.setHorizontalGroup(
            jp_DatosComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_DatosComidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_DatosComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ComidaFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(jp_DatosComidaLayout.createSequentialGroup()
                        .addGroup(jp_DatosComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NombreComida)
                            .addComponent(lbl_CostoComida, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_DatosComidaLayout.setVerticalGroup(
            jp_DatosComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_DatosComidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ComidaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_NombreComida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_CostoComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

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

        btn_Eliminar.setBackground(new java.awt.Color(143, 29, 32));
        btn_Eliminar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Eliminar.setBorderPainted(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Usuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loguito)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_CompletarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jp_TablaComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_Comida, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(lbl_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmb_Comida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_DatosComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_TotalT, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(lbl_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Comida)
                            .addComponent(cmb_Comida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Cantidad)
                            .addComponent(sp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jp_TablaComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_DatosComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TotalT)
                    .addComponent(lbl_Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TipoPago)
                    .addComponent(cmb_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CompletarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_ComidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_ComidaItemStateChanged
        if(cmb_Comida.getSelectedIndex() > 0) {
            int id = cmb_Comida.getSelectedIndex() - 1;
            Comida c = InicioSesión.cine.getMenu().getListaComidas().get(id);
            lbl_NombreComida.setText(c.getNombre());
            lbl_CostoComida.setText(Integer.toString((int) c.getPrecio()));
            lbl_ComidaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource(c.getPortada())));
        }
    }//GEN-LAST:event_cmb_ComidaItemStateChanged

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
       this.dispose();
       InicioVentaComida inicioVentaComida = new InicioVentaComida();
       inicioVentaComida.setVisible(true);        
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        int sel = (Integer) sp_Cantidad.getValue();
        Comida comida = al.get(cmb_Comida.getSelectedIndex() - 1);
        LineaComida lineaComida = new LineaComida(index, comida.getId(), sel);
        if (sel < 1 || cmb_Comida.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Debes escoger un número mayor a 0", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (modelo.getValueAt(0, 0) == null) {
            AgregarATabla(lineaComida);
        } else {
            if (comidaEnTabla(lineaComida) == -1) {
                index = modelo.getRowCount();
                lineaComida.setId(index);
                AgregarATabla(lineaComida);
            } else {
                int i = comidaEnTabla(lineaComida);
                int cant = Integer.parseInt(modelo.getValueAt(i, 3).toString()) + lineaComida.getCantidad();
                float costo = Float.parseFloat(modelo.getValueAt(i, 4).toString()) * cant; 
                modelo.setValueAt(cant, i, 3);
                modelo.setValueAt(costo, i, 5);
            }
        }
        ObtenerTotal();
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_CompletarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CompletarVentaActionPerformed
        if(cmb_TipoPago.getSelectedIndex() == 1) {
            dlg_PagoEfectivo.setSize(600, 400);
            dlg_PagoEfectivo.setLocationRelativeTo(this);
            dlg_PagoEfectivo.setVisible(true);
        } else if(cmb_TipoPago.getSelectedIndex() == 2) {
            dlg_PagoTarjeta.setSize(600, 400);
            dlg_PagoTarjeta.setLocationRelativeTo(this);
            dlg_PagoTarjeta.setVisible(true);
            cmb_TipoTarjeta.removeAllItems();
            cmb_TipoTarjeta.addItem("-Seleccionar-");
            cmb_TipoTarjeta.addItem("Débito");
            cmb_TipoTarjeta.addItem("Crédito");
        }       
    }//GEN-LAST:event_btn_CompletarVentaActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        dlg_MICHísimasGracias.dispose();
        this.dispose();
        InicioVentaComida inicioVentaComida = new InicioVentaComida();
        inicioVentaComida.setVisible(true);
    }//GEN-LAST:event_btn_CerrarActionPerformed

    private void btn_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ContinuarActionPerformed
        if(txt_NumTarjeta.getText().length() == 16) {
            dlg_PagoTarjeta.dispose();
            dlg_MICHísimasGracias.setSize(600, 350);
            dlg_MICHísimasGracias.setLocationRelativeTo(this);
            dlg_MICHísimasGracias.setVisible(true);
            /*ActualizarInventario();*/
        } else {
            JOptionPane.showMessageDialog(null, "Número de tarjeta no aceptado", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_ContinuarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        dlg_PagoTarjeta.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        int filaSeleccionada = tbl_Comida.getSelectedRow();
        if (filaSeleccionada != -1) {
         modelo.removeRow(filaSeleccionada);
         JOptionPane.showMessageDialog(null, "Comida eliminada correctamente");
         int id = filaSeleccionada;
         cambiarID(id);
         ObtenerTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una comida para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_ContinuarEfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ContinuarEfActionPerformed
        if(Float.parseFloat(txt_monto.getText()) >= Float.parseFloat(lbl_Total.getText())) {
            
            try {
                dlg_PagoEfectivo.dispose();
                dlg_MICHísimasGracias.setSize(600, 350);
                dlg_MICHísimasGracias.setLocationRelativeTo(this);
                dlg_MICHísimasGracias.setVisible(true);
                InicioSesión.cine.getCajaComida().nuevaVenta(0, Float.parseFloat(lbl_Total.getText()), false, llc);
                /*ActualizarInventario();*/
            } catch (IOException ex) {
                Logger.getLogger(NuevaVentaComida.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             JOptionPane.showMessageDialog(null, "Monto menor al total a pagar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_ContinuarEfActionPerformed

    private void btn_CancelarEfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarEfActionPerformed
            dlg_PagoEfectivo.dispose();
    }//GEN-LAST:event_btn_CancelarEfActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaVentaComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaVentaComida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_CancelarEf;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JButton btn_CompletarVenta;
    private javax.swing.JButton btn_Continuar;
    private javax.swing.JButton btn_ContinuarEf;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JComboBox<String> cmb_Comida;
    private javax.swing.JComboBox<String> cmb_TipoPago;
    private javax.swing.JComboBox<String> cmb_TipoTarjeta;
    private javax.swing.JDialog dlg_MICHísimasGracias;
    private javax.swing.JDialog dlg_PagoEfectivo;
    private javax.swing.JDialog dlg_PagoTarjeta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jp_DatosComida;
    private javax.swing.JPanel jp_PagoTarjeta1;
    private javax.swing.JPanel jp_TablaComida;
    private javax.swing.JLabel lbl_Cambio;
    private javax.swing.JLabel lbl_CambioDar;
    private javax.swing.JLabel lbl_Cantidad;
    private javax.swing.JLabel lbl_Comida;
    private javax.swing.JLabel lbl_ComidaFoto;
    private javax.swing.JLabel lbl_CostoComida;
    private javax.swing.JLabel lbl_DatosTarjeta;
    private javax.swing.JLabel lbl_Monto;
    private javax.swing.JLabel lbl_NombreComida;
    private javax.swing.JLabel lbl_NombreCompleto;
    private javax.swing.JLabel lbl_NumTarjeta;
    private javax.swing.JLabel lbl_PagoEfectivo;
    private javax.swing.JLabel lbl_PagoTarjeta;
    private javax.swing.JLabel lbl_PagoTarjeta1;
    private javax.swing.JLabel lbl_TarjetaMensaje1;
    private javax.swing.JLabel lbl_TipoPago;
    private javax.swing.JLabel lbl_TipoTarjeta;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_TotalT;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel loguito;
    private javax.swing.JSpinner sp_Cantidad;
    private javax.swing.JTable tbl_Comida;
    private javax.swing.JTextField txt_NombreCompleto;
    private javax.swing.JTextField txt_NumTarjeta;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables
}
