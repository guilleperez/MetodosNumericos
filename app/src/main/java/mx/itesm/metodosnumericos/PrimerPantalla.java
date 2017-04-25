package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class PrimerPantalla extends AppCompatActivity {

           protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_primer_pantalla);

            Button boton = (Button)findViewById(R.id.botonUno);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast =  Toast.makeText(PrimerPantalla.this,"Prueba", Toast.LENGTH_LONG);
                    toast.show();
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

            Button botonCuatro = (Button)findViewById(R.id.botonCuatro);
            botonCuatro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inti = new Intent(getBaseContext(), MetodoCuatro.class);
                    startActivity(inti);
                }
            });

            Button botonPaginaDos = (Button)findViewById(R.id.paginaDos);
            botonPaginaDos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inti = new Intent(getBaseContext(), SegundaPantalla.class);
                    startActivity(inti);
                }
            });

        }
}
