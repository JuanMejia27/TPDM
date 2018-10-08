package mx.edu.ittepic.tpdm_u2_ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText nombre, telefono, sueldo;
    Button eliminar, modificar;
    int ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nombre = findViewById(R.id.nombre);
        telefono = findViewById(R.id.telefono);
        sueldo = findViewById(R.id.sueldo);

        eliminar = findViewById(R.id.eliminarme);
        modificar = findViewById(R.id.modificarme);

        ID = getIntent().getExtras().getInt("id");
        nombre.setText(getIntent().getExtras().getString("nombre"));
        telefono.setText(getIntent().getExtras().getString("telefono"));
        sueldo.setText(""+getIntent().getExtras().getFloat("sueldo"));

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abogado abogado = new Abogado(Main4Activity.this);
                boolean res = abogado.eliminar(new Abogado(ID,"","",0.0f));
                if (res) {
                    Toast.makeText(Main4Activity.this,"Se borro con exito",
                            Toast.LENGTH_LONG).show();
                    nombre.setEnabled(false);
                    telefono.setEnabled(false);
                    sueldo.setEnabled(false);
                }else{
                    Toast.makeText(Main4Activity.this,"Error no se pudo eliminar",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abogado abogado = new Abogado(Main4Activity.this);
                boolean res = abogado.actualizar(new Abogado(ID,nombre.getText().toString()
                        ,telefono.getText().toString(),Float.parseFloat(sueldo.getText().toString())));
                if(res){
                    Toast.makeText(Main4Activity.this,"Se modifico con exito",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Main4Activity.this,"Error al modificar",
                             Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
