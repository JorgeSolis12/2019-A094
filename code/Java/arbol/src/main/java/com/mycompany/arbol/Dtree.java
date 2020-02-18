package com.mycompany.arbol;

import java.io.*;
import com.mycompany.arbol.Node;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgesolis
 */

public class Dtree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ganancia = 0;
        int respuestas_vn[] = {12,8,6,29,57,5,3,15,74,2,6,97,45,5,7,16,73,-1,-1,-1,-1,26,42,-1,-1};
        int respuestas_deuta_leve[] = {12,3,5,70,35,2,3,5,17,21,-1,-1,-1,-1,-1,-1,-1,5,2,45,73,6,};
        int respuestas_deuta_agudo[] = {12,3,5,70,35,2,3,5,17,21,-1,-1,-1,-1,-1,-1,-1,5,2,45,73,26,};
        int respuestas_prota_agudo[] = {12,8,6,29,57,5,3,15,74,2,6,97,45,5,7,16,73,-1,-1,-1,-1,-1,-1,-1,-1};
        int respuestas_prota_leve[] = {12,8,6,29,57,5,3,15,74,2,6,97,45,5,7,16,73,-1,-1,-1,-1,-1,-1,-1,-1};
        String resultados [] = {"Visión normal", "protanotopia aguda","protanotopia leve","deuanotropia leve", "deuanotropia aguda"} ;
        Node head = new Node(); 
        head.Question = "¿Qué número ves?";
        head.respuesta_a.answer = respuestas_vn[0];
        head.respuesta_b.answer = respuestas_deuta_leve[0];
        head.respuesta_c.answer = respuestas_deuta_agudo[0]; 
        head.respuesta_d.answer= respuestas_prota_leve[0];
        head.respuesta_e.answer= respuestas_prota_leve[0];
        do{
            int count_acro = 0;
            int count_dalt = 0;
            int i = 1;
            //respuesta que ingresará;
            int res = 0;
            Node temp = head.respuesta_a = new Node();
            temp.Question = "¿Qué número ves?"; 
            temp.respuesta_a = new Node();
            temp.respuesta_a.answer = respuestas_vn[i];
            temp.respuesta_b.answer = respuestas_deuta_leve[i];
            temp.respuesta_c.answer = respuestas_deuta_agudo[i]; 
            temp.respuesta_d.answer= respuestas_prota_agudo[i];
            temp.respuesta_e.answer= respuestas_prota_leve[i];
            
            
            i++;
        }while(ganancia == 21);
    }
    
}


