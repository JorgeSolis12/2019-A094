/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avance;


import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jorgesolis
 */
public class avance extends javax.swing.JFrame {

    /**
     * Creates new form avance
     */
    BufferedImage  imageActual;
    BufferedImage  imageActual_a;
    BufferedImage  imageActual_v;
    BufferedImage  imageActual_r;
    public BufferedImage abrirImagen(){
        //Creamos la variable que será devuelta (la creamos como null)
         
        BufferedImage bmp=null;
        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Seleccione una imagen");
        //Filtramos los tipos de archivos
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        //Abrimos el cuadro de diálog
        int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        }
        //Asignamos la imagen cargada a la propiedad imageActual
        imageActual=bmp;
        imageActual_a=bmp;
        imageActual_v=bmp;
        imageActual_r=bmp;
        //Retornamos el valor
        return bmp;
    }
    public BufferedImage Red(BufferedImage bi){
         BufferedImage img = null;
 
        // get width and height
        int width = bi.getWidth();
        int height = bi.getHeight();
 
        // convert to red image
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int p = bi.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
 
                p = (a<<24) | (r<<16) | (0<<8) | 0;
                bi.setRGB(x, y, p);
            }
        }
        img = bi;
        return img;
     }
      public BufferedImage Green(BufferedImage bi){
         BufferedImage img = null;
 
        // get width and height
        int width = bi.getWidth();
        int height = bi.getHeight();
 
        // convert to red image
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int p = bi.getRGB(x,y);
                int a = (p>>24)&0xff;
                int g = (p>>8)&0xff;
 
                p = (a<<24) | (0<<16) | (g<<8) | 0;
                bi.setRGB(x, y, p);
            }
        }
        img = bi;
        return img;
      }
      public BufferedImage Blue(BufferedImage bi){
         BufferedImage img = null;
 
        // get width and height
        int width = bi.getWidth();
        int height = bi.getHeight();
 
        // convert to red image
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int p = bi.getRGB(x,y);
                 int a = (p>>24)&0xff;
                 int b = p&0xff;
                p = (a<<24) | (0<<16) | (0<<8) | b;
                bi.setRGB(x, y, p);
            }
        }
        img = bi;
        return img;
      }
    public avance() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Abril = new javax.swing.JButton();
        Red = new javax.swing.JButton();
        Blue = new javax.swing.JButton();
        Green = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Abril.setText("Abrir");
        Abril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrilActionPerformed(evt);
            }
        });

        Red.setText("Rojo");
        Red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedActionPerformed(evt);
            }
        });

        Blue.setText("Azul");
        Blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueActionPerformed(evt);
            }
        });

        Green.setText("Verde");
        Green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GreenActionPerformed(evt);
            }
        });

        jLabel1.setText("PRUEBA DE DESCRIMINACIÓN RGB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(Red)
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Blue)
                                .addGap(103, 103, 103)
                                .addComponent(Green))
                            .addComponent(Abril)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(Abril)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Red)
                    .addComponent(Blue)
                    .addComponent(Green))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrilActionPerformed
        // TODO add your handling code here:
        JFrame TheFrame = new JFrame("ImageEdit: Imagen 1" ); 
         JLabel TheLabel = new JLabel(new ImageIcon(abrirImagen()));   
         TheFrame.getContentPane().add(TheLabel);
         TheFrame.setSize(600, 600); 
          TheFrame.addWindowListener(new WindowAdapter() {   
          public void windowClosing(WindowEvent e) {   
                 
          }   
        });           
      TheFrame.setVisible(true);  
    }//GEN-LAST:event_AbrilActionPerformed

    private void GreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GreenActionPerformed
        // TODO add your handling code here:

         JFrame TheFrame = new JFrame("Imagen "); 
         BufferedImage verde = imageActual_v;
         JLabel TheLabel = new JLabel(new ImageIcon(Green(verde)));   
         TheFrame.getContentPane().add(TheLabel);
         TheFrame.setSize(600, 600); 
         TheFrame.addWindowListener(new WindowAdapter() {   
          public void windowClosing(WindowEvent e) {   
                            
          }   
        });           
      TheFrame.setVisible(true);
    }//GEN-LAST:event_GreenActionPerformed

    private void BlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlueActionPerformed
        // TODO add your handling code here:
        JFrame TheFrame = new JFrame("Imagen "); 
        BufferedImage azul = imageActual_a;
         JLabel TheLabel = new JLabel(new ImageIcon(Blue(azul)));   
         TheFrame.getContentPane().add(TheLabel);
         TheFrame.setSize(600, 600); 
         
          TheFrame.addWindowListener(new WindowAdapter() {   
          public void windowClosing(WindowEvent e) {   
                            
          }   
        });           
      TheFrame.setVisible(true);
    }//GEN-LAST:event_BlueActionPerformed

    private void RedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedActionPerformed
        // TODO add your handling code here:
        JFrame TheFrame = new JFrame("Imagen "); 
        BufferedImage rojo = imageActual_r;
         JLabel TheLabel = new JLabel(new ImageIcon(Red(rojo)));   
         TheFrame.getContentPane().add(TheLabel);
         TheFrame.setSize(600, 600); 
          TheFrame.addWindowListener(new WindowAdapter() {   
          public void windowClosing(WindowEvent e) {   
                            
          }   
        });           
      TheFrame.setVisible(true);
    }//GEN-LAST:event_RedActionPerformed

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
            java.util.logging.Logger.getLogger(avance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(avance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(avance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(avance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new avance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abril;
    private javax.swing.JButton Blue;
    private javax.swing.JButton Green;
    private javax.swing.JButton Red;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
