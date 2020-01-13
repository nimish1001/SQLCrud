package com.nmsh.sqlcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        tvData=findViewById(R.id.tvData);
        String data=MainActivity.db.GetStudent();
        if (data.length()==0){
            tvData.setText("No records found");
        }
        else{
            tvData.setText(data);
        }
    }
}
