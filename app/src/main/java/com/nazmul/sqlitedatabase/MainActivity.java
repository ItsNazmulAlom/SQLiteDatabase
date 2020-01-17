package com.nazmul.sqlitedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText txtName,txtID,txtCell,txtEmail,txtDept;
Button btnADD,btnView,btnUpdate,btnDelete;

    SqliteDB mydb;

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
//        btnView = findViewById(R.id.btn_view);
//        btnUpdate = findViewById(R.id.btn_view);
//        btnDelete = findViewById(R.id.btn_delete);



//        mydb=new SqliteDB(MainActivity.this);
        mydb=new SqliteDB(MainActivity.this);




        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=txtID.getText().toString().trim();
                String name=txtName.getText().toString().trim();
                String cell=txtCell.getText().toString().trim();
                String email=txtEmail.getText().toString().trim();
                String dept=txtDept.getText().toString().trim();

                if (id.isEmpty())
                {
                    txtID.setError("Please input ID no!");
                    txtID.requestFocus();

                }

                else  if (name.isEmpty())
                {
                    txtName.setError("Please input Name!");
                    txtName.requestFocus();
                }

                else if (cell.isEmpty())
                {
                    txtCell.setError("Please input mobile number!");
                    txtCell.requestFocus();
                }

                else if (email.isEmpty())
                {
                    txtEmail.setError("Input valid email!");
                    txtEmail.requestFocus();
                }
                else if (dept.isEmpty())
                {
                    txtDept.setError("Input department!");
                    txtDept.requestFocus();
                }


                else
                {
                    boolean check=mydb.insertData(id,name,cell,email,dept);

                    if (check==true)
                    {
                        Toast.makeText(MainActivity.this, "Data insert successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Data not insert .Try again!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    public void viewData(View v){

        Cursor result=mydb.display();
        if(result.getCount()==0)
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            StringBuffer buffer= new StringBuffer();
            result.moveToFirst();

            do {
                buffer.append("ID: "+result.getString(0)+"\n");
                buffer.append("Name: "+result.getString(1)+"\n");
                buffer.append("Cell: "+result.getString(2)+"\n");
                buffer.append("Email: "+result.getString(3)+"\n");
                buffer.append("Dept: "+result.getString(4)+"\n");

            }while (result.moveToNext());
            showData("Information",buffer.toString());
        }

    }
    public void showData(String title,String data)
    {

        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setCancelable(true);
        dialog.setMessage(data);
        dialog.show();
    }

    //for update info
    public void updateData(View v)
    {
        String id=txtID.getText().toString().trim();
        String name=txtName.getText().toString().trim();
        String cell=txtCell.getText().toString().trim();
        String email=txtEmail.getText().toString().trim();
        String dept=txtDept.getText().toString().trim();


        if (id.isEmpty())
        {
            txtID.setError("Please input ID no!");
            txtID.requestFocus();

        }

        else  if (name.isEmpty())
        {
            txtName.setError("Please input Name!");
            txtName.requestFocus();
        }

        else if (cell.isEmpty())
        {
            txtCell.setError("Please input mobile number!");
            txtCell.requestFocus();
        }

        else if (email.isEmpty())
        {
            txtEmail.setError("Input valid email!");
            txtEmail.requestFocus();
        }
        else if (dept.isEmpty())
        {
            txtDept.setError("Input department!");
            txtDept.requestFocus();
        }



        else
        {
            boolean check=mydb.updateData(id,name,cell,email,dept);


            if (check==true)
            {
                Toast.makeText(MainActivity.this, "Data update successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Data not update.Try again!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    //for deleting
    public void deleteData(View v)
    {
        String id=txtID.getText().toString();

        int check=mydb.deleteData(id);
        if(check==1)
        {
            Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data not deleted", Toast.LENGTH_SHORT).show();
        }
    }

}

