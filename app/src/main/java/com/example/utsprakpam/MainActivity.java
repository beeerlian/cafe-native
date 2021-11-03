package com.example.utsprakpam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utsprakpam.dashboard.DashboardActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(String username, String password){
        Intent loginIntent = new Intent(getApplicationContext(), DashboardActivity.class);
        loginIntent.putExtra("username", username);
        loginIntent.putExtra("password", password);
        startActivity(loginIntent);
        this.finish();
    }

    public void checkUserLoginData(View view){
        EditText usernameText = (EditText) findViewById(R.id.Username);
        EditText passwordText = (EditText) findViewById(R.id.Password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        if(username.equals("admin") && password.equals("admin")){
            login(username, password);
        }
        else{
            showToast();
        }
    }
    public void showToast(){
        Context context = getApplicationContext();
        CharSequence text = "Username dan Password Salah";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}