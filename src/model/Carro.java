package model;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class Carro {

    private int codigoCarro;
    private Estrada posicaoAtual;
    private Estrada posicaoVelha;
    private String imagemCarro;
    private int proxSentido;
    private int velocidadeCarro;

    public Carro() {
    }

    public Carro(int codCarro, Estrada estrada) {
        this.codigoCarro = codCarro;
        this.posicaoAtual = estrada;
        this.proxSentido = 0;
    }

    public int getCodigoCarro() {
        return codigoCarro;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
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

    public String getImagemCarro() {
        return imagemCarro;
    }

    public void setImagemCarro(String imagemCarro) {
        this.imagemCarro = imagemCarro;
    }

    public int getProxSentido() {
        return proxSentido;
    }

    public void setProxSentido(int proxSentido) {
        this.proxSentido = proxSentido;
    }

    public void definicaoImagem(int direcao) {
        switch (direcao) {
            case 1:
                this.imagemCarro = "./imagens/carrovermelhocima.png";
                break;
            case 2:
                this.imagemCarro = "./imagens/carrovermelhodireita.png";
                break;
            case 3:
                this.imagemCarro = "./imagens/carrovermelhobaixo.png";
                break;
            case 4:
                this.imagemCarro = "./imagens/carrovermelhoesquerda.png";
                break;
            default:
                break;
        }

    }

}
