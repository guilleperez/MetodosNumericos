package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class TercerPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_pantalla);

        ImageButton back = (ImageButton)findViewById(R.id.regresoPantallaUno);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(),PrimerPantalla.class);
                startActivity(inti);
            }
        });

    }
}
