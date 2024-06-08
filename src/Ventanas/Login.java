/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;
import Clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Login extends javax.swing.JFrame {
    public static String usuario = "";
    String pass = "";
    public Login() {
        initComponents();
        setSize(330,540);
        setResizable(false);
        setTitle("Iniciar sesion");
        setLocationRelativeTo(null);     
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono.png"));
                return retValue;
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        btacceptar = new javax.swing.JButton();
        txtcontrasena = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 230, 160));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 140, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 140, 20));

        txtusuario.setBackground(new java.awt.Color(204, 204, 204));
        txtusuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 190, 30));

        btacceptar.setBackground(new java.awt.Color(51, 51, 51));
        btacceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btacceptar.setForeground(new java.awt.Color(255, 255, 255));
        btacceptar.setText("Acceder");
        btacceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btacceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btacceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btacceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btacceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 190, 30));

        txtcontrasena.setBackground(new java.awt.Color(204, 204, 204));
        txtcontrasena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtcontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btacceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btacceptarActionPerformed
         usuario = txtusuario.getText().trim();
         pass = txtcontrasena.getText().trim();
         if (!usuario.equals("") || !pass.equals("")) {
             try {
                 Connection con = conexion.conectar();
                 PreparedStatement val =  con.prepareStatement(
                         "select estatus, tipo_nivel from usuarios where username ='" + usuario  
                                 +"' and password = '" + pass + "'");
                 ResultSet resulba = val.executeQuery();
                 
                 if (resulba.next()) {
                     String habilitacion = resulba.getString("estatus");
                     String tipo = resulba.getString ("tipo_nivel");
                     if (tipo.equals("Administrador") && habilitacion.equals("Activo")) {
                         dispose ();
                         new Administrador().setVisible(true);}
                     else if (tipo.equals("Capturista") && habilitacion.equals("Activo")) {
                         dispose ();
                         new Capturista().setVisible(true);}
                     else  if (tipo.equals("Tecnico") && habilitacion.equals("Activo")) {
                         dispose ();
                        new Tecnico().setVisible(true);
                         
                         }
                     
                     
                 }
                 else {
                 JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                 txtusuario.setText("");
                 txtcontrasena.setText("");}
             } catch (SQLException e) {
                 System.out.println("error en el boton Acceder");
                 JOptionPane.showMessageDialog(null,"¡Error al iniciar sesion!, contacte al administrador ");
             }
         }  
         else {
         JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
                 }
    }//GEN-LAST:event_btacceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btacceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
