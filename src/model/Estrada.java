
package model;

import controller.ControllerMalha;
import java.util.ArrayList;
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
    private int sentido;
    private int x;
    private int y;
    private Carro carro;
    private Boolean carroCriado;
    private ArrayList<Estrada> proxEstrada;
    private boolean cruzamento;
    
    public Estrada(int sentido, int x, int y) {
        this.sentido = sentido;
        this.x = x;
        this.y = y;
        proxEstrada = new ArrayList<>();
        verificacaoCruzamento();
    }
    
    public void verificacaoCruzamento() {
        if (this.sentido > 8) {
            this.cruzamento = true;
        }
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getSentido() {
        return sentido;
    }

    public void setSentido(int sentido) {
        this.sentido = sentido;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean getCarroCriado() {
        return carroCriado;
    }

    public void setCarroCriado(Boolean carroCriado) {
        this.carroCriado = carroCriado;
    }

    public ArrayList<Estrada> getProxEstrada() {
        return proxEstrada;
    }

    public void setProxEstrada(ArrayList<Estrada> proxEstrada) {
        this.proxEstrada = proxEstrada;
    }

    public boolean isCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(boolean cruzamento) {
        this.cruzamento = cruzamento;
    }
    
    public void adicionarProxCelula(Estrada estrada){
        this.proxEstrada.add(estrada);
    }
    
    
    public void adicionarCarroEstrada(Carro carro) {
        try {
            while (getCarro() != null) {
                wait(carro.getVelocidadeCarro());
            }
            setCarro(carro);
        } 
        catch (Exception e) {
        }
    }
    
    public void removerCarro() {
        carro = null;
    }
}
