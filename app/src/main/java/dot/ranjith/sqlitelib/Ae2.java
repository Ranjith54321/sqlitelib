package dot.ranjith.sqlitelib;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ae2 extends AppCompatActivity {
    DatabaseHelper mydb;
    DatabaseHelperuser mysql;

    Button add,remove,update,info,student;

    EditText book,author,avail,id;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmle2);

        mydb = new DatabaseHelper(this);
        mysql = new DatabaseHelperuser(this);

        add=(Button)findViewById(R.id.take);
        remove=(Button)findViewById(R.id.remove);
        update=(Button)findViewById(R.id.update);
        info=(Button)findViewById(R.id.info);
        student=(Button)findViewById(R.id.st);

        book=(EditText)findViewById(R.id.book);
        author=(EditText)findViewById(R.id.author);
        avail=(EditText)findViewById(R.id.avil);
        id=(EditText)findViewById(R.id.id);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ckinser = mydb.insertdata(book.getText().toString(),author.getText().toString(),avail.getText().toString());

                if(ckinser == true){
                    Toast.makeText(Ae2.this," Data is inserted successfully ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Ae2.this," Can't insert data ",Toast.LENGTH_LONG).show();

                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getalldata();

                if(res.getCount()==0){
                    showmsg(" ERROR "," there is no data ");
                    return;
                }

                StringBuffer sb = new StringBuffer();

                while (res.moveToNext()){
                    sb.append( " ID = "+ res.getString(0)+"\n");
                    sb.append(" BOOK = "+res.getString(1)+"\n");
                    sb.append(" AUTHOR = "+res.getString(2)+"\n");
                    sb.append(" AVAILABLE = "+res.getString(3)+"\n\n");
                }
                showmsg(" DATA ",sb.toString());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  boolean chup = mydb.update(id.getText().toString(),book.getText().toString(),author.getText().toString(),avail.getText().toString());
                if(chup == true){
                    Toast.makeText(Ae2.this," Data is updated successfully ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Ae2.this," Can't update data ",Toast.LENGTH_LONG).show();

                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dch = mydb.delete(id.getText().toString());
                if(dch > 0){
                    Toast.makeText(Ae2.this," Data is deleted successfully ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Ae2.this," Can't delete data ",Toast.LENGTH_LONG).show();

                }

            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mysql.getalldata();

                if(res.getCount()==0){
                    showmsg2(" ERROR "," there is no data ");
                    return;
                }

                StringBuffer sb = new StringBuffer();

                while (res.moveToNext()){
                    sb.append( " ID = "+ res.getString(0)+"\n");
                    sb.append(" R. NO= "+res.getString(1)+"\n");
                    sb.append(" BOOK = "+res.getString(2)+"\n");
                    //sb.append(" AVAI = "+res.getString(3)+"\n\n");
                }
                showmsg2(" DATA ",sb.toString());
            }
        });
    }

    public void showmsg(String title,String msg){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setMessage(msg);
        b.setTitle(title);
        b.show();
             }

    public void showmsg2(String title,String msg){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setMessage(msg);
        b.setTitle(title);
        b.show();
             }
}
