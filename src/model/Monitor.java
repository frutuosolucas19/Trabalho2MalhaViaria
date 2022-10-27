package model;

/**
 *
 * @author lucas
 */
public class Monitor extends Estrada {

    @Override
    public void adicionarCarro(Carro carro) {
        try {
            while (this.getCarro() != null) {
                wait(carro.getVelocidadeCarro());
            }
            this.setCarro(carro);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void removerCarro() {
        super.carro = null;
    }

    public Monitor(int direcao, int x, int y) {
        super(direcao, x, y);
    }

}
