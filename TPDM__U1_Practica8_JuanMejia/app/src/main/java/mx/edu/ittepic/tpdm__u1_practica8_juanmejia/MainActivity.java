package mx.edu.ittepic.tpdm__u1_practica8_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    EditText editText = new EditText(MainActivity.this);
    Integer val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            case 0:
                                asigna();
                                break;
                            case 1:
                                generar();
                                break;
                            case 2:
                                calcula();
                                break;
                            case 3:
                                borra();
                                break;
                            default:
                                finish();


                        }
            }//onItemClick
        });//setOnItem
    }//onCreate

    private void asigna(){

        final AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle("Atencion").setMessage("Escriba la cantidad de valores a capturar")
                .setView(editText).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                val = Integer.parseInt(editText.getText().toString());
                dialog.dismiss();

            }
        }).show();

    }//asigna

    private void generar(){

        for (int i = 0; i < val; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(MainActivity.this);
        }
    }

    private void  calcula(){

    }

    private void borra(){

    }

}//class
