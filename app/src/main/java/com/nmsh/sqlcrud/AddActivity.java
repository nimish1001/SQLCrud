package com.nmsh.sqlcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etName,etRno;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName=findViewById(R.id.etName);
        etRno=findViewById(R.id.etRno);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String rno=etRno.getText().toString();
                MainActivity.db.AddStudent(Integer.parseInt(rno),name);

                etName.setText("");
                etRno.setText("");
                etRno.requestFocus();
            }
        });
    }
}
