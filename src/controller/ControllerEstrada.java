package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import model.Carro;
import model.Estrada;
import model.MalhaViaria;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class ControllerEstrada {

    private static MalhaViaria malhaViaria = MalhaViaria.getInstance();
    private static Estrada matrizEstrada[][];
    private static Random random = new Random();
    private static ControllerEstrada instance = null;
    private static SpawnerTeste nascer;
    private static int codigoCarro;
    private int velocidadeVeiculo;
    
    private ControllerEstrada(){
        
    }
    
    public static ControllerEstrada getInstance(){
        if(instance == null){
            instance = new ControllerEstrada();
        }
        return instance;
    }
    
    public void iniciar() {
        //notificarBotaoDesativacao(true);
        nascer = new SpawnerTeste();
        nascer.start();
    }
    
    public SpawnerTeste getSpawn() {
        return nascer;
    }
    
    public void verificaEstrada() {
        matrizEstrada = new Estrada[malhaViaria.getLinha()][malhaViaria.getColuna()];
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                Estrada estrada;
                 if (malhaViaria.getMatriz()[i][j] != 0) {
                     estrada = new Estrada(malhaViaria.getMatriz()[i][j], i, j);
                     matrizEstrada[i][j] = estrada;
                     sentidoCarro(estrada);
                 }else{
                     matrizEstrada[i][j] = null;
                 }
            }
            
    }
        definirProxCelula();
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
    
    
    public void definirProxCelula() {
        for (int i = 0; i < malhaViaria.getLinha(); i++) {
            for (int j = 0; j < malhaViaria.getColuna(); j++) {
                Estrada estrada = matrizEstrada[i][j];
                if (estrada != null) {
                    try {
                        switch (estrada.getSentido()) {
                            case 1:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]); //cima
                                break;
                            case 2:
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]); //direita
                                break;
                            case 3:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]); // baixo
                                break;
                            case 4:
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]); // esquerda
                                break;
                            case 5:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]); //cima
                                break;
                            case 6:
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);//direita
                                break;
                            case 7:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);//baixo
                                break;
                            case 8:
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);//esquerda
                                break;
                            case 9:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);
                                break;
                            case 10:
                                estrada.adicionarProxCelula(matrizEstrada[i - 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);
                                break;
                            case 11:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j + 1]);
                                break;
                            case 12:
                                estrada.adicionarProxCelula(matrizEstrada[i + 1][j]);
                                estrada.adicionarProxCelula(matrizEstrada[i][j - 1]);
                                break;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
        
    public void nascerCarro() {
        List<Estrada> estradas = new ArrayList();
        //imprimirMatriz();
        for (Estrada[] estradaLinha : matrizEstrada) {
            for (Estrada estrada : estradaLinha) {
                if (estrada != null && Estrada.carroCriado.booleanValue()) {
                    estradas.add(estrada);

                }
            }
        }
 
        definirCarro(estradas.get(random.nextInt(estradas.size())));
    }
    
    public void definirCarro(Estrada estrada){
        estrada.adicionarCarroEstrada(retornaCarro(estrada));
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
        int direcaoAtual = carro.getPosicaoAtual().getSentido();
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
                    carro.definicaoImagem(3);
                    break;
                case 8:
                    carro.definicaoImagem(4);
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
                            carro.definicaoImagem(4);
                        }
                    } else {
                        if (carro.getProxSentido()== 0) {
                            carro.definicaoImagem(4);
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
                            carro.definicaoImagem(3);
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
                            carro.definicaoImagem(4);
                        }
                    } else {
                        carro.definicaoImagem(3);
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
     
     public ImageIcon Estrada(int linha, int coluna) {
        if (matrizEstrada[linha][coluna].getCarro() == null) {
            return new ImageIcon("./imagens/asfalto.png");
        }
        return new ImageIcon(matrizEstrada[linha][coluna].getCarro().getImagem());
    }
     
    public void imprimirMatriz(){
        for (int i = 0; i < matrizEstrada.length; i++) {
            for (int j = 0; j < matrizEstrada[0].length; j++) {
                System.out.print(matrizEstrada[i][j]);
            }
            System.out.println();
        }
    }
}
