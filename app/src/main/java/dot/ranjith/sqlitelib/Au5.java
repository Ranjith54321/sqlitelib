package dot.ranjith.sqlitelib;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Au5 extends AppCompatActivity {
    Button bt1;

   EditText book;

    DatabaseHelperuser mydbus;
    DatabaseHelper mydb;

    public  String id;
    public String author;

    public String se1,idd,auth;
    public int a=0;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlu5);


        mydbus = new DatabaseHelperuser(this);
        mydb = new DatabaseHelper(this);

        book = (EditText) findViewById(R.id.book);
        bt1 = (Button) findViewById(R.id.take);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Cursor res = mydb.getalldata();

                        if(res.getCount()==0){
                            Toast.makeText(Au5.this," no data in data base ",Toast.LENGTH_LONG).show();
                            return;
                        }


                        while (res.moveToNext()){
                             idd = res.getString(0);
                             se1 = res.getString(1);  //book name
                             auth = res.getString(2);
                           // sb.append(" AVAILABLE = "+res.getString(3)+"\n\n");
                            if( book.getText().toString().compareToIgnoreCase(se1)==0)
                            {

                                a=1;
                                break;

                            }

                        }
                if( a==1 )
                     {

                  //  Toast.makeText(Au5.this," your book is avail in the main data so put to insert ",Toast.LENGTH_LONG).show();

                    boolean chup = mydb.update(idd,book.getText().toString(),auth,"YES");
                    if(chup == true){

                        Toast.makeText(Au5.this," Data is updated successfully ",Toast.LENGTH_LONG).show();

                        int chk = mydbus.delete(idd);
                        // delete the book from database (NEED TO HIDE THE BOOK FROM THE DATABASE HELPER NOT DELETE)
                        if(chk > 0){
                            Toast.makeText(Au5.this," Data is deleted successfully ",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Au5.this," Can't delete data ",Toast.LENGTH_LONG).show();
                           }
                    }
                    else
                        Toast.makeText(Au5.this," Can't update data ",Toast.LENGTH_LONG).show();


                }

                else
                {
                    Toast.makeText(Au5.this," your book is in valid "+se1,Toast.LENGTH_LONG).show();


                }
            }
        });

    }
}
