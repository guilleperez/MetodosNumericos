package mx.itesm.metodosnumericos;

//import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
//import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;


public class MetodoSeis extends AppCompatActivity {

    private double r, s;
    private double error;
    private int tamaño, basta, x=0;
    private ArrayList<String> ecuacion = new ArrayList<String>();
    private EditText ecuacionTxt,txtR,txtS, errorTxt, tamañotxt;
    private TextView resultado;
    private Button botonEcuacion, calcular ,botonR, botonS, botonError, botonTamaño;
    private ImageButton back;
    String ec = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_seis);

        botonEcuacion = (Button) findViewById(R.id.EcButton);
        calcular  = (Button)findViewById(R.id.bairstowButton);
        botonR = (Button)findViewById(R.id.rButton);
        botonError = (Button)findViewById(R.id.errButtonBr);
        botonS = (Button)findViewById(R.id.sButton);
        botonTamaño = (Button)findViewById(R.id.bottonGrado);

        //Datos
        ecuacionTxt = (EditText)findViewById(R.id.EcuacionBr);
        txtR = (EditText)findViewById(R.id.r);
        txtS = (EditText)findViewById(R.id.s);
        errorTxt = (EditText)findViewById(R.id.errorBr);
        tamañotxt = (EditText)findViewById(R.id.Grado);

        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoBr);
        resultado.setMovementMethod(new ScrollingMovementMethod());


       /* if(botonR.isEnabled() && botonS.isEnabled() && botonError.isEnabled() && botonEcuacion.isEnabled() && botonTamaño.isEnabled()){
            if (calcular.isEnabled()){
                calcular.setEnabled(false);
            }
        }*/
        botonR.setEnabled(false);
        botonEcuacion.setEnabled(false);
        botonError.setEnabled(false);
        botonS.setEnabled(false);
        calcular.setEnabled(false);



        //Back
        back = (ImageButton)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(),PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonEcuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = ecuacionTxt.getText().toString();
                int j= 0, k=0;

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                } else {
                    ((EditText) findViewById(R.id.EcuacionBr)).setText(" ");
                    ecuacion.add(getInput.trim());
                    basta += 1;
                    if (basta >= tamaño) {
                        if (botonEcuacion.isEnabled()) {
                            botonEcuacion.setEnabled(false);
                            botonR.setEnabled(true);
                        }
                    }

                    String s= "";
                    if (x < tamaño) {
                        x++;
                        for (int i = ecuacion.size() - 1; i >= 0; i--){
                           if (Double.parseDouble(ecuacion.get(i)) > 0)
                            s += ("+ " + Double.parseDouble(ecuacion.get(i)) + "x" + i + " ");
                            else
                                s+= (Double.parseDouble(ecuacion.get(i)) + "x" + i + " ");}

                        ec = s;
                        resultado.setText("Insertar: x" + x + "\n\nEcuación: \n" + ec);
                    }
                }
            }
        });

        botonTamaño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = tamañotxt.getText().toString().trim();
                tamaño = Integer.parseInt(getInput) + 1;

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.Grado)).setText(" ");
                    Toast.makeText(getBaseContext(),"La ecuación no puede ser de grado = "+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.Grado)).setText(" ");
                    Toast.makeText(getBaseContext(), "La ecuación es de grado "+getInput,Toast.LENGTH_LONG).show();
                    if(botonTamaño.isEnabled()) {
                        botonTamaño.setEnabled(false);
                        botonEcuacion.setEnabled(true);
                    }
                    tamaño = Integer.parseInt(getInput)+1;
                    resultado.setText("Insertar: x" + x);
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
                        calcular.setEnabled(true);
                    }
                    /*if(!botonTamaño.isEnabled() && !botonEcuacion.isEnabled() && !botonError.isEnabled() && !botonR.isEnabled() && !botonS.isEnabled()) {
                        if (!calcular.isEnabled()) {
                            calcular.setEnabled(true);
                        }
                    }*/
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
                        botonS.setEnabled(true);
                    }
                    r = Double.parseDouble(getInput);
                    resultado.setText("Insertar: x" + x + "\n\nEcuación: \n" + ec + "\n\nr = " + r);
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
                        botonError.setEnabled(true);
                    }
                    s = Double.parseDouble(getInput);
                    resultado.setText("Insertar: x" + x + "\n\nEcuación: \n" + ec + "\n\nr = " + r + "\ns= " + s);
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

                for (int i = 0; i < ecuacion.size(); i++) {
                    a[i] =  Double.parseDouble(ecuacion.get(i));
                }

                double[] re = new double[a.length];
                double[] im = new double[a.length];
                ArrayList<String> res = bairstow.Bairstow(a, r, s, re, im, error, tamaño);

                String result = "Ecuación: \n" + ec;
                result += "\n\n Metodo: \n Bairstow \n\n Resultado:\n";
                //double[] res = bairstow.Bairstow(a, r, s, re, im);
                for(int i=0;i<res.size();i++) {
                    result += res.get(i) + "\n";
                }


                //resultado.setText("Resultado = \n" + result);
                sendMessageIntent(result);

                ecuacion.clear();
                //bastaL = 0;
               // bastaM = 0;

                if(!botonR.isEnabled() || !botonS.isEnabled() || !botonError.isEnabled() || !botonEcuacion.isEnabled() || !botonTamaño.isEnabled()) {
                    botonR.setEnabled(true);
                    botonS.setEnabled(true);
                    botonError.setEnabled(true);
                    botonEcuacion.setEnabled(true);
                    botonTamaño.setEnabled(true);
                }
                if(calcular.isEnabled()){
                    calcular.setEnabled(false);
                }

            }
        });

    }

    public void sendMessageIntent(String resultado) {
        Intent intent =  new Intent(getApplicationContext(), Resultados.class);
        intent.putExtra("key", resultado);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), PrimerPantalla.class));
        finish();

    }
}

