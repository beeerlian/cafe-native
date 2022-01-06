package com.example.utsprakpam;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utsprakpam.dashboard.DashboardActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            String userActive = currentUser.getEmail();
            Log.println(Log.DEBUG, "user active", userActive );
            currentUser.reload();
        }
    }

    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                          gotoDashboard(email, password);

                        } else {
                            // If sign in fails, display a message to the user.
                            showToast();
                        }
                    }
                });
    }

    public void gotoDashboard(String email, String password){
        Intent loginIntent = new Intent(getApplicationContext(), DashboardActivity.class);
        loginIntent.putExtra("username", email);
        loginIntent.putExtra("password", password);
        startActivity(loginIntent);
        this.finish();
    }

    public void gotoSignUpPage(View view){
        Intent signupIntent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(signupIntent);
        this.finish();
    }

    public void checkUserLoginData(View view){
        EditText usernameText = (EditText) findViewById(R.id.Username);
        EditText passwordText = (EditText) findViewById(R.id.Password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        login(username, password);
    }
    public void showToast(){
        Context context = getApplicationContext();
        CharSequence text = "Login gagal";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}