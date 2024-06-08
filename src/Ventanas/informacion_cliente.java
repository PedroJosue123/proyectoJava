/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class informacion_cliente extends javax.swing.JFrame {
    DefaultTableModel diseño = new DefaultTableModel ();
    int idCliente_update =0;
    public static int Idequipo=0;
    String usuario = "";
    public informacion_cliente() {
        initComponents();
        usuario = Login.usuario;
        idCliente_update = gestion_clientes.IDcliente_update;
        setSize (630,450);
        setTitle("Informacion de cliente ");
        setLocationRelativeTo(null);
        setResizable (false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        try {
            Connection con = conexion.conectar();
            PreparedStatement val = con.prepareStatement(
                    "select * from clientes where id_cliente = '" +  idCliente_update + "'");
            ResultSet resulba = val.executeQuery();
            if (resulba.next()) {
                Titulo.setText("Información del cliente " + resulba.getString("nombre_cliente"));
                txtnombre.setText(resulba.getString("nombre_cliente"));
                txtemail.setText(resulba.getString("mail_cliente"));
                txttelefono.setText(resulba.getString("tel_cliente"));
                txtdireccion.setText(resulba.getString("dir_cliente"));
                txtmodificador.setText(resulba.getString("ultima_modificacion"));
            }
            con.close();
        } catch (SQLException e) { 
            System.err.println("Error en la informacion de cliente" + e);
            JOptionPane.showMessageDialog(
                    null, "¡ERROR en la informacion!, contacte al administrador.");
        }
         try {
            Connection con =  conexion.conectar();
            PreparedStatement val = con.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '"
                    + idCliente_update + "'");
            ResultSet rs = val.executeQuery();
            tabla = new JTable(diseño);
            jScrollPane1.setViewportView(tabla);
            diseño.addColumn("ID equipo");
            diseño.addColumn("Tipo de equipo");
            diseño.addColumn("Marca");
            diseño.addColumn("Estatus");
            
            while (rs.next()) {
                Object [] fila = new Object [4];
                for (int i = 0; i < 4; i++) {
                    fila [i] = rs.getObject(i+1);
                }
                diseño.addRow(fila);
            }
            con.close();
            
        } catch (SQLException e) {
            System.err.println("Error en la tabla equipos");
        }
         
        tabla.addMouseListener( new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                 int fila_seleccionada = tabla.rowAtPoint(e.getPoint());
                int columna_seleccionada = 0;
                if (fila_seleccionada>-1){
                Idequipo = (int)diseño.getValueAt(fila_seleccionada, columna_seleccionada);
                new informacion_equipo().setVisible(true);
                
                }
            }
        });
        
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

        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txtmodificador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btregistrar = new javax.swing.JButton();
        btactualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnombre.setBackground(new java.awt.Color(51, 51, 51));
        txtnombre.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 30));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, 20));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 20));

        txtemail.setBackground(new java.awt.Color(51, 51, 51));
        txtemail.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, 30));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Télefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 70, 20));

        txttelefono.setBackground(new java.awt.Color(51, 51, 51));
        txttelefono.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, 20));

        txtdireccion.setBackground(new java.awt.Color(51, 51, 51));
        txtdireccion.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtdireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtdireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 210, 30));

        txtmodificador.setEditable(false);
        txtmodificador.setBackground(new java.awt.Color(102, 102, 102));
        txtmodificador.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtmodificador.setForeground(new java.awt.Color(255, 255, 255));
        txtmodificador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmodificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtmodificador.setEnabled(false);
        getContentPane().add(txtmodificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 210, 30));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ultima modificacion:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 20));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 320, 180));

        btregistrar.setBackground(new java.awt.Color(51, 51, 51));
        btregistrar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btregistrar.setForeground(new java.awt.Color(255, 255, 255));
        btregistrar.setText("Registrar equipo");
        btregistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btregistrar.setBorderPainted(false);
        btregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 292, 200, 30));

        btactualizar.setBackground(new java.awt.Color(51, 51, 51));
        btactualizar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btactualizar.setText("Actualizar cliente");
        btactualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btactualizar.setBorderPainted(false);
        btactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 342, 200, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 100, 90));

        Titulo.setFont(new java.awt.Font("Cambria", 1, 23)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Informacion del cliente");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistrarActionPerformed
        new registro_equipo().setVisible(true);
    }//GEN-LAST:event_btregistrarActionPerformed

    private void btactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btactualizarActionPerformed
        int validacion = 0;
        String nombre, mail, telefono, direccion;

        nombre = txtnombre.getText().trim();
        mail = txtemail.getText().trim();
        telefono = txttelefono.getText().trim();
        direccion = txtdireccion.getText().trim();

        if (nombre.equals("")) {
            txtnombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            txtemail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txttelefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            txtdireccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {

                Connection con = conexion.conectar();
                PreparedStatement val = con.prepareStatement(
                        "update clientes set nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? "
                        + "where id_cliente = '" + idCliente_update + "'");

                val.setString(1, nombre);
                val.setString(2, mail);
                val.setString(3, telefono);
                val.setString(4, direccion);
                val.setString(5, usuario);

                val.executeUpdate();
                con.close();

                txtnombre.setText("");
                txtemail.setText("");
                txttelefono.setText("");
                txtdireccion.setText("");

                txtnombre.setBackground(Color.green);
                txtemail.setBackground(Color.green);
                txttelefono.setBackground(Color.green);
                txtdireccion.setBackground(Color.green);
                txtmodificador.setText(usuario);

                JOptionPane.showMessageDialog(null, "Actualización correcta.");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en actualizar cliente." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar cliente!!, contacte al administrador.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
        }
    }//GEN-LAST:event_btactualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txtnombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/Imagenes/BannerPDF.jpg");
            header.scaleToFit(650, 800);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            
            parrafo.add("Información del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombres");
            tablaCliente.addCell("email");
            tablaCliente.addCell("Télefono");
            tablaCliente.addCell("Dirección");

            try {

                Connection con = conexion.conectar();
                PreparedStatement val = con.prepareStatement(
                        "select * from clientes where id_cliente = '" + idCliente_update + "'");

                ResultSet resulba = val.executeQuery();

                if (resulba.next()) {
                    do {

                        tablaCliente.addCell(resulba.getString(1));
                        tablaCliente.addCell(resulba.getString(2));
                        tablaCliente.addCell(resulba.getString(3));
                        tablaCliente.addCell(resulba.getString(4));
                        tablaCliente.addCell(resulba.getString(5));

                    } while (resulba.next());

                    documento.add(tablaCliente);
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos registrados. \n \n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tabla = new PdfPTable(4);
                tabla.addCell("ID equipo");
                tabla.addCell("Tipo");
                tabla.addCell("Marca");
                tabla.addCell("Estatus");

                try {

                    Connection con2 = conexion.conectar();
                    PreparedStatement val2 = con2.prepareStatement(
                            "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + idCliente_update + "'");
                    
                    ResultSet resulba2 = val2.executeQuery();
                    
                    if(resulba2.next()){
                        do {                            
                            tabla.addCell(resulba2.getString(1));
                            tabla.addCell(resulba2.getString(2));
                            tabla.addCell(resulba2.getString(3));
                            tabla.addCell(resulba2.getString(4));
                            
                        } while (resulba2.next());
                        documento.add(tabla);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al cargar equipos " + e);
                }

            } catch (SQLException e) {
                System.err.print("Error al obtener datos del clientes. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacion_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btactualizar;
    private javax.swing.JButton btregistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmodificador;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
