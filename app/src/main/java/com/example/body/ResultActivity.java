package com.example.body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.body.Food;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        if (intent != null) {
            //データセット
            Double height = Double.parseDouble(intent.getStringExtra("height")); // キー名を指定してデータを受信
            Double weight = Double.parseDouble(intent.getStringExtra("weight")); // キー名を指定してデータを受信
            Integer age = Integer.parseInt(intent.getStringExtra("age")); // キー名を指定してデータを受信
            Double goalweight = Double.parseDouble(intent.getStringExtra("goalweight")); // キー名を指定してデータを受信

            //------カロリー計算------

            //基礎代謝計算 (性別で計算変更)
            Double bmr = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
            Log.w("BMR", String.valueOf(bmr));

            //総エネルギー量 (1.5身体活動レベル変更)
            Double energy = bmr * 1.5;
            Log.w("総エネルギー", String.valueOf(energy));

            //減量体重,１か月の減量体重
            Double genweight = weight - goalweight;
            Double onegenweight = weight * 0.05;
            Log.w("総減量体重", String.valueOf(genweight));
            Log.w("月減量体重", String.valueOf(onegenweight));


            //期間(月　日　週)
            Double soukikan = genweight / onegenweight;
            Double niti = soukikan * 30;
            Double syu = niti / 7;
            Log.w("月", String.valueOf(soukikan));
            Log.w("週", String.valueOf(syu));
            Log.w("日", String.valueOf(niti));

            //減量カロリー (総、月、週、日)
            Double sougenkrl = genweight * 7200;
            Double tukigenkrl = sougenkrl / soukikan;
            Double syugenkrl = sougenkrl / syu;
            Double nitigenkrl = sougenkrl / niti;
            Log.w("総減量カロリー", String.valueOf(sougenkrl));
            Log.w("月減量カロリー", String.valueOf(tukigenkrl));
            Log.w("週減量カロリー", String.valueOf(syugenkrl));
            Log.w("日減量カロリー", String.valueOf(nitigenkrl));

            //運動の頻度（週何回）　運動のみ変更
            int undou_hindo = 5;
            int syokuji_hindo = 7;

            //食事と運動の割りあい　システムでの変更
            double undou = 3 * 0.1;
            double syokuji = 7 * 0.1;

            //運動での減量カロリー（週,日) 間違ってるかも
            Double syuungenkrl = syugenkrl * undou;
            Double nitiungenkrl = syuungenkrl / undou_hindo;
            Log.w("週間運動減量カロリー", String.valueOf(syuungenkrl));
            Log.w("日運動減量カロリー", String.valueOf(nitiungenkrl));

            //食事での減量カロリー(週,月)
            Double syusyokujigenkrl = syugenkrl * syokuji;
            Double nitisyokujigenkrl = syusyokujigenkrl / syokuji_hindo;
            Log.w("週間食事減量カロリー", String.valueOf(syusyokujigenkrl));
            Log.w("日食事減量カロリー", String.valueOf(nitisyokujigenkrl));

            //運動日の消費・摂取カロリー
            Double unsyouhi = nitiungenkrl + energy;
            Double unsesyu = energy - nitisyokujigenkrl;
            Log.w("運動日消費カロリー", String.valueOf(unsyouhi));
            Log.w("運動日摂取カロリー", String.valueOf(unsesyu));

            //休憩日の消費・摂取カロリー
            Double kyukeisyouhi = energy;
            Double kyukeisesyu = energy - nitisyokujigenkrl;
            Log.w("休憩日消費カロリー", String.valueOf(kyukeisyouhi));
            Log.w("休憩日摂取カロリー", String.valueOf(kyukeisesyu));

            //------カロリー計算------

            //画面表示
            TextView  txbmr = findViewById(R.id.bmr);
            txbmr.setText(String.valueOf(bmr));

            TextView txonegenweight = findViewById(R.id.onegenweight);
            txonegenweight.setText(String.valueOf(onegenweight));

            TextView txunsyouhi = findViewById(R.id.unsyouhi);
            txunsyouhi.setText(String.valueOf(unsyouhi));

            TextView txunsesyu = findViewById(R.id.unsesyu);
            txunsesyu.setText(String.valueOf(unsesyu));

            TextView txkyukeisyouhi = findViewById(R.id.kyukeisyouhi);
            txkyukeisyouhi.setText(String.valueOf(kyukeisyouhi));

            TextView txkyukeisesyu = findViewById(R.id.kyukeisesyu);
            txkyukeisesyu.setText(String.valueOf(kyukeisesyu));

            //ボタンクリック

            Button button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // クリック時のアクション
                    Intent intent = new Intent(ResultActivity.this, SelectActivity.class);
                    //データを取得してセットする
                    intent.putExtra("kyukeisesyu",kyukeisesyu);
                    startActivity(intent);
                }
            });



        }
    }
}