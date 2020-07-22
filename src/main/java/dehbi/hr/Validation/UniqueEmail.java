package dehbi.hr.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.TYPE )
@Constraint(validatedBy = UniqueEmailClass.class)
public @interface UniqueEmail {
    String message() default "Email déjà utilisé";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
