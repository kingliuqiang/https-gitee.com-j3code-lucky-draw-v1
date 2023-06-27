package cn.j3code.common.annotation;

import java.lang.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.common.annotation
 * @createTime 2022/12/12 - 23:01
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DistributedLock {

    /**
     * 如果字符串中存在{1}，{2}等占位符，则程序会获取对应方法中的参数顺序值进行填充
     * 获取不到则不处理
     * @return
     */
    String key() default "distributedLock";

    /**
     * 加锁失败，是否抛错，默认 false，不抛错
     * @return
     */
    boolean lockFail() default false;

    /**
     * 加锁失败，抛错的提示信息
     * @return
     */
    String failMessage() default "";

    long expiredTime() default 30L;

    int maxToRenewNum() default 30;
}
