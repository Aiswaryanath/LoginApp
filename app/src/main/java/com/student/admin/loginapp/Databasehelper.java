package com.student.admin.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/4/2019.
 */
public class Databasehelper extends SQLiteOpenHelper {
    public static final String Dbname = "MyDb.db";
    public static final String TableName = "Login";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "emailid";
    public static final String col4= "mobileno";
    public static final String col5 = "username";
    public static final String col6 = "pasword";

    public Databasehelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text,"+col4+" text,"+col5+" text,"+col6+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name, String emailid,String mobileno,String username,String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, emailid);
        contentValues.put(col4, mobileno);
        contentValues.put(col5, username);
        contentValues.put(col6, password);

        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor SearchData(String username) {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM " + TableName + " WHERE " + col5+ "='" + username+"'", null);
        return cursor;

    }
    public boolean UpdateData(String id,String emailid,String id,String emailid,String id,String emailid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col3,emailid);
        long status=db.update(TableName,contentValues,col1+"="+id,null);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}

