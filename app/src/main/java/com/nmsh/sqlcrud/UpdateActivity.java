package com.nmsh.sqlcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText etUpdateName,etupdateRno;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etUpdateName=findViewById(R.id.etUpdateName);
        etupdateRno=findViewById(R.id.etUpdateRno);
        btnUpdate=findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = etupdateRno.getText().toString();
                if(r.length()==0){
                    etupdateRno.setError("rno is empty");
                    etupdateRno.requestFocus();
                    return;
                }
                String name = etUpdateName.getText().toString();

                if(name.length()<=2){
                    etUpdateName.setError("rno is empty");
                    etUpdateName.requestFocus();
                    return;
                }

                MainActivity.db.updateStudent(Integer.parseInt(r),name);
                
            }
        });
    }
}
