package mx.edu.ittepic.tpdm_u2_ejercicio2;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.sql.SQLException;

public class Expediente {
    String id,descripcion,cliente,fecha;
    int idabogado;
    BaseDatos base;

    public Expediente(Activity activity){
        base = new BaseDatos(activity,"buffete",null,1);
    }

    public Expediente(String id,String descripcion,String cliente,String fecha,int idabogado){
        this.id = id;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = fecha;
        this.idabogado = idabogado;
    }

    public boolean inertar(Expediente expediente){
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            ContentValues data = new ContentValues();

            data.put("IDEXPEDIENTE",expediente.id);
            data.put("DESCRIPCION",expediente.descripcion);
            data.put("CLIENTE",expediente.cliente);
            data.put("FECHA",expediente.fecha);
            data.put("IDABOGADO",expediente.idabogado);
            long resultado = tabla.insert("EXPEDIENTE",null,data);
            tabla.close();

            if (resultado < 0)return  false;
        }catch (SQLiteException e){
            return false;
        }
        return true;
    }//insertar

    public Expediente[] consulta(){
        Expediente[] resultado=null;
        try{
            SQLiteDatabase tabla = base.getReadableDatabase();
            String SQL = "SELECT * FROM EXPEDIENTE";


            Cursor c = tabla.rawQuery(SQL,null);
            if(c.moveToFirst()){
                resultado = new Expediente[c.getCount()];
                int i=0;
                do {
                    resultado[i++] = new Expediente(c.getString(0),
                            c.getString(1), c.getString(2),
                            c.getString(3),c.getInt(4));
                }while(c.moveToNext());
            }
            tabla.close();
        }catch (SQLiteException e){
            return null;
        }
        return resultado;
    }

    public boolean eliminar(Expediente expediente){
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            String[] data = {expediente.id};
            long res = tabla.delete("EXPEDIENTE","IDEXPEDIENTE=?",data);
            tabla.close();
            if(res==0){
                return false;
            }
        }catch (SQLiteException e){
            return false;
        }
        return true;
    }

    public boolean actualizar(Expediente expediente){
        try{
            SQLiteDatabase tabla = base.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put("DESCRIPCION",expediente.descripcion);
            data.put("CLIENTE",expediente.cliente);
            data.put("FECHA",expediente.fecha);
            data.put("IDABOGADO",expediente.idabogado);
            String[] clave = {expediente.id};
            long res = tabla.update("EXPEDIENTE",data,"IDEXPEDIENTE=?",clave);
            tabla.close();
            if(res<0){
                return false;
            }
        }catch (SQLiteException e){
            return false;
        }
        return true;
    }

}//class
