package Ventanas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import javax.swing.WindowConstants;
import Clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Capturista extends javax.swing.JFrame {
    String usuario,nombre_usuario;
    int sesion_usuario;
    public Capturista() {
        initComponents();
        usuario = Login.usuario;
        sesion_usuario = Administrador.sesion_usuario;
        setSize (540,300);
        setTitle("Sesion capturista sesion: " + usuario);
        setLocationRelativeTo(null);
        setResizable (false);
        if (sesion_usuario==1) { 
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   
        } else {setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        try {
            Connection on = conexion.conectar();
            PreparedStatement val = on.prepareStatement("select nombre_usuario from usuarios where username = '" + usuario +"'");
            ResultSet resulba = val.executeQuery();
            if (resulba.next()) {
                nombre_usuario = resulba.getString("nombre_usuario");
                Titulo.setText("Bienvenido " + nombre_usuario);
            } else {
            }
        } catch (SQLException e) { System.err.println("Error en la ventana Capturista");
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

        btregistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btgestionar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btimprimir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btregistrar.setBackground(new java.awt.Color(0, 0, 0));
        btregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addUser.png"))); // NOI18N
        btregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, 100));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Registrar cliente");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, 20));

        btgestionar.setBackground(new java.awt.Color(0, 0, 0));
        btgestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informationuser.png"))); // NOI18N
        btgestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgestionarActionPerformed(evt);
            }
        });
        getContentPane().add(btgestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 110, 100));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestionar clientes");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 100, 20));

        btimprimir.setBackground(new java.awt.Color(0, 0, 0));
        btimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora.png"))); // NOI18N
        btimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btimprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 110, 100));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Imprimir");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 70, 20));

        Titulo.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistrarActionPerformed
        new registrar_cliente().setVisible(true);

    }//GEN-LAST:event_btregistrarActionPerformed

    private void btgestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgestionarActionPerformed
        new gestion_clientes().setVisible(true);
    }//GEN-LAST:event_btgestionarActionPerformed

    private void btimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btimprimirActionPerformed
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListaClientes.pdf"));
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/Imagenes/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de clientes. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("email");
            tabla.addCell("Télefono");
            tabla.addCell("Dirección");
            
            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    do {                        
                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        
                    } while (rs.next());
                    documento.add(tabla);
                }
                
            } catch (SQLException e) {
                System.err.print("Error al generar lista de clientes. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de clientes creada correctamente.");
            
        } catch (Exception e) {
            System.err.println("Error al generar PDF " + e);
        }
    }//GEN-LAST:event_btimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btgestionar;
    private javax.swing.JButton btimprimir;
    private javax.swing.JButton btregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
