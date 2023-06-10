package com.dima.entities.prompts;

import com.dima.models.SignupModel;

public class EmailDBPrompt extends EmailPrompt {

    @Override
    public boolean validate(String input) {
        if (!super.validate(input)) {
            return false;
        }
        if (SignupModel.isEmailInDB(input)) {
            setError(Errors.EMAIL_EXISTS.err);
            return false;
        }
        return true;
    }
}
