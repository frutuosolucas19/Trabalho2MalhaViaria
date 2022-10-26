package controller;

import controllerObserver.InterfaceMalha;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Estrada;
import model.MalhaViaria;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerEstrada {

    private static MalhaViaria malhaViaria = MalhaViaria.getInstance();
    private static Estrada matrizEstrada[][];
    private ControllerCarro conCarro = ControllerCarro.getInstance();
    private static Random random = new Random();
    private static ControllerEstrada instance = null;
    private static SpawnerTeste nascer;
    
    private ControllerEstrada(){
        
    }
    
    public static ControllerEstrada getInstance(){
        if(instance == null){
            instance = new ControllerEstrada();
        }
        return instance;
    }
    
    public void iniciar() {
        //notificarBotaoDesativacao(true);
        nascer = new SpawnerTeste();
        nascer.start();
    }
    
    public SpawnerTeste getSpawn() {
        return nascer;
    }
    
    public void verificaEstrada(int posicao) {
        matrizEstrada = new Estrada[malhaViaria.getLinha()][malhaViaria.getColuna()];
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                 if (malhaViaria.getMatriz()[i][j] != 0) {
                     Estrada estrada = new Estrada(malhaViaria.getMatriz()[i][j], i, j);
                     matrizEstrada[i][j] = estrada;
                     conCarro.sentidoCarro(estrada);
                 }else{
                     matrizEstrada[i][j] = null;
                 }
            }
            
    }
        definirProxCelula();
}
    
    public void definirProxCelula() {
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                Estrada estrada = matrizEstrada[i][j];
                if (estrada != null) {
                    try {
                        switch (estrada.getSentido()) {
                            case 1:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]); //cima
                                break;
                            case 2:
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]); //direita
                                break;
                            case 3:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]); // baixo
                                break;
                            case 4:
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]); // esquerda
                                break;
                            case 5:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]); //cima
                                break;
                            case 6:
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);//direita
                                break;
                            case 7:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);//baixo
                                break;
                            case 8:
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);//esquerda
                                break;
                            case 9:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);
                                break;
                            case 10:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);
                                break;
                            case 11:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);
                                break;
                            case 12:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);
                                break;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
        
    public void nascerCarro() {
        List<Estrada> estradas = new ArrayList();
        for (Estrada[] estradaLinha : matrizEstrada) {
            for (Estrada estrada : estradaLinha) {
                if (estrada != null && estrada.getCarroCriado()) {
                    estradas.add(estrada);

                }
            }
        }
 
        definirCarro(estradas.get(random.nextInt(estradas.size())));
    }
    
    public void definirCarro(Estrada estrada){
        estrada.adicionarCarroEstrada(conCarro.retornaCarro(estrada));
    }
}
