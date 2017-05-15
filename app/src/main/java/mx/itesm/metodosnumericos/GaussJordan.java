package mx.itesm.metodosnumericos;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by guille_pt on 09/05/2017.
 */

public class GaussJordan {

    public GaussJordan(){
    }

    public String calcular(Float[][] G, int total) {

        int col = 0;
        boolean valido = true;
        Float[] temp;
        int cont = 0;
        String res ="1. Matriz Aumentada:\n";

        for (int i=0;i<G.length;i++)
            res += Arrays.toString(G[i]) + "\n";

        res += "\n2. Calcula Matriz Identidad:\n";

        for (int y = 0; y < G.length; y++) {
            for (int x = 0; x < G.length; x++) {
                while (G[y][col] == 0) {
                    temp = G[y];
                    if(y == G.length-1 || cont == total) {
                        valido = false;
                        break;
                    }
                    G[y] = G[y + 1];
                    G[y + 1] = temp;
                    cont ++;

                }

                if(!valido) {
                    res += "\n3. Solucion:\nNo existe solución.";
                    break;
                }

                if (G[y][col] != 1) {
                    Float[] valores = G[y];
                    float valor;
                    for (int i = valores.length - 1; i >= 0; i--) {
                        if(valores[col] != 0) {
                            valor = valores[i] / valores[col];
                            valores[i] = valor;
                        }else{
                            valido = false;
                            break;
                        }
                    }
                    //res += Arrays.toString(valores) + "\n";
                }

                if(!valido) {
                    res += "3. Solucion:\nNo existe solución.\n";
                    break;
                }


                if (x != col) {
                    res += "\nReacomoda la matriz:\n";
                    for (int i=0;i<G.length;i++)
                        res += Arrays.toString(G[i]) + "\n";
                    res +="\nModificar la fila "+ (y+1) + "\n"+ Arrays.toString(G[y])+"\n\n"
                    + "Cambia los valores distintos a 1\n";
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

            if(!valido)
                break;

            col++;
        }

        if (valido) {
            res += "\n3. Solucion:\n";
            for (int i = 0; i < G.length; i++)
                res += Arrays.toString(G[i]) + "\n";
        }
        return res;
    }
}

