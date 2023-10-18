package com.example.body;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insertData(String name,Double food_krl) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.FOOD_NAME, name);
        values.put(DatabaseHelper.FOOD_KRL, food_krl);
        try {
            return database.insertOrThrow(DatabaseHelper.TABLE_NAME, null, values);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // エラーが発生した場合は-1を返す
        }
    }

    public Cursor fetchData() {
        String[] columns = new String[] { DatabaseHelper.COLUMN_ID, DatabaseHelper.FOOD_NAME, DatabaseHelper.FOOD_KRL };
        return database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // 他のデータベース操作を定義
}
