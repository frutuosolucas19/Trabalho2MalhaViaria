package controller;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerSpawner extends Thread {

    ControllerEstrada conEstrada = ControllerEstrada.getInstance();
    ControllerMalha conMalha = ControllerMalha.getInstance();
    private boolean on = true;
    private int velocidade = 300;
    private int totalCarros = 0;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void removerCarro() {

    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void run() {
        while (on) {
            try {
                if (totalCarros < conMalha.getQuantidadeCarros()) {
                    conEstrada.nascerCarro();
                    totalCarros++;
                    sleep(velocidade);
                }
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
