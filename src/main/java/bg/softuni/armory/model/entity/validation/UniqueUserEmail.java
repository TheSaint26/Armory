package bg.softuni.armory.model.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueUserEmail {
    String message() default "This email already exists in the database!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
