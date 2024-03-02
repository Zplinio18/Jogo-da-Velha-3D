/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodavelha3d;

/**
 *
 * @author pedro
 */
public class Tabuleiro {
    private char [][][] m= new char [3][3][3];
    private int cont=0;
    private char [][] ver1= new char[3][3];
    private char [][] ver2= new char[3][3];
    private int aux = 0;
    public Tabuleiro(){
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j< 3; j++)
                for(int k=0; k<3;k++)
                    m[i][k][j] = '_';
        
    }
    private void verificaVitoria(int a, int b,char c){
       
                    if(cont%2 == 0)
                    {
                        if(ver2[b][a] == c);
                        else
                            ver2[b][a] = c;
                        
                    for(int i = 0; i < 3; i++)
                        for(int j = 0; j< 3; j++)
                            if(i == 0 &&ver2[i][j] == c && ver2[i+1][j] == c && ver2[i+2][j] == c)
                                aux = 1;
                            else if(j == 0 && ver2[i][j] == c && ver2[i][j+1] == c && ver2[i][j+2] == c)
                                aux = 1;
                            else if (i == 0 && j== 0 && ver2[i][j] == c && ver2[i+2][j+2]== c && ver2[i+1][j+1] == c)
                                aux = 1;
                            else if (i == 0 && j== 2 && ver2[i][j] == c && ver2[i+1][j-1]== c && ver2[i+2][j-2]== c)
                                aux = 1;
                    }
                    else
                    {
                        if(ver1[b][a] == c);
                        else
                            ver1[b][a] = c;
                        
                        
                    for(int i = 0; i < 3; i++)
                        for(int j = 0; j< 3; j++)
                            if(i == 0 &&ver1[i][j] == c && ver1[i+1][j] == c && ver1[i+2][j] == c)
                                aux = 1;
                            else if(j == 0 && ver1[i][j] == c && ver1[i][j+1] == c && ver1[i][j+2] == c)
                                aux = 1;
                            else if (i == 0 && j== 0 && ver1[i][j] == c && ver1[i+2][j+2]== c && ver1[i+1][j+1] == c)
                                aux = 1;
                            else if (i == 0 && j== 2 && ver1[i][j] == c && ver1[i+1][j-1]== c && ver1[i+2][j-2]== c)
                                aux = 1;
                    }
                    
        
    }
    public void imprime(){
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                for(int k=0; k<3;k++)
                   System.out.print(m[i][j][k] + " ");
                    
             System.out.print("  "); 
            }
         System.out.println("");
        }        
        System.out.println("");
    }
    public char getInfo(int i, int j, int k){
        return m[j][k][i];
    }
    public void realizaJogada(int i, int j, int k, char a){
        
        cont++;
        if(i > 2 || i < 0 || j > 2 || j < 0|| k > 2|| k < 0)
            System.out.println("ERRO: indices invalidos!\n");
        else if(m[j][k][i] == '_')
            m[j][k][i] = a;
        else
            System.out.println("ERRO: jogada invalida!\n");
        
        verificaVitoria(i,j,a);
        
    }
    public boolean ehEmpate(){
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j< 3; j++)
                for(int k=0; k<3;k++)
                   if(m[i][k][j] == '_')
                       return false;
        
        return true;
    }
    
    public boolean detectaFim(char c)  {
        
        if(ehEmpate())
            return true;
        else if (aux == 1)
          return true;
        
        return false;
    }
 
}
