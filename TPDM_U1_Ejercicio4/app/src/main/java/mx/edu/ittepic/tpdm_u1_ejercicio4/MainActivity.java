package mx.edu.ittepic.tpdm_u1_ejercicio4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout layo;
    TextView etiqueta;
    EditText campo,campos[];
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layo = findViewById(R.id.layin);

        etiqueta = new TextView(this);
        campo = new EditText(this);
        boton = new Button(this);
        campos = new EditText[20];//para definir el numero de celdillas para guardar un objeto y falta declarar para cada una

        /*campos[0] = new EditText(this);//para todos del 0 al 19
        campos[1] = new EditText(this);
        ...*/

        for (int i=0; i<campos.length; i++){
            campos[i] = new EditText(this);
            campos[i].setText(""+i);//solo para ver el comportamiento
            layo.addView(campos[i]);
        }

        etiqueta.setText("Escriba su nombre");
        campo.setHint("Debe empezar por APELLIDOS, nombre");
        boton.setText("Saludar");

        layo.addView(etiqueta,0);//se agregan indices para poder acomodar los objetos
        layo.addView(boton,2);//se agregan indices para poder acomodar los objetos
        layo.addView(campo,1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlerta();
            }
        });
    }
    private void crearAlerta(){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Atention").setMessage("Hola"+campo.getText().toString())
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }).show();
        }
        //layo.addView();para crear un objeto grafico
        //layo.remove(); parq euitar los objetos ya sea desde un punto hasta otro o individua
    }

