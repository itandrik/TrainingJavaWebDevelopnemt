package com.javaweb.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation, that you can use for methods,
 * which you want or don't want to call.
 * Use enabled() method to set usability of this method.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodUsable {
    /**
     * @return logical result of enabling method
     */
    boolean enabled() default false;
}
