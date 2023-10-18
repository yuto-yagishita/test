package com.example.body;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時のアクション
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                //データを取得してセットする
                EditText exheight = findViewById(R.id.height);
                String height = exheight.getText().toString();
                intent.putExtra("height",height); // データを"key_name"というキーで設定

                EditText exweight = findViewById(R.id.weight);
                String weight = exweight.getText().toString();
                intent.putExtra("weight",weight); // データを"key_name"というキーで設定


                EditText exage = findViewById(R.id.age);
                String age = exage.getText().toString();
                intent.putExtra("age",age); // データを"key_name"というキーで設定

                EditText exgoalweight = findViewById(R.id.goalweight);
                String goalweight = exgoalweight.getText().toString();
                intent.putExtra("goalweight",goalweight); // データを"key_name"というキーで設定

                startActivity(intent);
            }
        });

    }


}