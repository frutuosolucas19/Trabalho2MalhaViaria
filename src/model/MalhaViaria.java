
package model;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class MalhaViaria {
    private int linha;
    private int coluna;
    private int matriz[][];
    
    public MalhaViaria(){
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
