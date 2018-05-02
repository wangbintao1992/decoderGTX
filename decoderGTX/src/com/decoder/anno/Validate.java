package com.decoder.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Validate {

    int ks() default 0;

    int ke() default 0;

    int ds() default 0;

    int de() default 0;

    /**
     * 出现offset，其他参数忽略
     */
    int offset() default 0;
}
