package com.uottawa.segproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference accountsDbRef;
    EditText etName,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //summit the data to database
    public void btnSummitClick(View view){
        etName=(EditText) findViewById(R.id.TextName);
        etPassword=(EditText) findViewById(R.id.TextPassword);
        accountsDbRef= FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
        insertAccountData();
    }
    //helper method for btnSummitClick
    private void insertAccountData(){
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();
        TempAccount TA=new TempAccount(name,password);//a dummy class for testing

        accountsDbRef.push().setValue(TA);// add this dummy class to the database
        Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_SHORT).show();//show a success message if success
    }

}