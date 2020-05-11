package com.saucelabs.salsaverde.pages;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface OnPage {
    String url() default "";
    String title() default "";
    String[] elements() default {};
    String urlPath() default "";
}
