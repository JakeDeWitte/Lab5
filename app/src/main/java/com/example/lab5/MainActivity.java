package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {

        EditText myTextField = (EditText) findViewById(R.id.editTextName);
        String str = myTextField.getText().toString();

        EditText myTextField2 = (EditText) findViewById(R.id.editTextPassword);
        String password = myTextField2.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();

        goToActivity2(str);
    }

    private void goToActivity2(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String str = sharedPreferences.getString(usernameKey, "");
            goToActivity2(str);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
}