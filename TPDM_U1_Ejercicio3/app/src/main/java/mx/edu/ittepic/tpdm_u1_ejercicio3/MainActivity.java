package mx.edu.ittepic.tpdm_u1_ejercicio3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listamenu);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        irActivity1();
                        break;
                    case 1:
                        irActivity2();
                        break;
                    case 2:
                        acerca();
                        break;
                    default:
                        finish();
                }
            }
        });
    }

    private void irActivity1(){
        //para que MainActivity mande llamar a Main2Activity
        Intent otraVentana = new Intent(MainActivity.this,
                Main2Activity.class);//lleva 2 parametros activity actual y activity abrir
        startActivity(otraVentana);
    }//irActivity1

    private void irActivity2(){
        Intent otraVentana2 = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(otraVentana2);
    }//irActivity2

    private void acerca(){
        AlertDialog.Builder alerta =
                new AlertDialog.Builder(MainActivity.this);

        alerta.setTitle("Acerca de este programa");
        alerta.setMessage("(c) Reservados Juan Mejia\nTecnologico de Tepic");
        alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();//para el positive es dismiss para negative es cancel
            }
        });
        alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
            }
        });

    }//acerca
}
