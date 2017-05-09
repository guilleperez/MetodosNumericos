package mx.itesm.metodosnumericos;


import java.util.ArrayList;

/**
 * Created by guille_pt on 09/05/2017.
 */

public class GaussJordan {

  /*  public GaussJordan(){

    }

    public Float[][] calcular(Float[][] G){
        //Matriz salida = matriz;
        //int col = 0;
        //ArrayList<ArrayList<Float>> mat = matriz.getDatos();
        ArrayList<Float> temp;

        for (int y = 0; y < G[1].length; y++) {
            for (int x = 0; x < G[1].length ; x++) {
                while (mat.get(y).get(col) == 0) {
                    temp = mat.get(y);
                    mat.set(y, mat.get(y + 1));
                    mat.set(y + 1, temp);
                }

            if (mat.get(y).get(col) != 1) {
                ArrayList<Float> valores = mat.get(y);
                float valor;
                for (int i = valores.size() - 1; i >= 0; i--) {
                    valor = valores.get(i) / valores.get(col);
                    valores.set(i, valor);
                }
            }

            if (x != col) {
                float valor;
                ArrayList<Float> valores = mat.get(y);
                float pivote = mat.get(x).get(col);
                for (int i = valores.size() - 1; i >= 0; i--) {
                    valor = (valores.get(i) * (-pivote) + mat.get(x).get(i));
                    mat.get(x).set(i, valor);
                }
            }
        }
        col++;
    }
        System.out.println("Matriz FINAL: " + mat.toString());
        GaussResult.agregarTexto("El resultado de la matriz aplicando el método de" +
                "\nGauss-Jordan es: ");
        GaussResult.agregarMatriz(matriz);

        salida.setDatos(mat);
return salida;*/
}

