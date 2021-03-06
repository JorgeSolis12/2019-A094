/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daltonic_show;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author nirfa
 */
public class hoja_paciente extends javax.swing.JFrame {

    /**
     * Creates new form hoja_paciente
     */
    int id = 0;
    Connection cnx = null;
    ResultSet rs = null;
    
    public hoja_paciente(int id_recv) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
        this.setTitle("Información del paciente");
        id = id_recv;
        
        
        cancelar.setVisible(false);
        guardar.setVisible(false);
        nombretf.setEnabled(false);
        apeidotf.setEnabled(false);
        fecha_nactf.setEnabled(false);
        ingresotf.setEnabled(false);
        ultima_citatf.setEnabled(false);
        int resultado = 0;
        String ultima; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
            Statement st = cnx.createStatement();
            String SSQL="SELECT * FROM paciente WHERE id ="+id;
            int i = 0;
            rs = st.executeQuery(SSQL);
            while(rs.next()){
                nombretf.setText(rs.getString("nombre"));
                apeidotf.setText(rs.getString("apeido"));
                String pattern = "MM/dd/yyyy";
                DateFormat df = new SimpleDateFormat(pattern);
                
                fecha_nactf.setText(df.format(rs.getDate(4)));
                ingresotf.setText(df.format(rs.getDate(5)));
                ultima_citatf.setText(df.format(rs.getDate(6)));         
                ultima = df.format(rs.getDate(7));
                
                String year = ultima.substring(6,10);
                String day = ultima.substring(3,5);
                String month = ultima.substring(0,2);
                
                Calendar date = new GregorianCalendar();
                int dia_ingreso = date.get(Calendar.DAY_OF_MONTH);
                int mes_ingreso = date.get(Calendar.MONTH)+1;
                int ano_ingreso = date.get(Calendar.YEAR);
                
                boolean ano_flag = true;
                
                if(Integer.parseInt(year)>ano_ingreso){
                    ano_flag = false;
                }
                
                System.out.println(ultima);
                if(Integer.parseInt(month)> mes_ingreso){
                    if(Integer.parseInt(year)>=ano_ingreso){
                        System.out.println("entro en mes");
                        ano_flag = false;
                    }
                }
                
                if(Integer.parseInt(day)>dia_ingreso){
                    if(Integer.parseInt(month)>= mes_ingreso){
                       if(Integer.parseInt(year)>=ano_ingreso){
                            ano_flag = false;
                        }
                    }
                }
                
                if(ano_flag == false){
                    cita.setEnabled(false);
                }
            }
           rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DS_main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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

