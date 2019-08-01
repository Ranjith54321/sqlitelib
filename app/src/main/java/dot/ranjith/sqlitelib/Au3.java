package dot.ranjith.sqlitelib;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Au3 extends AppCompatActivity {
    Button take;

    EditText name,rno;

    public String se1,idd,auth,bok;
    public int a=0;
    // public static  String pos;


    DatabaseHelperuser mysql;
   DatabaseHelper mydb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlu3);

     mysql = new DatabaseHelperuser(this);
     mydb = new DatabaseHelper(this);

        take = (Button) findViewById(R.id.take);
       // back = (Button)findViewById(R.id.back);
        name = (EditText) findViewById(R.id.id);
        rno = (EditText) findViewById(R.id.t2);



        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namec = name.getText().toString();
                String rnoc = rno.getText().toString();
                if (namec.length() != 0 && rnoc.length() != 0) {
                    String reg = rno.getText().toString();
                    String num = reg.substring(0, 2);
                    String dep = reg.substring(2, 6);
                    if ((num.equals("16") || num.equals("17") || num.equals("18")) && (dep.equalsIgnoreCase("euit") ||
                            dep.equalsIgnoreCase("euee") || dep.equalsIgnoreCase("eumc") || dep.equalsIgnoreCase("eucs"))) {

                        boolean ans = mysql.insertdata(rno.getText().toString(), name.getText().toString(), getIntent().getStringExtra("book"));

                        // insert data to student data base
                        if (ans == true) {
                            //update data
                            Toast.makeText(Au3.this, " you clicked  " + getIntent().getStringExtra("book").toString(), Toast.LENGTH_LONG).show();
                            Cursor res = mydb.getalldata();

                            if (res.getCount() == 0) {
                                Toast.makeText(Au3.this, " no data in data base ", Toast.LENGTH_LONG).show();
                                return;
                            }


                            while (res.moveToNext()) {
                                idd = res.getString(0);
                                se1 = res.getString(1);
                                auth = res.getString(2);
                                // sb.append(" AVAILABLE = "+res.getString(3)+"\n\n");
                                if (se1.compareTo(getIntent().getStringExtra("book")) == 0) {
                                    a = 1;
                                    Toast.makeText(Au3.this, " your book  " + getIntent().getStringExtra("book") + " and idd " + idd, Toast.LENGTH_LONG).show();
                                    break;
                                }
                            }
                            if (a == 1) {

                              //  Toast.makeText(Au3.this, " your book is avail in the main data so put to insert ", Toast.LENGTH_LONG).show();

                                boolean chup = mydb.update(idd, getIntent().getStringExtra("book"), auth, " NO ");
                                if (chup == true) {
                                  //  Toast.makeText(Au3.this, " Data is updated successfully ", Toast.LENGTH_LONG).show();
                                    Toast.makeText(Au3.this, " you can take the book", Toast.LENGTH_LONG).show();
                                } else
                                    Toast.makeText(Au3.this, " can't update the data ", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(Au3.this, " the book is can't match ", Toast.LENGTH_LONG).show();


                        } else
                            Toast.makeText(Au3.this, " problem inside sqls", Toast.LENGTH_LONG).show();

                    } else
                        Toast.makeText(Au3.this, " invalid name or id ", Toast.LENGTH_LONG).show();
               name.setText("");
               rno.setText("");
                }
                else{
                    Toast.makeText(Au3.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }


        });



    }
}
