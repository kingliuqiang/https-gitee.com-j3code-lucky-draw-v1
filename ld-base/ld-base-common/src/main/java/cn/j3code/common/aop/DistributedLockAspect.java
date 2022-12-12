package cn.j3code.common.aop;

import cn.j3code.common.annotation.DistributedLock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.common.aop
 * @createTime 2022/12/12 - 23:04
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
@Aspect
public class DistributedLockAspect {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String defaultKey = "distributed:lock:aspect:";

    @Pointcut("@annotation(cn.j3code.common.annotation.DistributedLock)")
    public void distributedLock() {
    }


    @Around("distributedLock()")
    public void invoke(ProceedingJoinPoint joinPoint) throws Exception {
        String key =  getKey(joinPoint);

        Boolean absent = redisTemplate.opsForValue()
                .setIfAbsent(key, Thread.currentThread().getId() + "",5, TimeUnit.MINUTES);

        if (Boolean.FALSE.equals(absent)){
            return;
        }

        try {
            // 执行业务
            joinPoint.proceed();
        } catch (Throwable e) {
            log.error("业务执行出错！");
        } finally {
            // 资源处理
            String value = (String) redisTemplate.opsForValue().get(key);
            if (value.equals(Thread.currentThread().getId() + "")){
                // 只删除自己线程加的锁，防止误删他人的锁，导致他人业务逻辑执行多次
                // 如果删除出问题，就是key没有被删除掉
                redisTemplate.delete(key);
            }
        }
    }

    private String getKey(ProceedingJoinPoint joinPoint) {
        Method method = null;
        try {
            method = joinPoint
                    .getTarget()
                    .getClass()
                    .getMethod(
                            joinPoint.getSignature().getName(),
                            ((MethodSignature) joinPoint.getSignature()).getParameterTypes()
                    );
        } catch (NoSuchMethodException e) {
            log.error("获取注解key失败，使用默认key");
            return defaultKey + "default-key";
        }

        DistributedLock annotation = method.getAnnotation(DistributedLock.class);
        String key = annotation.key();
        if (Objects.isNull(key)) {
            key = defaultKey + method.getClass().getName() + ":" + method.getName();
        }
        return key;
    }

}
