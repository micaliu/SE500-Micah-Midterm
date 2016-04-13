package edu.olivet.se530.annotations;

import java.lang.annotation.*;

/**
 * 容错处理: 重复若干次操作, 以期至少有一次成功, 默认重复3次
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 3:48 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Repeat {

    int times() default 3;
}
