package mx.itesm.metodosnumericos;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by guille_pt on 09/05/2017.
 */

public class GaussJordan {

    public GaussJordan(){
    }

    public String calcular(Float[][] G) {

        int col = 0;
        Float[] temp;
        String res ="1. Matriz Aumentada:\n";

        for (int i=0;i<G.length;i++)
            res += Arrays.toString(G[i]) + " \n";

        res += "\n2. Calcula Matriz Identidad:\n";

        for (int y = 0; y < G.length; y++) {
            res += "\nModificar la fila "+ (y+1) + "\n"+ Arrays.toString(G[y])+"\n\n";
            for (int x = 0; x < G.length; x++) {
                while (G[y][col] == 0) {
                    temp = G[y];
                    G[y] = G[y + 1];
                    G[y + 1] = temp;
                }

                if (G[y][col] != 1) {
                    res += "Cambia los valores distintos a 1\n";
                    Float[] valores = G[y];
                    float valor;
                    for (int i = valores.length - 1; i >= 0; i--) {
                        valor = valores[i] / valores[col];
                        valores[i] = valor;
                    }
                    res += Arrays.toString(valores) + "\n";
                }

                if (x != col) {
                    res += "\nModifica la fila " + x +"\n";
                    float valor;
                    Float[] valores = G[y];
                    float pivote = G[x][col];
                    //for (int i = valores.length - 1; i >= 0; i--) {
                    for (int i = 0; i < valores.length; i++) {
                        res += "Anterior: "+ G[x][i] + " - Actual ";
                        valor = (valores[i] * (-pivote) + G[x][i]);
                        G[x][i] =  valor;
                        res += G[x][i] + "\n";

                    }
                }
            }

            col++;
        }

        res += "\n3. Solucion:\n";
        for (int i = 0; i < G.length; i++)
            res += Arrays.toString(G[i])+ "\n";
        return res;
    }
}

