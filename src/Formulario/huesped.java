
package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class huesped extends javax.swing.JInternalFrame {

    //Conectar cc=new Conectar();
    //Connection cn=cc.conexion();
    //ResultSet datos;
   
    fecha fecha=new fecha();
    Integer n=1;
    public static String id;
    public static String bandera_huesped;
    public static editar_huesped editar_hues;
  //  public static editar_huesped editar_huespededi;    
    public huesped() {
        initComponents();
        java.util.Date fecha = new java.util.Date();
        java.sql.Date fechasq1 = new java.sql.Date(fecha.getTime());
        txtfecha.setMaxSelectableDate(fechasq1);        
        this.setTitle("Datos de nuevo huésped");
        this.setLocation(10, 10);      
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);     
        btneditar.setEnabled(false);
        //mostrardatos("");
        //jTable1.setEnabled(false); 
        bandera_huesped="bandera";
        fechadefecto();      
    }
    
    void limpiar(){
        txtdni.setText("");       
        txtnombre.setText("");
        txtapellido.setText("");
        fechadefecto(); 
        cmbestadocivil.setSelectedIndex(0);
        txttelefono.setText("");  
        txtciudad.setText("");
        txtpais.setText(""); 
        txtdireccion.setText("");
        txtocupacion.setText("");        
    } 
    void fechadefecto(){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
            txtfecha.setDate(date);            
        }catch(ParseException ex){
            //Logger.getLogger(alquiler.class.getName()).log(Level.WARNING);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txtocupacion = new javax.swing.JTextField();
        cmbestadocivil = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName("Datos del Huesped"); // NOI18N

        jLabel3.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        txtnombre.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellido.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel6.setText("Estado Civil:");

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel2.setText("DNI:");

        txtdni.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel7.setText("Telefono:");

        txttelefono.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel8.setText("Ciudad:");

        txtciudad.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciudadActionPerformed(evt);
            }
        });
        txtciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciudadKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel9.setText("Pais:");

        txtpais.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaisActionPerformed(evt);
            }
        });
        txtpais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaisKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel11.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel11.setText("Ocupación:");

        txtdireccion.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        txtocupacion.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtocupacionKeyTyped(evt);
            }
        });

        cmbestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No se sabe", "Casado(a)", "Soltero(a)", "Viudo(a)", "Divorciado(a)" }));
        cmbestadocivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestadocivilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(txtdni)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtciudad))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txttelefono)
                                                    .addComponent(txtpais, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtdireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtocupacion, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbestadocivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                        .addGap(1, 1, 1)))
                .addGap(292, 292, 292))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cmbestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btneditar.setText("Actualizar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("REGISTRO DE HUESPED");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
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

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtapellidoActionPerformed

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

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
            }else if(txtapellido.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Ingrese apellidos","¡Error!",JOptionPane.ERROR_MESSAGE);
            }else if(txtdni.getText().length()!=8){
                JOptionPane.showMessageDialog(null,"DNI incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
            }else if (txtfecha.getDate()==null) {
                JOptionPane.showMessageDialog(null,"Ingrese fecha de nacimiento","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if(txttelefono.getText().length()>0 && txttelefono.getText().length()<9){
                JOptionPane.showMessageDialog(null,"Teléfono incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
            }else if(txtpais.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingrese País","¡Error!",JOptionPane.ERROR_MESSAGE);
            }
            else if(txtciudad.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingrese ciudad","¡Error!",JOptionPane.ERROR_MESSAGE);
            }else if(n==1){
                try{ 
                Conectar cc=new Conectar();            
                Connection cn=cc.conexion();    
                PreparedStatement pst=cn.prepareStatement("INSERT INTO huesped(dni_huesped,nombre_h,apellidos_h,nacimiento,ciudad,telefono,estado_civil,pais,direccion,ocupacion) Values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,txtdni.getText());
                pst.setString(2,txtnombre.getText());
                pst.setString(3,txtapellido.getText());
                pst.setString(4,fecha.getFecha(txtfecha));   
                pst.setString(5,txtciudad.getText());  
                pst.setString(6,txttelefono.getText());
                pst.setString(7,(String) cmbestadocivil.getSelectedItem());             
                pst.setString(8,txtpais.getText());
                pst.setString(9,txtdireccion.getText());
                pst.setString(10,txtocupacion.getText());

                //jTable1.setEnabled(false);
                btnguardar.setEnabled(false);
                btneditar.setEnabled(false); 
                btnnuevo.setEnabled(true);
                pst.executeUpdate();
                //limpiar();
                txtapellido.setEnabled(false);
                txtdni.setEnabled(false);
                txtfecha.setEnabled(false);
                cmbestadocivil.setEnabled(false);
                txttelefono.setEnabled(false);        
                txtdireccion.setEnabled(false);
                txtnombre.setEnabled(false);
                txtciudad.setEnabled(false);
                txtpais.setEnabled(false);
                txtocupacion.setEnabled(false); 
                JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
                cc.desconectar();
            }catch (HeadlessException | SQLException e){
                System.out.print(e.getMessage());
            }  
        }
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        limpiar(); 
        txtapellido.setEnabled(true);
        txtdni.setEnabled(true);
        txtfecha.setEnabled(true);
        cmbestadocivil.setEnabled(true);
        txttelefono.setEnabled(true);        
        txtdireccion.setEnabled(true);
        txtnombre.setEnabled(true);
        txtciudad.setEnabled(true);
        txtpais.setEnabled(true);
        txtocupacion.setEnabled(true);
        btneditar.setEnabled(false);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);
       // mostrardatos("");
        //jTable1.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        bandera_huesped=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
       // jTable1.setEnabled(true);
    
    try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();

            PreparedStatement pst;
            pst = cn.prepareStatement("UPDATE huesped SET dni_huesped='"+txtdni.getText()+"',nombre_h='"+txtnombre.getText()+"',apellidos_h='"+txtapellido.getText()+"',nacimiento='"+fecha.getFecha(txtfecha)+"',ciudad='"+txtciudad.getText()+"',telefono='"+txttelefono.getText()+"', estado_civil='"+(String) cmbestadocivil.getSelectedItem()+"',pais='"+txtpais.getText()+"',direccion='"+txtdireccion.getText()+"',ocupacion='"+txtocupacion.getText()+"'   WHERE id_huesped="+id );
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);  
            txtapellido.setEnabled(false);
            txtdni.setEnabled(false);
            txtfecha.setEnabled(false);
            cmbestadocivil.setEnabled(false);
            txttelefono.setEnabled(false);        
            txtdireccion.setEnabled(false);
            txtnombre.setEnabled(false);
            txtciudad.setEnabled(false);
            txtpais.setEnabled(false);
            txtocupacion.setEnabled(false);  
            cc.desconectar();
            id="null";
            //jTable1.setEnabled(false);
                btnguardar.setEnabled(false);
                btneditar.setEnabled(false);      // CAMBIO       
                btnnuevo.setEnabled(true);
            } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
       
       
       /* try {
        Conectar cc=new Conectar();            
        Connection cn=cc.conexion();
        
        PreparedStatement pst;
        pst = cn.prepareStatement("UPDATE huesped SET dni_huesped='"+txtdni.getText()+"',nombre_h='"+txtnombre.getText()+"',apellidos_h='"+txtapellido.getText()+"',nacimiento='"+fecha.getFecha(txtfecha)+"',ciudad='"+txtciudad.getText()+"',telefono='"+txttelefono.getText()+"', estado_civil='"+txtestadocivil.getText()+"',pais='"+txtpais.getText()+"',direccion='"+txtdireccion.getText()+"',ocupacion='"+txtocupacion.getText()+"'   WHERE id_huesped=id_huesped" );
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
        cc.desconectar();
        n=1;
        //jTable1.setEnabled(false);
            btnguardar.setEnabled(false);
            btneditar.setEnabled(true);            
            btnnuevo.setEnabled(true);
        } catch (SQLException e) {
        System.out.print(e.getMessage());
    }*/    
        /*btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btneditar.setEnabled(false);
      n=2; */
    }//GEN-LAST:event_btneditarActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        //mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=8;
        char d=evt.getKeyChar();
        if (txtdni.getText().length()>=numerocaracteres){
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
    }//GEN-LAST:event_txtdniKeyTyped

    private void txtpaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaisKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
       int numerocaracteres=25;
 char c = evt.getKeyChar();
