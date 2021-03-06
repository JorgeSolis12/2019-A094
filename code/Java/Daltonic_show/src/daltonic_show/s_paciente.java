/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nirfa
 */

package daltonic_show;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class s_paciente extends javax.swing.JFrame {

    /**
     * Creates new form s_paciente
     */
   
    public s_paciente() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
        this.setTitle("Seleccionar paciente");
        Connection cnx = null;
        ResultSet rs = null;
        
         List<String> nombres = new ArrayList<>();
         List<Integer> id = new ArrayList<>();
        
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
            Statement st = cnx.createStatement();

            String SSQL="SELECT * FROM paciente";
            int i = 0;
            rs = st.executeQuery(SSQL);
            while(rs.next()){

                if(i>2){
                    id.add(rs.getInt("id"));
                    String paciente = rs.getString("nombre")+ " " + rs.getString("apeido") ;
                    nombres.add(paciente);
                    pacientes.addItem(paciente);
                   
                }
                 i++;

            }
           rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DS_main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pacientes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientesActionPerformed(evt);
            }
        });
        getContentPane().add(pacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 156, -1));

        jButton1.setText("Seleccionar este paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/daltonic_show/7db99d46d3568fe5b985e529b133cddb-icono-de-lupa-de-ojo-by-vexels.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 310, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/daltonic_show/purple-iphone-wallpaper-11.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         
        Connection cnx = null;
        ResultSet rs = null;
        
        String paciente_select = (String) pacientes.getSelectedItem();
        String[] parts = paciente_select.split(" ");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        
        int resultado = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
            Statement st = cnx.createStatement();
            
            String SSQL="SELECT id FROM paciente WHERE nombre ="+ "'"+part1+ "'"+"AND apeido="+"'"+part2+"'";
            int i = 0;
            rs = st.executeQuery(SSQL);
            while(rs.next()){
                   resultado = rs.getInt("id");
            }
          
           rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DS_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        hoja_paciente pac = new hoja_paciente(resultado);
        pac.setVisible(true);
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
            java.util.logging.Logger.getLogger(s_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(s_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(s_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(s_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new s_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> pacientes;
    // End of variables declaration//GEN-END:variables
}
