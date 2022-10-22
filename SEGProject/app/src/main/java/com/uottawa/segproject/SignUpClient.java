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
public class SignUpClient extends AppCompatActivity {
    DatabaseReference accountsDbRef;
    EditText etFirstname,etPassword,etLastname,etEmail,etZIP,etCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_client);
    }



    public void onDoneClick(View view){

        etFirstname=(EditText) findViewById(R.id.firstnameTxt);
        etPassword=(EditText) findViewById(R.id.passwardTxt);
        etCard=(EditText) findViewById(R.id.cardTxt);
        etLastname=(EditText) findViewById(R.id.lastnameTxt);
        etZIP=(EditText) findViewById(R.id.ZIPTxt);
        etEmail=(EditText) findViewById(R.id.emailTxt);

        // The try-catch will check if the user inputted all-numeric input for
        // the client's credit card. In addition, the if-else statement will
        // ensure that all text-fields are non-empty.
        try {
            Long.parseLong(etCard.getText().toString());
            if (!etFirstname.getText().toString().equals("") &&
                    !etLastname.getText().toString().equals("") &&
                    !etPassword.getText().toString().equals("") &&
                    !etEmail.getText().toString().equals("") &&
                    !etCard.getText().toString().equals("") &&
                    !etZIP.getText().toString().equals("")) {

                accountsDbRef = FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
                insertAccountData();

                backToMain();
            } else {
                Toast.makeText(SignUpClient.this, "Please fill out all fields!", Toast.LENGTH_SHORT).show();
            }
        } catch(NumberFormatException e){
            Toast.makeText(SignUpClient.this, "Credit card field cannot contain alphabets.", Toast.LENGTH_SHORT).show();
        }



    }

    private void insertAccountData(){
        Map<String, Object> update = new HashMap<>();
        String firstname=etFirstname.getText().toString();
        String lastname=etLastname.getText().toString();
        String password=etPassword.getText().toString();
        String email=etEmail.getText().toString();
        String address=etZIP.getText().toString();
        long card=Long.parseLong(etCard.getText().toString());




            ClientAccount CA = new ClientAccount(firstname, lastname, email, password, address, card);
            accountsDbRef.push().setValue(CA);// add this dummy class to the database
        Toast.makeText(SignUpClient.this, "data inserted", Toast.LENGTH_SHORT).show();//show a success message if success

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

