package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class alquiler extends javax.swing.JInternalFrame {

    public static seleccion_habitacion seleccion_ha;
    public static elegir_huesped elegir_h;
    DefaultTableModel modelo;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    Integer seleccionado;
    fecha fecha=new fecha();
    //String rtta;//r
    Integer cantidadpersonas,totalpersonas;
    public static String bandera_alquiler;//guardar el usuario que inicio sesion
    public String usuario_alquiler;
    public static String id_habitacion_seleccion; //guarda el id retornado
    public String id_huesped_huesped;//recibe el huesped de la interfaz elegir
    ///////////////
    public alquiler() {
        super();
        initComponents();
        this.setLocation(5,5);        
        this.setTitle("Alquiler");
        java.util.Date fechaa = new java.util.Date();
        java.sql.Date fechasq1 = new java.sql.Date(fechaa.getTime());
        txtnacimiento.setMaxSelectableDate(fechasq1); 
        txtsalida.setMinSelectableDate(fechaa);
        bandera_alquiler="bandera";
        ////Tabla
        modelo= new DefaultTableModel();        
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Estado Civil");
        modelo.addColumn("País");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ocupacion");
        modelo.addColumn("Dirección");        
        this.tb_det.setModel(modelo);
        ///
        spinner.setValue(0);
        SpinnerNumberModel nm=new SpinnerNumberModel();
        nm.setMaximum(10);
        nm.setMinimum(0);
        //nm.setStepSize(1);
        spinner.setModel(nm);
        ///
        limpiar();  
        btnnuevo();  
    }
    public void obtenerusuario (String u){
        usuario_alquiler=u;        
    }
    void bloqueorestantes(){
        btnbuscar_h.setEnabled(false);
        btnhuesped.setEnabled(false); 
        btnexplorar.setEnabled(false);
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
    }    
    void btnnuevo(){
        btnbuscar_h.setEnabled(true);
        btnhuesped.setEnabled(true); 
        btnexplorar.setEnabled(true);
        btnbuscar_th.setEnabled(false);
        btnagregar.setEnabled(false);
        btneditar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);
        btnguardar.setEnabled(false);
        //
        txtdni.setEnabled(true);
        txtdni.setEditable(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);        
        spinner.setEnabled(false);//spiner true
        txtnumeroha.setEnabled(false);
        txttipoha.setEnabled(false);
        txtnumeroca.setEnabled(false);
        //
        bloquearcampoingreso(0);
        //
        txtidalquiler.setEnabled(false);
        txtllegada.setEnabled(false);
        txtsalida.setEnabled(false);
        txtusuario.setEnabled(false);
        txtmonto.setEnabled(false);
        txtobservacion.setEnabled(false);          
    }    
    void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        spinner.setValue(0);//spiner a 0
        txtnumeroha.setText("");
        txttipoha.setText("");
        txtnumeroca.setText("");
        obt_id(); 
        txtllegada.setText(fecha_actual());
        resetearfecha();//resetear fecha salida
        txtusuario.setText(usuario_alquiler);
        txtmonto.setText("");
        txtobservacion.setText("");
        limpiaringresohuesped();
        eliminarelementos();       
    }
    void limpiaringresohuesped(){        
        txtnombre_mi.setText(null);
        txtapellido_mi.setText(null);
        txtdni_mi.setText(null);        
        fechadefecto();//set fecha        
        txtciudad.setText(null);
        cmbestadocivil.setSelectedIndex(0);
        txtpais.setText(null);
        txttelefono.setText(null);
        txtocupacion.setText(null);
        txtdireccion.setText(null);        
    }
    void bloquearcampoingreso(int s){
        int a=1;
            txtnombre_mi.setEnabled(s==a);
            txtapellido_mi.setEnabled(s==a);
            txtdni_mi.setEnabled(s==a);
            txtnacimiento.setEnabled(s==a);
            txtciudad.setEnabled(s==a);
            cmbestadocivil.setEnabled(s==a);
            txtpais.setEnabled(s==a);
            txttelefono.setEnabled(s==a);
            txtocupacion.setEnabled(s==a);
            txtdireccion.setEnabled(s==a);
    }
    void eliminarelementos(){
        int cantfil=tb_det.getRowCount();
        for(int i=cantfil-1;i>=0;i--){
            modelo.removeRow(i);
            cantidadpersonas=cantidadpersonas+1;
        }
    }
    /////////////////  
    void fechadefecto(){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
            txtnacimiento.setDate(date);            
        }catch(ParseException ex){
            //Logger.getLogger(alquiler.class.getName()).log(Level.WARNING);
        }
    }
    void resetearfecha(){
        try{
            String fec ="";
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date fech;
            fech = df.parse(fec);
            this.txtsalida.setDate(fech); 
        }catch(ParseException e){
            
        }     
    }
    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_alquila AS UNSIGNED)), 0) codigoExterno FROM alquila");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtidalquiler.setText(String.valueOf(cont));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
