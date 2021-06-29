package validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DemoConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo {

    // define default value
    String value() default "DEMO";

    // define default message
    String message() default "Must start with DEMO";

    //define default groups
    Class<?>[] groups() default {};

    // define default payloads
    Class<?extends Payload>[] payloads() default {};

}
