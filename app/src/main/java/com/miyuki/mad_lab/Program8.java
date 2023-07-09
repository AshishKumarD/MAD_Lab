package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class Program8 extends AppCompatActivity {

    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program8);
        phone = findViewById(R.id.phone);
    }

    public void call(View v){
        String phoneNumber=phone.getText().toString();
        Intent intent= new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }
    public void save(View v){
        String phoneNumber=phone.getText().toString();
        Intent intent=new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNumber);
        startActivity(intent);
    }
}