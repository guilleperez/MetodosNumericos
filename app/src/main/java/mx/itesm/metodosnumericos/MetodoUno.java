package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MetodoUno extends Activity {

    private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_uno);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        Button boton = (Button) findViewById(R.id.enter);
        final Button botonCramer = (Button)findViewById(R.id.cramerBoton);
        final Button botonTamano = (Button)findViewById(R.id.enterTamano);
        //Datos
        txt = (EditText)findViewById(R.id.numero);
        txtDos = (EditText)findViewById(R.id.tamano);
        //Resultado
        resultado = (TextView)findViewById(R.id.resultado);


        boton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_LONG).show();
                }else{
                    arreglo.add(getInput.trim());
                }
                    ((EditText) findViewById(R.id.numero)).setText(" ");
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

        botonCramer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Cramer cm = new Cramer(tamano);
                float[] b = cm.getB();
                float[][] a = cm.getA();
                Log.d("********************** ", "" + tamano);
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


                cm.setA(a);
                cm.setB(b);

                String res ="[ ";
                float[] cramer = cm.cramer();
                for(int i=0;i<cramer.length;i++){
                    if(i!=cramer.length-1)
                        res += cramer[i] + " , ";
                    else
                        res += cramer[i];
                }
                res += " ]";
                //Toast.makeText(getBaseContext(), "El resultado de la operacion es " + res, Toast.LENGTH_LONG).show();
                resultado.setText("El resultado de la operacion es\n"+res);
                Log.d("********************** ", "RESULTADO  "  + res);
                arreglo.clear();
                tamano = 0;
                if(botonTamano.isEnabled()==false) {
                    botonTamano.setEnabled(true);
                }

                }
        });

        botonTamano.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtDos.getText().toString().trim();
                tamano = Integer.parseInt(getInput);

                if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_LONG).show();
                }else if (getInput.trim().equals("0")){
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de 0x0", Toast.LENGTH_LONG).show();
                }else{
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
                    Toast.makeText(getBaseContext(), getInput,Toast.LENGTH_LONG).show();
                    if(botonTamano.isEnabled()) {
                        botonTamano.setEnabled(false);
                    }
                }
            }
        });

    }
}













