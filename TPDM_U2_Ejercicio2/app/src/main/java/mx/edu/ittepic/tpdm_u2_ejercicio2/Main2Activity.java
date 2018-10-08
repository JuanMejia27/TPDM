package mx.edu.ittepic.tpdm_u2_ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText nombre,telefono, sueldo;
    Button guardar, regresar;
    Abogado abogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.nombre);
        telefono = findViewById(R.id.telefono);
        sueldo = findViewById(R.id.sueldo);
        guardar = findViewById(R.id.guardar);
        regresar = findViewById(R.id.regresar);
        abogado = new Abogado(this);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean respuesta = abogado.insertar(
                        new Abogado(0,nombre.getText().toString(),
                        telefono.getText().toString(), Float.parseFloat(sueldo.getText().toString())));
                if(respuesta){
                    Toast.makeText(Main2Activity.this,"SE INSERTO",Toast.LENGTH_LONG).show();
                    nombre.setText("");telefono.setText("");sueldo.setText("");
                }else{
                    Toast.makeText(Main2Activity.this,"ERROR NO SE INSERTO",Toast.LENGTH_LONG).show();
                }
            }//onClick
        });//setOnClick
    }//onCreate

}
