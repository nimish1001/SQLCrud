package com.nmsh.sqlcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText etDeleteRno;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etDeleteRno=findViewById(R.id.etDeleteRno);
        btnDelete=findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=etDeleteRno.getText().toString();
                if(r.length()==0){
                    etDeleteRno.setError("Enter valid Rno");
                    etDeleteRno.requestFocus();
                }
                else {
                    MainActivity.db.DeleteStudent(Integer.parseInt(r));
                    etDeleteRno.setText("");
                    etDeleteRno.requestFocus();
                }
            }
        });
    }
}
