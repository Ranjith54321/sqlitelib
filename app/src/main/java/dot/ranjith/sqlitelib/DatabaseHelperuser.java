package dot.ranjith.sqlitelib;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperuser extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME="student_details";
    public static final String COL1 = "ID";
    public static final String COL2 = "RNO";
    public static final String COL3 = "NAME";
    public static final String COL4 = "BOOK";


    public DatabaseHelperuser(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " RNO TEXT ,NAME TEXT , BOOK TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF  EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String rno, String name,String book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, rno);
        contentValues.put(COL3, name);
        contentValues.put(COL4, book);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //query for 1 week repeats
    public Cursor getalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean updateData(String id, String rno,String name,String book){    // HERE METHOD NAME YOU CAN GIVE ANY NAME
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contval = new ContentValues();
        contval.put(COL1,id);
        contval.put(COL2,rno);
        contval.put(COL3,name);
        contval.put(COL4,book);
        db.update(TABLE_NAME,contval,"ID=?",new String[] { id });    // HERE INBUILD NAME IS IMPORTANT     to know the USAGE OF THR PRESS ****Ctrl+MOUSE CLICK******
        return true;

    }

    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME," ID=?",new String[] { id });
    }
}
