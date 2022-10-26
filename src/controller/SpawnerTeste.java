package controller;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class SpawnerTeste extends Thread{
    ControllerEstrada conEstrada = ControllerEstrada.getInstance();
    ControllerMalha conMalha = ControllerMalha.getInstance();
    private boolean on = true;
    private int velocidade = 500;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    private int totalCars = 0;

    public void removerCarro() {

    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void run() {
        while (on) {
            try {
                if (totalCars < conMalha.getQuantiCarros()) {
                    conEstrada.nascerCarro();
                    totalCars++;
                    sleep(velocidade);
                }
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(SpawnerTeste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
