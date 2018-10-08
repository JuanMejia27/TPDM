package mx.edu.ittepic.tpdm_u2_ejercicio1;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, domicilio, telefono;
    Button anterior, siguiente, actualizar;
    ConexionBase basedatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //findViewByid

        nombre = (EditText)findViewById(R.id.nombre);
        domicilio = (EditText)findViewById(R.id.domicilio);
        telefono = (EditText)findViewById(R.id.nombre);

        basedatos = new ConexionBase(this,"base1",null,1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.buscar) {
            buscar("buscar");
            return true;
        }

        if (id == R.id.eliminar) {
            buscar("eliminar");
            return true;
        }

        if (id == R.id.actualiza) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void buscar(final String tipo){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        final EditText campo = new EditText(this);//final es una semi constante
        String mnsaje = "Escriba el telefono a "+tipo;

        alerta.setTitle(tipo.toUpperCase())
                .setMessage("Escriba el telefono a buscar")
                .setView(campo)
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                buscarPorTelefono(campo.getText().toString(),tipo);
            }
        }).setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }//buscar

    private void buscarPorTelefono(String telefono,String tipo){
        try{
            SQLiteDatabase base = basedatos.getReadableDatabase();
            String[] claves = {telefono};
            /*rawquery: parametros: 1 SELECT (instruccion_SQL)
                                  2 vector con valores del where
            rawquery query // en su primer parametro es la consulta sql y el siguiente es si va condicionado con un where
            query: parametros: 1Tabla, 2 Columnas, 3 where, 4 valor del where,5,6,7 grupo,having y order*/
            Cursor c = base.rawQuery("SELECT * FROM PROTO WHERE TELEFONO = ?",claves); //se pueden ir asignando mas valores pero tambien debe aumentar el vector
            if(tipo.startsWith("buscar") || tipo.startsWith("actualizar")){
                nombre.setText(c.getString(0));
                domicilio.setText(c.getString(1));
                this.telefono.setText(c.getString(2));
                if(tipo.startsWith("actualizar")){
                    actualizar.setEnabled(true);
                    this.telefono.setEnabled(false);
                }
            }else{
                eliminar(c.getString(0),telefono);
            }
            mensaje("ERROR","no se encontro coincidencia con "+telefono);
            base.close();

        }catch(SQLiteException e){
            mensaje("ERROR",e.getMessage());
        }
    }//buscarPorTelefono

    private void actualizar(){
        try{

        }catch(SQLiteDatabase e){
            mensaje("error",e.getMessage());
        }
    }


    private void eliminar(String nombre,final String telefono){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle("ATECNCION");
        alerta.setMessage("¿Seguro que deseas borrar a " + nombre + "?");
        alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarRegistro(telefono);
                dialog.dismiss();
            }
        });
        alerta.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "CANCELO ELIMINAR",
                        Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        alerta.show();
    }//eliminar

    private void eliminarRegistro(String telefono){
        try{
            SQLiteDatabase base = basedatos.getWritableDatabase();
            String SQL = "DELETE FROM PROTO WHERE TELEFONO = '"+telefono+"'";

            base.execSQL(SQL);
            base.close();
            mensaje("ATENCION","Se ELIMINO correctamente el dato");
        }catch(SQLiteException e){
            mensaje("Error",e.getMessage());
        }
    }//eliminarRegistro

    private void insertar(){
        try{
            SQLiteDatabase base = basedatos.getWritableDatabase();//para lectura y escritura
            ContentValues datos = new ContentValues();

            //para mañana: rawquery y query sin where y con where

            datos.put("NOMBRE",nombre.getText().toString());
            datos.put("DOMICILIO",domicilio.getText().toString());
            datos.put("TELEFONO",telefono.getText().toString());

            base.insert("PROTO",null,datos);
            base.close();
            mensaje("ATENCION","Se inserto correctamente el dato");
            limpiarCampos();

        }catch(SQLiteException e){
            mensaje("Error",e.getMessage());
        }
    }



    /*private void insertar(){
        try{
            SQLiteDatabase base = basedatos.getWritableDatabase();//para lectura y escritura
            String SQL = "INSERT INTO VALUES('%1','%2','%3')";//otra alternativa para insertar

            SQL = SQL.replace("%1",nombre.getText().toString());// se iguala a si misma para poder reeplazar la cadena
            SQL = SQL.replace("%2",domicilio.getText().toString());
            SQL = SQL.replace("%3",telefono.getText().toString());

            base.execSQL(SQL);
            base.close();
            mensaje("ATENCION","Se inserto correctamente el dato");
            limpiarCampos();

            //Escritura DIRECTA del codigo
            //base.execSQL("INSERT INTO PROTO VALUES('"+nombre.getText().toString()+"','"+
                            //domicilio.getText().toString()+"','"+telefono.getText().toString()+")");//para las funciones create, insert,update,alter_table,etc. exepto query
            //si la iinea anterior se cumple con exito entonces no habra errores despues de esta
            //base.insert(); es otra forma de hacer las funciones del execSQL
            //base.close();
            //mensaje("ATENCION","Se inserto correctamente el dato");
        }catch(SQLiteException e){
            mensaje("Error",e.getMessage());
        }
    }*/

    private void limpiarCampos() {
        nombre.setText("");
        domicilio.setText("");
        telefono.setText("");
    }

    private void mensaje(String title,String message){
        AlertDialog.Builder a = new AlertDialog.Builder(this);
        a.setTitle(title).setMessage(message);
    }
}
