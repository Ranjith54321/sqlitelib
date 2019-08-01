package dot.ranjith.sqlitelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ae1 extends AppCompatActivity {
    EditText t1,t2;
    Button bt1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmle1);

        t1 = (EditText) findViewById(R.id.id);
        t2 = (EditText) findViewById(R.id.t2);

        bt1 = (Button) findViewById(R.id.take);
/*
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((t1.getText().toString().equals("Admin")) && (t2.getText().toString().equals("1234"))){
                    Intent i = new Intent(Ae1.this,Ae2.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(Ae1.this,"enter the valid name or password",Toast.LENGTH_LONG).show();
            }
        }); */


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = t1.getText().toString();
                String pass = t2.getText().toString();
                if(Name.length() != 0 && pass.length() != 0){
                    if((t1.getText().toString().equals("Admin")) && (t2.getText().toString().equals("1234"))){
                        Intent i = new Intent(Ae1.this,Ae2.class);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(Ae1.this,"enter the valid name or password",Toast.LENGTH_LONG).show();
                t1.setText("");
                t2.setText("");
                }else{
                    Toast.makeText(Ae1.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
