/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jogodavelha3d;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class JogoDaVelha3D {

    public static void inicioJogo(){
        System.out.println("Bem vindo ao Jogo da Velha 3D!!!");
    }
    public static void main(String[] args) {
        
        inicioJogo();
        String modo;
        String novamente = "S";
        Scanner teclado = new Scanner(System.in);
        
        while(novamente.equals("S") || novamente.equals("s"))
        {
            
            do{
                 System.out.println("Digite o Modo de Jogo (JxJ - para dois jogadores, ou JxB - para ogar contra o bot)");
                modo = teclado.nextLine();
            }
            while(!modo.equals("JxJ") && !modo.equals("JxB"));
            
           if(modo.equals("JxJ")){
                JxJ p = new JxJ();
                p.organizaJogo();
            }
           else{
               JxB q = new JxB();
               q.organizaJogo();
           }
            
           
            System.out.println("Jogar Novamente?(S/N)");
             novamente = teclado.nextLine();
        }
        
       
    }
}
