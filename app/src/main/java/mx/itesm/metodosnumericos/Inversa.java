package mx.itesm.metodosnumericos;

import java.util.ArrayList;

/**
 * Created by Mauricio on 10/05/2017.
 */

public class Inversa {

    private Float[][] identidad;
    private int tamano;
    private Float[][] inversa;

    public Inversa(int tamanho, Float[][] matriz){
        this.tamano = tamanho;
        for(int filas=0; filas <= tamano-1; filas++){
            for(int columna=0; columna <= tamano-1; columna++){
                    if(filas == columna){
                        identidad[filas][columna] = Float.valueOf(1);
                    }else{
                        identidad[filas][columna] = Float.valueOf(0);
                    }
            }
        }
        for(int filas=0; filas <= tamano-1; filas++){
            for(int columna=0; columna <= tamano-1; columna++){
                inversa[filas][columna] = matriz[filas][columna];
            }
        }
        for(int filas=0; filas <= tamano-1; filas++){
            for(int columna=0; columna <= tamano-1; columna++){
                inversa[filas][columna+1] = identidad[filas][columna];
            }
        }


    }


}
