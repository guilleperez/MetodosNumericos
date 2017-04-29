package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MetodoDos extends Activity {

    private EditText txtDos,txt;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private Integer tamano, basta = 0;
    private TextView resultado;
    private Button botonTamano,botonCramer,boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_metodo_dos);
        

        ImageButton boton = (ImageButton)findViewById(R.id.back);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(),PrimerPantalla.class);
                startActivity(inti);
            }
        });

        LineChart lineChart = (LineChart)findViewById(R.id.grafica);

        ArrayList<String> xs = new ArrayList<>();
        ArrayList<Entry> ys = new ArrayList<>();


        double x = 0;
        int max = 500;
        for(int i = 0; i<max ;i++){
            float sin = Float.parseFloat(String.valueOf(Math.sin(x)));
            x = x + 0.1;
            ys.add(new Entry(sin,i));
            xs.add(i,String.valueOf(x));
        }
        String[] xss = new String[xs.size()];
        for(int i = 0; i<xs.size();i++){
            xss[i] = xs.get(i).toString();

        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(ys,"Sin");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setCircleColor(Color.BLUE);
        lineDataSets.add(lineDataSet1);

        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);

*/              // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metodo_uno);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        boton = (Button) findViewById(R.id.enter);
        botonCramer = (Button)findViewById(R.id.cramerBoton);
        botonTamano = (Button)findViewById(R.id.enterTamano);
        //Datos
        txt = (EditText)findViewById(R.id.numero);
        txtDos = (EditText)findViewById(R.id.tamano);

        //Resultado
        resultado = (TextView)findViewById(R.id.resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(basta >= (tamano+1) * tamano){
                    if(boton.isEnabled()) {
                        boton.setEnabled(false);
                    }
                }
                else if(getInput==null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }
                else{
                    ((EditText) findViewById(R.id.numero)).setText(" ");
                    arreglo.add(getInput.trim());
                    basta += 1;
                }

                //Toast.makeText(getBaseContext(), arreglo.toString(),Toast.LENGTH_LONG).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(getBaseContext(), PrimerPantalla.class);
                startActivity(inti);
            }
        });

        botonCramer.setOnClickListener(new View.OnClickListener() {
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
                //resultado.setText(arreglo.toString());
                Log.d("********************** ", "RESULTADO  "  + res);
                arreglo.clear();
                tamano = 0;
                basta = 0;
                if(!botonTamano.isEnabled() || !boton.isEnabled()) {
                    botonTamano.setEnabled(true);
                    boton.setEnabled(true);
                }

            }
        });

        botonTamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtDos.getText().toString().trim();

                if(getInput == null||getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Dato faltante", Toast.LENGTH_SHORT).show();
                }else if (getInput.trim().equals("0")||getInput.trim().equals("1")){
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
                    Toast.makeText(getBaseContext(),"La matriz no puede ser de "+getInput+"x"+getInput, Toast.LENGTH_LONG).show();
                }
                else{
                    ((EditText) findViewById(R.id.tamano)).setText(" ");
                    Toast.makeText(getBaseContext(), "La matriz es de "+getInput+"x"+getInput,Toast.LENGTH_LONG).show();
                    if(botonTamano.isEnabled()) {
                        botonTamano.setEnabled(false);
                    }
                    tamano = Integer.parseInt(getInput);
                }


            }
        });







    }
}
