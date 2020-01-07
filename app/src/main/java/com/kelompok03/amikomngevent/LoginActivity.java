package com.kelompok03.amikomngevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText textInputEditTextEmail, textInputEditTextPassword;
    ProgressBar progressBar;
    FirebaseAuth mAuth;


    AppCompatButton appCompatButtonLogin;
    AppCompatTextView textViewLinkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

        initListeners();
    }

    private void initListeners() {
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);

        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
        Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:

                String email = textInputEditTextEmail.getText().toString().trim();
                String password = textInputEditTextPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    textInputEditTextEmail.setError("Email tidak boleh kosong!");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    textInputEditTextPassword.setError("Password tidak boleh kosong!");
                    return;
                }

                if(password.length() < 6) {
                    textInputEditTextPassword.setError("Password harus lebih dari 6 karakter");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate the user
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intentHome);
                        }else {
                            Toast.makeText(LoginActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                startActivity(intentRegister);
                break;
        }
    }
}
