package com.decoder.anno;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.decoder.engine.SimpleEngine;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Rule {
	/**
	 * 包含start
	 */
	int start() default 0;

	/**
	 * 不包含 end
	 */
	int end() default 0;

	Class<?> engine() default SimpleEngine.class;
	
	boolean sub() default false;

	int bytesit() default -1;
}
