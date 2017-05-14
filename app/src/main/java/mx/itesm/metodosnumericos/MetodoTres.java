package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodoTres extends AppCompatActivity {

    private EditText txtTamano,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0;
    private TextView resultado;
    private Button botonTamano, botonGauss, botonMatriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_tres);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        botonMatriz = (Button) findViewById(R.id.matrizBtnG);
        botonGauss = (Button)findViewById(R.id.gaussBoton);
        botonTamano = (Button)findViewById(R.id.tamanoBtnG);
        //Datos
        txt = (EditText)findViewById(R.id.matrizG);
        txtTamano = (EditText)findViewById(R.id.tamanoG);

        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoG);

        if(botonTamano.isEnabled() && botonMatriz.isEnabled()){
            if (botonGauss.isEnabled()){
                botonGauss.setEnabled(false);
            }
        }


        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonTamano.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtTamano.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null||getInput.equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.tamanoG)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de "+getInput+"x"+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.tamanoG)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonTamano.isEnabled()) {
                        botonTamano.setEnabled(false);
                    }
                    tamano = Integer.parseInt(getInput);
                }

            }
        });

        botonMatriz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
                if(getInput==null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }
                else{
                    ((EditText) findViewById(R.id.matrizG)).setText(" ");
                    arreglo.add(getInput.trim());
                    basta += 1;
                    if(basta >= (tamano+1) * tamano){
                        if(botonMatriz.isEnabled()|| !botonGauss.isEnabled()) {
                            botonMatriz.setEnabled(false);
                            botonGauss.setEnabled(true);
                        }
                    }
                }

                //resultado.setText("Insertar valor: ");


                //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
            }
        });


        botonGauss.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Float[][] G = new Float[tamano][tamano + 1];
                int x = 0, y = 0;
                for (int i = 1; i <= arreglo.size(); i++) {
                    G[x][y] = Float.parseFloat(arreglo.get(i - 1));
                    if (i % (tamano + 1) == 0) {
                        x++;
                        y = 0;
                    } else {
                        y++;
                    }
                }

                Gauss g = new Gauss(G);
                String res = "";
                if (g.calcular()) {
                    res =  Arrays.toString(g.getRes());
                    //resultado.setText("Resultado = \n" +  Arrays.toString(g.getRes()));
                } else {
                    //Toast.makeText(getBaseContext(), "El resultado de la operacion es " + res, Toast.LENGTH_LONG).show();
                    res = "No se puede calcular";
                    //resultado.setText("No se puede calcular");

                    // Log.d("********************** ", "RESULTADO  " + res);
                }
                sendMessageIntent(res);

                arreglo.clear();
                basta = 0;
                tamano = 0;

                if (!botonTamano.isEnabled() || !botonGauss.isEnabled() || !botonMatriz.isEnabled()) {
                    botonTamano.setEnabled(true);
                    botonGauss.setEnabled(true);
                    botonMatriz.setEnabled(true);
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













