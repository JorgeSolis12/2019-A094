/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonic_show;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nirfa
 */
public class Instrucciones extends javax.swing.JFrame {

    /**
     * Creates new form Instrucciones
     */
    int count = 0;
    public Instrucciones() {
        initComponents();
        last.setVisible(false);
        img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/frente.jpg"));
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);
        instruccion.setText("Mantente a 20 cm de la pantalla con una buena luz en la habitación");
        instruccion.setHorizontalAlignment(JLabel.CENTER);
        instruccion.setVerticalAlignment(JLabel.CENTER);
        
            
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instruccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        last = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(instruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 390, 50));

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 36)); // NOI18N
        jLabel1.setText("INSTRUCCIONES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 360, 90));
        getContentPane().add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 670, 460));

        last.setText("Anterior");
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });
        getContentPane().add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 100, 40));

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, 110, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/daltonic_show/66539476-fondo-de-póquer-de-color-azul-claro-minimalista-con-textura-transparente-compuesta-de-símbolos-de-la-tarj.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        count++;
        last.setVisible(true);
        if(count == 6){
                this.setVisible(false);
            }
        
        else if(count == 1){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/iniciar.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Da click en iniciar");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 2){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/1.jpg"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER); 
            instruccion.setText("Podras ver una imagen similar a esta");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 3){  
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/escribir.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Escribe el número que verás en la tarjeta");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }

        else if(count == 4){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/next.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Aprieta el botón siguiente");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 5){
            siguiente.setText("Finalizar");
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/esperar.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Espera la siguiente carta, repite estos pasos");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
            

        
        
    }//GEN-LAST:event_siguienteActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
        // TODO add your handling code here:
        count--;
        
        if(count < 6){
                siguiente.setText("Siguiente");
            }
        if(count == 0){
            last.setVisible(false);
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/frente.jpg"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Mantente a 20 cm de la pantalla con una buena luz en la habitación");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        
        }
        else if(count == 1){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/iniciar.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Da click en iniciar");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 2){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/1.jpg"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER); 
            instruccion.setText("Podras ver una imagen similar a esta");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 3){  
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/escribir.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Escribe el número que verás en la tarjeta");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }

        else if(count == 4){
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/next.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Aprieta el botón siguiente");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
        else if(count == 5){
            siguiente.setText("Finalizar");
            img.setIcon(new ImageIcon("C:/Users/nirfa/OneDrive/Documentos/GitHub/2019-A094/code/Java/Daltonic_show/src/daltonic_show/Instrucciones/esperar.gif"));
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setVerticalAlignment(JLabel.CENTER);
            instruccion.setText("Espera la siguiente carta, repite estos pasos");
            instruccion.setHorizontalAlignment(JLabel.CENTER);
            instruccion.setVerticalAlignment(JLabel.CENTER);
        }
    }//GEN-LAST:event_lastActionPerformed

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
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel img;
    private javax.swing.JLabel instruccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton last;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
