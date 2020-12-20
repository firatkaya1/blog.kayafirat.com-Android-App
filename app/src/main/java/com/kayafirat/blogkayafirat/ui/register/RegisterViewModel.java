package com.kayafirat.blogkayafirat.ui.register;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.data.LoginRepository;
import com.kayafirat.blogkayafirat.data.Result;
import com.kayafirat.blogkayafirat.data.model.LoggedInUser;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.UserService;

import java.util.Arrays;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();

    private LoginRepository loginRepository;

    RegisterViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    public void register(String emailAddress,String username, String password) {

        Result<LoggedInUser> result = loginRepository.login(username, password);

        IUserService userService = new UserService();
        if (result instanceof Result.Success) {
            registerResult.setValue(new RegisterResult(new RegisteredInUserView(username)));
            userService.saveUser(new User(null,emailAddress,username,password,null));

        } else {
            registerResult.setValue(new RegisterResult(R.string.register_failed));
        }
    }

    public void registerDataChanged(String emailAddress,String username, String password) {
        if (!isEmailAddressValid(emailAddress)) {
            registerFormState.setValue(new RegisterFormState(R.string.invalid_username,null, null));
        } else if (!hasUppercase(username)){
            registerFormState.setValue(new RegisterFormState(null,R.string.has_upper_case, null));
        } else if (!hasNumber(username)){
            registerFormState.setValue(new RegisterFormState(null, R.string.has_digit,null));
        } else if (!hasLowerCase(username)){
            registerFormState.setValue(new RegisterFormState(null,R.string.has_lower_case, null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(null,null, R.string.invalid_password));
        }
        else if (!hasUppercase(password)){
            registerFormState.setValue(new RegisterFormState(null,null, R.string.has_upper_case));
        } else if (!hasLowerCase(password)){
            registerFormState.setValue(new RegisterFormState(null, null,R.string.has_lower_case));
        } else if (!hasNumber(password)){
            registerFormState.setValue(new RegisterFormState(null,null, R.string.has_digit));
        }
        else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isEmailAddressValid(String emailAddress) {
        if (emailAddress == null) {
            return false;
        }
        if (emailAddress.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
        } else {
            return !emailAddress.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    //check if at least one uppercase
    private boolean hasUppercase(String value){
        char ch[] = value.toCharArray();
        for (char c:ch) {
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }
    //Check if at least one lowercase
    private boolean hasLowerCase(String value){
        char ch[] = value.toCharArray();
        for (char c:ch) {
            if (Character.isLowerCase(c))
                return true;
        }
        return false;
    }

    //check if at least one number
    private boolean hasNumber(String value){
        char ch[] = value.toCharArray();
        for (char c:ch) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }


}
