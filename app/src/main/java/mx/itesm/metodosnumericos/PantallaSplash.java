package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class PantallaSplash extends Activity {

    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_splash);
        // Hide the Title bar of this activity screen
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        resultado = (TextView) findViewById(R.id.info);
        resultado.setText("Instituto Tecnológico y de Estudios Superiores de Monterrey\nCampus Estado de México " +
                "\n\nProyecto Final\nMétodos Numéricos y Algebra Lineal\nMarco Antonio Reyes Guzmán\n\nJosé Antonio Malo de la Peña " +
                "\nA01371454\nGuillermo Pérez Trueba\nA01377162");


        Button boton = (Button) findViewById(R.id.inicio);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);

            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
