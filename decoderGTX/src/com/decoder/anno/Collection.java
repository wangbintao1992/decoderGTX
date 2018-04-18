package com.decoder.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Collection {
	
	int start() default 0;
	
	int step() default 0;
	
	Class<?> domain() default Object.class;
	
	int repeat() default 0;
	
	Class<?> key() default Object.class;
	
	Class<?> val() default Object.class;
}
