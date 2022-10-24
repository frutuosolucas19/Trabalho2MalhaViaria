
package model;

import controller.ControllerCarro;
import controller.ControllerMalha;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Carro extends Thread {
    private int codigoCarro = 15;
    private int posicaoAtual;
    private String imagemCarro;
    private int carrosCriados = 0;
    private ControllerCarro conCarro = new ControllerCarro();

    public Carro(){
        this.setCodigoCarro(this.codigoCarro ++);
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
    
    @Override
    public void run(){
        System.out.println(this.toString());
        conCarro.iniciarCarro(this.codigoCarro);
       
    }
    
}
