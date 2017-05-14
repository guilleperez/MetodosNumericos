package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class PrimerPantalla extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Hide the Title bar of this activity screen
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_primer_pantalla);

        //ImageButton back = (ImageButton)findViewById(R.id.back);
        Button boton = (Button)findViewById(R.id.botonUno);

       /* back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PantallaSplash.class);
                startActivity(inti);
            }
        });*/
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast toast =  Toast.makeText(PrimerPantalla.this,"Prueba", Toast.LENGTH_LONG);
                toast.show();*/
                Intent inti = new Intent(getBaseContext(), MetodoUno.class);
                startActivity(inti);
            }
        });

        Button botonDos = (Button)findViewById(R.id.botonDos);
        botonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoDos.class);
                startActivity(inti);
            }
        });

        Button botonTres = (Button)findViewById(R.id.botonTres);
        botonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoTres.class);
                startActivity(inti);
            }
        });

        Button NewRaphsonBoton = (Button)findViewById(R.id.botonCuatro);
        NewRaphsonBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti  = new Intent(getBaseContext(), Determinante.class);
                startActivity(inti);
            }
        });

        Button botonCinco = (Button)findViewById(R.id.botonCinco);
        botonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti  = new Intent(getBaseContext(), MetodoCinco.class);
                startActivity(inti);
            }
        });

        Button botonSeis = (Button)findViewById(R.id.botonSeis);
        botonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti  = new Intent(getBaseContext(), MetodoSeis.class);
                startActivity(inti);
            }
        });


    }
}
