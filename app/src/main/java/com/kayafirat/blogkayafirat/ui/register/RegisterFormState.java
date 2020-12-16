package com.kayafirat.blogkayafirat.ui.register;

import androidx.annotation.Nullable;

public class RegisterFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer emailAddressError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    public RegisterFormState(@Nullable Integer emailAddressError, @Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.emailAddressError = emailAddressError;
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    public RegisterFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.emailAddressError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    Integer getEmailAddressError() {
        return emailAddressError;
    }


    boolean isDataValid() {
        return isDataValid;
    }
}
