package mx.itesm.metodosnumericos;

import java.util.ArrayList;

/**
 * Created by guille_pt on 26/04/2017.
 */

public class Gauss {

    public Gauss() {
    }

    public Float[][] calcularGauss(Float[][] G) {
        //Matriz matriz = a;
        //Matriz mat = a;
        float valor;
        ArrayList<Float> valores = null;
        //ArrayList<ArrayList<Float>> mat;
        String texto;
        int fila;
        Float[][] g = G;

        // vvv DEBUG
        //System.out.println("INICIO: " + matriz.getDatos().toString());
        // ^^^ DEBUG
        /*texto = "Matriz inicial:";
        GaussResult.agregarTexto(texto);
        GaussResult.agregarMatriz(matriz.copy());*/

        if (G[0][0] != 1f) {
            for (int y = 0; y < g.length; y++) {
                for (int x = 0; x < g.length; x++) {
                    valores.add(g[0][x]);
                }
            }
            for (int i = valores.size() - 1; i >= 0; i--) {
                valor = valores.get(i) / g[0][0];
                valores.set(i, valor);
            }

            // vvv DEBUG
            // System.out.println("STEP 1: " + matriz.getDatos().toString());
            // ^^^ DEBUG
            //fila = 1;
            /*texto = "Se divide la fila " + fila + " entre el valor en la\n" +
                    "posición [" + fila + "] de ésta misma.\n" +
                    "(La F" + fila + " se divide entre F" + fila + "[" + fila + "])";
            GaussResult.agregarTexto(texto);
            GaussResult.agregarMatriz(matriz.copy());

        }*/

            // vvv DEBUG
//        System.out.println("STEP: " + matriz.getDatos().toString());
            // ^^^ DEBUG

            float pivote = 0;
            ArrayList<Float> valores1 = null;
            ArrayList<Float> valores2 = null;
            for (int i = 1; i < g.length; i++) {
                for (int j = i; j < g.length; j++) {
                    valores1.add(g[g.length][j]);
                    pivote = valores1.get(i - 1);
//                System.out.println("Pivote: " + pivote);
                    for (int k = i - 1; k < valores1.size(); k++) {
                        valor = valores1.get(k) - (pivote * g[i - 1][j]);
                        //mat.getDatos().get(i - 1).get(k));
                        valores1.set(k, valor);
                        // vvv DEBUG
//                    System.out.println("STEP 2: " + matriz.getDatos().toString());
//                    System.out.println("Valor: " + mat.getDatos().get(i - 1).get(k));
                        // ^^^ DEBUG

                    }
                    // vvv DEBUG
                    //System.out.println("STEP 2: " + matriz.getDatos().toString());
                    // ^^^ DEBUG
                    //fila = j + 1;
                /*texto = "Se le resta a cada valor de la fila " + fila + " el resultado" +
                        "\nde la resta del valor en esta misma posición menos" +
                        "\nla multiplicación del valor en la posición " + (fila - 1) + "por" +
                        "\nel valor en esta misma posición de la fila anterior." +
                        "\n(F" + fila + "[x] - (F" + fila + "[" + (fila - 1) + "] * F" + (fila - 1) + "[x]) )";
                GaussResult.agregarTexto(texto);
                GaussResult.agregarMatriz(matriz.copy());*/
                }

                valores2.add(g[g.length][i]);
                //mat.getDatos().get(i);
                for (int j = valores2.size() - 1; j >= 0; j--) {
                    valor = valores2.get(j) / g[i][i];
                    valores2.set(j, valor);
                }

                // vvv DEBUG
                //System.out.println("STEP 3: " + matriz.getDatos().toString());
                // ^^^ DEBUG
                fila = i + 1;
            /*texto = "Se divide la fila " + fila + " entre el valor en la\n" +
                    "posición [" + fila + "] de ésta misma.\n" +
                    "(La F" + fila + " se divide entre F" + fila + "[" + fila + "])";

            GaussResult.agregarTexto(texto);
            GaussResult.agregarMatriz(matriz.copy());*/
            }

            // vvv DEBUG
//        System.out.println("Step: " + matriz.getDatos().toString());
            // ^^^ DEBUG


//        for (int i = 1; i < mat.getDatos().size(); i++) {
//            valores = mat.getDatos().get(i);
//            for (int j = valores.size() - 1; j >= 0; j--) {
//                valor = valores.get(j) / mat.getDatos().get(i).get(i);
//                valores.set(j, valor);
//            }
//        }

            // vvv DEBUG
            //System.out.println("Final: " + matriz.getDatos().toString());
            // ^^^ DEBUG
            // texto = "Matriz final:";
        /*GaussResult.agregarTexto(texto);
        GaussResult.agregarMatriz(matriz.copy());

        return matriz.copy();*/
        }
        return g;
    }
}
