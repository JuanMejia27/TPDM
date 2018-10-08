package mx.edu.ittepic.tpdm_u1_practica3_juanmejia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton basico,superior,tecnico,lic,maestria,doc;
    Button boton;
    TextView monto;
    EditText sueldo;
    double val=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sueldo=(EditText)findViewById(R.id.sueldo);

        basico=(RadioButton)findViewById(R.id.basico);
        superior=(RadioButton)findViewById(R.id.superior);
        tecnico=(RadioButton)findViewById(R.id.tecnico);
        lic=(RadioButton)findViewById(R.id.lic);
        maestria=(RadioButton)findViewById(R.id.maestria);
        doc=(RadioButton)findViewById(R.id.doc);

        boton=(Button)findViewById(R.id.calcular);

        monto=(TextView)findViewById(R.id.monto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(basico.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.05;
                    int x = (int)(val);
                    monto.setText("Su prestamo es de: "+x);
                }

                if(superior.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.07;
                    int x = (int)(val);
                    monto.setText("Su prestamo es de: "+x);
                }

                if(tecnico.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.1;
                    int x = (int)(val);
                    monto.setText("Su prestamo es de: "+x);
                }
                if(lic.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.15;
                    int x = (int)(val);
                    monto.setText("Su prestamo es de: "+x);
                }

                if(maestria.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.25;
                    int x = (int) (val);
                    monto.setText("Su prestamo es de: "+x);
                }

                if(doc.isChecked()){
                    val=Integer.parseInt(sueldo.getText().toString())*0.35;
                    int x = (int)(val);
                    monto.setText("Su prestamo es de: "+x);
                }

            }//onClick
        });//boton OnclickListener
    }//onCreate
}//class
