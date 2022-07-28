package kr.hs.emirims2121.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editname, edithight, editweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = findViewById(R.id.edt_name);
        edithight = findViewById(R.id.edt_hight);
        editweight = findViewById(R.id.edt_weight);
        Button btnresult = findViewById(R.id.btn_result);
        btnresult.setOnClickListener(btnresultListener);
    }

    View.OnClickListener btnresultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("name", editname.getText().toString());
            intent.putExtra("height", edithight.getText().toString());
            intent.putExtra("weight", editweight.getText().toString());
            startActivity(intent);
        }
    };
}