package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class NewRaphsonPantalla extends Activity {

    private ImageButton back;
    private Button botonAprox, botonTole, botonDone;
    private EditText txtAprox, txtTole;
    private Double aproxValor, toleranciaValor;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_raphson_pantalla);

        back = (ImageButton)findViewById(R.id.back);

        //Botones
        botonAprox = (Button)findViewById(R.id.aproxBoton);
        botonTole = (Button)findViewById(R.id.toleranciaBoton);
        botonDone = (Button)findViewById(R.id.ok);

        //Texto datos
        txtAprox = (EditText)findViewById(R.id.aproximacion);
        txtTole = (EditText)findViewById(R.id.tolerancia);

        //resultado
        resultado = (TextView)findViewById(R.id.resultado);

        if(botonDone.isEnabled()){
            botonDone.setEnabled(false);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonAprox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getIntput = txtAprox.getText().toString();
                if (getIntput == null || getIntput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else{
                    aproxValor = Double.parseDouble(getIntput.trim());
                    txtAprox.setText("");
                    if(botonAprox.isEnabled()){
                        botonAprox.setEnabled(false);
                    }
                }
            }
        });

        botonTole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtTole.getText().toString();
                if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else{
                    toleranciaValor = Double.parseDouble(getInput.trim());
                    txtTole.setText("");
                    if(botonTole.isEnabled()){
                        botonTole.setEnabled(false);
                    }if(!botonDone.isEnabled()){
                        botonDone.setEnabled(true);
                    }


                }
            }
        });

        botonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double b;
                double c;
                do{
                    b=aproxValor-(aproxValor*aproxValor-aproxValor-2)/(2*aproxValor-1);
                    c=Math.abs(aproxValor-b);
                    aproxValor=b;
                }while(c>toleranciaValor);

                resultado.setText(b+" ");
                aproxValor = 0.0;
                toleranciaValor = 0.0;
                if(!botonTole.isEnabled() || !botonAprox.isEnabled()) {
                    botonTole.setEnabled(true);
                    botonAprox.setEnabled(true);
                }
                if(botonDone.isEnabled()){
                    botonDone.setEnabled(false);
                }

            }
        });

    }
}
