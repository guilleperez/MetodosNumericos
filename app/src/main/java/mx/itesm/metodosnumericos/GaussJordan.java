package mx.itesm.metodosnumericos;


import java.util.ArrayList;

/**
 * Created by guille_pt on 09/05/2017.
 */

public class GaussJordan {

    public GaussJordan(){

    }

    public Float[][] calcular(Float[][] G) {
        //Matriz salida = matriz;
        int col = 0;
        //ArrayList<ArrayList<Float>> mat = matriz.getDatos();
        Float[] temp;
        Float[][] g = G;

        for (int y = 0; y < G.length; y++) {
            for (int x = 0; x < G.length; x++) {
                while (g[y][col] == 0) {
                    temp = g[y];
                    g[y] = g[y + 1];
                    g[y + 1] = temp;
                }

                if (g[y][col] != 1) {
                    Float[] valores = g[y];
                    float valor;
                    for (int i = valores.length - 1; i >= 0; i--) {
                        valor = valores[i] / valores[col];
                        valores[i] = valor;
                    }
                }

                if (x != col) {
                    float valor;
                    Float[] valores = g[y];
                    float pivote = g[x][col];
                    for (int i = valores.length - 1; i >= 0; i--) {
                        valor = (valores[i] * (-pivote) + g[x][i]);
                        g[x][i] =  valor;
                    }
                }
            }
            col++;
        }

        return g;
    }
}

