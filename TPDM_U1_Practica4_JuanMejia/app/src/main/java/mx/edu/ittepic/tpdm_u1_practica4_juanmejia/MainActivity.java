package mx.edu.ittepic.tpdm_u1_practica4_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (ListView) findViewById(R.id.menu);

        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        irActivity1();
                        break;
                    case 1:
                        irActivit2();
                        break;
                    case 2:
                        irActivity3();
                    default:
                        finish();
                }
            }
        });//onItemClick
    }//onCreate

    private void irActivity1(){
        Intent otra1 = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(otra1);
    }

    private void irActivit2(){
        Intent otra2 = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(otra2);
    }

    private void irActivity3(){
        Intent otra3 = new Intent(MainActivity.this,Main4Activity.class);
        startActivity(otra3);
    }

}//class
