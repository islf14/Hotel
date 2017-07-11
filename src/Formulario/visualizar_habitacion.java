package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class visualizar_habitacion extends javax.swing.JInternalFrame {

    static String bandera_visualizar_reserva;

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static String bandera_visualizar_habitaciones;
    ResultSet datos;
    DefaultTableModel model;       
    public visualizar_habitacion() {
        initComponents();
        cargar("");
        this.setTitle("Estado de las habitaciones");
        bandera_visualizar_habitaciones="akjh";
    }        
    void cargar(String valor)
    {
        String [] titulos = {"Nro Habitación","Tipo Habitación","Estado","Nro de Camas","Fecha Salida"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("select ha.nro_hab as 'n_habitacion',"
                    + "th.nombre_tipo as 'tipo_habitacion',ha.estado as 'estado',a.num_camas as 'n_camas',"
                    + "a.fecha_salida as 'fechasalida'\n" +
                    "from habitacion ha inner join tip_habitacion th on th.id_tipo=ha.tip_habitacion_id_tipo\n" +
                    "left outer join alquila a on a.habitacion_id_habitacion=ha.id_habitacion\n" +
                    "where ha.nro_hab like'%"+valor+"%';");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[5];
            while(datos.next()){                
                fila[0]=datos.getString("n_habitacion");
                fila[1]=datos.getString("tipo_habitacion");
                fila[2]=datos.getString("estado");  
                fila[3]=datos.getString("n_camas");   
                fila[4]=datos.getString("fechasalida");
                model.addRow(fila);            
            } 
            t_datos.setModel(model);
            t_datos.getColumnModel().getColumn(0).setMaxWidth(500);
            t_datos.getColumnModel().getColumn(1).setMaxWidth(600);
            t_datos.getColumnModel().getColumn(2).setMaxWidth(600);//nombres
            t_datos.getColumnModel().getColumn(3).setMaxWidth(700);
            t_datos.getColumnModel().getColumn(4).setMaxWidth(500);//dni
                   
            DefaultTableCellRenderer tcr= new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            t_datos.getColumnModel().getColumn(0).setCellRenderer(tcr);
       
            t_datos.setModel(model);
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
        txtnumero = new javax.swing.JTextField();
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
        jLabel3.setText("Número de habitación:");

        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });
        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnumeroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroKeyTyped(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnresetear)
                .addGap(48, 48, 48)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnresetear)
                    .addComponent(btnsalir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
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

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtnumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyReleased
        // TODO add your handling code here:
        cargar(txtnumero.getText());
    }//GEN-LAST:event_txtnumeroKeyReleased

    private void txtnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Solo se permite el Ingreso de Letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }int numerocaracteres=30;
        if (txtnumero.getText().length()>=numerocaracteres){
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
    }//GEN-LAST:event_txtnumeroKeyTyped

    private void btnresetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetearActionPerformed
        // resetear
        txtnumero.setText("");
        cargar("");
    }//GEN-LAST:event_btnresetearActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // salir
        this.dispose();
        bandera_visualizar_habitaciones=null;        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando interfaz
        bandera_visualizar_habitaciones=null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnresetear;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtnumero;
    // End of variables declaration//GEN-END:variables
}
