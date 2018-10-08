package com.example.mejia.tpdm_u1_practica2_juanmejia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mayor, menor;
    EditText val1, val2, val3;
    Integer num;
    TextView alertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.text1);
        val2 = findViewById(R.id.text2);
        val3 = findViewById(R.id.text3);

        mayor = findViewById(R.id.valmayor);
        menor = findViewById(R.id.valmenor);

        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cMayor();
                AlertDialog.Builder alerta1 = new AlertDialog.Builder(MainActivity.this);
                alerta1.setMessage("El valor mayor es: "+num)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });//mayor

        menor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cMenor();
                AlertDialog.Builder alerta2 = new AlertDialog.Builder(MainActivity.this);
                alerta2.setMessage("El valor menor es: "+num)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });//menor
    }

    public Integer cMayor(){
        int x=0, y=0, z=0;
        x = Integer.parseInt(val1.getText().toString());
        y = Integer.parseInt(val2.getText().toString());
        z = Integer.parseInt(val3.getText().toString());

        if(x>y && x>z){
            return num = x;
        }
        if(y>x && y>z){
            return num = y;
        }
        if(z>x && z>y){
            return num = z;
        }
        return 0;
    }//cMayor

    public Integer cMenor(){
        int x=0, y=0, z=0;
        x = Integer.parseInt(val1.getText().toString());
        y = Integer.parseInt(val2.getText().toString());
        z = Integer.parseInt(val3.getText().toString());

        if(x<y && x<z){
            return num = x;
        }
        if(y<x && y<z){
            return num = y;
        }
        if(z<x && z<y){
            return num = z;
        }
        return 0;
    }


}
