/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_pruebas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nirfa
 */
public class Arbol_pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
           int[] respuestas_rv = {12,3,5,70,35,2,5,17,21,-1,-1,-1,-1,-1,-1,-1,-1,5,2,45,73};
           int[] respuestas_vn = {12,8,6,29,57,5,3,15,74,2,6,97,45,5,7,16,73,-1,-1,-1,-1};
           int[] respuestas_ac = {12,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
           
           ArrayList<Integer> id_vn = new ArrayList<Integer>();
           ArrayList<Integer> id_rv = new ArrayList<Integer>(); 
           ArrayList<Integer> val_rv = new ArrayList<Integer>();
           
           ArrayList<Integer> valores_nodo = new ArrayList<Integer>();
           ArrayList<Integer> valores_nodo_vn = new ArrayList<Integer>();
           ArrayList<Integer> blacklist = new ArrayList<Integer>();
           
           
           int ent_rv = 0;
           int val_vn = 0;
           int val_ac = 0;
           
            Connection cnx = null;
             ResultSet rs = null;
             
            
            //visión normal
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
            Statement st = (Statement) cnx.createStatement();

          
            String SSQL="select * from paciente_tiene_daltonismo where id_daltonismo= 1;";
            rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_vn.add(rs.getInt("id_paciente"));           
            }
           rs.close();
          
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Arbol_pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
            //visión rv
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
            Statement st = (Statement) cnx.createStatement();

           
            String SSQL="select * from paciente_tiene_daltonismo where id_daltonismo != 1;";
            rs = st.executeQuery(SSQL);

            while(rs.next()){
                id_rv.add(rs.getInt("id_paciente"));           
            }
               rs.close();
            
        
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Arbol_pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
           //Generar valor de cada nodo y entriopia.
           
           //Entriopia de Rojo-Verde  
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
                Statement st = (Statement) cnx.createStatement();

                //Carta 1
                String SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 1 "
                        + "and paciente_ve_carta.respuesta = 12;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 2
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 2 "
                        + "and paciente_ve_carta.respuesta = 3;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 3
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 3 "
                        + "and paciente_ve_carta.respuesta = 5;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 4
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 4 "
                        + "and paciente_ve_carta.respuesta = 70;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 5
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 5 "
                        + "and paciente_ve_carta.respuesta = 35;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 6
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 6 "
                        + "and paciente_ve_carta.respuesta = 2;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 7
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 7 "
                        + "and paciente_ve_carta.respuesta = 5;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 8
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 8 "
                        + "and paciente_ve_carta.respuesta = 17;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                
                //Carta 9
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 9 "
                        + "and paciente_ve_carta.respuesta = 21;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 10
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 10 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 11
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 11 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 12
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 12 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 13
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 13 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                
                //Carta 14
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 14 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 15
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 15 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 16
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 16 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 17
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 17 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 18
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 18 "
                        + "and paciente_ve_carta.respuesta = 5;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 19
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 19 "
                        + "and paciente_ve_carta.respuesta = 2;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 20
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 20 "
                        + "and paciente_ve_carta.respuesta = 45;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 21
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo != 1 and paciente_ve_carta.id_carta = 21 "
                        + "and paciente_ve_carta.respuesta = 73;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                rs.close();
                
             System.out.println(valores_nodo);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Arbol_pruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            for(int i = 0; i<21; i++){
            ent_rv= ent_rv+ valores_nodo.get(i);
            }

           System.out.println(ent_rv);
           
           
           //Entriopia de Visión Normal 
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente", "jorgesolis12", "root2");
                Statement st = (Statement) cnx.createStatement();

                //Carta 1
                String SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 1 "
                        + "and paciente_ve_carta.respuesta = 12;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 2
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 2 "
                        + "and paciente_ve_carta.respuesta = 8;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 3
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 3 "
                        + "and paciente_ve_carta.respuesta = 6;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 4
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 4 "
                        + "and paciente_ve_carta.respuesta = 29;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 5
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 5 "
                        + "and paciente_ve_carta.respuesta = 57;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 6
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 6 "
                        + "and paciente_ve_carta.respuesta = 5;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 7
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 7 "
                        + "and paciente_ve_carta.respuesta = 3;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 8
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 8 "
                        + "and paciente_ve_carta.respuesta = 15;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                
                //Carta 9
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 9 "
                        + "and paciente_ve_carta.respuesta = 74;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 10
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 10 "
                        + "and paciente_ve_carta.respuesta = 2;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 11
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 11 "
                        + "and paciente_ve_carta.respuesta = 6;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 12
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 12 "
                        + "and paciente_ve_carta.respuesta = 97;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 13
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 13 "
                        + "and paciente_ve_carta.respuesta = 45;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                
                //Carta 14
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 14 "
                        + "and paciente_ve_carta.respuesta = 5;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 15
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 15 "
                        + "and paciente_ve_carta.respuesta = 7;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 16
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 16 "
                        + "and paciente_ve_carta.respuesta = 16;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 17
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 17 "
                        + "and paciente_ve_carta.respuesta = 73;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 18
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 18 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 19
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 19 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 20
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 20 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                
                //Carta 21
                SSQL = "select count(paciente_ve_carta.id_paciente) FROM paciente_ve_carta "
                        + "RIGHT JOIN paciente_tiene_daltonismo ON paciente_tiene_daltonismo.id_paciente = paciente_ve_carta.id_paciente "
                        + "where paciente_tiene_daltonismo.id_daltonismo = 1 and paciente_ve_carta.id_carta = 21 "
                        + "and paciente_ve_carta.respuesta = -1;";
                rs = st.executeQuery(SSQL);

                while(rs.next()){    
                    valores_nodo_vn.add(rs.getInt(1));
                    //System.out.println(rs.getInt(1));
                }
                rs.close();
                
             System.out.println(valores_nodo_vn);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Arbol_pruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            for(int i = 0; i<21; i++){
            val_vn= val_vn+ valores_nodo_vn.get(i);
            }

           System.out.println(val_vn);
           

           //Generar árbol
                       
           
           node head = new node(); 
           
           int n;
           Scanner sc = new Scanner(System.in);
           System.out.println(head.pregunta);
           n = sc.nextInt();
           
           
           ent_rv = ent_rv - valores_nodo.get(0);
           val_vn = val_vn - valores_nodo_vn.get(0);
           blacklist.add(1);
           
           node nuevo_nodo = new node();
           nuevo_nodo.padre = head;
           nuevo_nodo.id = 2;
           nuevo_nodo.respuesta_vn = respuestas_rv[1];
           nuevo_nodo.respuesta_rv = respuestas_vn[1];
           nuevo_nodo.respueta_ac = respuestas_ac[1];
           blacklist.add(2);
           
           int siguiente = 2;
           
           do{
               
               System.out.println(nuevo_nodo.pregunta);
               
               int m;
               Scanner sc2 = new Scanner(System.in);
               m = sc2.nextInt();
               
               if(m == nuevo_nodo.respuesta_rv){
                   ent_rv = ent_rv - valores_nodo.get(siguiente-1);
                    int i = 1;
                    
                    int may = 0;
                    while(i<=21){
                        
                        if(may< valores_nodo.get(i-1)){
                            if(blacklist.contains(i)){
                                i++;
                             }
                            else{
                                may = valores_nodo.get(i-1);
                                siguiente = i;
                                i++;
                            }
                        }
                        
                    }
                    
                    node nodo_aux = new node(); 
                    nodo_aux.padre = nuevo_nodo;
                    nodo_aux.id = siguiente ;
                    blacklist.add(siguiente);
                    nodo_aux.respuesta_vn = respuestas_rv[i-1];
                    nodo_aux.respuesta_rv = respuestas_vn[i-1];
                    nodo_aux.respueta_ac = respuestas_ac[i-1];
                    nuevo_nodo = nodo_aux;
                    
                    }
               
               else if(m == nuevo_nodo.respuesta_vn){
                   val_vn = val_vn - valores_nodo_vn.get(siguiente-1);
                    int i = 1;
                    
                    int may = 0;
                    while(i<=21){
                        
                        if(may< valores_nodo_vn.get(i-1)){
                            if(blacklist.contains(i)){
                                i++;
                             }
                            else{
                                may = valores_nodo_vn.get(i-1);
                                siguiente = i;
                                i++;
                            }
                        }
                        
                    }
                    
                    node nodo_aux = new node(); 
                    nodo_aux.padre = nuevo_nodo;
                    nodo_aux.id = siguiente ;
                    blacklist.add(siguiente);
                    nodo_aux.respuesta_vn = respuestas_rv[i-1];
                    nodo_aux.respuesta_rv = respuestas_vn[i-1];
                    nodo_aux.respueta_ac = respuestas_ac[i-1];
                    nuevo_nodo = nodo_aux;
               }
               else if(m == nuevo_nodo.respueta_ac){
                   val_ac++;
                   siguiente++;
                   while(blacklist.contains(siguiente)){
                      siguiente++;  
                   }
                   
                    node nodo_aux = new node(); 
                    nodo_aux.padre = nuevo_nodo;
                    nodo_aux.id = siguiente ;
                    blacklist.add(siguiente);
                    nodo_aux.respuesta_vn = respuestas_rv[siguiente-1];
                    nodo_aux.respuesta_rv = respuestas_vn[siguiente-1];
                    nodo_aux.respueta_ac = respuestas_ac[siguiente-1];
                    nuevo_nodo = nodo_aux;
                   
               }
               else{
                   System.out.println("Siguiente");
                   siguiente++;
                   while(blacklist.contains(siguiente)){
                      siguiente++;  
                   }
                   
                    node nodo_aux = new node(); 
                    nodo_aux.padre = nuevo_nodo;
                    nodo_aux.id = siguiente ;
                    blacklist.add(siguiente);
                    nodo_aux.respuesta_vn = respuestas_rv[siguiente-1];
                    nodo_aux.respuesta_rv = respuestas_vn[siguiente-1];
                    nodo_aux.respueta_ac = respuestas_ac[siguiente-1];
                    nuevo_nodo = nodo_aux;
               }
               
               
           }while( ent_rv <= 0 || val_vn <= 0 || val_ac == 10);
    }
    
}
