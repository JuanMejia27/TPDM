package com.example.mejia.tpdm_u1_ejercicio8;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    TextView etiqueta,etiqueta2;
    Button boton,boton2;
    CountDownTimer timer, timer2;//para poner un timer
    int contador,contador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta = findViewById(R.id.etiqueta);
        boton = findViewById(R.id.boton);
        boton2 = findViewById(R.id.boton2);
        contador = 1;

        timer = new CountDownTimer(2000,200) {//poner parametros, primero cantidad de tiempo
            // y segundo los lapsos de tiempo
            @Override
            public void onTick(long millisUntilFinished) {
                contador++;
                etiqueta.setText(""+contador);
            }

            @Override
            public void onFinish() {
                start();//este parametro para volver a iniciarlo y que sea infinito
            }
        };//quitar indicacion de error con ;

        timer2 = new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };//timer2
        //agregar la hora actual queda pendiente

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();// El metodo START sube el codigo a ejecucion en 2do plano
                boton.setEnabled(false);
            }
        });//boton

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();//Este hace qeu se detenga pero se agrega en otro boton
                contador = 0;
                boton.setEnabled(true);
            }
        });//boton2
    }
}
