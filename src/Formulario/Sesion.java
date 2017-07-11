package Formulario;
import ClaseConectar.Conectar;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Sesion extends javax.swing.JFrame {

    ResultSet datos;
    public Sesion() {
        initComponents();
        System.out.println("Iniciando Sesión");
        this.setLocationRelativeTo(null);
        this.setTitle("Inicio Sesión");
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/usuario.png"));
        this.setIconImage(icono);
    }
    public void acceder(String usu, String con){
        Conectar cc= new Conectar();
        Connection cn= cc.conexion(); 
        if(txtusuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Usuario","!Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtcontrasena.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Contraseña","!Error!",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String cap="";
            try{            
                PreparedStatement pst=cn.prepareStatement("SELECT *from usuario where id_usuario='"+usu+"'&& contrasena='"+con+"'");
                datos = pst.executeQuery();//buscando datos y guardando en datos           
                while(datos.next()){
                    cap=datos.getString("tipo_usu");
                } 
                if(cap.equals("Administrador")){
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Bienvenido Administrador "+usu);
                    MenuPrincipal ingresoA = new MenuPrincipal();                    
                    ingresoA.obtenerusuario(usu);
                    ingresoA.setVisible(true);     
                }
                if(cap.equals("Recepcionista")){
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Bienvenido Recepcionista "+usu);
                    MenuPrincipalRe ingresoR = new MenuPrincipalRe();
                    ingresoR.obtenerusuario(usu);
                    ingresoR.setVisible(true);       
                }
                if((!cap.equals("Administrador"))&&(!cap.equals("Recepcionista")))
                {
                    JOptionPane.showMessageDialog(null,"No existe sus datos");
                    txtusuario.requestFocus();
                    txtusuario.setText(null);
                    txtcontrasena.setText(null);
                }
                cc.desconectar();
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null,"El usuario no se encuentra registrado","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcontrasena = new javax.swing.JPasswordField();
        btnacceder = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        txtusuario1.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        txtusuario1.setName(""); // NOI18N
        txtusuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario1ActionPerformed(evt);
            }
        });
        txtusuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuario1KeyTyped(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO DE SESIÓN");
        setMaximumSize(new java.awt.Dimension(384, 498));
        setMinimumSize(new java.awt.Dimension(384, 498));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 20, 260, 256);

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtusuario.setName(""); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtusuario);
        txtusuario.setBounds(160, 290, 193, 35);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 290, 97, 35);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 340, 120, 40);

        txtcontrasena.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        txtcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyTyped(evt);
            }
        });
        getContentPane().add(txtcontrasena);
        txtcontrasena.setBounds(160, 340, 193, 34);

        btnacceder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnacceder.setText("Acceder");
        btnacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccederActionPerformed(evt);
            }
        });
        getContentPane().add(btnacceder);
        btnacceder.setBounds(50, 410, 130, 40);

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(210, 410, 130, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 390, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccederActionPerformed
        // TODO add your handling code here:
        String usu = txtusuario.getText();
        String con = new String(txtcontrasena.getPassword());
        acceder(usu,con);
        
    }//GEN-LAST:event_btnaccederActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cancelarActionPerformed

    private void txtcontrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==com.sun.glass.events.KeyEvent.VK_ENTER){
            String usu = txtusuario.getText();
            String con = new String(txtcontrasena.getPassword());
            acceder(usu,con);
        }
    }//GEN-LAST:event_txtcontrasenaKeyPressed

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
        txtcontrasena.transferFocus();
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
        txtusuario.transferFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=15;
        if (txtusuario.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtusuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1ActionPerformed

    private void txtusuario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuario1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1KeyTyped

    private void txtcontrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=15;
        if ( (txtcontrasena.getText()).length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
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
        else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String usu = txtusuario.getText();
            String con = new String(txtcontrasena.getPassword());
            acceder(usu,con);
        }
    }//GEN-LAST:event_txtcontrasenaKeyTyped

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
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacceder;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtusuario1;
    // End of variables declaration//GEN-END:variables
}
