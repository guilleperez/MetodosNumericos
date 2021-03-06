package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Determinante extends AppCompatActivity {

    private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0,x = 1 , y = 1;
    private TextView resultado;
    private Button botonTamanho,botonDeterminante,boton;
    private String valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        // getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_determinante);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        boton = (Button) findViewById(R.id.matrizGauss);
        botonDeterminante = (Button)findViewById(R.id.cramerBoton);
        botonTamanho = (Button)findViewById(R.id.enterTamano);
        //Datos
        txt = (EditText)findViewById(R.id.matrizzGJ);
        txtDos = (EditText)findViewById(R.id.tamanoGS);
        //Resultado
        resultado = (TextView)findViewById(R.id.resultadoGJ);

        botonDeterminante.setEnabled(false);
        boton.setEnabled(false);

        boton.setOnClickListener(new OnClickListener() {
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
                        if(boton.isEnabled()|| !botonDeterminante.isEnabled()) {
                            boton.setEnabled(false);
                            botonDeterminante.setEnabled(true);
                        }
                    }

                    valores ="";
                    if (y % (tamano+1) == 0) {
                        x++;
                        y = 1;
                    }else{
                        y++;
                    }

                    for(int i=1;i<=arreglo.size();i++) {
                        if (i == arreglo.size())
                            valores += arreglo.get(i - 1);
                        else if (i % (tamano + 1) == 0 && i > 1)
                            valores += arreglo.get(i - 1) + "\n";
                        else if (i < arreglo.size())
                            valores += arreglo.get(i - 1) + " , ";

                    }
                    resultado.setText("Tamaño: " + tamano + " x " + tamano +"\n\n" +
                            "Posicion: " + x +" , "+ y + "\n\nMatriz:\n"+ valores);

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

        botonDeterminante.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Cramer cm = new Cramer();
                float[][] a = new float[tamano][tamano];
                float[] b  = new float[tamano];

                int y = 0;
                int x = 0;
                for (int i = 1; i <= arreglo.size(); i++) {
                    if (i % (tamano+1) == 0) {
                        b[x] = Float.parseFloat(arreglo.get(i-1));
                        x++;
                        y = 0;
                    }else{
                        a[x][y] = Float.parseFloat(arreglo.get(i-1));
                        //Log.d("********************** ", "" + a[x][y] + " " + x + " " + y);
                        y++;
                    }
                }

                String res = "Metodo:\nDeterminante\n\nMatriz:\n";
                for (int i = 0; i < a.length; i++)
                    res += Arrays.toString(a[i])+"\n";
                res += "\nResultado:\n" + cm.determinante(0,a);
                //resultado.setText(cm.determinante(0,a)+" ");

                sendMessageIntent(res);

                //resultado.setText(arreglo.toString());
                //Log.d("********************** ", "RESULTADO  "  + res);
                arreglo.clear();
                tamano = 0;
                basta = 0;
                if(!botonTamanho.isEnabled() || !boton.isEnabled()) {
                    botonTamanho.setEnabled(true);
                    boton.setEnabled(true);
                }
                if(botonDeterminante.isEnabled()){
                    botonDeterminante.setEnabled(false);
                }

            }
        });

        botonTamanho.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtDos.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.tamanoGS)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de "+getInput+"x"+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.tamanoGS)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonTamanho.isEnabled()) {
                        botonTamanho.setEnabled(false);
                        boton.setEnabled(true);
                    }
                    tamano = Integer.parseInt(getInput);
                    resultado.setText("Tamaño: " + tamano + "\n\nPosicion: " + x +" , "+ y);
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














