package com.uottawa.segproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    DatabaseReference accountsDbRef;
    EditText etName,etPassword;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }



    public void onDoneClick(View view){
        etName=(EditText) findViewById(R.id.nameTxt);
        etPassword=(EditText) findViewById(R.id.passwardTxt);
        accountsDbRef= FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
        insertAccountData();

        backToMain();
    }

    private void insertAccountData(){
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();
        String role = spinner.getSelectedItem().toString();

        TempAccount TA=new TempAccount(name,password, role);//a dummy class for testing

        accountsDbRef.push().setValue(TA);// add this dummy class to the database
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

