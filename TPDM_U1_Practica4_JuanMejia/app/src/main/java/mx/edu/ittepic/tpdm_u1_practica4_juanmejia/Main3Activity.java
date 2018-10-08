package mx.edu.ittepic.tpdm_u1_practica4_juanmejia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main3Activity extends AppCompatActivity {

    EditText mnt,total;
    Spinner spinnerA3;
    Button calcula;
    double x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mnt=(EditText)findViewById(R.id.mnt);
        total=(EditText)findViewById(R.id.total);

        calcula=(Button)findViewById(R.id.calcula);

        spinnerA3=(Spinner)findViewById(R.id.spinnerA3);


        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerA3.getSelectedItemPosition() == 0){
                    x = Double.parseDouble(mnt.getText().toString());
                    y = x * 0.1;
                    total.setText(y+"");
                }

                if(spinnerA3.getSelectedItemPosition() == 1){
                    x = Double.parseDouble(mnt.getText().toString());
                    y = x*0.05;
                    total.setText(y+"");
                }

                if(spinnerA3.getSelectedItemPosition() == 2){
                    x = Double.parseDouble(mnt.getText().toString());
                    y = x * 0.2;
                    total.setText(y+"");
                }
                if(spinnerA3.getSelectedItemPosition()==3){
                    x=Double.parseDouble(mnt.getText().toString());
                    y=x*0.15;
                    total.setText(y+"");
                }

                if(spinnerA3.getSelectedItemPosition() == 4){
                    x = Double.parseDouble(mnt.getText().toString());
                    y = x * 0.25;
                    total.setText(y+"");
                }
            }//onClick
        });//setOnClick


    }//onCreate
}//class
