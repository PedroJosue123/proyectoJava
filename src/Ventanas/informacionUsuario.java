/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;
import Clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
public class informacionUsuario extends javax.swing.JFrame {
String usuario = "", user_update = "";
int id;
    public informacionUsuario() {
        initComponents();
        usuario= Login.usuario;
        user_update =  gestionar_usuarios.user_update;
        setSize(650,450);
        setResizable(false);
        setTitle("Informacion del usuario - " + user_update+ "- Sesion de " + usuario);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Titulo.setText("Informacion del usuario - " + user_update);
        try {
            Connection con = conexion.conectar();
            PreparedStatement val = con.prepareStatement(
                    "select * from usuarios where username = '" + user_update + "'" );
            ResultSet resulba = val.executeQuery();
             if (resulba.next()) {
                 id = resulba.getInt("id_usuario");
                 txtnombre.setText(resulba.getString("nombre_usuario"));
                 txtemail.setText(resulba.getString("email"));
                 txttelefono.setText(resulba.getString("telefono"));
                 txtusername.setText(resulba.getString("username"));
                 txtregistrador.setText(resulba.getString("registrado_por"));
                 boxpermisos.setSelectedItem(resulba.getString("tipo_nivel"));
                 boxestado.setSelectedItem(resulba.getString("estatus"));    
            }
            con.close();
        } catch (SQLException e) {
             System.err.println("Error en cargar usuario" + e );
                        JOptionPane.showMessageDialog(null,"¡Error al cargar! Contactese con el administrador");
        }
        
    }
    
@Override
 public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono.png"));
        return retValue;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btcambiar = new javax.swing.JButton();
        btactualizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        boxestado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        boxpermisos = new javax.swing.JComboBox<>();
        Titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtregistrador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btcambiar.setBackground(new java.awt.Color(51, 51, 51));
        btcambiar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btcambiar.setForeground(new java.awt.Color(255, 255, 255));
        btcambiar.setText("Cambiar contraseña");
        btcambiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btcambiar.setBorderPainted(false);
        btcambiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btcambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btcambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 200, 30));

        btactualizar.setBackground(new java.awt.Color(51, 51, 51));
        btactualizar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btactualizar.setText("Actualizar usuario");
        btactualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btactualizar.setBorderPainted(false);
        btactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 200, 30));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 90, 20));

        boxestado.setBackground(new java.awt.Color(255, 255, 255));
        boxestado.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxestado.setForeground(new java.awt.Color(0, 0, 0));
        boxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(boxestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 130, 30));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 70, 20));

        txtusername.setBackground(new java.awt.Color(51, 51, 51));
        txtusername.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 210, 30));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, 20));

        txtnombre.setBackground(new java.awt.Color(51, 51, 51));
        txtnombre.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 30));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 20));

        txtemail.setBackground(new java.awt.Color(51, 51, 51));
        txtemail.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 30));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Télefono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, 20));

        txttelefono.setBackground(new java.awt.Color(51, 51, 51));
        txttelefono.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 210, 30));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Permisos de:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 90, 20));

        boxpermisos.setBackground(new java.awt.Color(255, 255, 255));
        boxpermisos.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxpermisos.setForeground(new java.awt.Color(0, 0, 0));
        boxpermisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(boxpermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 130, 30));

        Titulo.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Informacion del usuario - ");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registrado por:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 110, 20));

        txtregistrador.setEditable(false);
        txtregistrador.setBackground(new java.awt.Color(102, 102, 102));
        txtregistrador.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtregistrador.setForeground(new java.awt.Color(255, 255, 255));
        txtregistrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtregistrador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtregistrador.setEnabled(false);
        getContentPane().add(txtregistrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 459));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btactualizarActionPerformed
        int permisos, estado,validacion = 0;
        String nombre , mail , telefono, username, pass, permisos_string = "",estado_string;
         nombre = txtnombre.getText().trim();
         mail = txtemail.getText().trim();
         telefono = txttelefono.getText().trim();
         username = txtusername.getText().trim();
         permisos = boxpermisos.getSelectedIndex() +1 ;
         estado = boxestado.getSelectedIndex() +1;
          if (mail.equals("")){
              txtemail.setBackground(Color.red);
              validacion ++;
          }
          if (telefono.equals("")){
              txttelefono.setBackground(Color.red);
              validacion ++;
          }
          if (username.equals("")){
              txtusername.setBackground(Color.red);
              validacion ++;
          }
         
          if (nombre.equals("")){
              txtnombre.setBackground(Color.red);
              validacion ++; }
         if (validacion == 0) {
             if (permisos==1) {permisos_string = "Administrador";
             }else if (permisos==2) {permisos_string = "Capturista";
             }else  {permisos_string = "Tecnico";}
             if (estado == 1) {estado_string = "Activo";
             } else {estado_string = "Inactivo";}
             
             try {
                 Connection con = conexion.conectar();
                 PreparedStatement val = con.prepareStatement(
                  "select username from usuarios where username = '" + username + "' and not id_usuario= '" +
                          id +  "'");
                 ResultSet resulba = val.executeQuery();
                  if (resulba.next()) { 
                      txtusername.setBackground(Color.red);
                      JOptionPane.showMessageDialog(null, "El nombre del usuario ya esta en uso");
                      con.close();
                  } else {
                      Connection con2 = conexion.conectar();
                      PreparedStatement val2 = con2.prepareStatement(
                      "update usuarios set nombre_usuario=? ,email=?, telefono = ? , username = ? , tipo_nivel = ?, estatus = ?"
                          + " where id_usuario = '" + id + "'" );
                      val2.setString(1, nombre);
                      val2.setString(2, mail);
                      val2.setString(3, telefono);
                      val2.setString(4, username);
                      val2.setString(5, permisos_string);
                      val2.setString(6, estado_string);
                      val2.executeUpdate();
                      con.close();
                      JOptionPane.showMessageDialog(null, "Usuario modificado");  
                  }
             } catch (SQLException e) {
                  System.err.println("Error al actulizar");
             }
             
        } else {
             JOptionPane.showMessageDialog(null,"Completa todo los campos");
        }
        
    }//GEN-LAST:event_btactualizarActionPerformed

    
    private void btcambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcambiarActionPerformed
        new cambiar_contraseña().setVisible(true);
    }//GEN-LAST:event_btcambiarActionPerformed

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
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacionUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JComboBox<String> boxestado;
    private javax.swing.JComboBox<String> boxpermisos;
    private javax.swing.JButton btactualizar;
    private javax.swing.JButton btcambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtregistrador;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
