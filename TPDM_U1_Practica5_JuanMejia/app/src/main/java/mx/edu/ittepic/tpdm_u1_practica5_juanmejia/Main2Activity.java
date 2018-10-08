package mx.edu.ittepic.tpdm_u1_practica5_juanmejia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText pos;
    TextView res,rest;
    Button mostrar;
    Bundle bundle;//pasa valores entre ventanas
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pos = (EditText)findViewById(R.id.pos);

        res = (TextView)findViewById(R.id.rest);
        rest = (TextView)findViewById(R.id.rest);

        mostrar = (Button)findViewById(R.id.mostrar);

        bundle = new Bundle();
        bundle = getIntent().getExtras();//pasar a la variable los metodos de optencin de valres, segun sangoogle

        final int[] arr = bundle.getIntArray("vector");//para traer los valores del vector antes creado mandandolo a uno nuevo, espero funcione

        mostrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                p = Integer.parseInt((pos).getText().toString());

                if ((p) > arr.length){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                    builder.setMessage("posicion invalida")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            }).show();
                }else{
                    res.setText("Posicion: "+ (p)+" es "+arr[p-1]);
                }

            }//Onclick
        });//setOnclick

    }//onCreate
}//clas
