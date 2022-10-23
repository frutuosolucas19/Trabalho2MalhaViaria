package controller;

import controllerObserver.InterfaceMalha;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;
import model.Estrada;
import model.MalhaViaria;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerCarro extends Thread {

    private Boolean iniciar = false;
    private int carrosCriados = 0;
    private int qtdCarro = 0;
    private Carro carro;
    private static MalhaViaria malhaViaria = MalhaViaria.getInstance();
    private static Estrada estrada;
    private String sentidoEstrada;

    public synchronized void criarCarro(int quantidadeCarros) throws InterruptedException {
        this.qtdCarro = quantidadeCarros;
        // while(true){
        carro = new Carro();
        carro.setCodigoCarro(4);
        this.start();
        // }
    }

    @Override
    public void run() {
        ControllerMalha conCriacaoMalha = new ControllerMalha();
        Boolean status = true;
        int valorMatriz = 0;
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4) + 1;
        System.out.println(numeroAleatorio);

        if (numeroAleatorio == 2) {
            int i = retornaValorLinha(2);
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if ((malhaViaria.getMatriz()[i][j] == 2 || malhaViaria.getMatriz()[i][j] == 5 || malhaViaria.getMatriz()[i][j] == 9 || malhaViaria.getMatriz()[i][j] == 11)
                        && status == true && retornaValorSentido(2) == 2 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i][j - 1] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());
                    }
                    sentidoEstrada = "Direita";
                    carrosCriados++;
                    valorMatriz = malhaViaria.getMatriz()[i][j];
                    //Aqui ele define o ID que será pintado na Malha Viária
                    malhaViaria.getMatriz()[i][j] = carro.getCodigoCarro();
                    //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                    conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());

                }
            }
        }
        if (numeroAleatorio == 4) {
            int i = retornaValorLinha(4);
                for (int j = malhaViaria.getColuna() - 1; j >= 0; j--) {
                    if ((malhaViaria.getMatriz()[i][j] == 4 || malhaViaria.getMatriz()[i][j] == 8 || malhaViaria.getMatriz()[i][j] == 10 || malhaViaria.getMatriz()[i][j] == 12)
                            && status == true && retornaValorSentido(4) == 4 && qtdCarro != 0) {
                        if (valorMatriz != 0) {
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            malhaViaria.getMatriz()[i][j + 1] = valorMatriz;
                            conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());
                        }
                        sentidoEstrada = "Esquerda";
                        carrosCriados++;
                        valorMatriz = malhaViaria.getMatriz()[i][j];
                        //Aqui ele define o ID que será pintado na Malha Viária
                        malhaViaria.getMatriz()[i][j] = carro.getCodigoCarro();
                        //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                        conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());

                    }
                }
            }

            if (numeroAleatorio == 3) {
                for (int i = 0; i < malhaViaria.getLinha(); i++) {
                    int j = retornaValorColuna(3);
                    if ((malhaViaria.getMatriz()[i][j] == 3 || malhaViaria.getMatriz()[i][j] == 7 || malhaViaria.getMatriz()[i][j] == 11 || malhaViaria.getMatriz()[i][j] == 12)
                            && status == true && retornaValorSentido(3) == 3 && qtdCarro != 0) {
                        if (valorMatriz != 0) {
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            malhaViaria.getMatriz()[i - 1][j] = valorMatriz;
                            conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());
                        }
                        sentidoEstrada = "Baixo";
                        carrosCriados++;
                        valorMatriz = malhaViaria.getMatriz()[i][j];
                        //Aqui ele define o ID que será pintado na Malha Viária
                        malhaViaria.getMatriz()[i][j] = carro.getCodigoCarro();
                        //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                        conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());

                    }
                }
            }

            if (numeroAleatorio == 1) {
                for (int i = malhaViaria.getLinha() - 1; i >= 0; i--) {
                    int j = retornaValorColuna(1);
                    if ((malhaViaria.getMatriz()[i][j] == 1 || malhaViaria.getMatriz()[i][j] == 5 || malhaViaria.getMatriz()[i][j] == 9 || malhaViaria.getMatriz()[i][j] == 10)
                            && status == true && retornaValorSentido(1) == 1 && qtdCarro != 0) {
                        if (valorMatriz != 0 && malhaViaria.getMatriz()[i + 1][j] == 50) {
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            malhaViaria.getMatriz()[i + 1][j] = valorMatriz;
                            conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());
                        }
                        sentidoEstrada = "Cima";
                        carrosCriados++;
                        valorMatriz = malhaViaria.getMatriz()[i][j];
                        //Aqui ele define o ID que será pintado na Malha Viária
                        malhaViaria.getMatriz()[i][j] = carro.getCodigoCarro();
                        //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                        conCriacaoMalha.notificarAtualizarTabela(carro.getCodigoCarro());

                    }
                }
            }

            status = false;
            System.out.println(carrosCriados);
            //sleep(1000);
            // }
        }

    

    public int retornaValorSentido(int valor) {
        int retorno = 0;
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if (malhaViaria.getMatriz()[i][j] == valor) {
                    retorno = malhaViaria.getMatriz()[i][j];
                    return retorno;
                }
            }
        }
        return 0;
    }

    public int retornaValorColuna(int valor) {
        int retorno = 0;
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if (malhaViaria.getMatriz()[i][j] == valor) {
                    retorno = j;
                    return retorno;
                }
            }
        }
        return 0;
    }

    public int retornaValorLinha(int valor) {
        int retorno = 0;
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if (malhaViaria.getMatriz()[i][j] == valor) {
                    retorno = i;
                    return retorno;
                }
            }
        }
        return 0;
    }

    public String getSentidoEstrada() {
        return sentidoEstrada;
    }

    public void setSentidoEstrada(String estradaDireita) {
        this.sentidoEstrada = estradaDireita;
    }

}
