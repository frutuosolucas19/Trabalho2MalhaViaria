package controller;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerCarro extends Thread {

    private Carro carro;
    private int contador;
    private int velocidade = 1000;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    ControllerMalha conMalha = ControllerMalha.getInstance();
    ControllerEstrada conEstrada = ControllerEstrada.getInstance();

    public ControllerCarro(Carro carro, int velocidade) {
        this.carro = carro;
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        Random rand = new Random();
        conMalha.notificarAtualizarTabela();
        try {
            while (!this.carro.getPosicaoAtual().getProxEstrada().isEmpty()) {

                sleep(velocidade);

                int numRand = rand.nextInt(2);
                if (this.carro.getPosicaoAtual().isCruzamento()) {
                    if (this.carro.getPosicaoAtual().isCruzamento()) {
                        contador++;
                    } else {
                        contador = 0;
                    }
                    if (contador >= 2) {
                        contador = 0;
                        if (this.carro.getPosicaoAtual().getProxEstrada().get(0).isCruzamento()) {
                            numRand = 1;
                        } else {
                            numRand = 0;
                        }
                    }
                    this.carro.getPosicaoAtual().getProxEstrada().get(numRand).adicionarCarro(carro);
                    this.carro.getPosicaoAtual().removerCarro();
                    this.carro.setPosicaoVelha(this.carro.getPosicaoAtual());
                    this.carro.setPosicaoAtual(this.carro.getPosicaoAtual().getProxEstrada().get(numRand));
                    this.carro.setProxSentido(numRand);

                } else {
                    this.carro.getPosicaoAtual().getProxEstrada().get(0).adicionarCarro(carro);
                    this.carro.getPosicaoAtual().removerCarro();
                    this.carro.setPosicaoVelha(this.carro.getPosicaoAtual());
                    this.carro.setPosicaoAtual(this.carro.getPosicaoAtual().getProxEstrada().get(0));
                }
                conEstrada.definirCarroImagem(carro);
                conMalha.notificarAtualizarTabela();
            }

            sleep(velocidade);
            conEstrada.definirCarroImagem(carro);
            this.carro.getPosicaoAtual().removerCarro();
            conMalha.notificarAtualizarTabela();
            conEstrada.getControllerSpawner().removerCarro();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
