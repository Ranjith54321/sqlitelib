package dot.ranjith.sqlitelib;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

public class Au2 extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<User> userList;
    ArrayList<User> userList2;
    ListView listView;
    User user;
    User book; //here del

    SearchView s1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlu2);

        myDB = new DatabaseHelper(this);

        s1 = (SearchView)findViewById(R.id.s1);

        userList = new ArrayList<>();
        //userList2 = new ArrayList<>();
        Cursor data = myDB.getalldata();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(Au2.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3));
                userList.add(i,user);
                System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
                System.out.println(userList.get(i).getBookName());
                //
                // book = new User(data.getString(1),data.getString(2),data.getString(3)); //here del
                 //userList2.add(i,book);   //here del
                //userList2.get(i).getBookName(); //del here

                //
                i++;
            }
           final ThreeColumn_ListAdapter adapter =  new ThreeColumn_ListAdapter(this,R.layout.list_adapter_view, userList);
            listView = (ListView) findViewById(R.id.lv1);
            listView.setAdapter(adapter);

            //clickable
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //        Toast.makeText(Au2.this,"  move to next activity!!.. ",Toast.LENGTH_LONG).show();
                   // String name = (String)listView.getItemAtPosition(1);
                    if(userList.get(position).getAvailable().compareToIgnoreCase("YES") == 0 || userList.get(position).getAvailable().compareToIgnoreCase("yes") == 0)
                    {
                        Intent i =new Intent(Au2.this,Au3.class);
                        i.putExtra("book",userList.get(position).getBookName());           //parent.getItemAtPosition(position).toString()
                        startActivity(i);
                    }
                    else
                        Toast.makeText(Au2.this," the book is currently not available (:... "+userList.get(position).getAvailable(),Toast.LENGTH_LONG).show();

                }
            });

            // eneble search view


               /*
            s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                ArrayList<String> temlist = new ArrayList<>();

                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });    */

            s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                   // Toast.makeText(Au2.this,"in query "+query+" in user list "+userList.contains(query),Toast.LENGTH_LONG).show();

                    if(userList.contains(query)){  //here im using userlist2 but again app back to previous menu
                       // Toast.makeText(Au2.this,"in query "+query+" in user list "+userList,Toast.LENGTH_LONG).show();
                        adapter.getFilter().filter(query);
                    }else{
                        Toast.makeText(Au2.this, "No Match found",Toast.LENGTH_LONG).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                    return false;
                }
            });


        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);                 //check here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }   */


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(userList.contains(query)){
                     adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(Au2.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

*/


}
