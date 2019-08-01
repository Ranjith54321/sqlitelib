package dot.ranjith.sqlitelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubaritem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
            if (id==R.id.about){
           // Toast.makeText(MainActivity.this,"yeah it's working ",Toast.LENGTH_LONG).show();

                  Intent i3 = new Intent(MainActivity.this,About.class);
                  startActivity(i3);

        }
        return super.onOptionsItemSelected(item);
    }

    public void type(View v){
        switch (v.getId()){
            case R.id.take:
                Intent i = new Intent(MainActivity.this,Au1.class);
                startActivity(i);
                break;
            case R.id.bt2:


                Intent i2 = new Intent(MainActivity.this,Ae1.class);
                startActivity(i2);
                break;

        }

    }
}
