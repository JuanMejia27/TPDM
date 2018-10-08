package mx.edu.ittepic.tpdm_u2_ejercicio2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lista = findViewById(R.id.listaabogados);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mensajeAlerta(position);
            }
        });
    }//onCreate

    private void mensajeAlerta(final int position) {
        AlertDialog.Builder alerta  = new AlertDialog.Builder(this);
        Abogado abogado = new Abogado(this);
        final Abogado vector[] = abogado.consulta();


        alerta.setTitle("Detalle de abogado").setMessage("¿Deseas moodificar/borrar abogado?"+vector[position])
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ventana = new Intent(Main3Activity.this,Main4Activity.class);
                        ventana.putExtra("id",vector[position].id);
                        ventana.putExtra("nombre",vector[position].id);
                        ventana.putExtra("telefono",vector[position].id);
                        ventana.putExtra("sueldo",vector[position].id);
                        startActivity(ventana);
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    //metodo onstart
    protected void onStart(){//se encarga de la parte dinamica de los cambios generados
        super.onStart();
        Abogado abogado = new Abogado(this);
        Abogado vector[] = abogado.consulta();
        if(vector == null){
            Toast.makeText(this,"NOHAY ABOGADOS CAPTURADOS", Toast.LENGTH_LONG).show();
            return;
        }
        String nombres[] = new String[vector.length];

        for(int i=0; i<nombres.length;i++){
            nombres[i] = vector[i].nombre;
        }

        //es el equivalente a los que se agregan en values/String y se asociancon entries
        ArrayAdapter<String> adaptador
                = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,nombres);
        lista.setAdapter(adaptador);
    }//onStart
}//class
