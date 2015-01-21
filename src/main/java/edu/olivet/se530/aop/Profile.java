package edu.olivet.se530.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * 性能调优注解，声明的方法可以打印出来花费时间
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 21, 2015 8:22:36 AM
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface Profile {

	String desc() default StringUtils.EMPTY;
}
