/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;
import javax.swing.WindowConstants;
import Clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class cambiar_contraseña extends javax.swing.JFrame {
    String usuario = "",user_update ="";
    public cambiar_contraseña() {
        initComponents();
        usuario= Login.usuario;
        user_update =  gestionar_usuarios.user_update;
        setSize(360,300);
        setResizable(false);
        setTitle("Cambio de contraseña de: " + user_update);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
@Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono.png"));
        return retValue;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtpass = new javax.swing.JTextField();
        txtconfirmacion = new javax.swing.JTextField();
        btcambiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtpass.setBackground(new java.awt.Color(51, 51, 51));
        txtpass.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 210, 30));

        txtconfirmacion.setBackground(new java.awt.Color(51, 51, 51));
        txtconfirmacion.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtconfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txtconfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtconfirmacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtconfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 210, 30));

        btcambiar.setBackground(new java.awt.Color(51, 51, 51));
        btcambiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btcambiar.setForeground(new java.awt.Color(255, 255, 255));
        btcambiar.setText("Cambiar");
        btcambiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btcambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btcambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 120, 30));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar contraseña:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 160, 20));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 110, 20));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cambiar contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcambiarActionPerformed
        String contraseña , confirmacion;
        contraseña = txtpass.getText();
        confirmacion = txtconfirmacion.getText();
        if (!contraseña.equals("") && !confirmacion.equals("") ) {
            if (contraseña.equals(confirmacion)){
                try {
                    
                    Connection con = conexion.conectar();
                    PreparedStatement val = con.prepareStatement(
                            "update usuarios set password = ? where username ='" + user_update + "'");
                    val.setString(1, contraseña);
                    val.executeUpdate();
                    con.close();
                    txtpass.setBackground(Color.GREEN);
                    txtconfirmacion.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada") ;
                    dispose();
                } catch (SQLException e) { 
                    System.err.println("Error al cambiar la contraseña");
                }    
            }
            else {}
                txtconfirmacion.setBackground(Color.red);
                 JOptionPane.showMessageDialog(null, "La contraseña no coincide") ;
                
        } else  {
           JOptionPane.showMessageDialog(null, "Complete los campos") ;}
       
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
            java.util.logging.Logger.getLogger(cambiar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cambiar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cambiar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cambiar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cambiar_contraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtconfirmacion;
    private javax.swing.JTextField txtpass;
    // End of variables declaration//GEN-END:variables
}
