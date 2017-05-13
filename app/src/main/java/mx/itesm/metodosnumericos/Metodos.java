package mx.itesm.metodosnumericos;

/**
 * Created by guille_pt on 13/05/2017.
 */

public class Metodos {

    public String resultado;
    public int metodo;

    public Metodos(int n) {
        this.metodo = n;
    }

    public Metodos() {
    }

    public void setResultado(String resultado){
        this.resultado = resultado;
    }

    public String getResultado() {
        return this.resultado;
    }
}
