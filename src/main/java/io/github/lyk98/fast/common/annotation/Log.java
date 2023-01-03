package io.github.lyk98.fast.common.annotation;

import io.github.lyk98.fast.common.enums.BusinessType;
import io.github.lyk98.fast.common.enums.OperatorType;

/**
 * 自定义操作日志记录注解
 *
 * @author 准点下班
 * @date 2023/1/3 8:59
 */
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}
