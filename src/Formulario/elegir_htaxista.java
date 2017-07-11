package Formulario;

import ClaseConectar.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class elegir_htaxista extends javax.swing.JDialog {

    public static huespedportaxista taxi;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    DefaultTableModel model;
    public elegir_htaxista(huespedportaxista parent, boolean modal) {
        this.taxi= parent;
        this.setModal(modal);
        this.setTitle("Seleccionar taxista");
        initComponents();
        cargar("");
        this.setLocationRelativeTo(this);  
    }
     void cargar(String valor)
    {
        DefaultTableModel modelo= new DefaultTableModel();
    
    modelo.addColumn("  Nº");
    modelo.addColumn("  DNI ");
    modelo.addColumn("     NOMBRES");
    modelo.addColumn("     APELLIDOS");   
    t_datos.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {    //String []datos = new String [4];

        SQL="SELECT * FROM taxista";
    }
    else{
        SQL="SELECT * FROM taxista WHERE nombre LIKE '%"+valor+"%'";
    }
 
    String []datos = new String [4];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(5);                
                datos[1]=rs.getString(1);
                datos[2]=rs.getString(2);
                datos[3]=rs.getString(3);  
                modelo.addRow(datos);
            }
            t_datos.setModel(modelo);
            t_datos.getColumnModel().getColumn(0).setMaxWidth(50);         
            t_datos.getColumnModel().getColumn(1).setMaxWidth(350);
             
            t_datos.getColumnModel().getColumn(2).setMaxWidth(350);
            t_datos.getColumnModel().getColumn(3).setMaxWidth(350);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            t_datos.getColumnModel().getColumn(0).setCellRenderer(tcr);           
            t_datos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 1, 14)); // NOI18N
        lb_tip_hab_alq.setText("Nombre:");

        txtnombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(btnsalir))
                .addContainerGap())
        );

        t_datos.setAutoCreateRowSorter(true);
        t_datos.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        t_datos.setModel(new javax.swing.table.DefaultTableModel(
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
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        cargar(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo letras","Advertencia.!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        int fsel= t_datos.getSelectedRow();
        huespedportaxista.id=t_datos.getValueAt(fsel, 0).toString();
        huespedportaxista.txtcod.setText(t_datos.getValueAt(fsel, 0).toString());
        
        this.dispose();
    }//GEN-LAST:event_t_datosMouseClicked

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
            java.util.logging.Logger.getLogger(elegir_htaxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(elegir_htaxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(elegir_htaxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(elegir_htaxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                elegir_htaxista dialog = new elegir_htaxista(taxi, true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
