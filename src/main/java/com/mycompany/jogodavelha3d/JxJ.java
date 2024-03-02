/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodavelha3d;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class JxJ {
    
    private int[] converteStringInt (String s) {
        
        int[] vet = new int [3];
        char c;
        int k = 0;
        for(int i = 0; i < s.length() ; i++){
                
                char x = s.charAt(i);
                if(x <= '9' && x >= '0'){
                    
                    c = s.charAt(i);
                    vet[k] = c - '0';
                    k++;
                }
            }
        return vet;
    }
    private char converteStringChar(String s){
        char x = s.charAt(0);
        return x;
        
    }
    public void organizaJogo (){
        
        Scanner teclado = new Scanner(System.in);
        
        String player1, player2, p1, p2, jogada;
        Tabuleiro a = new Tabuleiro();
        char j1,j2;
        int []vet = new int [3];
        int v=0;
        
        
        
        System.out.println("Digite o nome do jogador:");
        player1 = teclado.nextLine();
        
        System.out.println("Digite o simbolo que deseja utilizar durante o jogo:");
        p1 = teclado.nextLine();
        
        System.out.println("Digite o nome do jogador:");
        player2 = teclado.nextLine();
        
        System.out.println("Digite o simbolo que deseja utilizar durante o jogo:");
        p2 = teclado.nextLine();
        
        j1 = converteStringChar(p1);
        j2 = converteStringChar(p2);
        
        a.imprime();
        
        while(!a.detectaFim(j1) && !a.detectaFim(j2)){
            
            System.out.println("====> Turno de " + player1);
            System.out.println("Digite a posicao que deseja jogar no formato (linha,coluna, camada): ");
            jogada = teclado.nextLine();
            
            
           vet = converteStringInt(jogada);
           
           a.realizaJogada(vet[1],vet [0], vet[2], j1);
           a.imprime();
           if(a.detectaFim(j1))
           {
               v=1;
               break;
           }
               
           
           System.out.println("====> Turno de " + player2);
            System.out.println("Digite a posicao que deseja jogar no formato (linha,coluna, camada): ");
            jogada = teclado.nextLine();
            
           
          vet = converteStringInt(jogada);
           a.realizaJogada(vet[1],vet [0], vet[2], j2);
           a.imprime();
                
                
        }
        if(a.ehEmpate())
            System.out.println("Jogo empatado!");
        else if(v==1)
            System.out.println("Parabens "+ player1 + "!");
        else
            System.out.println("Parabens "+ player2 + "!");

        
    }
}
