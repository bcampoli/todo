package demo.validator;

import demo.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by William Campoli on 2017-08-30.
 */
public class RegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
