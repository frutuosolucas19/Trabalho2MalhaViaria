package model;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class MalhaViaria {

    private int linha;
    private int coluna;
    private int matriz[][];
    private static MalhaViaria instance = null;

    public MalhaViaria() {
    }

    public static MalhaViaria getInstance() {
        if (instance == null) {
            instance = new MalhaViaria();
        }
        return instance;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

}
