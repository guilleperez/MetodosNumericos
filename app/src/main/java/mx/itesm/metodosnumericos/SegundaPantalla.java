package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SegundaPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        ImageButton back = (ImageButton)findViewById(R.id.regresoPantallaUno);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(),PrimerPantalla.class);
                startActivity(inti);
            }
        });

        Button botonCinco = (Button)findViewById(R.id.metodoCinco);

        Button botonSeis = (Button)findViewById(R.id.metodoSeis);

        Button botonSiete = (Button)findViewById(R.id.metodoSiete);

        Button botonOcho = (Button)findViewById(R.id.metodoOcho);

        Button botonNueve = (Button)findViewById(R.id.metodoNueve);

        botonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoCinco.class);
                startActivity(inti);
            }
        });

        botonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoSeis.class);
                startActivity(inti);
            }
        });

        botonSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoSiete.class);
                startActivity(inti);
            }
        });

        botonOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoOcho.class);
                startActivity(inti);
            }
        });

        botonNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), MetodoNueve.class);
                startActivity(inti);
            }
        });
    }
}
