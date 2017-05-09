package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MetodoCuatro extends AppCompatActivity {

    private EditText tamanoTxt;
    //private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0;
    private TextView resultado, listaTxt;
    private Button botonTamano,botonJordan,boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_cuatro);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //dibujoMatriz = new TableLayout(this);
        tamanoTxt = (EditText) findViewById(R.id.tamano);
        //espacioMatriz = (RelativeLayout) findViewById(R.id.matriz);
        tamano = 0;
        //hayMatriz = false;

        ImageButton back = (ImageButton)findViewById(R.id.back);
        boton = (Button) findViewById(R.id.listaEnter);
        botonJordan = (Button)findViewById(R.id.cramerBoton);
        botonTamano = (Button)findViewById(R.id.enterTamano);

        //Datos
        listaTxt = (EditText)findViewById(R.id.lista);
        tamanoTxt = (EditText)findViewById(R.id.tamano);

        //Resultado
        resultado = (TextView)findViewById(R.id.resultado);
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
                    ((EditText) findViewById(R.id.lista)).setText(" ");
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

                float[] gaussJordan = gj.calcular(M);
                if(cramer != null){
                    String res ="[ ";
                    for(int i=0;i<cramer.length;i++){
                        if(i!=cramer.length-1)
                            res += cramer[i] + " , ";
                        else
                            res += cramer[i];
                    }
                    res += " ]";
                    resultado.setText("El resultado de la operacion es\n"+res);
                }else{
                    resultado.setText("El determinante es cero, entonces el sistema no tiene resolución." );
                }

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
                String getInput = txtDos.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de "+getInput+"x"+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
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


