package mx.itesm.metodosnumericos;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by guille_pt on 26/04/2017.
 */

public class Gauss {


    private Float[][] MA ;
    private Float[][] G;
    private Float[] res;

    public Gauss(Float[][] g){
        setGauss(g);
    }

    public void setGauss(Float[][] g){
        this.G = g;
    }

    public Float[][] getGauss(){
        return this.G;
    }

    public void setRes(Float[] res) {
        this.res = res;
    }

    public Float[] getRes() {
        return this.res;
    }

    public boolean calcular() {

        modificarMatriz(getGauss());

        Float[] res = new  Float[this.getGauss().length];
        MA = this.getGauss();

        /*for (int i = 0; i < this.getGauss().length; i++)
            System.out.println(Arrays.toString(this.getGauss()[i]));*/

        for (int i = 0; i < MA[0].length-2; i++) {
            Float[] pivote = MA[i];
            for (int j = i; j < MA.length; j++) {
                if(j!=i){
                    float mult;
                    if(pivote[i] != 1){
                       // System.out.println(this.getGauss()[j][i] + " a");
                       // System.out.println(this.getGauss()[i][i] + " b" );
                        mult = MA[j][i] / MA[i][i] ;
                       // System.out.println(mult);
                        //return false;
                    }else {
                        mult = MA[j][i];
                    }

                    MA = this.getGauss();
                    for (int k = 0; k < MA[i].length; k++) {
                        MA[j][k] = MA[j][k]  + (pivote[k] * -mult);
                        if(MA[j][k].isNaN() || MA[j][k].isInfinite())
                            return false;
                    }
                    this.setGauss(MA);
                    //System.out.println(Arrays.toString(this.getGauss()[j]));
                }
            }
        }

        /*for (int i = 0; i < this.getGauss().length; i++)
            System.out.println(Arrays.toString(this.getGauss()[i]));*/

        MA = this.getGauss();

        MA [MA.length-1][ MA[0].length-1] /= MA [MA.length-1][MA[0].length-2];
        res[res.length-1] = this.getGauss()[this.getGauss().length-1][this.getGauss()[0].length-1];
        MA [ MA.length-1][ MA.length-2] = 1f;

        //Float[] pivote =  MA [ MA .length-1];
        //System.out.println(Arrays.toString(pivote) + " pivote");
        //MA = this.getGauss();
        float x = 0;
        for (int i = MA.length-2; i >=0; i--) {
            x = MA[i][MA[i].length-1];
            System.out.println(Arrays.toString(MA[i]));
            for (int j = MA[i].length-2; j >0; j--) {
                if( MA[i][j-1] != 0){
                    x += -(MA[i][j] * MA[j][MA[i].length-1]);
                }else{
                    x = x /  MA[i][j];
                    MA[i][MA[i].length-1] = x ;
                    res[i] = x;
                    if(res[i].isNaN() || res[i].isInfinite())
                        return false;
                    this.setGauss(MA);
                }
            }
        }

        x = x /  MA[0][0];
        MA[0][MA[0].length-1] = x ;
        res[0] = x;
        if(res[0].isNaN() || res[0].isInfinite())
            return false;
        this.setGauss(MA);

        this.setRes(res);
        //System.out.println(" *** ");
        //for (int i = 0; i < this.getGauss().length; i++)
            //System.out.println(Arrays.toString(this.getGauss()[i]));
          //  System.out.println(res[i]);



        return true;
    }

    public void modificarMatriz(Float[][] M) {
        if(M[0][0] == 0) {
            Float[] temp = M[1];
            M[1] = M[0];
            M[0] = temp;
            this.setGauss(M);
        }
    }


}
