package com.kayafirat.blogkayafirat.ui.register;

import androidx.annotation.Nullable;

import com.kayafirat.blogkayafirat.ui.register.RegisteredInUserView;

public class RegisterResult {
    @Nullable
    private RegisteredInUserView success;
    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable RegisteredInUserView success) {
        this.success = success;
    }

    @Nullable
    RegisteredInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