        cita = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        fecha_nactf = new javax.swing.JTextField();
        nombretf = new javax.swing.JTextField();
        ingresotf = new javax.swing.JTextField();
        editar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        ultima_citatf = new javax.swing.JTextField();
        apeidotf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cita.setText("Agendar próxima cita");
        cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citaActionPerformed(evt);
            }
        });
        getContentPane().add(cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 200, 50));

        jButton1.setText("Habilitar Gafas");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 150, 50));

        eliminar.setText("eliminar usuario");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 50));

        fecha_nactf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_nactfActionPerformed(evt);
            }
        });
        getContentPane().add(fecha_nactf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 290, 40));
        getContentPane().add(nombretf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 190, 40));
        getContentPane().add(ingresotf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 290, 40));

        editar.setText("Editar usuario");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 140, 50));

        guardar.setText("Guardar cambios");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 160, 50));

        cancelar.setText("Cerrar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 150, 50));
        getContentPane().add(ultima_citatf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 290, 40));
        getContentPane().add(apeidotf, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 200, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("FECHA DE NACIMIENTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 60));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("FECHA DE INGRESO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 210, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("FECHA DE ÚLTIMA CITA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 240, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("NOMBRE: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/daltonic_show/66539476-fondo-de-póquer-de-color-azul-claro-minimalista-con-textura-transparente-compuesta-de-símbolos-de-la-tarj.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citaActionPerformed
        // TODO add your handling code here:
        agendar_cita agenda;
        try {
            agenda = new agendar_cita(id);
            agenda.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(hoja_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }//GEN-LAST:event_citaActionPerformed

    private void fecha_nactfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_nactfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_nactfActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        cancelar.setVisible(true);
        guardar.setVisible(true);
        cancelar.setEnabled(true);
        guardar.setEnabled(true);
        nombretf.setEnabled(true);
        apeidotf.setEnabled(true);
        fecha_nactf.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
        boolean flag = true;
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        String na = nombretf.getText();
        String a = apeidotf.getText();
        String f = fecha_nactf.getText();
        
        
        String year = f.substring(6,10);
        String month = f.substring(3,5);
        String day = f.substring(0,2);
        
        
        
        if(na.length() == 0){
            flag = false;
        }
        
        
        if(a.length() == 0){
            flag = false;
        }
        
        
        if(f.length() != 10){
            flag = false;
        }
        else{
            int getsu = Integer.parseInt(month);
            int bi = Integer.parseInt(day);
            int nen = Integer.parseInt(year);
            
            if(year.length()!=4){
                flag = false;
            }
            
            if(getsu>12){
                flag = false;
            }
            
            if(getsu<8){
                if(getsu !=2){
                    if(getsu%2==0){
                        if(bi>30){
                            flag= false;
                        }
                    }
                    else{
                        if(bi>31){
                            flag= false;
                        }
                    }
                }
            }
            else if(getsu >=8){
                if(getsu%2==0){
                            if(bi>31){
                                flag= false;
                            }
                        }
                        else{
                            if(bi>30){
                                flag= false;
                            }
                        }
            }
            
            int biciesto = nen%4;
                if(biciesto != 0){
                    if(getsu ==2){
                        if(bi>=29){
                            flag = false;
                        }
                    }
                    
                }
        }
        if(flag == true){
            
            String f2 = year +"-"+month+"-"+day; 
            try {
                Statement st = cnx.createStatement();
                
                String sql = "UPDATE paciente SET nombre=?, apeido=?, fecha_de_nacimiento=? WHERE id=?";
                PreparedStatement statement = cnx.prepareStatement(sql);
                statement.setString(1, na);
                statement.setString(2,a);
                statement.setString(3, f2);
                statement.setString(4, Integer.toString(id));
                
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario crado", "Información", JOptionPane.INFORMATION_MESSAGE, null); 
                    nombretf.setEnabled(false);
                    apeidotf.setEnabled(false);
                    fecha_nactf.setEnabled(false);
                    cancelar.setVisible(false);
                    guardar.setVisible(false);
                    
                    String SSQL="SELECT * FROM paciente WHERE id ="+id;
                    int i = 0;
                    rs = st.executeQuery(SSQL);
                    while(rs.next()){
                        nombretf.setText(rs.getString("nombre"));
                        apeidotf.setText(rs.getString("apeido"));
                        String pattern = "MM/dd/yyyy";
                        DateFormat df = new SimpleDateFormat(pattern);

                        fecha_nactf.setText(df.format(rs.getDate(4)));
                        ingresotf.setText(df.format(rs.getDate(5)));
                        ultima_citatf.setText(df.format(rs.getDate(6)));

                    }
                        }
                    } catch (SQLException ex) {
                            Logger.getLogger(crear_paciente.class.getName()).log(Level.SEVERE, null, ex);
                        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Error en algun campo", "Error", JOptionPane.ERROR_MESSAGE, null); 
            cancelar.setEnabled(true);
            guardar.setEnabled(true);
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        
        nombretf.setEnabled(false);
        apeidotf.setEnabled(false);
        fecha_nactf.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM paciente WHERE id=?";
        PreparedStatement statement;
        try {
            statement = cnx.prepareStatement(sql);
            statement.setString(1, Integer.toString(id));
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Paciente Borrado", "Listo", JOptionPane.INFORMATION_MESSAGE, null); 
                    this.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoja_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apeidotf;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cita;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField fecha_nactf;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField ingresotf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombretf;
    private javax.swing.JTextField ultima_citatf;
    // End of variables declaration//GEN-END:variables
}
