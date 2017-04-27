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
import android.widget.Toast;

import java.util.ArrayList;

public class MetodoUno extends Activity {

    private ArrayList<String> arreglo = new ArrayList<>();
    private EditText txt, txtDos;
    private Integer tamano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_uno);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        Button boton = (Button) findViewById(R.id.enter);
        Button botonCramer = (Button)findViewById(R.id.cramerBoton);
        Button botonTamano = (Button)findViewById(R.id.enterTamano);
        //Datos
        txt = (EditText)findViewById(R.id.numero);
        txtDos = (EditText)findViewById(R.id.tamano);

        boton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_LONG).show();
                }else{
                    arreglo.add(getInput);
                    ((EditText) findViewById(R.id.numero)).setText(" ");
                    //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
                }
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
                Toast.makeText(getBaseContext(),arreglo.toString(),Toast.LENGTH_SHORT).show();
                arreglo.clear();
            }
        });

        botonTamano.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtDos.getText().toString();
                tamano = Integer.parseInt(getInput);

                if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_LONG).show();
                }else{
                    ((EditText) findViewById(R.id.numero)).setText(" ");
                    //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}













