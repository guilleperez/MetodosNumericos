package mx.itesm.metodosnumericos;

/**
 * Created by guille_pt on 27/04/2017.
 */

import android.util.Log;

import java.math.BigDecimal;
import java.util.Arrays;

public class GaussSeidel {

    //public static final int MAX_ITERATIONS = 100;

    public GaussSeidel() {}

    public boolean transformToDominant(int r, boolean[] V, int[] R, Float[][] M) {
        int n = M.length;
        if (r == M.length) {
            Float[][] T = new Float[n][n + 1];
            for (int i = 0; i < R.length; i++) {
                for (int j = 0; j < n + 1; j++)
                    T[i][j] = M[R[i]][j];
            }


            return true;
        }

        for (int i = 0; i < n; i++) {
            if (V[i]) continue;

            double sum = 0;

            for (int j = 0; j < n; j++)
                sum += Math.abs(M[i][j]);

            if (2 * Math.abs(M[i][r]) > sum) { // diagonally dominant?
                V[i] = true;
                R[r] = i;

                if (transformToDominant(r + 1, V, R, M))
                    return true;

                V[i] = false;
            }
        }

        return false;
    }

    public boolean makeDominant(Float[][] M)  {
        boolean[] visited = new boolean[M.length];
        int[] rows = new int[M.length];

        Arrays.fill(visited, false);

        return transformToDominant(0, visited, rows, M);
    }

    public float[] solve(Float[][] M, Float error, float[] X) {

        float[] anterior =  X;//new double[M.length];// Prev
        float[] actual = new float[M.length];
        Float abs;

        while (true) {
            abs = 0.0f;
            for (int i = 0; i < M.length; i++) {
                Float sum = M[i][M.length]; // b_n
                for (int j = 0; j < M.length; j++)
                    if (j != i)
                        sum -= M[i][j]*actual[j];
                actual[i] = 1 / M[i][i] * sum;
            }
            for (int i = 0; i < actual.length; i++){
                abs += Math.abs((actual[i] - anterior
                        [i]) / anterior[i]);
                //Log.d("**********************", "ABS " + (abs));
                //Log.d("**********************", "actual[i] " + (actual[i]));
                //Log.d("**********************", "anterior[i] " + (anterior[i]));
            }

            //Log.d("**********************", "ABS "+ (abs / (float)actual.length) * 100.0);
            //Log.d("**********************", "ABS "+ error);
            if ((abs / actual.length) * 100 < error)
                break;

            anterior = actual;
        }

        return actual;
    }
}
