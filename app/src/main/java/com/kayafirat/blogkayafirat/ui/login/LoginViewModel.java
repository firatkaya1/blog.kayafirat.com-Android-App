package com.kayafirat.blogkayafirat.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Patterns;

import com.kayafirat.blogkayafirat.MainActivity;
import com.kayafirat.blogkayafirat.data.LoginRepository;
import com.kayafirat.blogkayafirat.data.Result;
import com.kayafirat.blogkayafirat.data.model.LoggedInUser;
import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.AuthenticateRequest;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.UserService;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;
    LoginViewModel(LoginRepository loginRepository ) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            loginResult.setValue(new LoginResult(new LoggedInUserView(username)));

            IUserService userService = new UserService();
            Long id = userService.login(new AuthenticateRequest(username,password));
            savePreferences(id);

        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
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
}