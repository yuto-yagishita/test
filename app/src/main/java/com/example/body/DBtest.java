package com.example.body;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
<<<<<<< HEAD
import android.view.Gravity;
=======
>>>>>>> b605c7b7a08252553607ce386677776c9a2d0f77
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

<<<<<<< HEAD
        //CalenderView
        ((CalendarView) findViewById(R.id.calendarView)).setOnDateChangeListener(listener);
    }

    CalendarView.OnDateChangeListener listener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            // 日付が選択されたときの処理
            String selectedDate = year + "年" + (month + 1) + "月" + dayOfMonth + "日"; // 月は0から11の範囲なので+1する
            toastMake(selectedDate,0,500);
        }
    };

    //トースト表示
    private void toastMake(String message , int x, int y){
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_LONG);
        //位置調整
        toast.setGravity(Gravity.CENTER, x ,y);
        toast.show();
    }
=======
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
>>>>>>> b605c7b7a08252553607ce386677776c9a2d0f77
}
