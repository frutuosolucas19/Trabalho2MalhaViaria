
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import model.MalhaViaria;
import utils.ScannerTxt;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerCriacaoMalha {

    private File blocoNotas;
    private ScannerTxt scanner;
    private int matriz[][];
    private static MalhaViaria malhaViaria;
    
    
    public ControllerCriacaoMalha() {
    }
    
 
    public MalhaViaria getMalhaViaria() {
        return malhaViaria;
    }

    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }
    
    

    public void setCaminhoMalha(String caminho) throws FileNotFoundException {
        this.blocoNotas = new File(caminho);
        if (blocoNotas.exists() != true) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o caminho da Malha Viária!");
            System.exit(0);
        }
        System.out.println(blocoNotas);
        criarMalha(blocoNotas);
    }

    public void criarMalha(File blocoNotas) throws FileNotFoundException {
        
        
        scanner = new ScannerTxt();
        matriz = scanner.scanearTxt(blocoNotas);
        malhaViaria = new MalhaViaria();
        malhaViaria.setMatriz(matriz);
        malhaViaria.setLinha(matriz.length);
        malhaViaria.setColuna(matriz[0].length);
        //imprimirMatriz();
        
    }

    
    public void imprimirMatriz(){
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                System.out.print(malhaViaria.getMatriz()[i][j]);
            }
            System.out.println();
        }
    }
}
