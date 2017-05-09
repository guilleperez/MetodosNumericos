package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MetodoTres extends Activity {

    private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0;
    private TextView resultado;
    private Button botonTamano, botonGauss, botonMatriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_tres);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        botonMatriz = (Button) findViewById(R.id.matrizGJ);
        botonGauss = (Button)findViewById(R.id.gaussBoton);
        botonTamano = (Button)findViewById(R.id.enterTamano);
        //Datos
        txt = (EditText)findViewById(R.id.matrizzGJ);
        txtDos = (EditText)findViewById(R.id.tamanoGJ);
        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoGJ);
        if(botonTamano.isEnabled() && botonMatriz.isEnabled()){
            if (botonGauss.isEnabled()){
                botonGauss.setEnabled(false);
            }
        }

        botonMatriz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
                if(getInput==null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }
                else{
                    ((EditText) findViewById(R.id.matrizzGJ)).setText(" ");
                    arreglo.add(getInput.trim());
                    basta += 1;
                    if(basta >= (tamano+1) * tamano){
                        if(botonMatriz.isEnabled()|| !botonGauss.isEnabled()) {
                            botonMatriz.setEnabled(false);
                            botonGauss.setEnabled(true);
                        }
                    }
                }


                //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
            }
        });


        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonGauss.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                arreglo.clear();
                tamano = 0;
                basta = 0;
                if(!botonTamano.isEnabled() || !botonMatriz.isEnabled()) {
                    botonTamano.setEnabled(true);
                    botonMatriz.setEnabled(true);
                }
                if(botonGauss.isEnabled()){
                    botonGauss.setEnabled(false);
                }

            }
        });

        botonTamano.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtDos.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null||getInput.equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.tamanoGJ)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de "+getInput+"x"+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.tamanoGJ)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonTamano.isEnabled()) {
                        botonTamano.setEnabled(false);
                    }
                    tamano = Integer.parseInt(getInput);
                }

            }
        });


    }
}













