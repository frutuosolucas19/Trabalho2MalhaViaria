
package model;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class MalhaViaria {
    private int linha;
    private int coluna;
    private static MalhaViaria instance = null; //Singleton

    private MalhaViaria() {
    }
    
    public synchronized static MalhaViaria getInstance(){
        if(instance == null){
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

}
