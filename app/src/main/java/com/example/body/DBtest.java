package com.example.body;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class DBtest extends AppCompatActivity {
    private CalendarView calendarView;
    private long selectedDateMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        calendarView = findViewById(R.id.calendarView);

        // ボタン
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ボタンがクリックされたときの処理
                toastMake(getFormattedDate(selectedDateMillis), 0, 500);
            }
        });

        // CalendarViewの日付変更リスナーを設定
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // 日付が選択されたときの処理
                // 選択された日付のミリ秒単位の値を計算
                selectedDateMillis = getDateInMillis(year, month, dayOfMonth);
            }
        });
    }

    // 年月日からミリ秒単位の日付を取得
    private long getDateInMillis(int year, int month, int dayOfMonth) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        return calendar.getTimeInMillis();
    }

    // ミリ秒単位の日付をフォーマットして文字列に変換
    private String getFormattedDate(long dateMillis) {
        String selectedDate = "選択された日付: " + android.text.format.DateFormat.format("yyyy年MM月dd日", dateMillis);
        return selectedDate;
    }

    // トースト表示する
    private void toastMake(String message, int x, int y) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }
}
