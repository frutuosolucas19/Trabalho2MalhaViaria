package controller;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;

/**
 *
 * @author matheus
 */
public class CarroTeste extends Thread{
    private Carro car;
    private int contador;
    private int velocidade = 1000;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    ControllerMalha conMalha = ControllerMalha.getInstance();
    ControllerEstrada conEstrada = ControllerEstrada.getInstance();

    public CarroTeste(Carro car, int velocity) {
        this.car = car;
        this.velocidade = velocity;
    }

    @Override
    public void run() {
        Random rand = new Random();
        conMalha.notificarAtualizarTabela();
        try {
            //Inicia o ciclo de vida do carro
            while (!this.car.getPosicaoAtual().getProxEstrada().isEmpty()) {

                sleep(velocidade); //velocidade do carro

                int numRand = rand.nextInt(2);
                if (this.car.getPosicaoAtual().isCruzamento()) {
                    if (this.car.getPosicaoAtual().isCruzamento()) {
                        contador++;
                    } else {
                        contador = 0;
                    }
                    if (contador >= 2) {
                        contador = 0;
                        if (this.car.getPosicaoAtual().getProxEstrada().get(0).isCruzamento()) {
                            numRand = 1;
                        } else {
                            numRand = 0;
                        }
                    }
                    this.car.getPosicaoAtual().getProxEstrada().get(numRand).adicionarCarro(car);
                    this.car.getPosicaoAtual().removerCarro();
                    this.car.setPosicaoVelha(this.car.getPosicaoAtual());
                    this.car.setPosicaoAtual(this.car.getPosicaoAtual().getProxEstrada().get(numRand));
                    this.car.setProxSentido(numRand);

                } else {
                    this.car.getPosicaoAtual().getProxEstrada().get(0).adicionarCarro(car);
                    this.car.getPosicaoAtual().removerCarro();
                    this.car.setPosicaoVelha(this.car.getPosicaoAtual());
                    this.car.setPosicaoAtual(this.car.getPosicaoAtual().getProxEstrada().get(0));
                }
                conEstrada.definirCarroImagem(car);
                conMalha.notificarAtualizarTabela();
            }

            //Destroi o carro quando chega no fim
            sleep(velocidade);
            conEstrada.definirCarroImagem(car);
            this.car.getPosicaoAtual().removerCarro();
            conMalha.notificarAtualizarTabela();
            conEstrada.getSpawn().removerCarro();
        } catch (InterruptedException ex) {
            Logger.getLogger(CarroTeste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Carro getCar() {
        return car;
    }

    public void setCar(Carro car) {
        this.car = car;
    }
}
