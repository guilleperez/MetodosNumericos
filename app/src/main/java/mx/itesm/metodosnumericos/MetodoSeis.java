package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodoSeis extends Activity {

    private double r, s;
    private double error;
    private ArrayList<String> ecuacion = new ArrayList<String>();
    private EditText ecuacionTxt,txtR,txtS, errorTxt;
    private TextView resultado;
    private Button botonEcuacion, calcular ,botonR, botonS, botonError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_seis);

        botonEcuacion = (Button) findViewById(R.id.EcButton);
        calcular  = (Button)findViewById(R.id.bairstowButton);
        botonR = (Button)findViewById(R.id.rButton);
        botonError = (Button)findViewById(R.id.errButtonBr);
        botonS = (Button)findViewById(R.id.sButton);

        //Datos
        ecuacionTxt = (EditText)findViewById(R.id.EcuacionBr);
        txtR = (EditText)findViewById(R.id.r);
        txtS = (EditText)findViewById(R.id.s);
        errorTxt = (EditText)findViewById(R.id.errorBr);
        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoBr);

        botonEcuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = ecuacionTxt.getText().toString();

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                } else{
                    ((EditText) findViewById(R.id.EcuacionBr)).setText(" ");
                    ecuacion.add(getInput.trim());
                    /*bastaL += 1;
                    if(bastaL >= tamano){
                        if(botonLista.isEnabled()) {
                            botonLista.setEnabled(false);
                        }
                    }*/
                }
            }
        });

        botonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = errorTxt.getText().toString();

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                } else{
                    ((EditText) findViewById(R.id.errorBr)).setText(" ");
                    Toast.makeText(getBaseContext(), "Error: "+getInput,Toast.LENGTH_LONG).show();
                    if(botonError.isEnabled()) {
                        botonError.setEnabled(false);
                    }

                    error = Double.parseDouble(getInput);
                }
            }
        });

        botonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtR.getText().toString().trim();

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                } else{
                    ((EditText) findViewById(R.id.r)).setText(" ");
                    //Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonR.isEnabled()) {
                        botonR.setEnabled(false);
                    }
                    r = Double.parseDouble(getInput);
                }


            }
        });

        botonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtS.getText().toString().trim();

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                } else{
                    ((EditText) findViewById(R.id.s)).setText(" ");
                    //Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonS.isEnabled()) {
                        botonS.setEnabled(false);
                    }
                    s = Double.parseDouble(getInput);
                }


            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bairstow bairstow = new Bairstow();
                //Log.d("********************** ", "" + tamano);
                //Log.d("********************** ", "" + arreglo.toString());

                double[] a = new double[ecuacion.size()];


                int y = 0;
                int x = 0;

                for (int i = 0; i < ecuacion.size(); i++) {
                    a[i] =  Double.parseDouble(ecuacion.get(i));
                }

                double[] re = new double[a.length];
                double[] im = new double[a.length];
                ArrayList<String> res = bairstow.Bairstow(a, r, s, re, im, error);
                String result = " ";

                //double[] res = bairstow.Bairstow(a, r, s, re, im);
                for(int i=0;i<res.size();i++) {
                    result += res.get(i) + "\n";
                }

                resultado.setText("Resultado = \n" + result);
                ecuacion.clear();
                //bastaL = 0;
               // bastaM = 0;

                if(!botonR.isEnabled() || !botonS.isEnabled() || !botonError.isEnabled() || !botonEcuacion.isEnabled()) {
                    botonR.setEnabled(true);
                    botonS.setEnabled(true);
                    botonError.setEnabled(true);
                    botonEcuacion.setEnabled(true);
                }

            }
        });

    }
}

