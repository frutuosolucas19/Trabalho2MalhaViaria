
package model;

import java.util.Random;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Carro  {
    private int codigoCarro = 15;
    private Estrada posicaoAtual;
    private Estrada posicaoVelha;
    private String imagem;
    private int proxSentido;
    private String imagemCarro;
    private int quantidadeCarros = 0;
    private int velocidadeCarro;
    private Random random = new Random();

    public Carro(){
        this.setCodigoCarro(this.codigoCarro ++);
    }
    
   public Carro(int codCarro, Estrada estrada) {
        this.codigoCarro = codCarro;
        this.posicaoAtual = estrada;
        this.proxSentido = 0;

    }
    
    public int getCodigoCarro() {
        return codigoCarro + 15;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    public String getImagemCarro() {
        return imagemCarro;
    }

    public void setImagemCarro(String imagemCarro) {
        this.imagemCarro = imagemCarro;
    }

    public int getVelocidadeCarro() {
        return velocidadeCarro;
    }

    public void setVelocidadeCarro(int velocidadeVeiculo) {
        this.velocidadeCarro = velocidadeVeiculo;
    }

    public Estrada getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(Estrada posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public Estrada getPosicaoVelha() {
        return posicaoVelha;
    }

    public void setPosicaoVelha(Estrada posicaoVelha) {
        this.posicaoVelha = posicaoVelha;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getProxSentido() {
        return proxSentido;
    }

    public void setProxSentido(int proxSentido) {
        this.proxSentido = proxSentido;
    }
    
    
    
    public void definicaoImagem(int direcao) {
        if (direcao == 1) {
            this.imagem = "./imagens/carrovermelhocima.png";
        } else if(direcao == 2){
            this.imagem = "./imagens/carrovermelhodireita.png";
        }else if(direcao == 3){
            this.imagem = "./imagens/carrovermelhobaixo.png";
        }else if(direcao == 4){
            this.imagem = "./imagens/carrovermelhoesquerda.png";
        }

    }
    
   /* @Override
    public void run(){
        this.velocidadeCarro = (random.nextInt(1) + 1) * 1000;
        System.out.println(this.toString());
        while(true){
        try {   
        if(quantidadeCarros < conCarro.getQtdCarro())
        conCarro.iniciarCarro();
        quantidadeCarros ++;
            
                sleep(velocidadeCarro);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    */
}
