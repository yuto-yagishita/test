package com.example.body;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.CalendarView;
import android.widget.Toast;


public class DBtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();

// データの挿入
//        dbManager.insertData("オートミール",150.0);
//        dbManager.insertData("ヨーグルト", 100.0);

 //データの取得
        Cursor cursor = dbManager.fetchData();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String food_name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.FOOD_NAME));
                    Double food_krl = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.FOOD_KRL));
                    // データを処理
                    System.out.println(food_name);
                    System.out.println(food_krl);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        dbManager.close();

    }

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            // 日付が選択されたときの処理
            String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth; // 月は0から11の範囲なので+1する
            Toast.makeText(getApplicationContext(), "選択された日付: " + selectedDate, Toast.LENGTH_SHORT).show();
        }
    });
}
