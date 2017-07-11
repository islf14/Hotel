
package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usuario extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    Integer n=1;
    public static String bandera_usuario;
    public static buscar_usuario buscar_usu;
    public usuario() {
        initComponents();
        btnactualizar.setEnabled(false);
        this.setTitle("Registro de nuevo usuario");
        this.setLocation(10, 10);
    }
    
    //AGREGAR BLOQUEO DE TEXTFIEL Y BOTON GUARDAR
    
    void bloqueorestantes(){
        //btnbuscar.setEnabled(false);
        btnguardar.setEnabled(false);  
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtusuario.setEnabled(false);
        txtcontrasena.setEnabled(false);
        txttelefono.setEnabled(false);
        cmbtipo.setEnabled(false);
        cmbturno.setEnabled(false);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldatos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbturno = new javax.swing.JComboBox<>();
        txtapellido = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmbtipo = new javax.swing.JComboBox<>();
        txtcontrasena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelbotones3 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Turno:");

        cmbturno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Completo" }));
        cmbturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbturnoActionPerformed(evt);
            }
        });

        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        cmbtipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcionista", "Administrador" }));
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });

        txtcontrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        txtcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Contraseña:");

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneldatosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(txtapellido)
                                    .addComponent(txtcontrasena)
                                    .addComponent(txttelefono)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatosLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbturno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotones3Layout = new javax.swing.GroupLayout(panelbotones3);
        panelbotones3.setLayout(panelbotones3Layout);
        panelbotones3Layout.setHorizontalGroup(
            panelbotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotones3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelbotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelbotones3Layout.setVerticalGroup(
            panelbotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotones3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnnuevo)
                .addGap(12, 12, 12)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelbotones3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelbotones3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbturnoActionPerformed

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=25;
 char c = evt.getKeyChar();
if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       
        else if (txtapellido.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
             )
 {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
    evt.consume();
} 
                else if (evt.getKeyChar()=='´' && txtapellido.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
    evt.consume();
}
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        
        int numerocaracteres=25;
 char c = evt.getKeyChar();
if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       
        else if (txtnombre.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
             )
 {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
    evt.consume();
} 
                else if (evt.getKeyChar()=='´' && txtnombre.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
    evt.consume();
}
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=9;
        char d=evt.getKeyChar();
        if (txttelefono.getText().length()>=numerocaracteres){
        evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if (Character.isLetter(d)) 
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtusuario.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        cmbturno.setSelectedIndex(0); 
        txtcontrasena.setText("");
        txttelefono.setText("");
        cmbtipo.setSelectedIndex(0); 
        btnactualizar.setEnabled(false);        
        btnguardar.setEnabled(true);
     
        btnbuscar.setEnabled(true);
          
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtusuario.setEnabled(true);
        txtcontrasena.setEnabled(true);
        txttelefono.setEnabled(true);
        cmbtipo.setEnabled(true);
        cmbturno.setEnabled(true);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Nombre","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtapellido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa Apellidos","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtusuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Usuario","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtcontrasena.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttelefono.getText().length()>0 && txttelefono.getText().length()<9){
                JOptionPane.showMessageDialog(null,"Teléfono incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(n==1)
        {
            try{
                PreparedStatement pst=cn.prepareStatement("INSERT INTO usuario(id_usuario,nombre,apellido,turno,contrasena,telefono,tipo_usu) Values(?,?,?,?,?,?,?)");
                pst.setString(1,txtusuario.getText());
                pst.setString(2,txtnombre.getText());
                pst.setString(3,txtapellido.getText());
                pst.setString(4,((String) cmbturno.getSelectedItem()));
                pst.setString(5,txtcontrasena.getText());
                pst.setString(6,txttelefono.getText());
                pst.setString(7,((String) cmbtipo.getSelectedItem()));            
               
                JOptionPane.showMessageDialog(null,"registro exitoso");
                btnactualizar.setEnabled(false);        
                btnguardar.setEnabled(false);
                btnnuevo.setEnabled(true);  
                btnbuscar.setEnabled(true);
                pst.executeUpdate();
                bloqueorestantes();

            }catch(HeadlessException | SQLException e){} 

            }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
         int numerocaracteres=15;
        if (txtusuario.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaKeyReleased

    private void txtcontrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyTyped
        // TODO add your handling code here
        int numerocaracteres=15;
        if (txtcontrasena.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtcontrasenaKeyTyped

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        buscar_usu=new buscar_usuario(this,true);
        buscar_usu.setVisible(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtcontrasena.setEnabled(true);
        txttelefono.setEnabled(true);
        txtusuario.setEnabled(false);
        cmbtipo.setEnabled(true);
        cmbturno.setEnabled(true);
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
       
        
            
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipoActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // //PARA NO GUARDAR EL MISMO USUARIO
        try {
                //Conectar cc=new Conectar();            
                //Connection cn=cc.conexion();
            PreparedStatement pst1=cn.prepareStatement("UPDATE usuario SET nombre='"+txtnombre.getText()+
                    "',apellido='"+txtapellido.getText()+"',turno='"+(String) cmbturno.getSelectedItem()+
                    "',contrasena='"+txtcontrasena.getText()+"',telefono='"+txttelefono.getText()
                    +"', tipo_usu='"+(String) cmbtipo.getSelectedItem()+"' WHERE id_usuario='"
                    +txtusuario.getText()+"'");
            int b=pst1.executeUpdate();                
            if(b>0){
                System.out.println("Actualizacion exitosa en Usuario");  
                JOptionPane.showMessageDialog(null,"Usuario Modificado","!Aviso!",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al actualizar ","Error",1);
            } 
            }
            catch (SQLException e) {
                System.out.print(e.getMessage());
             }
        bloqueorestantes();
        btnbuscar.setEnabled(true);
        btnactualizar.setEnabled(false);
    }//GEN-LAST:event_btnactualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cmbtipo;
    public static javax.swing.JComboBox<String> cmbturno;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelbotones3;
    private javax.swing.JPanel paneldatos;
    public static javax.swing.JTextField txtapellido;
    public static javax.swing.JTextField txtcontrasena;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
