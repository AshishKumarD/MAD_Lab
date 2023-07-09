package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Program3 extends AppCompatActivity {

    String username, Password;
    Boolean isSignedin = false;
    EditText et_email, et_password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program3);
        et_email =findViewById(R.id.num1);
        et_password =findViewById(R.id.num2);
        btn =findViewById(R.id.signup);
        btn.setOnClickListener(v -> {
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();
            if(!isSignedin) {

                if (!isValidPassword(password)) {
                    toastMessage("Password doesn't match rules");
                } else {
                    username = email;
                    Password = password;
                    isSignedin = true;
                    toastMessage("Sign up successful");
                    btn.setText("Log in");
                    et_email.setText("");
                    et_password.setText("");
                }
            }else{
                if(email.equals(username) && password.equals(Password))
                    toastMessage("Login Successful");
                else toastMessage("Incorrect Password");
            }
        });
    }

    Pattern lowerCase= Pattern.compile("^.*[a-z].*$");
    Pattern upperCase=Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern special_Chara = Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if(password.length()<8) {
            return false;
        }
        if(!lowerCase.matcher(password).matches()) {
            return false;
        }
        if(!upperCase.matcher(password).matches()) {
            return false;
        }
        if(!number.matcher(password).matches()) {
            return false;
        }
        if(!special_Chara.matcher(password).matches()) {
            return false;
        }
        return true;
    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}