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

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void signup(String email, String password){


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            mAuth.updateUI(user);
                            gotoDashborad(email);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            showToast();
                        }
                    }
                });
    }

    public void gotoDashborad(String email){
        Intent signupIntent = new Intent(getApplicationContext(), DashboardActivity.class);
        signupIntent.putExtra("username", email);
        startActivity(signupIntent);
        this.finish();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
    public void checkUserSignupData(View view){
        EditText usernameText = (EditText) findViewById(R.id.Username);
        EditText passwordText = (EditText) findViewById(R.id.Password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        signup(username, password );
    }

    public void  gotoLoginPage(View view){
        Intent signupIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(signupIntent);
        this.finish();
    }
    public void showToast(){
        Context context = getApplicationContext();
        CharSequence text = "registrasi gagal";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}