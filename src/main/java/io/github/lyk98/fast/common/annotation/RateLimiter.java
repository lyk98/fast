package io.github.lyk98.fast.common.annotation;

import io.github.lyk98.fast.common.constant.CacheConstants;
import io.github.lyk98.fast.common.enums.LimitType;

import java.lang.annotation.*;

/**
 * @author 准点下班
 * @date 2023/1/3 9:02
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {
    /**
     * 限流key
     */
    String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;
}
