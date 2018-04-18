package com.decoder.anno;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.decoder.engine.SimpleEngine;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Rule {
	
	int start() default 0;
	
	int end() default 0;
	
	Class<?> engine() default SimpleEngine.class;
	
	boolean sub() default false;
}
