package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
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

public class MetodoCinco extends Activity {

    //private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0;
    private TextView resultado;
    private Button botonTamano,botonJordan,boton;
    private EditText listaTxt, tamanoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_cinco);
        //dibujoMatriz = new TableLayout(this);
        tamanoTxt = (EditText) findViewById(R.id.tamanoGJ);
        //espacioMatriz = (RelativeLayout) findViewById(R.id.matriz);
        tamano = 0;
        //hayMatriz = false;

        ImageButton back = (ImageButton)findViewById(R.id.back);
        boton = (Button) findViewById(R.id.matrizGauss);
        botonJordan = (Button)findViewById(R.id.gaussJordanBtn);
        botonTamano = (Button)findViewById(R.id.enterTamGJ);

        //Datos
        listaTxt = (EditText)findViewById(R.id.matrizzGJ);
        tamanoTxt = (EditText)findViewById(R.id.tamanoGJ);

        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoGJ);
        if(botonTamano.isEnabled() && boton.isEnabled()){
            if (botonJordan.isEnabled()){
                botonJordan.setEnabled(false);
            }
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = listaTxt.getText().toString();
                if(getInput==null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }
                else{
                    ((EditText) findViewById(R.id.matrizzGJ)).setText(" ");
                    arreglo.add(getInput.trim());
                    basta += 1;
                    if(basta >= (tamano+1) * tamano){
                        if(boton.isEnabled()|| !botonJordan.isEnabled()) {
                            boton.setEnabled(false);
                            botonJordan.setEnabled(true);
                        }
                    }
                }


                //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonJordan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GaussJordan gj = new GaussJordan();
                Float[][] G = new Float[tamano][tamano+1];

                int y = 0;
                int x = 0;
                for (int i = 1; i <= arreglo.size(); i++) {
                    G[x][y] = Float.parseFloat(arreglo.get(i-1));
                    if (i % (tamano+1) == 0) {
                        x++;
                        y = 0;
                    }else{
                        y++;
                    }
                }

                Float[][] gaussJordan = gj.calcular(G);
                String res = "";
                for(int i=0;i<gaussJordan.length;i++){
                    //Log.d("*****",""+ Arrays.toString(gaussJordan[i]));
                    if(i!=gaussJordan.length-1)
                        res += Arrays.toString(gaussJordan[i]) + " , ";
                    else
                        res += Arrays.toString(gaussJordan[i]);
                }
                resultado.setText("Resultado =\n"+res);

                //Toast.makeText(getBaseContext(), "El resultado de la operacion es " + res, Toast.LENGTH_LONG).show();

                //resultado.setText(arreglo.toString());
                //Log.d("********************** ", "RESULTADO  "  + res);
                arreglo.clear();
                tamano = 0;
                basta = 0;
                if(!botonTamano.isEnabled() || !boton.isEnabled()) {
                    botonTamano.setEnabled(true);
                    boton.setEnabled(true);
                }
                if(botonJordan.isEnabled()){
                    botonJordan.setEnabled(false);
                }

            }
        });

        botonTamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = tamanoTxt.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null||getInput.trim().equals("")){
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


