package com.uottawa.segproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference accountsDbRef;
    EditText etName,etPassword;
    ArrayList<String> list= new ArrayList<>();//temperate list that store accounts information locally

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGetAccountsClick(View view){//output accounts data as text
        TextView textView=(TextView)findViewById(R.id.textView);
        getAccountData();
        String tempOut="";
        for(String TA:list){
            tempOut=tempOut+TA+"; ";
        }
        textView.setText(tempOut);

    }

    public void getAccountData(){//helper method for btnGetAccountsClick
        accountsDbRef=FirebaseDatabase.getInstance().getReference().child("Accounts");
        accountsDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();//refresh the list every update
                for(DataSnapshot snapshot1: snapshot.getChildren()){//get each object under accounts collection from database
                    list.add(snapshot1.getValue().toString());//add them to the local list of accounts
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void btnSignUpClientClick(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void btnSignUpCookClick(View view){
        Intent intent = new Intent(this, SignUpActivity2.class);
        startActivity(intent);
    }



}