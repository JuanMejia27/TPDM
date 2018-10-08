package mx.edu.ittepic.tpdm_u1_ejercicio9;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menu = (ListView)findViewById(R.id.menu);

        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        irInsertar();
                        break;
                    case 1:
                        irBuscar();
                        break;
                    case 2:
                        irEliminar();
                        break;
                    case 3:
                        irAcerca();
                        break;
                     default:
                         finish();
                }
            }//onItem
        });//setOnItem

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }//onCreate

    private void irInsertar(){

    }

    private void irBuscar(){

    }

    private void irEliminar(){

    }

    private void irAcerca(){

    }

}//class
