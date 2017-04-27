package mx.itesm.metodosnumericos;

/**
 * Created by guille_pt on 26/04/2017.
 */

public class Cramer {

    private int tamaño;
    private float a[][];
    private float b[];
    private int solucion[];
    private float cmr[];
    private float determinante;
    private String res;

    public Cramer(int tamaño) {
        this.tamaño = tamaño;
        a = new float[this.tamaño][this.tamaño];
        b = new float[this.tamaño];
        cmr = new float[this.tamaño];
        res = "";
    }

    public float getDet() {
        return determinante;
    }

    public void setDet(float det) {
        this.determinante = det;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public float[][] getA() {
        return a;
    }

    public void setA(float[][] a) {
        this.a = a;
    }

    public float[] getB() {
        return b;
    }

    public void setB(float[] b) {
        this.b = b;
    }

    public float[] getCmr() {
        return cmr;
    }

    public void setCmr(float[] cmr) {
        this.cmr = cmr;
    }

    public int[] getSolucion() {
        return solucion;
    }

    public void setSolucion(int[] solucion) {
        this.solucion = solucion;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public float determinante(int j, float a[][]) {

        if (a.length == 2) {
            float det = a[0][0] * a[1][1] - a[0][1] * a[1][0];

            return det;
        }

        float det = 0;
        for (int i = 0; i < a.length; i++) {
            float[][] temp = this.SubMatriz(j, i, a);
            det = (float) (det + Math.pow(-1, i + j) * a[j][i] * this.determinante(j, temp));
        }

        this.determinante = det;
        return det;

    }

    private float[][] SubMatriz(int j, int i, float[][] a) {
        float[][] temp = new float[a.length - 1][a.length - 1];
        int count1 = 0;
        int count2 = 0;

        for (int k = 0; k < a.length; k++) {
            if (k != j) {

                count2 = 0;
                for (int l = 0; l < a.length; l++) {
                    if (l != i) {
                        temp[count1][count2] = a[k][l];
                        count2++;
                    }
                }
                count1++;
            }

        }

        return temp;

    }

    public float[][] sustituye(float a[][], float b[], int pos) {

        float c[][] = new float[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j == pos) {
                    c[i][j] = b[i];
                } else {
                    c[i][j] = a[i][j];
                }
            }

        }

        return c;
    }

    public int suma(int a[]) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }

        return result;

    }

    public float[] cramer() {
        float Rcramer[] = new float[b.length];

        /*
        for (int i = 0; i < this.a.length; i++) {
            String res = "[";
            for (int j = 0; j < this.a.length; j++) {
                res += this.a[i][j] + " ";
                if (j == this.a.length - 1) {
                    res += b[i] + "]";
                }
            }
            System.out.println("RES " + res);
        }*/

        float det = determinante(0, this.a);
        //System.out.println(det +  " *********************");
        if (det == 0) {
            System.out.println("NO HAY SOLUCION HIJO DE TU PUTA MADRE ");
            return null;
        }

        float detTemp;

        float c[][] = new float[this.a.length][this.a.length];

        for (int i = 0; i < this.a.length; i++) {
            c = sustituye(this.a, b, i);
            detTemp = determinante(0, c);
            //System.out.println("DET " + detTemp);
            Rcramer[i] = detTemp / det;
        }
        return Rcramer;
    }

    public void mostrarX() {
        int c = 1;
        res = res + "Determinante: " + this.determinante + "\n";
        for (int i = 0; i < a.length; i++) {
            res = res + "El resultado de X_" + c + " es: " + cmr[i] + "\n";
            c++;
        }

    }

}
