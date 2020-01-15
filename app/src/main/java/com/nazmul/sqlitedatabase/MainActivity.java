package com.nazmul.sqlitedatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText txtName,txtID,txtCell,txtEmail,txtDept;
Button btnADD,btnView,btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = findViewById(R.id.txt_id);
        txtName =findViewById(R.id.txt_name);
        txtCell = findViewById(R.id.txt_cell);
        txtEmail = findViewById(R.id.txt_email);
        txtDept = findViewById(R.id.txt_dept);


        btnADD = findViewById(R.id.btn_add);
        btnView = findViewById(R.id.btn_view);
        btnUpdate = findViewById(R.id.btn_view);
        btnDelete = findViewById(R.id.btn_delete);


    }
}
