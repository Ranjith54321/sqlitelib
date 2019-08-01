package dot.ranjith.sqlitelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Au1 extends AppCompatActivity {
    Button search,submit;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlu1);
        search = (Button) findViewById(R.id.take);
        submit = (Button) findViewById(R.id.bt2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Au1.this,Au2.class);
                startActivity(i);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Au1.this,Au5.class);
                startActivity(i2);
            }
        });

    }
}
