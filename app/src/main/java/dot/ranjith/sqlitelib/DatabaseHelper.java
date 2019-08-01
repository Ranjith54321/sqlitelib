package dot.ranjith.sqlitelib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.EditText;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "bookdetails";
    public static String TABLE_NAME = "books";
    public static String COL_1 = "ID";
    public static String COL_2 = "BOOKNAME";
    public static String COL_3 = "AUTHORNAME";
    public static String COL_4 = "AVAILABILITY";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(" create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,BOOKNAME TEXT,AUTHORNAME TEXT,AVAILABILITY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertdata(String book,String author,String avail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contval = new ContentValues();
        contval.put(COL_2,book);
        contval.put(COL_3,author);
        contval.put(COL_4,avail);

        long ls = db.insert(TABLE_NAME,null,contval);

        if(ls == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery(" select * from " + TABLE_NAME,null);
        return res;
    }

    public Cursor getalldata2(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery(" select * from " + COL_2,null);
        return res;
    }

    public boolean update(String id, String book, String author, String avail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contval = new ContentValues();
        contval.put(COL_1,id);
        contval.put(COL_2,book);
        contval.put(COL_3,author);
        contval.put(COL_4,avail);
        db.update(TABLE_NAME,contval,"ID=?",new String[] { id });
        return true;
    }

    public int rowcount(){
        int row = 0;
        String s1 = "SELECT COUNT (*) FROM "+ TABLE_NAME;

        Cursor cu =  getReadableDatabase().rawQuery(s1,null);

        if (cu.getCount() > 0){
            cu.moveToFirst();
            row = cu.getInt(0);
        }

        cu.close();

        return row;
    }


    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " ID=?",new String[] { id });
    }
}
