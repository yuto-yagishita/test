package com.example.body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        //小数点切り捨て
        int decimalPlaces = 2; // 切り捨てたい小数点以下の桁数
        double scale = Math.pow(10, decimalPlaces);

        //ボタン
        Button button = findViewById(R.id.button);

        Intent intent = getIntent();

            Double kyukeisesyu = intent.getDoubleExtra("kyukeisesyu", 0.0);
            kyukeisesyu = Math.floor(kyukeisesyu * scale) / scale;



            //------食事メニュー------
            //Foodインスタンス作成
            Food food = new Food();

            //ArrayListに食事メニューを入れる
            ArrayList<Food> FoodList = new ArrayList<>();
            food.setFoodName("オートミール");
            food.setFood_krl(150.0);
            FoodList.add(food);

            food = new Food();
            food.setFoodName("ヨーグルト");
            food.setFood_krl(100.0);
            FoodList.add(food);
            //変更した

            food = new Food();
            food.setFoodName("グリルチキンサラダ");
            food.setFood_krl(250.0);
            FoodList.add(food);

            food = new Food();
            food.setFoodName("蒸し野菜");
            food.setFood_krl(50.0);
            FoodList.add(food);

            food = new Food();
            food.setFoodName("きゅうり");
            food.setFood_krl(10000.0);
            FoodList.add(food);

            food = new Food();
            food.setFoodName("全粒パン");
            food.setFood_krl(10000.0);
            FoodList.add(food);

            //カロリー表示
            TextView txseseyukrl = findViewById(R.id.sesyukrl);
            txseseyukrl.setText(Double.toString(kyukeisesyu));

            //チェックリストを表示
            CheckBox chf1 = findViewById(R.id.f1);
            chf1.setText(FoodList.get(0).getFoodName());
            chf1.setTag(0);

            CheckBox chf2 = findViewById(R.id.f2);
            chf2.setText(FoodList.get(1).getFoodName());
            chf2.setTag(1);

            CheckBox chf3 = findViewById(R.id.f3);
            chf3.setText(FoodList.get(2).getFoodName());
            chf3.setTag(2);

            CheckBox chf4 = findViewById(R.id.f4);
            chf4.setText(FoodList.get(3).getFoodName());
            chf4.setTag(3);

            CheckBox chf5 = findViewById(R.id.f5);
            chf5.setText(FoodList.get(4).getFoodName());
            chf5.setTag(4);

        Double finalKyukeisesyu = kyukeisesyu;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList <Integer> tag = new ArrayList<>();
                //trueのチェックボックスのリスト
                if(chf1.isChecked()){
                    tag.add((Integer) chf1.getTag());
                }
                if(chf2.isChecked()){
                    tag.add((Integer) chf2.getTag());
                }
                if(chf3.isChecked()){
                    tag.add((Integer) chf3.getTag());
                }
                if(chf4.isChecked()){
                    tag.add((Integer) chf4.getTag());
                }
                if(chf5.isChecked()){
                    tag.add((Integer) chf5.getTag());
                }

                //  計算
                Double jyoukenkrl = 0.0;
                for (int i = 0;i < tag.size(); i++){
                    System.out.println(tag.get(i));
                    jyoukenkrl = jyoukenkrl+FoodList.get(tag.get((i))).getFood_krl();
                    System.out.println(jyoukenkrl);
                }
                    System.out.println(finalKyukeisesyu);

                if (finalKyukeisesyu >= jyoukenkrl){
                    // クリック時のアクション
                    Intent intent = new Intent(SelectActivity.this, SelectResultActivity.class);
                    startActivity(intent);
                }else {
                    startActivity(intent);
                }
            }
        });
    }
}