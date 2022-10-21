package com.uottawa.segproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SignUpActivity2 extends AppCompatActivity {
    DatabaseReference accountsDbRef;
    EditText etFirstname,etPassword,etLastname,etEmail,etZIP,etDescription;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);


    }

    public void upLoadImage(View view){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            uri = data.getData();
    }

    public void onDoneClick(View view) throws IOException {
        etFirstname=(EditText) findViewById(R.id.firstnameTxt2);
        etPassword=(EditText) findViewById(R.id.passwardTxt2);
        etLastname=(EditText) findViewById(R.id.lastnameTxt2);
        etZIP=(EditText) findViewById(R.id.ZIPTxt2);
        etEmail=(EditText) findViewById(R.id.emailTxt2);
        etDescription=(EditText) findViewById(R.id.selfDescriptionTxt);

        accountsDbRef= FirebaseDatabase.getInstance().getReference().child("Accounts");// get collection [Accounts] on database
        insertAccountData();

        backToMain();
    }

        /*convert uri to filepath
         
         */
        private String getRealPathFromURI(Context context, Uri contentUri) {
            Cursor cursor = null;
            try {
                String[] proj = { MediaStore.Images.Media.DATA };
                cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            } catch (Exception e) {
                return "";
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

    private void insertAccountData() throws IOException {
        String firstname=etFirstname.getText().toString();
        String lastname=etLastname.getText().toString();
        String password=etPassword.getText().toString();
        String email=etEmail.getText().toString();
        String address=etZIP.getText().toString();
        String description=etDescription.getText().toString();
        String filepath;

        filepath = getRealPathFromURI(this, uri);

        CookAccount CA = new CookAccount(firstname,lastname,email,password,address,description,filepath);

        accountsDbRef.push().setValue(CA);// add this dummy class to the database

        Toast.makeText(SignUpActivity2.this,"data inserted",Toast.LENGTH_SHORT).show();//show a success message if success
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