package com.dima.entities.prompts;

import com.dima.models.SignupModel;

public class UserNameDBPrompt extends UserNamePrompt {

    @Override
    public boolean validate(String input) {
        if (!super.validate(input)) {
            return false;
        }
        if (SignupModel.userExists(input)) {
            setError(UserNamePrompt.Errors.USER_ALREADY_EXISTS.err);
            return false;
        }
        return true;
    }
}
