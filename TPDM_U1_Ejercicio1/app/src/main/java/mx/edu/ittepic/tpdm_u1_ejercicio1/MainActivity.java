package mx.edu.ittepic.tpdm_u1_ejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensajeGoogle(View v){
        Toast.makeText(MainActivity.this,"la red social nunca fue",Toast.LENGTH_LONG).show();
    }//mensajeGoogle

    public void mensajeFacebook(View v){
        Toast.makeText(MainActivity.this,"Escandalos provoco",Toast.LENGTH_LONG).show();
    }

    public void mensajeTwiter(View v){
        Toast.makeText(MainActivity.this,"Pajaros se escuchan",Toast.LENGTH_LONG).show();
    }

    public void mensajeInstagram(View v){
        Toast.makeText(MainActivity.this, "Imagenes por doquier",Toast.LENGTH_LONG).show();
    }

    public void mensajeLinkedin(View v){
        Toast.makeText(MainActivity.this,"No la mas popular",Toast.LENGTH_LONG).show();
    }

    public void mensajeYouTube(View v){
        Toast.makeText(MainActivity.this,"Ni chabelo los ve todos",Toast.LENGTH_LONG).show();
    }

    public void mensajeWhatsapp(View v){
        Toast.makeText(MainActivity.this,"Disque red social",Toast.LENGTH_LONG).show();
    }

    public void mensajePrinterest(View v){
        Toast.makeText(MainActivity.this,"Solo imagenes",Toast.LENGTH_LONG).show();
    }
}