if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       
        else if (txtpais.getText().length()>=numerocaracteres){
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
                else if (evt.getKeyChar()=='´' && txtpais.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
    evt.consume();
}

    }//GEN-LAST:event_txtpaisKeyTyped

    private void txtciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciudadKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
         int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       
        else if (txtciudad.getText().length()>=numerocaracteres){
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
                else if (evt.getKeyChar()=='´' && txtciudad.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
    evt.consume();
}

    }//GEN-LAST:event_txtciudadKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=9;
        char d=evt.getKeyChar();
        if (txttelefono.getText().length()>=numerocaracteres){
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
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        int numerocaracteres=40;
        /*char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }*/
        //else 
        if (txtdireccion.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
               /*else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
         int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       
        else if (txtocupacion.getText().length()>=numerocaracteres){
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
                else if (evt.getKeyChar()=='´' && txtocupacion.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
    evt.consume();
}

    }//GEN-LAST:event_txtocupacionKeyTyped

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here: 
        editar_hues=new editar_huesped(this,true);
        editar_hues.setVisible(true);        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void cmbestadocivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestadocivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbestadocivilActionPerformed

    private void txtpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaisActionPerformed

    private void txtciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtciudadActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btneditar;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cmbestadocivil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    public static javax.swing.JTextField txtapellido;
    public static javax.swing.JTextField txtciudad;
    public static javax.swing.JTextField txtdireccion;
    public static javax.swing.JTextField txtdni;
    public static com.toedter.calendar.JDateChooser txtfecha;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtocupacion;
    public static javax.swing.JTextField txtpais;
    public static javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
