package interfaz;

import dominio.ContraseniaUtils;
import dominio.Persona;
import dominio.Sistema;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaMenuPrincipal extends javax.swing.JDialog {

    private Sistema sistema;
    private static String salt = ContraseniaUtils.generateSalt(512).get();

    public VentanaMenuPrincipal(Sistema unSistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sistema = unSistema;
        
        panelLogin = new JPanel();
        panelLogin.setBounds(55, 186, 678, 437);
        panelLogin.setBackground(new java.awt.Color(51, 51, 51));
        panel2.add(panelLogin);
        panelLogin.setLayout(null);
        
        txtMail = new JTextField();
        txtMail.setFont(new Font("Dialog", Font.PLAIN, 17));
        txtMail.setBounds(318, 125, 210, 31);
        panelLogin.add(txtMail);
        txtMail.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(318, 168, 210, 31);
        panelLogin.add(passwordField);
        
        JLabel lblMail = new JLabel("Mail");
        lblMail.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblMail.setForeground(new java.awt.Color(238, 238, 238));
        lblMail.setBounds(244, 132, 46, 16);
        panelLogin.add(lblMail);
        
        JLabel lblContrasea = new JLabel("Contraseña");
        lblContrasea.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblContrasea.setBounds(192, 173, 98, 16);
        lblContrasea.setForeground(new java.awt.Color(238, 238, 238));
        panelLogin.add(lblContrasea);
        
        lblNewLabel = new JLabel(""); 
        lblNewLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            iniciarSesion();
          }
        });
        
        ImageIcon loginImage = new ImageIcon(VentanaMenuPrincipal.class.getResource("/Imagenes/fotoDeUsuarioStandard.png"));
        Image resizedImage = getScaledImage(loginImage.getImage() , 40,40);
        lblNewLabel.setIcon(new ImageIcon(resizedImage));
        lblNewLabel.setBounds(299, 222, 42, 42);
        panelLogin.add(lblNewLabel);
        
        lblLogin = new JLabel("Login");
        lblLogin.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            iniciarSesion();
          }
        });
        
        lblLogin.setForeground(new java.awt.Color(238, 238, 238));
        lblLogin.setFont(new Font("Dialog", Font.PLAIN, 19));
        lblLogin.setBounds(353, 222, 56, 35);
        panelLogin.add(lblLogin);
        
        JPanel panelListados = new JPanel();
        panelListados.setBounds(55, 186, 678, 437);
        panelListados.setBackground(new java.awt.Color(51, 51, 51));
        panel2.add(panelListados);
        panelListados.setLayout(null);
        lblNombre1 = new javax.swing.JLabel();
        lblNombre1.setBounds(99, 16, 181, 38);
        panelListados.add(lblNombre1);
        panelListados.setVisible(false);
        
                lblNombre1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
                lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
                lblNombre1.setText("Usuario");
                lblNombre = new javax.swing.JLabel();
                lblNombre.setBounds(417, 16, 181, 38);
                panelListados.add(lblNombre);
                listaProfesionalesVentana = new javax.swing.JList();
                        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
                        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
                        lblNombre.setText("Profesional");
                        this.listaProfesionalesVentana.setListData(sistema.getListaProfesionales().toArray());
                        jScrollPane1 = new javax.swing.JScrollPane();
                        jScrollPane1.setBounds(390, 70, 230, 330);
                        panelListados.add(jScrollPane1);
                        
                        
                                listaProfesionalesVentana.setBackground(new java.awt.Color(51, 51, 51));
                                listaProfesionalesVentana.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
                                listaProfesionalesVentana.setForeground(new java.awt.Color(255, 255, 255));
                                listaProfesionalesVentana.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                                    public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                                        listaProfesionalesVentanaValueChanged(evt);
                                    }
                                });
                                listaUsuariosVentana = new javax.swing.JList();
                                jScrollPane1.setViewportView(listaProfesionalesVentana);
                                this.listaUsuariosVentana.setListData(sistema.getListaUsuarios().toArray());
                                jScrollPane2 = new javax.swing.JScrollPane();
                                jScrollPane2.setBounds(60, 70, 230, 330);
                                panelListados.add(jScrollPane2);
                                
                                
                                        listaUsuariosVentana.setBackground(new java.awt.Color(51, 51, 51));
                                        listaUsuariosVentana.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
                                        listaUsuariosVentana.setForeground(new java.awt.Color(255, 255, 255));
                                        listaUsuariosVentana.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                                        listaUsuariosVentana.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                                            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                                                listaUsuariosVentanaValueChanged(evt);
                                            }
                                        });
                                        jScrollPane2.setViewportView(listaUsuariosVentana);

        this.listaUsuariosVentana.setListData(sistema.getListaUsuarios().toArray());
        this.listaProfesionalesVentana.setListData(sistema.getListaProfesionales().toArray());
        
        
        
        addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {
                sistema.guardarDatosSistema();
                System.exit(0);

            }});

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagen5.png"));
        return retValue;
    }
    
    public void iniciarSesion() {
      String mail = txtMail.getText();
      String password = String.valueOf(passwordField.getPassword());
      
      int verify = sistema.setPersonaLogueadaConPassword(mail, password, salt);
      
      if (verify == 3) {
        JOptionPane.showMessageDialog(null, "Informacion de inicio incorrecto");
      } else if (verify == 2) {
        VentanaMenuPrincipalUsuario ventanaPrincipalUsuarios = new VentanaMenuPrincipalUsuario(sistema);
        this.setVisible(false);
        ventanaPrincipalUsuarios.setVisible(true);
      } else if (verify == 1) {
        this.setVisible(false);
        VentanaMenuPrincipalProfesional ventanaPrincipalProfesionales = new VentanaMenuPrincipalProfesional(sistema);
        ventanaPrincipalProfesionales.setVisible(true);
      }
    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
      BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = resizedImg.createGraphics();

      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(srcImg, 0, 0, w, h, null);
      g2.dispose();

      return resizedImg;
  }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema unSistema) {
        this.sistema = unSistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        lblTituloVentana = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        lblNuevoUsuario = new javax.swing.JLabel();
        lblIconoNuevoUsuario = new javax.swing.JLabel();
        btnAgregarUsuario = new javax.swing.JLabel();
        btnAgregarProfesional = new javax.swing.JLabel();
        btnAgregarProfesional1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1060, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1060, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(164, 211, 249));

        lblTituloVentana.setFont(new java.awt.Font("Segoe Script", 1, 50)); // NOI18N
        lblTituloVentana.setForeground(new java.awt.Color(0, 51, 153));
        lblTituloVentana.setText("Broccoli");

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoBrocoli.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(lblTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(lblTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 270, 800);

        panel2.setBackground(new java.awt.Color(51, 51, 51));
        panel2.setForeground(new java.awt.Color(51, 51, 51));
        panel2.setLayout(null);

        lblNuevoUsuario.setFont(new java.awt.Font("Levenim MT", 0, 65)); // NOI18N
        lblNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoUsuario.setText("Inicio de Sesión");
        panel2.add(lblNuevoUsuario);
        lblNuevoUsuario.setBounds(203, 36, 530, 91);

        lblIconoNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoDeUsuarioStandard.png"))); // NOI18N
        panel2.add(lblIconoNuevoUsuario);
        lblIconoNuevoUsuario.setBounds(85, 27, 100, 100);

        btnAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoAgregarUsuario.png"))); // NOI18N
        btnAgregarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarUsuarioMouseClicked(evt);
            }
        });
        panel2.add(btnAgregarUsuario);
        btnAgregarUsuario.setBounds(171, 649, 110, 90);

        btnAgregarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoAgregarProf.png"))); // NOI18N
        btnAgregarProfesional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarProfesionalMouseClicked(evt);
            }
        });
        panel2.add(btnAgregarProfesional);
        btnAgregarProfesional.setBounds(569, 689, 50, 80);

        btnAgregarProfesional1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoAgregarProfesional.png"))); // NOI18N
        btnAgregarProfesional1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarProfesional1MouseClicked(evt);
            }
        });
        panel2.add(btnAgregarProfesional1);
        btnAgregarProfesional1.setBounds(509, 649, 100, 90);

        getContentPane().add(panel2);
        panel2.setBounds(275, 0, 950, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.sistema.guardarDatosSistema();
    }//GEN-LAST:event_formWindowClosing

    private void listaUsuariosVentanaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaUsuariosVentanaValueChanged
        this.sistema.setPersonaLogueada((Persona) listaUsuariosVentana.getSelectedValue());
        VentanaMenuPrincipalUsuario ventanaPrincipalUsuarios = new VentanaMenuPrincipalUsuario(sistema);
        this.setVisible(false);
        ventanaPrincipalUsuarios.setVisible(true);
    }//GEN-LAST:event_listaUsuariosVentanaValueChanged

    private void listaProfesionalesVentanaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProfesionalesVentanaValueChanged
        this.sistema.setPersonaLogueada((Persona) listaProfesionalesVentana.getSelectedValue());
        VentanaMenuPrincipalProfesional ventanaPrincipalProfesionales = new VentanaMenuPrincipalProfesional(sistema);
        this.setVisible(false);
        ventanaPrincipalProfesionales.setVisible(true);
    }//GEN-LAST:event_listaProfesionalesVentanaValueChanged

    private void btnAgregarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioMouseClicked
        VentanaRegistrarUsuario unA = new VentanaRegistrarUsuario(sistema);
        this.setVisible(false);
        unA.setVisible(true);
    }//GEN-LAST:event_btnAgregarUsuarioMouseClicked

    private void btnAgregarProfesionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarProfesionalMouseClicked
        VentanaRegistrarProfesional ventanaRegProfesional = new VentanaRegistrarProfesional(sistema);
        this.setVisible(false);
        ventanaRegProfesional.setVisible(true);
    }//GEN-LAST:event_btnAgregarProfesionalMouseClicked

    private void btnAgregarProfesional1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarProfesional1MouseClicked
        VentanaRegistrarProfesional ventanaRegProfesional = new VentanaRegistrarProfesional(sistema);
        this.setVisible(false);
        ventanaRegProfesional.setVisible(true);
    }//GEN-LAST:event_btnAgregarProfesional1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarProfesional;
    private javax.swing.JLabel btnAgregarProfesional1;
    private javax.swing.JLabel btnAgregarUsuario;
    private javax.swing.JLabel icono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIconoNuevoUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JLabel lblTituloVentana;
    private javax.swing.JList listaProfesionalesVentana;
    private javax.swing.JList listaUsuariosVentana;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private JPanel panelLogin;
    private JTextField txtMail;
    private JPasswordField passwordField;
    private JLabel lblNewLabel;
    private JLabel lblLogin;
}
