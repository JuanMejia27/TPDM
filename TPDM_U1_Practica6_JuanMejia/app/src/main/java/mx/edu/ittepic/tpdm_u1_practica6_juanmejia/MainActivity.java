package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.nombre);
        lista=(ListView)findViewById(R.id.lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String no=nombre.getText().toString();
                if(position==0){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("nombrear",no);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    intent.putExtra("nombrear",no);
                    startActivity(intent);
                }
                if(position==2){
                    AlertDialog.Builder alerta=new AlertDialog.Builder(MainActivity.this);
                    alerta.setTitle("Acerca de...").setMessage("(C) Reservados Juan Antonio Mejia Peña\n Tecnologico de Tepic")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

}//class
