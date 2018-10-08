package mx.edu.ittepic.tpdm_u1_practica5_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText valores;
    Button abrir;
    String[] vector;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valores = (EditText)findViewById(R.id.valores);
        abrir = (Button)findViewById(R.id.abrir);

        abrir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                val = valores.getText().toString().trim();
                vector = val.split(",");

                int[] ini = new int[vector.length];
                int x = 0;

                for(int i = 0;i<vector.length;i++){

                    try {
                        int y = Integer.parseInt(vector[i]);
                        ini[i] = y;
                    }catch (NumberFormatException e){
                        x++;
                    }
                }//for

                if(x > 0 || valores.getText() == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("caracter no permitido/campos vacios")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            }).show();
                }else{
                    Intent otra = new Intent(MainActivity.this,Main2Activity.class);
                    otra.putExtra("vector", ini);//para poder pasar parametros del vector a otra ventana, o eso espero
                    startActivity(otra);
                }

            }//onClick
        });//setOnClick
    }//onCreate

    /*private void irOtra(){
        Intent otra = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(otra);
    }*/

}//class
