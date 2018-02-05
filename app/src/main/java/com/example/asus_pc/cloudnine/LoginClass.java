package com.example.asus_pc.cloudnine;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class LoginClass extends SQLiteOpenHelper {

    private static final String DatabaseName = "Login_Database.db";
    private static final String TableName = "User_Detail";
    private static final String ID = "ID";
    private static final String Name = "NAME";
    private static final String Age = "AGE";
    private static final String Email = "EMAIL";
    private static final String Passward = "PASSWARD";
    private static final int versionNo = 1;
    private Context context;
    private static final String string = "CREATE TABLE "+TableName+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Name+" VARCHAR(255), "+Email+" VARCHAR(255), "+Passward+" VARCHAR(255), "+Age+" INTEGER ); ";
    private static final String str = "DROP TABLE IF EXISTS "+TableName;

    public LoginClass(Context context) {
        super(context, DatabaseName, null, versionNo);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context, "OnCreate is start ",Toast.LENGTH_LONG).show();
            db.execSQL(string);
        }
        catch(Exception e){
            Toast.makeText(context, "Exception: " + e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{Toast.makeText(context, "OnUpgrade is start ",Toast.LENGTH_LONG).show();
            db.execSQL(str);
            onCreate(db);
        }catch(Exception e){
            Toast.makeText(context, "Exception: " + e,Toast.LENGTH_LONG).show();
        }
    }

    public long insertData(String name, String email, String passward,String age){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Email,email);
        contentValues.put(Passward,passward);
        contentValues.put(Age,age);
        long rowId = sqLiteDatabase.insert(TableName,null,contentValues);
        return rowId;
    }

    public boolean search(String s, String p)
    {
        Log.d("tag","username");
        return findPassward(s,p);
    }

    private boolean findPassward(String semail, String spass) {
        Log.d("tag","username");
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("SELECT * FROM "+TableName,null);
        Boolean result = false;
        Log.d("tag","username");
        while(cursor.moveToNext())
        {
            String username = cursor.getString(1);
            String cemail = cursor.getString(2);
            String passward = cursor.getString(3);

            Log.d("tag",username);
            Log.d("tag",passward);

            if((username.equals(semail) || cemail.equals(semail)) && passward.equals(spass))
            {
                result = true;
                break;
            }
        }
        return result;
    }
}
