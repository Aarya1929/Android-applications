package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname="signup.db";
    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase SqliteDatabase) {
        String q="create table users (_id integer primary key autoincrement, name text , username text, password text)";
        SqliteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert_data(String name,String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("username",username);
        c.put("password",password);
        long r=db.insert("users",null,c);
        if(r==-1) return false;
        else
            return true;

    }
    public boolean  delete_data(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0){
            long r=db.delete("users","username=?",new String[]{username});
            if(r==-1) return false;
            else
                return true;
        }
        else
            return false;
    }
    public boolean update_data(String name,String username, String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("password",password);
        Cursor cursor = db.rawQuery("select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0){
            long r=db.update("users",c,"username=?",new String[]{username});
            if(r==-1) return false;
            else
                return true;
        }
        else
            return false;
    }
    public Cursor getinfo()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users",null);
return cursor;
    }
}
