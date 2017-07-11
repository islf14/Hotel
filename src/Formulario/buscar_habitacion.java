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

public class buscar_habitacion extends javax.swing.JDialog {

    public static habitacion habit;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    DefaultTableModel model;
    String nrohab,nom_tipo,estado,costo,camas;
    /////////////
    public buscar_habitacion(habitacion parent, boolean modal) {
        //super(parent, modal);
        this.habit= parent;
        this.setModal(modal);
        this.setTitle("Seleccion de Habitación");
        initComponents();
        cargar("");
        this.setLocationRelativeTo(this);        
    }

    ///7///
    //public void enviodato(){
    //    alquile.poner();
    // }
    //////////////////
    void cargar(String valor)
    {
        String [] titulos = {"Nº","Habitacion", "Tipo", "Estado","Costo","Nro Camas"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("SELECT  id_habitacion,nro_hab,nombre_tipo,estado,costo,nro_camas "
                    + "FROM tip_habitacion inner join  habitacion on habitacion.tip_habitacion_id_tipo=tip_habitacion.id_tipo where nro_hab LIKE '"+valor+"%' order by nro_hab");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[6];
            while(datos.next()){
                fila[0]=datos.getString("id_habitacion");
                fila[1]=datos.getString("nro_hab");
                fila[2]=datos.getString("nombre_tipo");
                fila[3]=datos.getString("estado");
                fila[4]=datos.getString("costo");
                fila[5]=datos.getString("nro_camas");
                model.addRow(fila); 
            } 
            jTable1.setModel(model);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);         
            jTable1.getColumnModel().getColumn(1).setMaxWidth(70);            
            jTable1.getColumnModel().getColumn(2).setMaxWidth(400);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(300);     
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);             
            jTable1.getColumnModel().getColumn(5).setMaxWidth(50);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(tcr);              
            jTable1.getColumnModel().getColumn(1).setCellRenderer(tcr);     
            jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }catch(HeadlessException | SQLException e){
            System.err.println("No dispone de ese tipo");
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 1, 14)); // NOI18N
        lb_tip_hab_alq.setText("Nº de Habitación :");

        txtnumero.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        btnsalir.setText("Cancelar");
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
                .addComponent(lb_tip_hab_alq)
                .addGap(18, 18, 18)
                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("URW Gothic L", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyReleased
        // TODO add your handling code here:
        cargar(txtnumero.getText());
    }//GEN-LAST:event_txtnumeroKeyReleased

    private void txtnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=5;
        char d=evt.getKeyChar();
        if (txtnumero.getText().length()>=numerocaracteres){
        evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if (Character.isLetter(d)) 
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtnumeroKeyTyped

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fsel= jTable1.getSelectedRow();
        model= (DefaultTableModel) jTable1.getModel();
        habitacion.id= jTable1.getValueAt(fsel, 0).toString();
        habitacion.txthabitacion.setText(jTable1.getValueAt(fsel, 1).toString());      
        habitacion.numhabitacion= jTable1.getValueAt(fsel, 1).toString();
        habitacion.cmbtipo.setSelectedItem(jTable1.getValueAt (fsel,2).toString());
        habitacion.cmbestado.setSelectedItem(jTable1.getValueAt (fsel,3).toString()); 
        habitacion.txthabitacion.setEnabled(true);
        habitacion.cmbtipo.setEnabled(true);
        habitacion.cmbestado.setEnabled(true);
        habitacion.btnguardar.setEnabled(false);
        habitacion.btnactualizar.setEnabled(true);
        this.dispose();

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

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
            java.util.logging.Logger.getLogger(buscar_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscar_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscar_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscar_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                buscar_habitacion dialog = new buscar_habitacion(habit, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JTextField txtnumero;
    // End of variables declaration//GEN-END:variables
}
