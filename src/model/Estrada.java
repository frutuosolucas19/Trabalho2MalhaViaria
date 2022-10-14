
package model;

import controller.ControllerCriacaoMalha;
import view.SimuladorMalha;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public abstract class Estrada {
    private static Carro carro;
    
    public static final int estradaCima = 1;
    public static final int estradaDireita = 2;
    public static final int estradaBaixo = 3;
    public static final int estradaEsquerda = 4;
    public static final int estradaCruzamentoCima = 5;
    public static final int estradaCruzamentoDireita = 6;
    public static final int estradaCruzamentoBaixo = 7;
    public static final int estradaCruzamentoEsquerda = 8;
    public static final int estradaCruzamentoCimaDireita = 9;
    public static final int estradaCruzamentoCimaEsquerda = 10;
    public static final int estradaCruzamentoDireitaBaixo = 11;
    public static final int estradaCruzamentoBaixoEsquerda = 12;
    public static Boolean status = true;
    private static MalhaViaria malhaViaria;
    private static SimuladorMalha simMalha;
    private static ControllerCriacaoMalha conCriacaoMalha;
    
    //Este método tem por objetivo analisar a matriz e trazer as posições onde somente o carro pode andar
    public static void matrizEstrada(){
        carro = new Carro(1);
        conCriacaoMalha = new ControllerCriacaoMalha();
        malhaViaria = conCriacaoMalha.getMalhaViaria();
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                //System.out.print(malhaViaria.getMatriz()[i][j]);
                if(malhaViaria.getMatriz()[i][j] == estradaDireita && status == true){
                    carro = new Carro(20);
                    malhaViaria.getMatriz()[i][j] = carro.getPosicaoAtual();
                    simMalha = new SimuladorMalha();
                    simMalha.atualizarSimulador(carro.getPosicaoAtual());
                    status = false;
                }
            }
            //System.out.println();
        }
        
    }
}
