package kr.hs.emirims2121.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView textComment;
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imgv = findViewById(R.id.imgV);
        textComment = findViewById(R.id.text_comment);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double height = Double.parseDouble(intent.getStringExtra("height"));
        double weight = Double.parseDouble(intent.getStringExtra("weight"));
        double bmi = weight / Math.pow(height/100, 2);

        Button btnhome = findViewById(R.id.btn_home);
        btnhome.setOnClickListener(btnhomeListener);
        String bmiResult = "";
        if(bmi < 18.5){
            bmiResult = "저";
            imgv.setImageResource(R.drawable.underweight);
        } else if (bmi < 24.9){
            bmiResult = "정상";
            imgv.setImageResource(R.drawable.normal);
        } else if (bmi < 29.9) {
            bmiResult = "과";
            imgv.setImageResource(R.drawable.over);
        } else if (bmi < 34.5) {
            bmiResult = "비만";
            imgv.setImageResource(R.drawable.obese);
        } else {
            bmiResult = "고도비만";
            imgv.setImageResource(R.drawable.superobese);
        }
        textComment.setText(name + "님의 BMI 지수는 ㎏/㎡" + String.format("%.2f", bmi) + "입니다. 따라서" + bmiResult +"체중입니다.");

    }

    View.OnClickListener btnhomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}