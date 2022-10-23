
package model;

import controller.ControllerCarro;
import controller.ControllerMalha;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Carro{
    private int codigoCarro;
    private int posicaoAtual;
    private String imagemCarro;
    private int carrosCriados = 0;

    public Carro(){
        
    }
    
    public Carro(int posicao){
        this.posicaoAtual = posicao;
    }
    
    public int getCodigoCarro() {
        return codigoCarro + 15;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    public int getPosicaoAtual() {
        posicaoAtual = 20;
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public String getImagemCarro() {
        return imagemCarro;
    }

    public void setImagemCarro(String imagemCarro) {
        this.imagemCarro = imagemCarro;
    }
    
    
}
