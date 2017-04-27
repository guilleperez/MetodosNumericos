package mx.itesm.metodosnumericos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MetodoDos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title bar of this activity screen
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








    }
}
