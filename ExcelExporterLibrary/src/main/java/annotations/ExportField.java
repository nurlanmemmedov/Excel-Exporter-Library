package annotations;

import java.lang.annotation.*;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportField {
    String value();

    int sort() default Integer.MAX_VALUE;
}