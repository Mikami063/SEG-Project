package com.uottawa.segproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

//create client account
public class SignUpActivity extends AppCompatActivity {
    DatabaseReference accountsDbRef;
    EditText etFirstname,etPassword,etLastname,etEmail,etZIP,etCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }



    public void onDoneClick(View view){
        etFirstname=(EditText) findViewById(R.id.firstnameTxt);
        etPassword=(EditText) findViewById(R.id.passwardTxt);
        etCard=(EditText) findViewById(R.id.cardTxt);
        etLastname=(EditText) findViewById(R.id.lastnameTxt);
        etZIP=(EditText) findViewById(R.id.ZIPTxt);
        etEmail=(EditText) findViewById(R.id.emailTxt);

        accountsDbRef= FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
        insertAccountData();

        backToMain();
    }

    private void insertAccountData(){
        Map<String, Object> update = new HashMap<>();
        String firstname=etFirstname.getText().toString();
        String lastname=etLastname.getText().toString();
        String password=etPassword.getText().toString();
        String email=etEmail.getText().toString();
        String address=etZIP.getText().toString();
        long card=Long.parseLong(etCard.getText().toString());

        ClientAccount CA = new ClientAccount(firstname,lastname,email,password,address,card);
        update.put(firstname+"/userType", "client");
        accountsDbRef.push().setValue(CA);// add this dummy class to the database

        accountsDbRef.updateChildren(update);
        Toast.makeText(SignUpActivity.this,"data inserted",Toast.LENGTH_SHORT).show();//show a success message if success
    }

    public void backToMain(){
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void onBackClick(View view){
        backToMain();
    }
}

