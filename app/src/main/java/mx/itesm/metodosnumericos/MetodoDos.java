package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodoDos extends AppCompatActivity {

    private EditText tamanoTxt, numerosTxt, txtError, listaTxt;
    private ArrayList<String> arregloM = new ArrayList<String>();
    private ArrayList<String> arregloL = new ArrayList<String>();


    private Integer tamano, bastaL = 0, bastaM = 0, x = 1, y = 1, xl = 1;
    private TextView resultado;
    private Button botonTamano, calcular, botonDatos, botonError, botonLista;
    private Float error;
    private String valores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_dos);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        botonDatos = (Button) findViewById(R.id.enterMatrizGS);
        calcular = (Button) findViewById(R.id.gauss_seidel);
        botonTamano = (Button) findViewById(R.id.enterTamGS);
        botonError = (Button) findViewById(R.id.botonError);
        botonLista = (Button) findViewById(R.id.btnListaGS);

        //Datos
        numerosTxt = (EditText) findViewById(R.id.matrizGS);
        tamanoTxt = (EditText) findViewById(R.id.tamanoGS);
        txtError = (EditText) findViewById(R.id.errorTxt);
        listaTxt = (EditText) findViewById(R.id.listaGS);
        //Resultado
        resultado = (TextView) findViewById(R.id.resultadoGS);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        if(botonTamano.isEnabled() && botonDatos.isEnabled() && botonLista.isEnabled()){
            if (calcular.isEnabled()){
                calcular.setEnabled(false);
            }
        }
        botonDatos.setEnabled(false);
        botonLista.setEnabled(false);
        botonError.setEnabled(false);
        calcular.setEnabled(false);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonTamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = tamanoTxt.getText().toString().trim();

                if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Dato faltante", Toast.LENGTH_SHORT).show();
                } else if (getInput.trim().equals("0") || getInput.trim().equals("1")) {
                    ((EditText) findViewById(R.id.tamanoGS)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz no puede ser de " + getInput + " , " + getInput, Toast.LENGTH_LONG).show();
                } else {
                    ((EditText) findViewById(R.id.tamanoGS)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz es de " + getInput + "x" + getInput, Toast.LENGTH_LONG).show();
                    if (botonTamano.isEnabled()) {
                        botonTamano.setEnabled(false);
                        botonDatos.setEnabled(true);
                    }
                    tamano = Integer.parseInt(getInput);
                    resultado.setText("Tamaño Matriz: " + tamano +"x" + tamano+ "\n\nPosicion Matriz: " +
                            x +" , "+ y + " \n\nTamaño Lista: " + tamano +
                            "\n\nPosicion Lista: " + xl);
                }


            }
        });

        botonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = listaTxt.getText().toString();

                if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Dato faltante", Toast.LENGTH_SHORT).show();
                } else {
                    ((EditText) findViewById(R.id.listaGS)).setText(" ");
                    arregloL.add(getInput.trim());
                    bastaL += 1;
                    if (bastaL >= tamano) {
                        if (botonLista.isEnabled()) {
                            botonLista.setEnabled(false);
                            botonError.setEnabled(true);
                        }
                    }
                }

                xl++;
                if (arregloM.size()==0)
                    valores = "";
                else {
                    valores = "[ ";
                    for (int i = 1; i <= arregloM.size(); i++) {
                        if (i == arregloM.size())
                            valores += arregloM.get(i - 1);
                        else if (i % (tamano + 1) == 0 && i > 1)
                            valores += arregloM.get(i - 1) + "\n";
                        else if (i < arregloM.size())
                            valores += arregloM.get(i - 1) + " , ";

                    }
                }
                resultado.setText("Tamaño Matriz: " + tamano +"x" + tamano+ "\n\nPosicion Matriz: " +
                        x +" , "+ y + "\n\nMatriz:\n" + valores + " \n\nTamaño Lista: "
                        + tamano + "\n\nPosicion Lista: " + xl + "\n\nLista: " + arregloL.toString());
            }
        });

        botonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtError.getText().toString();

                if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Dato faltante", Toast.LENGTH_SHORT).show();
                } else if(Float.parseFloat(getInput.trim()) <= 0) {
                    Toast.makeText(getBaseContext(), "Error Invalido", Toast.LENGTH_SHORT).show();
                    ((EditText) findViewById(R.id.errorTxt)).setText(" ");
                }else{
                    ((EditText) findViewById(R.id.errorTxt)).setText(" ");
                    Toast.makeText(getBaseContext(), "Error: " + getInput, Toast.LENGTH_LONG).show();
                    if (botonError.isEnabled()) {
                        botonError.setEnabled(false);
                        calcular.setEnabled(true);
                    }

                    error = Float.parseFloat(getInput);
                }
            }
        });

        botonDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = numerosTxt.getText().toString();

                if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Dato faltante", Toast.LENGTH_SHORT).show();
                } else {
                    ((EditText) findViewById(R.id.matrizGS)).setText(" ");
                    arregloM.add(getInput.trim());
                    bastaM += 1;
                    if (bastaM >= (tamano + 1) * tamano) {
                        if (botonDatos.isEnabled()) {
                            botonDatos.setEnabled(false);
                            botonLista.setEnabled(true);
                            //calcular.setEnabled(true);
                        }
                    }

                    valores ="";
                    if (y % (tamano+1) == 0) {
                        x++;
                        y = 1;
                    }else{
                        y++;
                    }

                    for(int i=1;i<=arregloM.size();i++) {
                        if (i == arregloM.size())
                            valores += arregloM.get(i - 1);
                        else if (i % (tamano + 1) == 0 && i > 1)
                            valores += arregloM.get(i - 1) + "\n";
                        else if (i < arregloM.size())
                            valores += arregloM.get(i - 1) + " , ";

                    }
                    resultado.setText("Tamaño Matriz: " + tamano +"x" +
                            tamano+ "\n\nPosicion Matriz: " + x +" , "+ y + "\n\nMatriz:\n" +
                            valores + " \n\nTamaño Lista: " + tamano + "\n\nPosicion Lista: "
                            + xl +  "\n\nLista: " + arregloL.toString());
                }

                //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
            }
        });


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GaussSeidel gausSeidel = new GaussSeidel();
                //Log.d("********************** ", "" + tamano);
                //Log.d("********************** ", "" + arreglo.toString());
                Float[][] M = new Float[tamano][tamano + 1];
                float[] X = new float[tamano];
                int y = 0;
                int x = 0;

                for (int i = 1; i <= arregloM.size(); i++) {
                    M[x][y] = Float.parseFloat(arregloM.get(i - 1));
                    if (i % (tamano + 1) == 0) {
                        x++;
                        y = 0;
                    } else {
                        y++;
                    }
                }

                for (int i = 0; i < arregloL.size(); i++) {
                    X[i] = Float.parseFloat(arregloL.get(i));
                }

                String res = "Metodo: \nGauss Seidel\n\nMatriz: \n";
                for (int i = 0; i < M.length; i++)
                    res += Arrays.toString(M[i]) +"\n";
                res += "\nResultado:\n";

                if (!gausSeidel.makeDominant(M)) {
                    res += "No se puede calcular; Diagonal no dominante";
                    //resultado.setText("No se puede calcular; Diagonal no dominante");
                } else {
                    float[] GS = gausSeidel.solve(M, error, X);
                    //Toast.makeText(getBaseContext(), "El resultado de la operacion es " + res, Toast.LENGTH_LONG).show();
                    res += Arrays.toString(GS) +"\n";
                    //resultado.setText("El resultado de la operacion es\n" + Arrays.toString(GS));
                    // Log.d("********************** ", "RESULTADO  " + res);
                }

                sendMessageIntent(res);

                arregloM.clear();
                arregloL.clear();
                bastaL = 0;
                bastaM = 0;

                if (!botonTamano.isEnabled() || !botonDatos.isEnabled() || !botonError.isEnabled() || !botonLista.isEnabled()) {
                    botonTamano.setEnabled(true);
                    botonDatos.setEnabled(true);
                    botonError.setEnabled(true);
                    botonLista.setEnabled(true);
                }

            }
        });
    }

    public void sendMessageIntent(String resultado) {
        Intent intent =  new Intent(getApplicationContext(), Resultados.class);
        intent.putExtra("key", resultado);
        startActivity(intent);
    }
}
 /*
        Graficar
        LineChart lineChart = (LineChart)findViewById(R.id.grafica);

        ArrayList<String> xs = new ArrayList<>();
        ArrayList<Entry> ys = new ArrayList<>();

        double x = 0;
        int max = 500;
        for(int i = 0; i<max ;i++){
            float sin = Float.parseFloat(String.valueOf(Math.sin(x)));
            x = x + 0.1;
            ys.add(new Entry(sin,i));
            xs.add(i,String.valueOf(x));
        }
        String[] xss = new String[xs.size()];
        for(int i = 0; i<xs.size();i++){
            xss[i] = xs.get(i).toString();

        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(ys,"Sin");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setCircleColor(Color.BLUE);
        lineDataSets.add(lineDataSet1);

        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);

        */