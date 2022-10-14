
package model;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Carro {
    private int codigoCarro;
    private int posicaoAtual;
    private String imagemCarro;

    public Carro(int posicao){
        this.posicaoAtual = posicao;
    }
    
    public int getCodigoCarro() {
        return codigoCarro;
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
