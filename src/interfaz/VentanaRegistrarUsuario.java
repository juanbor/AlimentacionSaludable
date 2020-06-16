package interfaz;

import dominio.ContraseniaUtils;
import dominio.Ingesta;
import dominio.Sistema;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import datechooser.events.SelectionChangedListener;
import datechooser.events.SelectionChangedEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaRegistrarUsuario extends javax.swing.JDialog {

    private Sistema sistema;
    private ImageIcon fotoDePerfilActual;
    private boolean primeraVez;
    private String fechaHoy;
    private static String salt = ContraseniaUtils.generateSalt(512).get();
    private Calendar fechaNac = new GregorianCalendar();

    public VentanaRegistrarUsuario(Sistema unSistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sistema = unSistema;
        this.fotoDePerfilActual = new ImageIcon(getClass().getResource("/Imagenes/fotoDeUsuarioStandard.png"));
        this.primeraVez = true;
        ocultarEtiquetas();
        cargarListaPreferencias();
        cargarListaRestricciones();
        cargarListaPaises();
        Calendar fecha = new GregorianCalendar();
        this.dateChooserFechaNacimiento.setMaxDate(fecha);
        this.fechaHoy = this.dateChooserFechaNacimiento.getText();
        
        lblFechaNacErrorImg = new JLabel("");
        lblFechaNacErrorImg.setIcon(new ImageIcon(VentanaRegistrarUsuario.class.getResource("/Imagenes/iconoCampoIncorrecto.png")));
        lblFechaNacErrorImg.setBounds(533, 436, 32, 30);
        lblFechaNacErrorImg.setVisible(false);
        panel2.add(lblFechaNacErrorImg);
        
        lblFechaNacError = new JLabel("Debe ingresar una fecha");
        lblFechaNacError.setBounds(569, 436, 181, 26);
        lblFechaNacError.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
        lblFechaNacError.setForeground(new java.awt.Color(240, 128, 128));
        lblFechaNacError.setVisible(false);
        panel2.add(lblFechaNacError);
        
        lblRepetirContrasea = new JLabel();
        lblRepetirContrasea.setText("Repetir Contraseña");
        lblRepetirContrasea.setForeground(Color.WHITE);
        lblRepetirContrasea.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblRepetirContrasea.setBounds(31, 331, 290, 38);
        panel2.add(lblRepetirContrasea);
        
        lblContrasea = new JLabel();
        lblContrasea.setText("Contraseña");
        lblContrasea.setForeground(Color.WHITE);
        lblContrasea.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblContrasea.setBounds(31, 289, 181, 38);
        panel2.add(lblContrasea);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
        passwordField.setBounds(331, 293, 181, 34);
        panel2.add(passwordField);
        
        passwordField_1 = new JPasswordField();
        
        passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        passwordField_1.setBounds(333, 331, 181, 34);
        panel2.add(passwordField_1);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(VentanaRegistrarUsuario.class.getResource("/Imagenes/iconoCampoIncorrecto.png")));
        lblNewLabel.setForeground(new Color(102, 204, 0));
        lblNewLabel.setBounds(541, 331, 32, 44);
        lblNewLabel.setVisible(false);
        panel2.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("No coincide");
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 19));
        lblNewLabel_1.setForeground(new java.awt.Color(240, 128, 128));
        lblNewLabel_1.setBounds(581, 338, 169, 30);
        lblNewLabel_1.setVisible(false);
        panel2.add(lblNewLabel_1);
        
        JLabel lblMail = new JLabel();
        lblMail.setText("Mail");
        lblMail.setForeground(Color.WHITE);
        lblMail.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblMail.setBounds(31, 243, 171, 38);
        panel2.add(lblMail);
        
        txtMail = new JTextField();
        txtMail.addFocusListener(new FocusAdapter() {
          @Override
          public void focusLost(FocusEvent e) {
            validoMail();
          }
        });
        
        txtMail.setMaximumSize(new Dimension(6, 26));
        txtMail.setFont(new Font("Dialog", Font.PLAIN, 15));
        txtMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMail.setBackground(new Color(227, 227, 227));
        txtMail.setBounds(260, 252, 181, 30);
        panel2.add(txtMail);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(VentanaRegistrarUsuario.class.getResource("/Imagenes/iconoCampoIncorrecto.png")));
        lblNewLabel_2.setForeground(Color.CYAN);
        lblNewLabel_2.setBounds(460, 245, 32, 44);
        lblNewLabel_2.setVisible(false);
        panel2.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Dato vacío");
        lblNewLabel_3.setForeground(new java.awt.Color(240, 128, 128));
        lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 19));
        lblNewLabel_3.setBounds(500, 251, 195, 30);
        lblNewLabel_3.setVisible(false);
        panel2.add(lblNewLabel_3);
        this.primeraVez = false;
        
        
        fechaNac.setTime(sistema.getLastPickedDateBirth());
        dateChooserFechaNacimiento.setCurrent(fechaNac);
        dateChooserFechaNacimiento.setSelectedDate(fechaNac);
        
        
        addWindowListener(new WindowAdapter() {

          @Override
          public void windowClosing(WindowEvent e) {
              sistema.guardarDatosSistema();
              System.exit(0);

          }});
        

        passwordField_1.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            //String apellidoIngresado = this.txtApellido.getText();
            
          }
          
          @Override
          public void keyReleased(KeyEvent e) {
            setCamposPasswordCorrectoIncorrecto();
          }
        });
        
      }
    
    private void setCamposPasswordCorrectoIncorrecto() {
      boolean esValido = validarPassword();
      
      if (!esValido) {
          lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
          lblNewLabel.setText("");
          lblNewLabel.setVisible(true);
          lblNewLabel_1.setVisible(true);
      } else {
          lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoCorrecto.png")));
          lblNewLabel.setText("");
          lblNewLabel.setVisible(true);
          lblNewLabel_1.setVisible(false);
      }

        
        
    }

    private boolean validarPassword() {
      
      char[] pass1 = passwordField.getPassword();
      char[] pass2 = passwordField_1.getPassword();
      
      if (pass1.length != pass2.length)
        return false;
      
      for (int i = 0; i < pass1.length; i++) {
        if (pass1[i] != pass2[i])
          return false;
      }
      
      return true;
      
    }
    
    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema unSistema) {
        this.sistema = unSistema;
    }

    public ImageIcon getFotoDePerfilActual() {
        return fotoDePerfilActual;
    }

    public void setFotoDePerfilActual(ImageIcon unaFoto) {
        this.fotoDePerfilActual = unaFoto;
    }

    public boolean getPrimeraVezEnSistema() {
        return primeraVez;
    }

    public void setPrimeraVezEnSistema(boolean primera) {
        this.primeraVez = primera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        lblTituloVentana = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        lblNuevoUsuario = new javax.swing.JLabel();
        lblIconoNuevoUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblTxtPreferencias = new javax.swing.JLabel();
        rdBtnVerduras = new javax.swing.JRadioButton();
        rdBtnHarinas = new javax.swing.JRadioButton();
        rdBtnFrutas = new javax.swing.JRadioButton();
        rdBtnCarnesRojas = new javax.swing.JRadioButton();
        rdBtnCarnesBlancas = new javax.swing.JRadioButton();
        lblTxtRestricciones = new javax.swing.JLabel();
        rdBtnCeliaco = new javax.swing.JRadioButton();
        rdBtnDiabetes = new javax.swing.JRadioButton();
        rdBtnVegano = new javax.swing.JRadioButton();
        btnIngresarUsuarioASistema = new javax.swing.JButton();
        lblTxtNacionalidad = new javax.swing.JLabel();
        listaNacionalidad = new javax.swing.JComboBox<>();
        lblTxtFechaNac = new javax.swing.JLabel();
        rdBtnIntoleranteLactosa = new javax.swing.JRadioButton();
        dateChooserFechaNacimiento = new datechooser.beans.DateChooserCombo();
        dateChooserFechaNacimiento.addSelectionChangedListener(new SelectionChangedListener() {
          public void onSelectionChange(SelectionChangedEvent arg0) {
            lblFechaNacError.setVisible(false);
            lblFechaNacErrorImg.setVisible(false);
            lblDatosIncorrectos.setVisible(false);
          }
        });
        btnIngresarFotoPerfil = new javax.swing.JButton();
        lblValidarNombre = new javax.swing.JLabel();
        lblValidarApellido = new javax.swing.JLabel();
        lblValidarNacionalidad = new javax.swing.JLabel();
        lblDatosIncorrectos = new javax.swing.JLabel();
        lblNombreVacio = new javax.swing.JLabel();
        lblApellidoVacio = new javax.swing.JLabel();
        lblPaisVacio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1060, 800));
        setUndecorated(false);
        setResizable(false);
        setSize(new java.awt.Dimension(1060, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(164, 211, 249));
        panel1.setMaximumSize(new java.awt.Dimension(270, 800));

        lblTituloVentana.setFont(new java.awt.Font("Segoe Script", 1, 50)); // NOI18N
        lblTituloVentana.setForeground(new java.awt.Color(0, 51, 153));
        lblTituloVentana.setText("Broccoli");

        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoVolverAtras.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoBrocoli.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnHome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(116, 116, 116)
                .addComponent(lblTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 270, 800);

        panel2.setBackground(new java.awt.Color(51, 51, 51));
        panel2.setForeground(new java.awt.Color(51, 51, 51));
        panel2.setMaximumSize(new java.awt.Dimension(800, 800));
        panel2.setMinimumSize(new java.awt.Dimension(800, 800));
        panel2.setPreferredSize(new java.awt.Dimension(800, 800));
        panel2.setLayout(null);

        lblNuevoUsuario.setFont(new java.awt.Font("Levenim MT", 0, 65)); // NOI18N
        lblNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoUsuario.setText("Nuevo Usuario");
        panel2.add(lblNuevoUsuario);
        lblNuevoUsuario.setBounds(203, 36, 475, 91);

        lblIconoNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoDeUsuarioStandard.png"))); // NOI18N
        panel2.add(lblIconoNuevoUsuario);
        lblIconoNuevoUsuario.setBounds(85, 27, 100, 100);

        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        panel2.add(lblNombre);
        lblNombre.setBounds(31, 159, 181, 38);

        lblApellido.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido");
        panel2.add(lblApellido);
        lblApellido.setBounds(31, 201, 171, 38);

        txtNombre.setBackground(new java.awt.Color(227, 227, 227));
        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.setMaximumSize(new java.awt.Dimension(6, 26));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        panel2.add(txtNombre);
        txtNombre.setBounds(260, 168, 181, 30);

        txtApellido.setBackground(new java.awt.Color(227, 227, 227));
        txtApellido.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellido.setMaximumSize(new java.awt.Dimension(6, 26));
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        panel2.add(txtApellido);
        txtApellido.setBounds(260, 210, 181, 30);

        lblTxtPreferencias.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblTxtPreferencias.setForeground(new java.awt.Color(255, 255, 255));
        lblTxtPreferencias.setText("Preferencias");
        panel2.add(lblTxtPreferencias);
        lblTxtPreferencias.setBounds(31, 476, 265, 38);

        rdBtnVerduras.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnVerduras.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnVerduras.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnVerduras.setText("Preferencia 3");
        panel2.add(rdBtnVerduras);
        rdBtnVerduras.setBounds(31, 597, 195, 35);

        rdBtnHarinas.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnHarinas.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnHarinas.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnHarinas.setText("Preferencia 5");
        panel2.add(rdBtnHarinas);
        rdBtnHarinas.setBounds(31, 673, 153, 35);

        rdBtnFrutas.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnFrutas.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnFrutas.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnFrutas.setText("Preferencia 4");
        panel2.add(rdBtnFrutas);
        rdBtnFrutas.setBounds(31, 635, 153, 35);

        rdBtnCarnesRojas.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnCarnesRojas.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnCarnesRojas.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnCarnesRojas.setText("Preferencia 1");
        panel2.add(rdBtnCarnesRojas);
        rdBtnCarnesRojas.setBounds(31, 521, 218, 35);

        rdBtnCarnesBlancas.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnCarnesBlancas.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnCarnesBlancas.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnCarnesBlancas.setText("Preferencia 2");
        panel2.add(rdBtnCarnesBlancas);
        rdBtnCarnesBlancas.setBounds(31, 559, 209, 35);

        lblTxtRestricciones.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblTxtRestricciones.setForeground(new java.awt.Color(255, 255, 255));
        lblTxtRestricciones.setText("Restricciones");
        panel2.add(lblTxtRestricciones);
        lblTxtRestricciones.setBounds(460, 482, 208, 38);

        rdBtnCeliaco.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnCeliaco.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnCeliaco.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnCeliaco.setText("Restriccion 4");
        panel2.add(rdBtnCeliaco);
        rdBtnCeliaco.setBounds(460, 641, 145, 35);

        rdBtnDiabetes.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnDiabetes.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnDiabetes.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnDiabetes.setText("Restriccion 1");
        panel2.add(rdBtnDiabetes);
        rdBtnDiabetes.setBounds(460, 527, 175, 35);

        rdBtnVegano.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnVegano.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnVegano.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnVegano.setText("Restriccion 2");
        panel2.add(rdBtnVegano);
        rdBtnVegano.setBounds(460, 565, 145, 35);

        btnIngresarUsuarioASistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoConfirmar.png"))); // NOI18N
        btnIngresarUsuarioASistema.setBorderPainted(false);
        btnIngresarUsuarioASistema.setContentAreaFilled(false);
        btnIngresarUsuarioASistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarUsuarioASistemaActionPerformed(evt);
            }
        });
        panel2.add(btnIngresarUsuarioASistema);
        btnIngresarUsuarioASistema.setBounds(665, 688, 99, 94);

        lblTxtNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblTxtNacionalidad.setForeground(new java.awt.Color(255, 255, 255));
        lblTxtNacionalidad.setText("Nacionalidad");
        panel2.add(lblTxtNacionalidad);
        lblTxtNacionalidad.setBounds(31, 380, 204, 38);

        listaNacionalidad.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        listaNacionalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaNacionalidadItemStateChanged(evt);
            }
        });
        panel2.add(listaNacionalidad);
        listaNacionalidad.setBounds(261, 380, 270, 40);

        lblTxtFechaNac.setFont(new Font("Dialog", Font.PLAIN, 25)); // NOI18N
        lblTxtFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblTxtFechaNac.setText("Fecha de nacimiento");
        panel2.add(lblTxtFechaNac);
        lblTxtFechaNac.setBounds(31, 436, 328, 38);

        rdBtnIntoleranteLactosa.setBackground(new java.awt.Color(51, 51, 51));
        rdBtnIntoleranteLactosa.setFont(new Font("Dialog", Font.PLAIN, 16)); // NOI18N
        rdBtnIntoleranteLactosa.setForeground(new java.awt.Color(255, 255, 255));
        rdBtnIntoleranteLactosa.setText("Restriccion 3");
        rdBtnIntoleranteLactosa.setActionCommand("");
        panel2.add(rdBtnIntoleranteLactosa);
        rdBtnIntoleranteLactosa.setBounds(460, 603, 276, 35);

        dateChooserFechaNacimiento.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserFechaNacimiento.setFieldFont(new java.awt.Font("Century Gothic", java.awt.Font.PLAIN, 19));
    dateChooserFechaNacimiento.setMaxDate(new java.util.GregorianCalendar(2017, 10, 9));
    dateChooserFechaNacimiento.setMinDate(new java.util.GregorianCalendar(1917, 10, 1));
    panel2.add(dateChooserFechaNacimiento);
    dateChooserFechaNacimiento.setBounds(371, 436, 150, 30);

    btnIngresarFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregarFotoUsuario.png"))); // NOI18N
    btnIngresarFotoPerfil.setBorderPainted(false);
    btnIngresarFotoPerfil.setContentAreaFilled(false);
    btnIngresarFotoPerfil.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIngresarFotoPerfilActionPerformed(evt);
        }
    });
    panel2.add(btnIngresarFotoPerfil);
    btnIngresarFotoPerfil.setBounds(640, 160, 124, 117);

    lblValidarNombre.setForeground(new java.awt.Color(255, 255, 255));
    lblValidarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
    panel2.add(lblValidarNombre);
    lblValidarNombre.setBounds(460, 160, 32, 44);

    lblValidarApellido.setForeground(new java.awt.Color(255, 255, 255));
    lblValidarApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
    panel2.add(lblValidarApellido);
    lblValidarApellido.setBounds(461, 205, 32, 44);

    lblValidarNacionalidad.setForeground(new java.awt.Color(255, 255, 255));
    lblValidarNacionalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
    panel2.add(lblValidarNacionalidad);
    lblValidarNacionalidad.setBounds(541, 380, 32, 44);

    lblDatosIncorrectos.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
    lblDatosIncorrectos.setForeground(new java.awt.Color(255, 153, 153));
    lblDatosIncorrectos.setText("Aún quedan datos incorrectos");
    panel2.add(lblDatosIncorrectos);
    lblDatosIncorrectos.setBounds(320, 714, 341, 26);

    lblNombreVacio.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
    lblNombreVacio.setForeground(new java.awt.Color(240, 128, 128));
    lblNombreVacio.setText("Dato vacío");
    panel2.add(lblNombreVacio);
    lblNombreVacio.setBounds(500, 160, 134, 38);

    lblApellidoVacio.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
    lblApellidoVacio.setForeground(new java.awt.Color(240, 128, 128));
    lblApellidoVacio.setText("Dato vacío");
    panel2.add(lblApellidoVacio);
    lblApellidoVacio.setBounds(501, 205, 134, 38);

    lblPaisVacio.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
    lblPaisVacio.setForeground(new java.awt.Color(240, 128, 128));
    lblPaisVacio.setText("Dato vacío");
    panel2.add(lblPaisVacio);
    lblPaisVacio.setBounds(581, 380, 120, 38);

    getContentPane().add(panel2);
    panel2.setBounds(275, 0, 950, 800);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        VentanaMenuPrincipal vPrincipal = new VentanaMenuPrincipal(sistema);
        this.setVisible(false);
        vPrincipal.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed
    
    private int compareDates(String date1, String date2) {
      String[] date1Split = date1.split("/");
      String[] date2Split = date2.split("/");
      int[] date1Int = {Integer.parseInt(date1Split[0]), Integer.parseInt(date1Split[1]), Integer.parseInt(date1Split[2])};
      int[] date2Int = {Integer.parseInt(date2Split[0]), Integer.parseInt(date2Split[1]), Integer.parseInt(date2Split[2])};
      int ret;
      
      if (date1Int[2] > date2Int[2]) {
        ret = 1;
      } else if (date1Int[2] < date2Int[2]) {
        ret = -1;
      } else {
        if (date1Int[1] > date2Int[1]) {
          ret = 1;
        } else if (date1Int[1] < date2Int[1]) {
          ret = -1;
        } else {
          if (date1Int[0] > date2Int[0]) {
            ret = 1;
          } else if (date1Int[0] < date2Int[0]) {
            ret = -1;
          } else {
            ret = 0;
          }
        }
      }
      
      return ret;
    }

    private void btnIngresarUsuarioASistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarUsuarioASistemaActionPerformed
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        ArrayList<String> preferencias = new ArrayList<>();
        ArrayList<String> restricciones = new ArrayList<>();
        String nacionalidad = (String) this.listaNacionalidad.getSelectedItem();
        String fechaNacimiento = this.dateChooserFechaNacimiento.getText();
        sistema.setLastPickedDateBirth(dateChooserFechaNacimiento.getCurrent().getTime());
        String mail = this.txtMail.getText();
        char[] passwordChar = this.passwordField_1.getPassword();
        String passwordString = String.valueOf(passwordChar);
        Optional<String> key = ContraseniaUtils.hashPassword(passwordString, salt);
        
        if (nombre.equals("") || apellido.equals("") || nacionalidad.equals("Seleccione...") || emptyPassword() || !validarPassword() || !validoMail()) {
            this.lblDatosIncorrectos.setVisible(true);
            mostrarErrores(nombre, apellido, nacionalidad);
        }else if (compareDates(fechaNacimiento, this.fechaHoy) == 0) {
          this.lblDatosIncorrectos.setVisible(true);
          this.lblFechaNacError.setVisible(true);
          this.lblFechaNacErrorImg.setVisible(true);
        }else {
            this.lblDatosIncorrectos.setVisible(false);
            agregarPreferenciasUsuario(preferencias);
            agregarRestriccionesUsuario(restricciones);
            boolean seAgregoUsuario = this.getSistema().crearUsuario(nombre, apellido, fechaNacimiento, nacionalidad, mail, key.get());
            getSistema().cambiarFotoUsuario(mail, fotoDePerfilActual);
            getSistema().agregarListasUser(mail, preferencias, restricciones);
            if (seAgregoUsuario) {
                this.txtNombre.setText("");
                this.txtApellido.setText("");
                VentanaMenuPrincipal vPrincipal = new VentanaMenuPrincipal(sistema);
                this.setVisible(false);
                vPrincipal.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIngresarUsuarioASistemaActionPerformed
    
    private boolean validoMail() {
      if (txtMail.getText().equals("")) {
        lblNewLabel_3.setVisible(true);
        lblNewLabel_3.setText("Dato vacío");
        lblNewLabel_2.setVisible(true);
        lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
        return false;
      } else if(this.sistema.existeMailEnSistema(txtMail.getText())) {
        lblNewLabel_3.setVisible(true);
        lblNewLabel_3.setText("Mail ya registrado");
        lblNewLabel_2.setVisible(true);
        lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
        return false;
      } else {
        lblNewLabel_3.setVisible(false);
        lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoCorrecto.png"))); // NOI18N
        lblNewLabel_2.setVisible(true);
        return true;
      }
    }
    
    public boolean emptyPassword() {
      char[] pass1 = passwordField.getPassword();
      char[] pass2 = passwordField_1.getPassword();
      
      boolean ret = true;
      
      if ((pass1.length == 0) || (pass2.length == 0)) {
        lblNewLabel.setVisible(true);
        lblNewLabel_1.setVisible(true);
        lblNewLabel_1.setText("Campo vacío");
        lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
      } else {
        lblNewLabel.setVisible(false);
        lblNewLabel_1.setVisible(false);
        lblNewLabel_1.setText("No coincide");
        lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png"))); // NOI18N
        ret = false;
      }
      
      return ret;
      
    }

    private void btnIngresarFotoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarFotoPerfilActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter file = new FileNameExtensionFilter("PNG", "png");
        fileChooser.setFileFilter(file);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int imagen = fileChooser.showOpenDialog(this);
        if (imagen == JFileChooser.APPROVE_OPTION) {
            ImageIcon iconoPerfil = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
            this.btnIngresarFotoPerfil.setIcon(iconoPerfil);
            this.fotoDePerfilActual = iconoPerfil;
        }
    }//GEN-LAST:event_btnIngresarFotoPerfilActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        String nombreIngresado = this.txtNombre.getText();
        if (nombreIngresado.equals("")) {
            this.lblValidarNombre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
            this.lblValidarNombre.setVisible(true);
            this.lblNombreVacio.setVisible(true);
        } else {
            this.lblValidarNombre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoCorrecto.png")));
            this.lblValidarNombre.setVisible(true);
            this.lblNombreVacio.setVisible(false);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        String apellidoIngresado = this.txtApellido.getText();
        if (apellidoIngresado.equals("")) {
            this.lblValidarApellido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
            this.lblValidarApellido.setVisible(true);
            this.lblApellidoVacio.setVisible(true);
        } else {
            this.lblValidarApellido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoCorrecto.png")));
            this.lblValidarApellido.setVisible(true);
            this.lblApellidoVacio.setVisible(false);
        }
    }//GEN-LAST:event_txtApellidoFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.sistema.guardarDatosSistema();
    }//GEN-LAST:event_formWindowClosing

    private void listaNacionalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaNacionalidadItemStateChanged
        if (!this.primeraVez) {
            String nacionalidadIngresada = (String) listaNacionalidad.getSelectedItem();
            if (nacionalidadIngresada.equals("Seleccione...")) {
                this.lblValidarNacionalidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
                this.lblValidarNacionalidad.setVisible(true);
                this.lblPaisVacio.setVisible(true);
            } else {
                this.lblValidarNacionalidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoCorrecto.png")));
                this.lblValidarNacionalidad.setVisible(true);
                this.lblPaisVacio.setVisible(false);
            }
        }

    }//GEN-LAST:event_listaNacionalidadItemStateChanged

    void agregarRestriccionesUsuario(ArrayList<String> restricciones) {
        if (this.rdBtnCeliaco.isSelected()) {
            restricciones.add("Celíaco");
        }
        if (this.rdBtnDiabetes.isSelected()) {
            restricciones.add("Diabético");
        }
        if (this.rdBtnVegano.isSelected()) {
            restricciones.add("Veganismo");
        }
        if (this.rdBtnIntoleranteLactosa.isSelected()) {
            restricciones.add("Intolerancia a la lactosa");
        }
    }

    void agregarPreferenciasUsuario(ArrayList<String> preferencias) {
        if (this.rdBtnCarnesBlancas.isSelected()) {
            preferencias.add("Carnes Blancas");
        }
        if (this.rdBtnCarnesRojas.isSelected()) {
            preferencias.add("Carnes Rojas");
        }
        if (this.rdBtnFrutas.isSelected()) {
            preferencias.add("Frutas");
        }
        if (this.rdBtnVerduras.isSelected()) {
            preferencias.add("Verduras");
        }
        if (this.rdBtnHarinas.isSelected()) {
            preferencias.add("Harinas");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnIngresarFotoPerfil;
    private javax.swing.JButton btnIngresarUsuarioASistema;
    private datechooser.beans.DateChooserCombo dateChooserFechaNacimiento;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoVacio;
    private javax.swing.JLabel lblDatosIncorrectos;
    private javax.swing.JLabel lblIconoNuevoUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreVacio;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JLabel lblPaisVacio;
    private javax.swing.JLabel lblTituloVentana;
    private javax.swing.JLabel lblTxtFechaNac;
    private javax.swing.JLabel lblTxtNacionalidad;
    private javax.swing.JLabel lblTxtPreferencias;
    private javax.swing.JLabel lblTxtRestricciones;
    private javax.swing.JLabel lblValidarApellido;
    private javax.swing.JLabel lblValidarNacionalidad;
    private javax.swing.JLabel lblValidarNombre;
    private javax.swing.JComboBox<String> listaNacionalidad;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JRadioButton rdBtnCarnesBlancas;
    private javax.swing.JRadioButton rdBtnCarnesRojas;
    private javax.swing.JRadioButton rdBtnCeliaco;
    private javax.swing.JRadioButton rdBtnDiabetes;
    private javax.swing.JRadioButton rdBtnFrutas;
    private javax.swing.JRadioButton rdBtnHarinas;
    private javax.swing.JRadioButton rdBtnIntoleranteLactosa;
    private javax.swing.JRadioButton rdBtnVegano;
    private javax.swing.JRadioButton rdBtnVerduras;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel lblFechaNacError;
    private javax.swing.JLabel lblFechaNacErrorImg;
    private JLabel lblRepetirContrasea;
    private JLabel lblContrasea;
    private JLabel lblNewLabel_2;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField txtMail;
    private JLabel lblNewLabel_3;
    // End of variables declaration//GEN-END:variables

    private void ocultarEtiquetas() {
        this.lblValidarNombre.setVisible(false);
        this.lblValidarApellido.setVisible(false);
        this.lblValidarNacionalidad.setVisible(false);
        this.lblDatosIncorrectos.setVisible(false);
        this.lblNombreVacio.setVisible(false);
        this.lblApellidoVacio.setVisible(false);
        this.lblPaisVacio.setVisible(false);
    }

    private void cargarListaPreferencias() {
        Sistema.Preferencias[] listaPreferencias = new Sistema.Preferencias[5];
        listaPreferencias[0] = Sistema.Preferencias.CARNESBLANCAS;
        listaPreferencias[1] = Sistema.Preferencias.CARNESROJAS;
        listaPreferencias[2] = Sistema.Preferencias.FRUTAS;
        listaPreferencias[3] = Sistema.Preferencias.HARINAS;
        listaPreferencias[4] = Sistema.Preferencias.VERDURAS;
        for (int i = 0; i < listaPreferencias.length; i++) {
            if (i == 0) {
                this.rdBtnCarnesRojas.setText("Carnes Rojas");
            }
            if (i == 1) {
                this.rdBtnCarnesBlancas.setText("Carnes Blancas");
            }
            if (i == 2) {
                this.rdBtnFrutas.setText("Frutas");
            }
            if (i == 3) {
                this.rdBtnHarinas.setText("Harinas");
            }
            if (i == 4) {
                this.rdBtnVerduras.setText("Verduras");
            }
        }
    }

    private void cargarListaRestricciones() {
        Sistema.Restricciones[] listaRestricciones = new Sistema.Restricciones[4];
        listaRestricciones[0] = Sistema.Restricciones.CELIAQUIA;
        listaRestricciones[1] = Sistema.Restricciones.DIABETES;
        listaRestricciones[2] = Sistema.Restricciones.INTOLERANCIALACTOSA;
        listaRestricciones[3] = Sistema.Restricciones.VEGANISMO;
        for (int i = 0; i < listaRestricciones.length; i++) {
            if (i == 0) {
                this.rdBtnCeliaco.setText("Celiaquía");
            }
            if (i == 1) {
                this.rdBtnDiabetes.setText("Diabetes");
            }
            if (i == 2) {
                this.rdBtnIntoleranteLactosa.setText("Intolerante a la lactosa");
            }
            if (i == 3) {
                this.rdBtnVegano.setText("Veganismo");
            }
        }
    }

    private void cargarListaPaises() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<String> nacionalidaesEnSistema = sistema.devolverListaPaises();
        this.listaNacionalidad.setModel(modelo);
        this.listaNacionalidad.addItem("Seleccione...");
        for (int i = 0; i < nacionalidaesEnSistema.size(); i++) {
            this.listaNacionalidad.addItem(nacionalidaesEnSistema.get(i));
        }
    }

    private void mostrarErrores(String nombre, String apellido, String nacionalidad) {
        if (nombre.equals("")) {
            this.lblValidarNombre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
            this.lblValidarNombre.setVisible(true);
            this.lblNombreVacio.setVisible(true);
        }
        if (apellido.equals("")) {
            this.lblValidarApellido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
            this.lblValidarApellido.setVisible(true);
            this.lblApellidoVacio.setVisible(true);
        }
        if (nacionalidad.equals("Seleccione...")) {
            this.lblValidarNacionalidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoCampoIncorrecto.png")));
            this.lblValidarNacionalidad.setVisible(true);
            this.lblPaisVacio.setVisible(true);
        }
        validoMail();
        emptyPassword();
        if (!validarPassword()) {
          lblNewLabel.setVisible(true);
          lblNewLabel_1.setVisible(true);
          lblNewLabel_1.setText("No coincide");
        }
    }
}
