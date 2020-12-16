package com.kayafirat.blogkayafirat.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel RegisterViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterViewModel = new ViewModelProvider(this, new RegisterViewModelFactory()).get(RegisterViewModel.class);

        final EditText emailEditText = findViewById(R.id.emailAddress);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button RegisterButton = findViewById(R.id.register);
        final Button goLogin = findViewById(R.id.btn_go_login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        goLogin.setEnabled(true);
        RegisterViewModel.getRegisterFormState().observe(this, new Observer<RegisterFormState>() {
            @Override
            public void onChanged(@Nullable RegisterFormState RegisterFormState) {
                if (RegisterFormState == null) {
                    return;
                }
                RegisterButton.setEnabled(RegisterFormState.isDataValid());

                if (RegisterFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(RegisterFormState.getUsernameError()));
                }
                if (RegisterFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(RegisterFormState.getPasswordError()));
                }
                if(RegisterFormState.getEmailAddressError() != null){
                    emailEditText.setError(getString(RegisterFormState.getEmailAddressError()));
                }
            }
        });

        RegisterViewModel.getRegisterResult().observe(this, new Observer<RegisterResult>() {
            @Override
            public void onChanged(@Nullable RegisterResult RegisterResult) {
                if (RegisterResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (RegisterResult.getError() != null) {
                    showRegisterFailed(RegisterResult.getError());
                }
                if (RegisterResult.getSuccess() != null) {
                    updateUiWithUser();
                }
                setResult(Activity.RESULT_OK);

                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                RegisterViewModel.registerDataChanged(emailEditText.getText().toString(),usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        };

        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    RegisterViewModel.register(emailEditText.getText().toString(),usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                RegisterViewModel.register(emailEditText.getText().toString(),usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateUiWithUser() {
        String welcome = getString(R.string.register_success);
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showRegisterFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}
