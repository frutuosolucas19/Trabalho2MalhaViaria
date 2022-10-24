/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ScannerMatriz {

    private int matriz[][];

    public int[][] scanearTxt(File blocoNotas) throws FileNotFoundException {
        Scanner scan = new Scanner(blocoNotas);
        try{
        int linha = Integer.parseInt(scan.next().trim());
        int coluna = Integer.parseInt(scan.next().trim());
        matriz = new int[linha][coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz[i][j] = Integer.parseInt(scan.next().trim());
            }
        }

        }catch(Exception e){
            e.printStackTrace();
        }
        scan.close();
        return matriz;
    }
    
    public int[][] retornaMatriz(int[][] matriz) {
    
        int[][] matrizRetorno;
        int linha = matriz.length;
        int coluna = matriz[0].length;
        matrizRetorno = new int[linha][coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matrizRetorno[i][j] = valorIndividualMatriz(matriz);
            }
        }
        return matriz;
    }
    
    public int valorIndividualMatriz(int[][] matriz){
        int retorno;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                return retorno = matriz[i][j];
            }
        }
        return 0;
    }
}
