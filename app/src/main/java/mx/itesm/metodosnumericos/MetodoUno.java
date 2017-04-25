package mx.itesm.metodosnumericos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MetodoUno extends AppCompatActivity {

    private EditText numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_uno);

        ImageButton boton = (ImageButton)findViewById(R.id.regreso);

        Button botonEnter = (Button)findViewById(R.id.enter);


        boton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_primer_pantlla);
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);

            }
        });


        botonEnter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = (EditText) findViewById(R.id.numero);
                
                Toast toast =  Toast.makeText(MetodoUno.this,numero.getText().toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
























    }
}
