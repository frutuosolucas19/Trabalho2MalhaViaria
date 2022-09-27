/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import model.MalhaViaria;
import utils.ScannerTxt;
import view.SimuladorMalha;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerCriacaoMalha {

    private File blocoNotas;
    private ScannerTxt scanner;
    private int matriz[][];
    private MalhaViaria malhaViaria;
    static int linhas;
    static int colunas;
    private static ControllerCriacaoMalha instance = null; //Singleton

    private ControllerCriacaoMalha() {
    }
    
    public synchronized static ControllerCriacaoMalha getInstance(){
        if (instance == null) {
            instance = new ControllerCriacaoMalha();
        }
        return instance;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void setCaminhoMalha(String caminho) throws FileNotFoundException {
        this.blocoNotas = new File(caminho);
        if (blocoNotas.exists() != true) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o caminho da Malha Viária!");
            System.exit(0);
        }
        System.out.println(blocoNotas);
        criarMalha();
    }

    public void criarMalha() throws FileNotFoundException {
        scanner = new ScannerTxt();
        matriz = scanner.scanearTxt(blocoNotas);

         linhas = matriz.length;
         colunas = matriz[0].length;
        
        malhaViaria = MalhaViaria.getInstance();
        malhaViaria.setLinha(linhas);
        malhaViaria.setColuna(colunas);      
    }

}
