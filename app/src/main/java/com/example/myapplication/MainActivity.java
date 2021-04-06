package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // sqlite database which you can use locally on the android..
    // 1) set up a database, update and delete?
    // parameters in this class which make them acceccable.
    Button btn_add, btn_viewAll;
    EditText txt_name, txt_age;
    Switch sw_activeCustomer;
    ListView customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        txt_age = findViewById(R.id.age);
        txt_name = findViewById(R.id.customerName);
        sw_activeCustomer = findViewById(R.id.activeCustomer);
        customerList = findViewById(R.id.customerList);

        // button listener for add and view

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                   CustomerModel customerModel = new CustomerModel(-1, txt_name.getText().toString(),Integer.parseInt(txt_age.getText().toString()),sw_activeCustomer.isChecked());
                Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                    if  (dataBaseHelper.addOne(customerModel))
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();

                   ; //

                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this, "Error Creating customer", Toast.LENGTH_SHORT).show();

                }
                // Create our database here....



                    // btn_add
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn_add
                Toast.makeText(MainActivity.this, "View button", Toast.LENGTH_SHORT).show();

            }
        });




    }
}
