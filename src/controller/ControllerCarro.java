package controller;

import controllerObserver.InterfaceMalha;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;
import model.Estrada;
import model.MalhaViaria;
import utils.ScannerMatriz;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerCarro {

    private static Boolean iniciar = false;
    private int carrosCriados = 0;
    private int qtdCarro = 0;
    private static MalhaViaria malhaViaria = MalhaViaria.getInstance();
    private static Estrada estrada;
    private static String sentidoEstrada;
    private Random random = new Random();
    private int velocidadeVeiculo;
    private ControllerMalha conCriacaoMalha = ControllerMalha.getInstance();
    private ScannerMatriz scanMatriz = new ScannerMatriz();
    private static int codigoCarro;
    private static ControllerCarro instance = null;
    
    private ControllerCarro(){
    }

     public static ControllerCarro getInstance() {
        if (instance == null) {
            instance = new ControllerCarro();
        }
        return instance;
    }
/*
    public void prepararCarro(int quantidadeCarros) {
        this.qtdCarro = quantidadeCarros;
        this.iniciar = true;
        Carro carro = new Carro();
        carro.start();
    }*/
/*
    public void iniciarCarro() {

        int valorMatriz = 0;
        int numeroAleatorio = random.nextInt(4) + 1;
        velocidadeVeiculo = (random.nextInt(1) + 1) * 1000;
        this.qtdCarro = 1;

        codigoCarro++;
        if (numeroAleatorio == 2) {
            int i = retornaValorLinha(2);
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if ((malhaViaria.getMatriz()[i][j] == 2 || malhaViaria.getMatriz()[i][j] == 5 || malhaViaria.getMatriz()[i][j] == 9 || malhaViaria.getMatriz()[i][j] == 11)
                        && iniciar == true && retornaValorSentido(2) == 2 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i][j - 1] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(valorMatriz);
                    }
                    this.sentidoEstrada = "Direita";
                    carrosCriados++;
                    valorMatriz = malhaViaria.getMatriz()[i][j];
                    //Aqui ele define o ID que será pintado na Malha Viária
                    malhaViaria.getMatriz()[i][j] = codigoCarro;
                    //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                    conCriacaoMalha.notificarAtualizarTabela(codigoCarro);

                }
            }
        }
        if (numeroAleatorio == 4) {
            int i = retornaValorLinha(4);
            for (int j = malhaViaria.getColuna() - 1; j >= 0; j--) {
                if ((malhaViaria.getMatriz()[i][j] == 4 || malhaViaria.getMatriz()[i][j] == 8 || malhaViaria.getMatriz()[i][j] == 10 || malhaViaria.getMatriz()[i][j] == 12)
                        && iniciar == true && retornaValorSentido(4) == 4 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i][j + 1] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(valorMatriz);
                    }
                    this.sentidoEstrada = "Esquerda";
                    carrosCriados++;
                    valorMatriz = malhaViaria.getMatriz()[i][j];
                    //Aqui ele define o ID que será pintado na Malha Viária
                    malhaViaria.getMatriz()[i][j] = codigoCarro;
                    //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                    conCriacaoMalha.notificarAtualizarTabela(codigoCarro);

                }
            }
        }

        if (numeroAleatorio == 3) {
            int j = retornaValorColuna(3);
            for (int i = 0; i < malhaViaria.getLinha(); i++) {
                if ((malhaViaria.getMatriz()[i][j] == 3 || malhaViaria.getMatriz()[i][j] == 7 || malhaViaria.getMatriz()[i][j] == 11 || malhaViaria.getMatriz()[i][j] == 12)
                        && iniciar == true && retornaValorSentido(3) == 3 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i - 1][j] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(valorMatriz);
                    }
                    this.sentidoEstrada = "Baixo";
                    carrosCriados++;
                    valorMatriz = malhaViaria.getMatriz()[i][j];
                    //Aqui ele define o ID que será pintado na Malha Viária
                    malhaViaria.getMatriz()[i][j] = codigoCarro;
                    //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                    conCriacaoMalha.notificarAtualizarTabela(codigoCarro);

                }
            }
        }

        if (numeroAleatorio == 1) {
            int j = retornaValorColuna(1);
            for (int i = malhaViaria.getLinha() - 1; i >= 0; i--) {
                if ((malhaViaria.getMatriz()[i][j] == 1 || malhaViaria.getMatriz()[i][j] == 5 || malhaViaria.getMatriz()[i][j] == 9 || malhaViaria.getMatriz()[i][j] == 10)
                        && iniciar == true && retornaValorSentido(1) == 1 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i + 1][j] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(valorMatriz);
                    }
                    this.sentidoEstrada = "Cima";
                    carrosCriados++;
                    valorMatriz = malhaViaria.getMatriz()[i][j];
                    //Aqui ele define o ID que será pintado na Malha Viária
                    malhaViaria.getMatriz()[i][j] = codigoCarro;
                    //conCriacaoMalha.notificarAtualizarMalha(malhaViaria.getMatriz(), malhaViaria.getLinha(), malhaViaria.getColuna());
                    conCriacaoMalha.notificarAtualizarTabela(codigoCarro);

                }
            }
        }

    } */

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
        int numeroAleatorioColuna = 0;
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j = numeroAleatorioColuna) {
                if (malhaViaria.getMatriz()[i][j] == valor) {
                    retorno = j;
                    return retorno;
                }
                numeroAleatorioColuna = random.nextInt(malhaViaria.getColuna());
            }
        }
        return 0;
    }

    public int retornaValorLinha(int valor) {
        int retorno = 0;
        int j = 0;
        int numeroAleatorioLinha = 0;
        for (int i = 0; i < malhaViaria.getLinha(); i = numeroAleatorioLinha) {
            if (malhaViaria.getMatriz()[i][j] == valor) {
                retorno = i;
                return retorno;
            }
            numeroAleatorioLinha = random.nextInt(malhaViaria.getLinha());
            for (j = 0; j < malhaViaria.getColuna(); j++) {
                if (malhaViaria.getMatriz()[i][j] == valor) {
                    retorno = i;
                    return retorno;
                }
            }
            j = j - 1;
        }
        return 0;
    }
    
    public void sentidoCarro(Estrada estrada) {
        if (estrada != null) {
            if (estrada.getY()== 0) {
                if (estrada.getSentido() == 2) {
                    estrada.setCarroCriado(true);
                }
            } else if (estrada.getY() == (malhaViaria.getColuna() - 1)) {
                if (estrada.getSentido() == 4) {
                    estrada.setCarroCriado(true);
                }
            }

            if (estrada.getX() == 0) {
                if (estrada.getSentido() == 3) {
                    estrada.setCarroCriado(true);
                }
            } else if (estrada.getX() == (malhaViaria.getLinha() - 1)) {
                if (estrada.getSentido()== 1) {
                    estrada.setCarroCriado(true);
                }
            }
        }
    }
    
    public Carro retornaCarro(Estrada estrada) {
        Carro carro = new Carro(codigoCarro++, estrada);
        definirCarroImagem(carro);
        definirVelocidadeCarro(velocidadeVeiculo);
        CarroTeste driver = new CarroTeste(carro, this.velocidadeVeiculo);
        driver.start();
        return carro;
    }
    
    public synchronized void definirCarroImagem(Carro carro) {
        int direcaoAtual = carro.getPosicaoVelha().getSentido();
        int direcaoAnterior = 0;
        if (carro.getPosicaoVelha()!= null) {
            direcaoAnterior = carro.getPosicaoVelha().getSentido();
        }
        if (direcaoAtual > 4) {
            switch (direcaoAtual) {
                case 5:
                    carro.definicaoImagem(1);
                    break;
                case 6:
                    carro.definicaoImagem(2);
                    break;
                case 7:
                    carro.definicaoImagem(1);
                    break;
                case 8:
                    carro.definicaoImagem(2);
                    break;
                case 9:
                    if (carro.getProxSentido()== 0) {
                        carro.definicaoImagem(1);
                    } else {
                        carro.definicaoImagem(2);
                    }
                    break;
                case 10:
                    if (direcaoAnterior <= 4) {
                        if (carro.getProxSentido()== 0) {
                            carro.definicaoImagem(2);
                        } else {
                            carro.definicaoImagem(1);
                        }
                    } else {
                        if (carro.getProxSentido()== 0) {
                            carro.definicaoImagem(1);
                        } else {
                            carro.definicaoImagem(2);
                        }
                    }
                    break;
                case 11:
                    if (direcaoAnterior <= 4) {
                        if (carro.getProxSentido() == 0) {
                            carro.definicaoImagem(2);
                        } else {
                            carro.definicaoImagem(1);
                        }
                    } else {

                        carro.definicaoImagem(1);
                    }
                    break;
                case 12:
                    if (direcaoAnterior <= 4) {
                        if (carro.getProxSentido() == 0) {
                            carro.definicaoImagem(1);
                        } else {
                            carro.definicaoImagem(2);
                        }
                    } else {
                        carro.definicaoImagem(2);
                    }
                    break;
            }

        } else {
            carro.definicaoImagem(direcaoAtual);
        }
    }
    
     public void definirVelocidadeCarro(int velocity) {
        Carro c = new Carro();
        if (velocity >= 0) {
            this.velocidadeVeiculo = Double.valueOf((Math.random() * (1500 - 500)) + 500).intValue();
            c.setVelocidadeCarro(velocity);
            System.out.println("Velocidade do carro: " + codigoCarro + ": " + c.getVelocidadeCarro()+ " milissegundos");
        }

    }
    
    public String getSentidoEstrada() {
        return sentidoEstrada;
    }

    public void setSentidoEstrada(String estradaDireita) {
        this.sentidoEstrada = estradaDireita;
    }

    public int getVelocidadeVeiculo() {
        return velocidadeVeiculo;
    }

    public void setVelocidadeVeiculo(int velocidadeVeiculo) {
        this.velocidadeVeiculo = velocidadeVeiculo;
    }

    public int getQtdCarro() {
        return qtdCarro;
    }

    public void setQtdCarro(int qtdCarro) {
        this.qtdCarro = qtdCarro;
    }

}
        
