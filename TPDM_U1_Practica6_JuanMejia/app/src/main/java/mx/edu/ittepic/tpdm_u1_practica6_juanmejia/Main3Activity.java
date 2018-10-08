package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3Activity extends AppCompatActivity {

    EditText posicion;
    Button mostrar;
    Bundle bundle;
    String aux="";
    int pos;
    String nombrear,cad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        posicion=(EditText)findViewById(R.id.posicion);
        mostrar=(Button)findViewById(R.id.mostrar);

        bundle = new Bundle();
        bundle = getIntent().getExtras();

        nombrear = bundle.getString("nombrear");

        Toast.makeText(Main3Activity.this,nombrear,Toast.LENGTH_LONG).show();

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerFicheroMemoriaExterna();
                aux.trim();
                pos=Integer.parseInt(posicion.getText().toString());



                String[] vec=aux.split(",");
                int[] vecint=new int[vec.length];
                int c=0;
                String err="";
                for(int i=0;i<vec.length;i++){
                    try {
                        int a=Integer.parseInt(vec[i]);
                        vecint[i]=a;
                    }catch (NumberFormatException e){

                    }
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        }).setTitle(":)").show();
            }
        });//setOnClick
    }//onCreate

    private void leerFicheroMemoriaExterna()
    {
        InputStreamReader flujo=null;
        BufferedReader lector=null;
        try
        {
            File ruta = Environment.getExternalStorageDirectory();
            File fichero = new File(ruta.getAbsolutePath(), nombrear+".txt");
            flujo= new InputStreamReader(new FileInputStream(fichero));
            lector= new BufferedReader(flujo);
            String texto = lector.readLine();
            while(texto!=null)
            {
                aux+=texto;
                //tbTexto.setText(texto);
                texto=lector.readLine();
            }
        }
        catch (Exception ex)
        {
            Log.e("ivan", "Error al leer desde la tarjeta SD");
        }
        finally
        {
            try {
                if(lector!=null)
                    lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//leer

}//class
