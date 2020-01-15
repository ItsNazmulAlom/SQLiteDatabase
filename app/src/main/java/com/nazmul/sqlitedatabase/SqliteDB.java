package com.nazmul.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDB extends SQLiteOpenHelper {


    private static final int DB_VERSION=1;
    private static final String DB_NAME="Sqlitebd.db";
    private static final String TABLE="Student";
    private static final String COLUMN1="id";
    private static final String COLUMN2="name";
    private static final String COLUMN3 ="cell";
    private static final String COLUMN4="email";
    private static final String COLUMN5 = "dept";

//    public SqliteDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    public SqliteDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        String query;
//        query="CREATE TABLE "+TABLE+" (id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
//
//        db.execSQL(query);

        String query = "CREATE TABLE "+TABLE +"(id INTEGER PRIMARY KEY,name TEXT,cell TEXT,email TEXT,dept TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }


    //for insert data
    public boolean insertData(String id,String name,String cell,String email,String dept)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN1,id);
        values.put(COLUMN2,name);
        values.put(COLUMN3,cell);
        values.put(COLUMN4,email);
        values.put(COLUMN5,dept);

        long check=db.insert(TABLE,null,values);
        if (check==-1)  //data insert na hole -1 return kore
        {
            return false;

        }

        else
        {
            return true;
        }

    }

    //for view data
    public Cursor display()
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor result;
        result=db.rawQuery("SELECT * FROM "+TABLE,null);
        return result;

    }

    //update
    public boolean updateData(String id,String name,String email)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN1,id);
        values.put(COLUMN2,name);
        values.put(COLUMN3,email);

        long check=db.update(TABLE,values,"id = ?",new String[] {id});
        if (check==-1)
        {
            return false;

        }

        else
        {
            return true;
        }

    }



    //for delete
    public int deleteData(String id)
    {
        SQLiteDatabase db=getWritableDatabase();

        return db.delete(TABLE,"id=?",new String[] {id});
    }



}








}
