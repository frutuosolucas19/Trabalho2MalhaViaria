
package controller;

import controllerObserver.InterfaceMalha;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.MalhaViaria;
import utils.ScannerMatriz;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerMalha{

    private File blocoNotas;
    private ScannerMatriz scanner;
    private int matriz[][];
    private static MalhaViaria malhaViaria;
    private static ControllerEstrada conEstrada;
    private static List<InterfaceMalha> listaObserversMalha = listaObserversMalha = new ArrayList<>();
    private static ControllerMalha instance = null;
    private int quantidadeCarros;
    
    private ControllerMalha(){
        
    }
    
    public static ControllerMalha getInstance() {
        if (instance == null) {
            instance = new ControllerMalha();
            
        }
        return instance;
    }
    
    public ControllerMalha(MalhaViaria malhaViaria) {
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
        
        conEstrada = ControllerEstrada.getInstance();
        scanner = new ScannerMatriz();
        matriz = scanner.scanearTxt(blocoNotas);
        malhaViaria.setMatriz(matriz);
        malhaViaria.setLinha(matriz.length);
        malhaViaria.setColuna(matriz[0].length);
        imprimirMatriz();
        conEstrada.verificaEstrada();
    }
    
    public void gerarMapa(){
        notificarAtualizarMalha(MalhaViaria.getInstance().getMatriz(), MalhaViaria.getInstance().getLinha(), 
                                MalhaViaria.getInstance().getColuna());
    }
    


    //este método adiciona a view simuladormalha para ficar observando qualquer mudança
     public void adicionarObserver(InterfaceMalha interObs) {
        this.listaObserversMalha.add(interObs);
    }
     
     public void notificarAtualizarMalha(int[][] matriz, int linha, int coluna){
         for(InterfaceMalha interMalha : listaObserversMalha){
             interMalha.gerarTabelaMalha(matriz, linha, coluna);
         }
     }
     
     public void notificarAtualizarTabela(){
         for(InterfaceMalha interMalha : listaObserversMalha){
             interMalha.atualizarSimulador();
         }
     }
     
      private void notificaQuantiCarros(int valor) {
        for (InterfaceMalha interfaceMalha : listaObserversMalha) {
            interfaceMalha.definirQuatCarros(valor);
        }
    }
    
       public void definirCarros(int valor) {
        this.quantidadeCarros = valor;
        if (valor > 0) {
            notificaQuantiCarros(valor);
        }
    }
       
        public int getQuantiCarros() {
        return quantidadeCarros;
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
