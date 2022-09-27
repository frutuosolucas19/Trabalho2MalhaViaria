/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ScannerTxt {

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
        
        return matriz;
    }
}
