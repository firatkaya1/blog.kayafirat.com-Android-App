package com.kayafirat.blogkayafirat.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kayafirat.blogkayafirat.MainActivity;
import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.AuthenticateRequest;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.impl.UserService;
import com.kayafirat.blogkayafirat.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    public static Context contextOfApplication;
    boolean isEmailValid = false;
    boolean isPasswordValid = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        contextOfApplication = getApplicationContext();

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button goRegister = findViewById(R.id.btn_go_register);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        goRegister.setEnabled(true);

        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isEmailValid = isUserNameValid(usernameEditText.getText().toString());
                if (!isEmailValid){
                    usernameEditText.setError("E-posta adresiniz uygun formatta değil.");
                } else if (isPasswordValid && isEmailValid){
                    loginButton.setEnabled(true);

                }
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 isPasswordValid = isPasswordValid(passwordEditText.getText().toString());
                 if (!isPasswordValid){
                    passwordEditText.setError("Lütfen şifrenizi giriniz.");
                } else if (isPasswordValid && isEmailValid){
                    loginButton.setEnabled(true);

                }
            }
        });

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            boolean result = login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            if (result) {
                updateUiWithUser();
            } else {
                showLoginFailed();
                loadingProgressBar.setVisibility(View.INVISIBLE);
            }
        });

        goRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void updateUiWithUser() {
        String welcome = getString(R.string.welcome) ;
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void showLoginFailed( ) {
        Toast.makeText(getApplicationContext(), "Kullanıcı adı veya şifre hatalı", Toast.LENGTH_SHORT).show();
    }

    public static Context applicationContext(){
        return contextOfApplication;
    }


    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }


    private void savePreferences(Long id){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.applicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("id", id);
        editor.apply();
    }

    public boolean login(String emailAddress,String password){
        UserService userService = new UserService();
        Long id = userService.login(new AuthenticateRequest(emailAddress,password));
        if (id!=null){
            savePreferences(id);
            return true;
        } else {
            return false;
        }
    }
}