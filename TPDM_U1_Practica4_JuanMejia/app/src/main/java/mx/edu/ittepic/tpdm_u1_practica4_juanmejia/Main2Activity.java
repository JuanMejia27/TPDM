package mx.edu.ittepic.tpdm_u1_practica4_juanmejia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {
    Spinner spinner;
    ImageView imagenA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = (Spinner)findViewById(R.id.spinner);
        imagenA2 = (ImageView)findViewById(R.id.imagenA2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(spinner.getSelectedItemPosition() == 0){
                    imagenA2.setImageResource(R.drawable.itt_escudo);
                }

                if(spinner.getSelectedItemPosition() == 1){
                    imagenA2.setImageResource(R.drawable.pickle_rick);
                }

                if(spinner.getSelectedItemPosition() == 2) {
                    imagenA2.setImageResource(R.drawable.koyomi);
                }

                if(spinner.getSelectedItemPosition() == 3){
                    imagenA2.setImageResource(R.drawable.advtime);
                }
            }//onItemSlected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//setOnItem
    }//onCreate
}//class
