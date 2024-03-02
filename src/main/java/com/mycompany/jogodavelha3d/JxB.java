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
public class JxB {
    private int[] sorteiaCoordenadas(Tabuleiro a){
        int[]v = new int [3];
        int i, j, k;
        
        do{
            i = (int) (Math.random() * 2);
            j = (int) (Math.random() * 2);
            k = (int) (Math.random() * 2);
        }while(a.getInfo(i, j, k) != '_');
        
        v[0] = i;
        v[1]= j;
        v[2] = k;
        
        return v;
    }
    private int[] converteStringInt(String s) {
        
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
        
        String player, p, jogada;
        Tabuleiro a = new Tabuleiro();
        char j,b;
        int []vet = new int [3];
        String bot = "BOT";
        int v=0;
        
        
        System.out.println("Digite o seu nome:");
        player = teclado.nextLine();
        
        System.out.println("Digite o simbolo que deseja utilizar durante o jogo:");
        p = teclado.nextLine();
        
         j = converteStringChar(p);
         
         if(j != 'x' && j != 'X')
             b = 'X';
         else b = 'O';
             
        
        a.imprime();
        
        while(!a.detectaFim(j) && !a.detectaFim(b)){
            
            System.out.println("====> Turno de " + player);
            System.out.println("Digite a posicao que deseja jogar no formato (linha,coluna, camada): ");
            jogada = teclado.nextLine();
            
            
           vet = converteStringInt(jogada);
           
           a.realizaJogada(vet[1],vet [0], vet[2], j);
           a.imprime();
           if(a.detectaFim(j)){
               v =1;
               break;
           }
               
           
           System.out.println("====> Turno de " + bot);
            
          vet = sorteiaCoordenadas(a);
           a.realizaJogada(vet[0],vet [1], vet[2], b);
           a.imprime();
                
                
        }
        if(a.ehEmpate())
            System.out.println("Jogo empatado!");
        else if(v==1)
            System.out.println("Parabens "+ player + "!");
        else
            System.out.println("O BOT venceu!");
        
        
    }
}
