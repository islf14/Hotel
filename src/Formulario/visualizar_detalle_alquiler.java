package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class visualizar_detalle_alquiler extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static String bandera_visualizar_detalle_alquiler;
    ResultSet datos;
    DefaultTableModel model;       
    public visualizar_detalle_alquiler() {
        initComponents();
        cargar("");
        this.setTitle("Visualizar detalle de alquiler");
        bandera_visualizar_detalle_alquiler="akjh";
    }        
    void cargar(String valor)
    {
        String [] titulos = {"Numero","Nombres","Apellidos","Nro DNI","Fecha de Nacimiento","Ciudad","Estado civil","País","Teléfono","Ocupación","Dirección","Numero de alquiler"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("SELECT * FROM detalle_alquila where dni like '%"+valor+"%'");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[12];
            while(datos.next()){
                fila[0]=datos.getString("id_detalle");
                fila[1]=datos.getString("Nombres");
                fila[2]=datos.getString("Apellidos");
                fila[3]=datos.getString("dni");   
                fila[4]=datos.getString("nacimiento");
                fila[5]=datos.getString("ciudad");   
                fila[6]=datos.getString("estado_civil");
                fila[7]=datos.getString("pais");
                fila[8]=datos.getString("telefono");
                fila[9]=datos.getString("ocupacion");
                fila[10]=datos.getString("direccion");
                fila[11]=datos.getString("alquila_id_alquila");
                model.addRow(fila);            
            }
            
            t_datos.setModel(model);
            /*
            
            t_datos.getColumnModel().getColumn(0).setMaxWidth(500);
            t_datos.getColumnModel().getColumn(1).setMaxWidth(600);
            t_datos.getColumnModel().getColumn(2).setMaxWidth(1700);//nombres
            t_datos.getColumnModel().getColumn(3).setMaxWidth(1700);
            t_datos.getColumnModel().getColumn(4).setMaxWidth(500);//dni
            t_datos.getColumnModel().getColumn(5).setMaxWidth(1000);
            t_datos.getColumnModel().getColumn(6).setMaxWidth(1000);            
            DefaultTableCellRenderer tcr= new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            t_datos.getColumnModel().getColumn(0).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(2).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(3).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(4).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(5).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(6).setCellRenderer(tcr);            
            t_datos.setModel(model);*/
        }catch(HeadlessException | SQLException e){
            System.err.println("El cliente no se encuentra registrado");           
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        btnresetear = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(t_datos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Documento de indentidad:");

        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        btnresetear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnresetear.setText("Resetear");
        btnresetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetearActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnresetear)
                .addGap(40, 40, 40)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnresetear)
                    .addComponent(btnsalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyReleased
        // TODO add your handling code here:
        cargar(txtdni.getText());
    }//GEN-LAST:event_txtdniKeyReleased

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Solo se permite el Ingreso de Letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }int numerocaracteres=15;
        if (txtdni.getText().length()>=numerocaracteres){
        evt.consume();
        //JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No se permite usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_txtdniKeyTyped

    private void btnresetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetearActionPerformed
        // resetear
        txtdni.setText("");
        cargar("");
    }//GEN-LAST:event_btnresetearActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // salir
        this.dispose();
        bandera_visualizar_detalle_alquiler=null;        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando interfaz
        bandera_visualizar_detalle_alquiler=null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnresetear;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtdni;
    // End of variables declaration//GEN-END:variables
}
