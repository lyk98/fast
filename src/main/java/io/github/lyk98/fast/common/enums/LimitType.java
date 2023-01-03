package io.github.lyk98.fast.common.enums;

/**
 * 限流类型
 *
 * @author 准点下班
 * @date 2023/1/3 9:03
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,

    /**
     * 根据请求者IP进行限流
     */
    IP
}
