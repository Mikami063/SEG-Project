package com.uottawa.segproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.Query;





import java.util.ArrayList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    DatabaseReference accountsDbRef;
    EditText etName,etPassword;
    ArrayList<String> list= new ArrayList<>();//temperate list that store accounts information locally

    ArrayList<Account> accountList = new ArrayList<>();



    ArrayList<Account> li= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGetAccountsClick(View view){//output accounts data as text
        TextView textView=(TextView)findViewById(R.id.textView);
        getAccountData("toha");
        String tempOut="";
        for(String TA:list){
            tempOut=tempOut+TA+"; ";
        }
        textView.setText(tempOut);

    }

//    public void getAccountData(String name){//helper method for btnGetAccountsClick
//        accountsDbRef=FirebaseDatabase.getInstance().getReference().child("Accounts");
//
//        Query myQue=accountsDbRef.orderByChild("name").equalTo(name);
//        myQue.addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Object ob= snapshot.getValue();
//                System.out.println("here: "+snapshot.getKey()+" "+snapshot.getValue());
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//
//        });


//        accountsDbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list.clear();//refresh the list every update
//                li.clear();
//                for(DataSnapshot snapshot1: snapshot.getChildren()){//get each object under accounts collection from database
//                    list.add(snapshot1.getValue().toString());//add them to the local list of accounts
//                    Account obj=snapshot1.getValue(Account.class);
//                    li.add(snapshot1.getValue(Account.class));
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

    public void getAccountData(String accountName){
        Query mQuery = accountsDbRef.orderByChild("AccountName").equalTo(accountName);
        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Account ob = snapshot.getValue(Account.class);
                accountList.add(ob);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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


    public void btnSignUpCookClick(View view) {
        Intent intent = new Intent(this, SignUpActivity2.class);
        startActivity(intent);

    }

    public void onBtnLogin(View view){
        EditText login = findViewById(R.id.TextName);
        EditText pass = findViewById(R.id.TextPassword);
        String loginName = login.getText().toString();
        String passName = login.getText().toString();
        //getAccountData(loginName);

        Intent intent = new Intent(this, WelcomeMs.class);
        startActivity(intent);
    }



}