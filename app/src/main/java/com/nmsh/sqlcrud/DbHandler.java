package com.nmsh.sqlcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DbHandler extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;
    DbHandler(Context context){
        super(context,"student_db",null,1);
        context=this.context;
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table student(rno int primary key,name varchar(30)) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddStudent(int rno,String name){

        ContentValues cv =  new ContentValues();
        cv.put("rno ",rno);
        cv.put("name",name);
        long id =db.insert("student",null,cv);
        if(id>0){
            Toast.makeText(context,"Record Added",Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(context,"Add something",Toast.LENGTH_SHORT);
        }
    }

    public String GetStudent(){
        StringBuffer sb = new StringBuffer();
        Cursor c = db.query("student",null,null,null,null,null,null);
        c.moveToFirst();
        if(c.getCount()>0){
            do{
                String rno =c.getString(0);
                String name = c.getString(1);
                sb.append("rno " + rno + "name " + name + "\n");
            }while (c.moveToNext());

        }
        return sb.toString();
    }

    public void UpdateStudent(int rno,String name){

        ContentValues cv =  new ContentValues();
        cv.put("rno ",rno);
        cv.put("name",name);
        long id =db.update("student",cv,"rno="+rno,null);
        if(id>0){
            Toast.makeText(context,"Record Added",Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(context,"Add something",Toast.LENGTH_SHORT);
        }
    }

    public void DeleteStudent(int rno){
        long nod =db.delete("student","rno="+rno,null);
        if (nod>=0){
            Toast.makeText(context,nod+"Record Deleted",Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(context,nod+"Add something to delete",Toast.LENGTH_SHORT);
        }
    }
}

