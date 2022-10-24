package controller;

import controllerObserver.InterfaceMalha;
import static java.lang.Thread.sleep;
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

    private Boolean iniciar = false;
    private int carrosCriados = 0;
    private int qtdCarro = 0;
    private static MalhaViaria malhaViaria = MalhaViaria.getInstance();
    private static Estrada estrada;
    private static String sentidoEstrada;
    private Random random = new Random();
    private int velocidadeVeiculo;
    private ControllerMalha conCriacaoMalha = new ControllerMalha();
    private ScannerMatriz scanMatriz = new ScannerMatriz();

    public synchronized void prepararCarro(int quantidadeCarros) throws InterruptedException {
        this.qtdCarro = quantidadeCarros;
        this.iniciar = true;
        while(0 < qtdCarro){
        Carro carro = new Carro();
        carro.start();
        qtdCarro --;
        }
    }

   public synchronized void iniciarCarro(int codigoCarro) {
        int[][] matrizCarro = scanMatriz.retornaMatriz(MalhaViaria.getInstance().getMatriz());
        for (int i = 0; i < matrizCarro.length; i++) {
            for (int j = 0; j < matrizCarro[0].length; j++) {
                System.out.print(matrizCarro[i][j]);
            }
            System.out.println();
        }
        
        Boolean status = true;
        int valorMatriz = 0;
        int numeroAleatorio = random.nextInt(4) + 1;
        velocidadeVeiculo = (random.nextInt(1) + 1) * 1000;
        this.qtdCarro = 1;
        
        if (numeroAleatorio == 2) {
            int i = retornaValorLinha(2);
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                if ((malhaViaria.getMatriz()[i][j] == 2 || malhaViaria.getMatriz()[i][j] == 5 || malhaViaria.getMatriz()[i][j] == 9 || malhaViaria.getMatriz()[i][j] == 11)
                        && status == true && retornaValorSentido(2) == 2 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i][j - 1] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(codigoCarro);
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
                        && status == true && retornaValorSentido(4) == 4 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i][j + 1] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(codigoCarro);
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
                        && status == true && retornaValorSentido(3) == 3 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i - 1][j] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(codigoCarro);
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
                        && status == true && retornaValorSentido(1) == 1 && qtdCarro != 0) {
                    if (valorMatriz != 0) {
                        try {
                            sleep(velocidadeVeiculo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerCarro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        malhaViaria.getMatriz()[i + 1][j] = valorMatriz;
                        conCriacaoMalha.notificarAtualizarTabela(codigoCarro);
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
            j = j - 1 ;
        }
        return 0;
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
    
    

}
