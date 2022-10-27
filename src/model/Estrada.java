package model;

import java.util.ArrayList;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public abstract class Estrada {

    protected int sentido;
    protected int x;
    protected int y;
    protected Carro carro;
    public static Boolean carroCriado;
    protected ArrayList<Estrada> proxEstrada;
    protected boolean cruzamento;

    public Estrada(int sentido, int x, int y) {
        this.sentido = sentido;
        this.x = x;
        this.y = y;
        proxEstrada = new ArrayList<>();
        verificacaoCruzamento();
    }

    public final void verificacaoCruzamento() {
        if (this.sentido > 8) {
            this.cruzamento = true;
        }
    }

    public abstract void adicionarCarro(Carro carro);

    public abstract void removerCarro();

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

    public void adicionarProxEstrada(Estrada estrada) {
        this.proxEstrada.add(estrada);
    }

}
