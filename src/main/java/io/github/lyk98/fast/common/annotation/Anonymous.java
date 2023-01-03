package io.github.lyk98.fast.common.annotation;

import java.lang.annotation.*;

/**
 * 匿名访问注解
 *
 * @author 准点下班
 * @date 2023/1/3 8:57
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Anonymous {
}

