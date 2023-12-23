package com.java.reflexion;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
/*
  This annotation marks a field to be automatically injected by the dependency injection framework.
 */
public @interface AutoInjectable {}
