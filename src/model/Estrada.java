
package model;

import controller.ControllerMalha;
import view.MenuMalha;
import view.SimuladorMalha;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Estrada {
    
    private final int estradaCima = 1;
    private final int estradaDireita = 2;
    private final int estradaBaixo = 3;
    private final int estradaEsquerda = 4;
    private final int estradaCruzamentoCima = 5;
    private final int estradaCruzamentoDireita = 6;
    private final int estradaCruzamentoBaixo = 7;
    private final int estradaCruzamentoEsquerda = 8;
    private final int estradaCruzamentoCimaDireita = 9;
    private final int estradaCruzamentoCimaEsquerda = 10;
    private final int estradaCruzamentoDireitaBaixo = 11;
    private final int estradaCruzamentoBaixoEsquerda = 12;
    private static Estrada instance = null;
    
    private Estrada(){
        
    }
    
    public static Estrada getInstance(){
        if(instance == null){
            instance = new Estrada();
        }
        return instance;
    }

    public int getEstradaCima() {
        return estradaCima;
    }

    public int getEstradaDireita() {
        return estradaDireita;
    }

    public int getEstradaBaixo() {
        return estradaBaixo;
    }

    public int getEstradaEsquerda() {
        return estradaEsquerda;
    }

    public int getEstradaCruzamentoCima() {
        return estradaCruzamentoCima;
    }

    public int getEstradaCruzamentoDireita() {
        return estradaCruzamentoDireita;
    }

    public int getEstradaCruzamentoBaixo() {
        return estradaCruzamentoBaixo;
    }

    public int getEstradaCruzamentoEsquerda() {
        return estradaCruzamentoEsquerda;
    }

    public int getEstradaCruzamentoCimaDireita() {
        return estradaCruzamentoCimaDireita;
    }

    public int getEstradaCruzamentoCimaEsquerda() {
        return estradaCruzamentoCimaEsquerda;
    }

    public int getEstradaCruzamentoDireitaBaixo() {
        return estradaCruzamentoDireitaBaixo;
    }

    public int getEstradaCruzamentoBaixoEsquerda() {
        return estradaCruzamentoBaixoEsquerda;
    }
   
    
    
}
