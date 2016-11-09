package com.javaweb.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation, that we can use only for fields of our class.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldUsable {
}
