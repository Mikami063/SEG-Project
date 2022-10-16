package com.uottawa.segproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    DatabaseReference accountsDbRef;
    EditText etName=(EditText) findViewById(R.id.TextName);
    EditText etPassword=(EditText) findViewById(R.id.TextPassword);

    public void btnSummitClick(View view){
        accountsDbRef= FirebaseDatabase.getInstance().getReference().child("Accounts");
        insertAccountData();
    }
    private void insertAccountData(){
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();

        accountsDbRef.push().setValue(name,password);
        Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_SHORT).show();
    }

}