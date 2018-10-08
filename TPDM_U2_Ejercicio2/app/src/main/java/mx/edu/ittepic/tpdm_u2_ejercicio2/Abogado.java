package mx.edu.ittepic.tpdm_u2_ejercicio2;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Abogado {
    int id;
    String nombre, telefono;
    float sueldo;
    BaseDatos base;

    //este constructor e para llamar los metodos
    public Abogado(Activity activity){//se requiere un contructor vacio
        base = new BaseDatos(activity, "buffete",null,1);
    }

    //este es para mantener los datos y pasarlos a un objeto
    public Abogado(int i, String nombre, String t, float sueldo){//y otro con parametros
        id = i;
        this.nombre = nombre;//si se llaman igual el this es para la variable global y poder referenciarla con la local de la clase
        telefono = t;
        this.sueldo = sueldo;
    }

    public boolean insertar(Abogado dato){//el menssaje puede ser boolean, entero o cadena para pasar el emnsaje a el main de insertar
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            ContentValues data = new ContentValues();

            data.put("NOMBRE",dato.nombre);
            data.put("TELEFONO",dato.telefono);
            data.put("SUELDO",dato.sueldo);
            long resultado = tabla.insert("ABOBADO","IDABOGADO",data);

            if(resultado == -1) return false;

        }catch (SQLiteException e){
            return false;
        }
        return true;
    }//insertar

    public Abogado consultar(String telefono){
        Abogado ab=null;
        try{
            SQLiteDatabase tabla = base.getReadableDatabase();
            String SQL = "SELECT * FROM ABOGADO WHERE TELEFONO=?";
            String claves[] = {telefono};

            Cursor c = tabla.rawQuery(SQL,claves);
            if(c.moveToFirst()){
                ab = new Abogado(c.getInt(0),c.getString(1),
                        c.getString(2),c.getFloat(3));
            }
            tabla.close();
        }catch (SQLiteException e){
            return null;
        }
        return ab;
    }

    public Abogado[] consulta(){
        Abogado[] resultado=null;
        try{
            SQLiteDatabase tabla = base.getReadableDatabase();
            String SQL = "SELECT * FROM ABOGADO";


            Cursor c = tabla.rawQuery(SQL,null);
            if(c.moveToFirst()){
                resultado = new Abogado[c.getCount()];
                int i=0;
                do {
                    resultado[i++] = new Abogado(c.getInt(0),
                            c.getString(1), c.getString(2),
                            c.getFloat(3));
                }while(c.moveToNext());
            }
            tabla.close();
        }catch (SQLiteException e){
            return null;
        }
        return resultado;
    }

    public boolean eliminar(Abogado datos){
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            String SQL = "DELETE FROM ABOGADO WHERE IDABOGADO="+datos.id;

            tabla.execSQL(SQL);
            tabla.close();
        }catch (SQLiteException e){
            return false;
        }
        return true;
    }

    public boolean actualizar(Abogado dato){
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            ContentValues data = new ContentValues();
            String claves[] = {""+dato.id};

            data.put("NOMBRE",dato.nombre);
            data.put("TELEFONO",dato.telefono);
            data.put("SUELDO",dato.sueldo);
            long resultado = tabla.update("ABOGADO",data,"IDABOGADO=?",claves);
            if(resultado == -1) return false;

        }catch (SQLiteException e){
            return false;
        }
        return true;
    }
}//class
