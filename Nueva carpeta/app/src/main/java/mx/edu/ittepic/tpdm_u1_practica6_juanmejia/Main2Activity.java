package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {

    EditText valor;
    Button guardar;
    Bundle bundle;
    String arr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = (EditText)findViewById(R.id.valor);
        guardar = (Button)findViewById(R.id.guardar);

        bundle = new Bundle();
        bundle = getIntent().getExtras();
        arr = bundle.getString("arr");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cad = valor.getText().toString().trim();
                String[] vectot = cad.split(",");

                int[] vecint = new int[vectot.length];
                int y = 0;
                String err="";

                for(int i = 0; i < vectot.length; i++){
                    try {
                        int x = Integer.parseInt(vectot[i]);
                        vecint[i] = x;
                    }catch (NumberFormatException e){
                        y++;
                        int pos = i+1;
                        err+="El valor "+vectot[i]+" en la posicion "+pos+"\n";
                    }
                }
                if(y > 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                    builder.setMessage("valor incorrecto")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            }).setTitle("Error").show();
                }else {
                    guardarDatos(arr,cad);
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("arr", arr);
                    startActivity(intent);
                }
            }
        });
    }//onCreate


    public void guardarDatos(String nombre, String cad) {

        FileOutputStream flujo = null;
        OutputStreamWriter escritor = null;
        try{
            File ruta = Environment.getExternalStorageDirectory();
            File fichero = new File(ruta.getAbsolutePath(), nombre+".txt");
            flujo = new FileOutputStream(fichero);
            escritor = new OutputStreamWriter(flujo);
            escritor.write(cad);//lo que voy a ecribir
        }

        catch (Exception e){
            e.printStackTrace();

        }

        finally{
            try {
                if(escritor != null)
                    escritor.close();
                Toast.makeText(Main2Activity.this, "Archivo guardado", Toast.LENGTH_SHORT).show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }//guardarDatos
}