//////    
    public static String fecha_actual(){
        Date fecha = new Date();
      //SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd h:mm:ss"); 
        return formatoFecha.format(fecha);
    } 
    /////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_dt_huesp = new javax.swing.JPanel();
        lb_dni_alq = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lb_nom_alq = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        lb_ape_alq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnbuscar_h = new javax.swing.JButton();
        btnhuesped = new javax.swing.JButton();
        btnexplorar = new javax.swing.JButton();
        spinner = new javax.swing.JSpinner();
        panel_dt_hab = new javax.swing.JPanel();
        lb_num_hab_alq = new javax.swing.JLabel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txttipoha = new javax.swing.JTextField();
        txtnumeroha = new javax.swing.JTextField();
        btnbuscar_th = new javax.swing.JButton();
        txtnumeroca = new javax.swing.JTextField();
        lb_num_camas_hab_alq1 = new javax.swing.JLabel();
        lb_num_camas_hab_alq = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtdni_mi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtapellido_mi = new javax.swing.JTextField();
        txtnombre_mi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnacimiento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbestadocivil = new javax.swing.JComboBox<>();
        txtpais = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtocupacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btneliminart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_det = new javax.swing.JTable();
        panel_dt_alq = new javax.swing.JPanel();
        lb_id_alq = new javax.swing.JLabel();
        lb_fech_lleg = new javax.swing.JLabel();
        lb_fech_sal = new javax.swing.JLabel();
        lb_obs_alq = new javax.swing.JLabel();
        lb_id_recep = new javax.swing.JLabel();
        txtidalquiler = new javax.swing.JTextField();
        txtllegada = new javax.swing.JTextField();
        txtobservacion = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtsalida = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        panel_dt_huesp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Huésped", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N
        panel_dt_huesp.setToolTipText("");

        lb_dni_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_dni_alq.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        lb_nom_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_nom_alq.setText("Nombres:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtapellido.setEditable(false);
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_ape_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_ape_alq.setText("Apellidos:");

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de personas:");

        btnbuscar_h.setText("Buscar");
        btnbuscar_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_hActionPerformed(evt);
            }
        });

        btnhuesped.setText("Nuevo Huesped");
        btnhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuespedActionPerformed(evt);
            }
        });

        btnexplorar.setText("Explorar");
        btnexplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexplorarActionPerformed(evt);
            }
        });

        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_huespLayout = new javax.swing.GroupLayout(panel_dt_huesp);
        panel_dt_huesp.setLayout(panel_dt_huespLayout);
        panel_dt_huespLayout.setHorizontalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nom_alq)
                            .addComponent(lb_ape_alq))
                        .addGap(33, 33, 33)
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtapellido)))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(lb_dni_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnhuesped)
                            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                                .addComponent(btnbuscar_h)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexplorar)))))
                .addGap(44, 44, 44))
        );
        panel_dt_huespLayout.setVerticalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dni_alq)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_h)
                    .addComponent(btnexplorar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhuesped)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nom_alq)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ape_alq)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        panel_dt_hab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N

        lb_num_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_num_hab_alq.setText("N° Habitación:");

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_tip_hab_alq.setText("Tipo:");

        txttipoha.setEditable(false);
        txttipoha.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        txtnumeroha.setEditable(false);
        txtnumeroha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnumeroha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumerohaActionPerformed(evt);
            }
        });

        btnbuscar_th.setText("Buscar");
        btnbuscar_th.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_thActionPerformed(evt);
            }
        });

        txtnumeroca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnumeroca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumerocaKeyTyped(evt);
            }
        });

        lb_num_camas_hab_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq1.setText("N° Camas: ");

        lb_num_camas_hab_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq.setText("Monto Diario:");

        txtmonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_habLayout = new javax.swing.GroupLayout(panel_dt_hab);
        panel_dt_hab.setLayout(panel_dt_habLayout);
        panel_dt_habLayout.setHorizontalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dt_habLayout.createSequentialGroup()
                                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_num_hab_alq)
                                    .addComponent(lb_tip_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_habLayout.createSequentialGroup()
                                .addComponent(lb_num_camas_hab_alq1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_habLayout.createSequentialGroup()
                                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txttipoha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dt_habLayout.createSequentialGroup()
                                        .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnbuscar_th)))
                                .addGap(27, 27, 27))))
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addComponent(lb_num_camas_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel_dt_habLayout.setVerticalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_num_hab_alq)
                    .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_th))
                .addGap(11, 11, 11)
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(txttipoha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_num_camas_hab_alq1)
                    .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_num_camas_hab_alq))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Miembros en la habitación"));

        txtdni_mi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdni_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdni_miKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("DNI:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombres:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Apellidos:");

        txtapellido_mi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtapellido_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellido_miKeyTyped(evt);
            }
        });

        txtnombre_mi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnombre_mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombre_miActionPerformed(evt);
            }
        });
        txtnombre_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre_miKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Fech. Nacimiento");

        txtciudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciudadKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Ciudad Origen:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Estado Civil:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("País:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Teléfono:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Ocupación:");

        cmbestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No se sabe", "Casado", "Soltero", "Viudo", "Divorciado" }));

        txtpais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaisKeyTyped(evt);
            }
        });

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        txtocupacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtocupacionKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Dirección:");

        txtdireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btneliminart.setText("Eliminar Todo");
        btneliminart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminart, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtapellido_mi, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtnombre_mi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbestadocivil, 0, 122, Short.MAX_VALUE)
                        .addComponent(txtciudad)
                        .addComponent(txtpais)
                        .addComponent(txtocupacion)
                        .addComponent(txttelefono)
                        .addComponent(txtdireccion))
                    .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdni_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdni_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellido_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_det.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_det);

        panel_dt_alq.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Alquiler"));
        panel_dt_alq.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lb_id_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq.setText("Nº alquiler:");

        lb_fech_lleg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg.setText("Fecha Llegada:");

        lb_fech_sal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_sal.setText("Fecha Salida:");

        lb_obs_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_alq.setText("Observación: ");

        lb_id_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep.setText("Recepcionista:");

        txtidalquiler.setEditable(false);
        txtidalquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidalquilerActionPerformed(evt);
            }
        });

        txtllegada.setEditable(false);
        txtllegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtllegadaActionPerformed(evt);
            }
        });
        txtllegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtllegadaKeyTyped(evt);
            }
        });

        txtobservacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtobservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobservacionKeyTyped(evt);
            }
        });

        txtusuario.setEditable(false);

        javax.swing.GroupLayout panel_dt_alqLayout = new javax.swing.GroupLayout(panel_dt_alq);
        panel_dt_alq.setLayout(panel_dt_alqLayout);
        panel_dt_alqLayout.setHorizontalGroup(
            panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_alqLayout.createSequentialGroup()
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_dt_alqLayout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dt_alqLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_dt_alqLayout.createSequentialGroup()
                                    .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_obs_alq)
                                        .addComponent(lb_id_alq)
                                        .addComponent(lb_fech_lleg)
                                        .addComponent(lb_fech_sal))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panel_dt_alqLayout.createSequentialGroup()
                                    .addComponent(lb_id_recep)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_dt_alqLayout.setVerticalGroup(
            panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_alqLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_alq)
                    .addComponent(txtidalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_fech_lleg)
                    .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_fech_sal)
                    .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_recep)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_obs_alq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnsalir)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_dt_alq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dt_alq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_dt_hab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_dt_hab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TIPEO DNI
        int numerocaracteres=8;
        char c = evt.getKeyChar();       
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtdni.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_txtdniKeyTyped

    private void btnbuscar_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_hActionPerformed
        // boton buscar huesped
        if (txtdni.getText().length()!=8){
            JOptionPane.showMessageDialog(null,"Ingrese DNI Completo");
            txtnombre.setText(null);
            txtapellido.setText(null);
        }
        else
        {
            txtnombre.setText(null);
            txtapellido.setText(null);
            String dni= (txtdni.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombre_h,apellidos_h,id_huesped "
                        + "FROM huesped where dni_huesped='"+dni+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombre.setText(rs1.getString("nombre_h"));
                    txtapellido.setText(rs1.getString("apellidos_h"));
                    id_huesped_huesped=rs1.getString("id_huesped");
                }
                if (txtnombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"DNI no encontrado, por favor registre al cliente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    txtdni.setText(null);
                }else{
                    //desbloqueo
                    btnhuesped.setEnabled(false);                    
                    spinner.setEnabled(true);//enabled spinner
                    txtdni.setEditable(false);
                    btnguardar.setEnabled(true);
                    //txtnumeroha.setEnabled(true);
                    //txttipoha.setEnabled(true);
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        }
    }//GEN-LAST:event_btnbuscar_hActionPerformed

    private void txtnumerohaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumerohaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumerohaActionPerformed

    private void btnbuscar_thActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_thActionPerformed
        //boton buscar // mostrar_seleccion_habitacion();       
        btnhuesped.setEnabled(false);  
        btnguardar.setEnabled(true);
        btnbuscar_h.setEnabled(false);
        btnexplorar.setEnabled(false);
        txtdni.setEditable(false);
       
        totalpersonas=Integer.parseInt(spinner.getValue().toString());
        if(totalpersonas>0){    
            cantidadpersonas=totalpersonas;
            seleccion_ha=new seleccion_habitacion(this,true);
            seleccion_ha.setVisible(true);
            spinner.setEnabled(false);//spinner desanilidado
            txtnumeroca.setEnabled(true);
            txtidalquiler.setEnabled(true);
            txtllegada.setEnabled(true);
            txtsalida.setEnabled(true);
            txtusuario.setEnabled(true);
            txtmonto.setEnabled(true);
            btnguardar.setEnabled(true);
            txtobservacion.setEnabled(true);

            if(totalpersonas>=2){                
                btnagregar.setEnabled(true);                
                bloquearcampoingreso(1);//desbloqueando campos                
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa número válido de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnbuscar_thActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // boton nuevo
        limpiar(); 
        btnnuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // boton salir
        cc.desconectar();
        bandera_alquiler=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // boton guardar
        if(txtdni.getText().length()!=8){
            JOptionPane.showMessageDialog(null,"Elija Huésped","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(totalpersonas<1){
            JOptionPane.showMessageDialog(null,"Ingresa Cantidas de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtnumeroca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Cantidad de camas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtmonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Monto Total","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtidalquiler.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"No existe ID_Alquiler","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtllegada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Error al Obtener Fecha de llegada","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtsalida.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingresa Fecha Salida","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtusuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Error al obtener Usuario ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttipoha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Elije habitacion","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if((totalpersonas>1) && ((tb_det.getRowCount()+1)!=totalpersonas)){
            JOptionPane.showMessageDialog(null,"Completa la Tabla de Huespedes en esta habitación","ERROR",JOptionPane.ERROR_MESSAGE);
        }else
        {
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fech = new Date();
            String ll= myFormat.format(fech);        
            String sa = fecha.getFecha(txtsalida); 
            double montoneto=0,intmonto=0;
            int numdias=0;
            try {
                Date date1 = myFormat.parse(ll);
                Date date2 = myFormat.parse(sa);
                long diff = date2.getTime() - date1.getTime();
                System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                String dias=String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                numdias=Integer.parseInt(dias);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            intmonto=Double.parseDouble(txtmonto.getText());
            montoneto=numdias*intmonto;
            
            try
            {
                PreparedStatement pst=cn.prepareStatement("INSERT INTO alquila(id_alquila,huesped_id_huesped,"
                        + "usuario_id_usuario,fecha_llegada,fecha_salida,num_dias,num_camas,observacion,monto_total,"
                        + "habitacion_id_habitacion) VALUES (?,?,?,?,?,?,?,?,?,?)");
                //pst.setString(1,txtnumeroha.getText());
                pst.setString(1,txtidalquiler.getText());//id alquiler                
                pst.setString(2,id_huesped_huesped);
                pst.setString(3,txtusuario.getText());
                pst.setString(4,txtllegada.getText());
                pst.setString(5,fecha.getFecha(txtsalida));//fecha salida
                pst.setString(6,String.valueOf(numdias));//num dias// corregir
                pst.setString(7,txtnumeroca.getText());//num camas
                pst.setString(8,txtobservacion.getText());
                pst.setString(9,String.valueOf(montoneto));//monto total, corregir!!
                pst.setString(10,id_habitacion_seleccion);
                
                int a=pst.executeUpdate();
                if(a>0){
                    System.out.println("Registro exitoso en Alquila");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al agregar en Alquila ","Error",1);
                }              
                //
                //String habb=txtnumeroha.getText();
                PreparedStatement pst1=cn.prepareStatement("UPDATE habitacion"
                        + " SET estado='Ocupado' WHERE id_habitacion='"+id_habitacion_seleccion+"'");
                int b=pst1.executeUpdate();                
                if(b>0){
                    System.out.println("Actualizacion exitosa en Habitacion");                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al actualizar habitación ","Error",1);
                } 
                int c=1;
                ////  actualizar tabla detalle              
                if(totalpersonas>1)
                {
                    c=0;//sirve para dar mensaje de confirmacion
                    try 
                    {
                        String id="";
                        ResultSet rsa;
                        int cont;
                        for(int i=0;i<tb_det.getRowCount();i++)
                        {
                            Statement sent = cn.createStatement();   
                            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_detalle AS UNSIGNED)), 0) codigoExterno FROM detalle_alquila");                                
                            while(rsa.next()){
                                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                                id=(String.valueOf(cont));                                    
                            }/////detalle de alquiler
                            PreparedStatement pst2=cn.prepareStatement("INSERT INTO detalle_alquila"
                                    + "(id_detalle,Nombres,Apellidos,dni,nacimiento,ciudad,estado_civil,pais,telefono,"
                                    + "ocupacion,direccion,alquila_id_alquila) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");                               
                            /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/
                            pst2.setString(1,id);// id detalle                              
                            pst2.setString(2,tb_det.getValueAt(i,0).toString());//nombre
                            pst2.setString(3,tb_det.getValueAt(i,1).toString());//apellido
                            pst2.setString(4,tb_det.getValueAt(i,2).toString());//dni
                            pst2.setString(5,tb_det.getValueAt(i,3).toString());//
                            pst2.setString(6,tb_det.getValueAt(i,4).toString());//
                            pst2.setString(7,tb_det.getValueAt(i,5).toString());//estado civil
                            pst2.setString(8,tb_det.getValueAt(i,6).toString());//
                            pst2.setString(9,tb_det.getValueAt(i,7).toString());//telefono
                            pst2.setString(10,tb_det.getValueAt(i,8).toString());//
                            pst2.setString(11,tb_det.getValueAt(i,9).toString());//direccion
                            pst2.setString(12,txtidalquiler.getText());//id alquiler                           
                            c=pst2.executeUpdate();
                            if(c>0){
                                System.out.println("Registro exitoso en detalle_alquiler");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Error al agregar ","Error",1);
                            }                                
                        }//fin for                            
                    } catch (Exception e) {
                       System.out.println("no se pudo actualizar detalle alquiler: "+e.getMessage());
                    }//fin trycatch
                }// fin if para detalle alquiler                
                if((a>0)&&(b>0)&&(c>0)){
                    JOptionPane.showMessageDialog(null,"Registro Exitoso","FELICITACIONES",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al agregar ");
                }
                btnnuevo();
                eliminarelementos(); 
                bloqueorestantes();///fin de todos los insert
               
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "error al agegar datos en alquila y detalle " +e);
            }//fin trycatch
        }//fn else 
        ///
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtllegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtllegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtllegadaActionPerformed

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped
        // monto total      
        int numerocaracteres=7;      
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if(txtmonto.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }       
    }//GEN-LAST:event_txtmontoKeyTyped

    private void txtobservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobservacionKeyTyped
        // observacion        
        int numerocaracteres=35;        
        if(txtobservacion.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtobservacionKeyTyped

    private void txtnumerocaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerocaKeyTyped
        // camas
        char c = evt.getKeyChar();
        int numerocaracteres=1;
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtnumeroca.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnumerocaKeyTyped

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // boton agregar
        if(txtnombre_mi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Nombre");
        }else if(txtapellido_mi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Apellidos");
        }else if (txtdni_mi.getText().length()!=8) {
            JOptionPane.showMessageDialog(null,"Ingrese DNI Completo","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtnacimiento.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingrese Fecha de Nacimiento","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtciudad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingrese ciudad de origen","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtpais.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese país de origen","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttelefono.getText().length()>0 && txttelefono.getText().length()<9){
            JOptionPane.showMessageDialog(null,"Ingrese Teléfono correctamente","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
             /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/  
            String []Dato=new String [10];
            Dato[0]=txtnombre_mi.getText();
            Dato[1]=txtapellido_mi.getText();
            Dato[2]=txtdni_mi.getText();
            Dato[3]=fecha.getFecha(txtnacimiento);        
            Dato[4]=txtciudad.getText();
            Dato[5]=((String) cmbestadocivil.getSelectedItem());
            Dato[6]=txtpais.getText();
            Dato[7]=txttelefono.getText();
            Dato[8]=txtocupacion.getText();
            Dato[9]=txtdireccion.getText();                
            ///limpiando campos
            limpiaringresohuesped();
            btnbuscar_th.setEnabled(false);
            modelo.addRow(Dato);
            //
            btneditar.setEnabled(true);
            btnactualizar.setEnabled(false);
            btneliminar.setEnabled(true);
            btneliminart.setEnabled(true);
            //
            cantidadpersonas=cantidadpersonas-1;
            if(cantidadpersonas<=1){
                btnagregar.setEnabled(false);
                //bloqueando campos
                bloquearcampoingreso(0);
                btnactualizar.setEnabled(false);
            }            
        }     
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // btn eliminar
        int filasel=tb_det.getSelectedRow();
        if(filasel>=0){
            modelo.removeRow(filasel);
            cantidadpersonas=cantidadpersonas+1;            
            bloquearcampoingreso(1);//desbloquenado campos
            btnagregar.setEnabled(true);               
        }else{
            JOptionPane.showMessageDialog(null,"Elije registro para eliminar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btneliminartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartActionPerformed
        // boton eliminar todos elementos
        eliminarelementos(); 
        btnagregar.setEnabled(true);
        btneditar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);        
        bloquearcampoingreso(1);           
    }//GEN-LAST:event_btneliminartActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // Actualizar
        if(txtnombre_mi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Nombre");
        }else if(txtapellido_mi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Apellidos");
        }else if (txtdni_mi.getText().length()!=8) {
            JOptionPane.showMessageDialog(null,"Ingrese DNI","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtnacimiento.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingrese Fecha de Nacimiento","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtciudad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingrese Ciudad de Origen","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtpais.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese País de Origen","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{        
            /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/
            modelo.setValueAt(txtnombre_mi.getText(), seleccionado, 0);
            modelo.setValueAt(txtapellido_mi.getText(), seleccionado, 1);
            modelo.setValueAt(txtdni_mi.getText(), seleccionado, 2);
            modelo.setValueAt(fecha.getFecha(txtnacimiento), seleccionado, 3);
            modelo.setValueAt(txtciudad.getText(), seleccionado, 4);
            modelo.setValueAt(((String) cmbestadocivil.getSelectedItem()), seleccionado, 5);
            modelo.setValueAt(txtpais.getText(), seleccionado, 6);
            modelo.setValueAt(txttelefono.getText(), seleccionado, 7);
            modelo.setValueAt(txtocupacion.getText(), seleccionado, 8);
            modelo.setValueAt(txtdireccion.getText(), seleccionado, 9);
            //poner resetear
            limpiaringresohuesped();
            btneditar.setEnabled(true);
            btnactualizar.setEnabled(false);
            btneliminar.setEnabled(true);
            btneliminart.setEnabled(true);
            btnagregar.setEnabled(true);
            if(cantidadpersonas<=1){
                ///bloqueando campos
                bloquearcampoingreso(0);            
                btnagregar.setEnabled(false); 
            }
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtidalquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidalquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidalquilerActionPerformed

    private void btnhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuespedActionPerformed
        // boton nuevo huesped
       
        String bandera=huesped.bandera_huesped;
        try{            
            if(bandera==null){            
                huesped a= new huesped();
                this.getDesktopPane().add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
        
    }//GEN-LAST:event_btnhuespedActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando ventana
        bandera_alquiler=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // boton editar
        seleccionado=tb_det.getSelectedRow();
        if(seleccionado>-1){
            /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/
            txtnombre_mi.setText(tb_det.getValueAt(seleccionado,0).toString());
            txtapellido_mi.setText(tb_det.getValueAt(seleccionado,1).toString());
            txtdni_mi.setText(tb_det.getValueAt(seleccionado,2).toString());
            ////poner fecha
            txtciudad.setText(tb_det.getValueAt(seleccionado,4).toString());
            cmbestadocivil.setSelectedItem(tb_det.getValueAt(seleccionado, 5).toString());
            txtpais.setText(tb_det.getValueAt(seleccionado,6).toString());
            txttelefono.setText(tb_det.getValueAt(seleccionado,7).toString());
            txtocupacion.setText(tb_det.getValueAt(seleccionado,8).toString());
            txtdireccion.setText(tb_det.getValueAt(seleccionado,9).toString());
            //////////            
            bloquearcampoingreso(1);//desb campos            
            btnagregar.setEnabled(false); 
            /////
            btneditar.setEnabled(false);
            btnactualizar.setEnabled(true);
            btneliminar.setEnabled(false);
            btneliminart.setEnabled(false);           
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void txtllegadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtllegadaKeyTyped
        // fecha llegada        
        int numerocaracteres=20;        
        if(txtllegada.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtllegadaKeyTyped

    private void txtdni_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdni_miKeyTyped
        // dni de miembro habitacion
        char c = evt.getKeyChar();
        int numerocaracteres=8;
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }
        
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtdni_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdni_miKeyTyped

    private void txtnombre_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre_miKeyTyped
        // nombre miembro habitacion
        int numerocaracteres=20;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtnombre_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_txtnombre_miKeyTyped

    private void txtapellido_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellido_miKeyTyped
        // apellido de miembro habitacion
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtapellido_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtapellido_miKeyTyped

    private void btnexplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexplorarActionPerformed
        // Boton explorar
        elegir_h=new elegir_huesped(this,true);
        elegir_h.setVisible(true);                
        spinner.setEnabled(true);//set enable spinner
        txtdni.setEditable(false);
        System.out.println("el ide huesped regresado: "+id_huesped_huesped);        
    }//GEN-LAST:event_btnexplorarActionPerformed

    private void txtciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciudadKeyTyped
        // typo dato CIUDAD
        int numerocaracteres=15;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtciudad.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtciudadKeyTyped

    private void txtpaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaisKeyTyped
        // CLIC EN PAIS
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtpais.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtpaisKeyTyped

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        // oCUPACION
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtocupacion.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtocupacionKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // DIRECCION
        int numerocaracteres=30;
        if(txtdireccion.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=9;
        char c = evt.getKeyChar();       
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }
        if ((int)
                evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txttelefono.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        // cambio en spinner
        txtnumeroha.setEnabled(true);
        txttipoha.setEnabled(true);
        //txtnumeroha.setEnabled(true);
        //txttipoha.setEnabled(true);
        btnbuscar_th.setEnabled(true);
        //btnbuscarhabitacion.setEnabled(true);                  
        //txtalquiler.setEnabled(true);        
    }//GEN-LAST:event_spinnerStateChanged

    private void txtnombre_miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombre_miActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre_miActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar_h;
    private javax.swing.JButton btnbuscar_th;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminart;
    private javax.swing.JButton btnexplorar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnhuesped;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cmbestadocivil;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ape_alq;
    private javax.swing.JLabel lb_dni_alq;
    private javax.swing.JLabel lb_fech_lleg;
    private javax.swing.JLabel lb_fech_sal;
    private javax.swing.JLabel lb_id_alq;
    private javax.swing.JLabel lb_id_recep;
    private javax.swing.JLabel lb_nom_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq1;
    private javax.swing.JLabel lb_num_hab_alq;
    private javax.swing.JLabel lb_obs_alq;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JPanel panel_dt_alq;
    private javax.swing.JPanel panel_dt_hab;
    private javax.swing.JPanel panel_dt_huesp;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tb_det;
    public static javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtapellido_mi;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtdireccion;
    public static javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtdni_mi;
    private javax.swing.JTextField txtidalquiler;
    private javax.swing.JTextField txtllegada;
    public static javax.swing.JTextField txtmonto;
    private com.toedter.calendar.JDateChooser txtnacimiento;
    public static javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre_mi;
    public static javax.swing.JTextField txtnumeroca;
    public static javax.swing.JTextField txtnumeroha;
    private javax.swing.JTextField txtobservacion;
    private javax.swing.JTextField txtocupacion;
    private javax.swing.JTextField txtpais;
    private com.toedter.calendar.JDateChooser txtsalida;
    private javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txttipoha;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
