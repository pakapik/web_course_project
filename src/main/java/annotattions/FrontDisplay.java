package annotattions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface FrontDisplay {
    String name();
    InputType inputType();
    Class<?> dataType();
    int orderPlace();
    boolean isRequired() default true;
    int min() default 0;
    int max() default 1;
}
