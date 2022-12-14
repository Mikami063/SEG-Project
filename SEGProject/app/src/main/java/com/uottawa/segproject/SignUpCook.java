package com.uottawa.segproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignUpCook extends AppCompatActivity {
    DatabaseReference accountsDbRef;
    EditText etFirstname,etPassword,etLastname,etEmail,etZIP,etDescription;
    private static final int RESULT_LOAD_IMAGE = 1000;
    Bitmap bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_cook);


    }

    public void upLoadImage(View view){

        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            bp = BitmapFactory.decodeFile(picturePath);
    }}

    public void onDoneClick(View view) throws IOException {
        etFirstname=(EditText) findViewById(R.id.firstnameTxt2);
        etPassword=(EditText) findViewById(R.id.passwardTxt2);
        etLastname=(EditText) findViewById(R.id.lastnameTxt2);
        etZIP=(EditText) findViewById(R.id.ZIPTxt2);
        etEmail=(EditText) findViewById(R.id.emailTxt2);
        etDescription=(EditText) findViewById(R.id.selfDescriptionTxt);

        // The if-else statement will ensure that all text-fields are non-empty.
            if (!etFirstname.getText().toString().equals("") &&
                    !etLastname.getText().toString().equals("") &&
                    !etPassword.getText().toString().equals("") &&
                    !etEmail.getText().toString().equals("") &&
                    !etDescription.getText().toString().equals("") &&
                    !etZIP.getText().toString().equals("")) {

                accountsDbRef = FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
                insertAccountData();

                backToMain();
            } else {
                Toast.makeText(SignUpCook.this, "Please fill out all fields!", Toast.LENGTH_SHORT).show();
            }

    }



    private void insertAccountData() throws IOException {
        Map<String, Object> update = new HashMap<>();
        String firstname=etFirstname.getText().toString();
        String lastname=etLastname.getText().toString();
        String password=etPassword.getText().toString();
        String email=etEmail.getText().toString();
        String address=etZIP.getText().toString();
        String description=etDescription.getText().toString();


        CookAccount CA = new CookAccount(firstname,lastname,email,password,address,description, bp);

        accountsDbRef.push().setValue(CA);// add this dummy class to the database

        Toast.makeText(SignUpCook.this,"data inserted",Toast.LENGTH_SHORT).show();//show a success message if success
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