package controller;

import controllerObserver.InterfaceMalha;
import model.Estrada;
import model.MalhaViaria;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerEstrada {

    private static MalhaViaria malhaViaria;
    private static ControllerMalha conCriacaoMalha;
    private Estrada estrada;
    // private static InterfaceMalha interMalha;

    //public void verificaEstrada(){
    // interMalha = new ControllerCriacaoMalha();
    // interMalha.atualizarSimulador();
    //}
    public void verificaEstrada(int posicao) {
        malhaViaria = MalhaViaria.getInstance();
        estrada = Estrada.getInstance();

        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if(malhaViaria.getMatriz()[i][j] == estrada.getEstradaCima()){
                    
                }

            }
        }
    }
}
