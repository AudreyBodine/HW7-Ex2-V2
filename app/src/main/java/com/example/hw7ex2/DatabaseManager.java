package com.example.hw7ex2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "friendsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_FRIENDS = "friends";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String EMAIL = "email";

    public DatabaseManager(Context context)
    {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // build SQL create statement
        String sqlCreate = "create table " + TABLE_FRIENDS + "( " + ID;
        sqlCreate += " text, " + FIRST_NAME;
        sqlCreate += " text, " + LAST_NAME;
        sqlCreate += " text, " + EMAIL + " real )" ;

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_FRIENDS );
        // Re-create tables
        onCreate( db );
    }

    public void insert (Friends friends)
    {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_FRIENDS;
        sqlInsert += " values( null, '" + friends.getName();
        sqlInsert += "', '" + friends.getEmail( ) + "' )";

        db.execSQL( sqlInsert );
        db.close( );
    }
}
