package validation;

import validation.Demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DemoConstraintValidator implements ConstraintValidator<Demo, String> {

    private String demoPrefix;


    @Override
    public void initialize(Demo demo) {
        demoPrefix = demo.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;

        if (theCode!=null) result = theCode.startsWith(demoPrefix);
        else result = true;
        return result;
    }
}
