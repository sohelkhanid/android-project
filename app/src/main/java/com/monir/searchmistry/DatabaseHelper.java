package com.monir.searchmistry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Sohel on 3/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="mistry.db";
    private static final String TABLE_NAME="mistry";
    private static final String ID="_id";
    private static final String NAME="name";
    private static final String ADDRESS="address";
    private static final String MAIL="Main";
    private static final String USER_NAME="user_name";
    private static final String PASSWORD="Password";
    private static final int VERSION_NUMBER=2;
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+NAME+" TEXT,"+ADDRESS+" TEXT,"+MAIL+" TEXT,"+USER_NAME+" TEXT,"+PASSWORD+" TEXT);";




    Context context;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"database created",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,"not created",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long inserData(UserDetails userDetails){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(ADDRESS,userDetails.getAddress());
        contentValues.put(MAIL,userDetails.getMail());
        contentValues.put(USER_NAME,userDetails.getUserName());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowId=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return rowId;


    }
    public Boolean findPassword(String uname,String pass){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result=true;
        if (cursor.getCount()==0){
            Toast.makeText(context,"no data found ",Toast.LENGTH_LONG).show();
        }else {
            while (cursor.moveToNext()){
                String userName=cursor.getString(4);
                String password=cursor.getString(5);
                if (userName.equals(uname)&& password.equals(pass))
                {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }




}
