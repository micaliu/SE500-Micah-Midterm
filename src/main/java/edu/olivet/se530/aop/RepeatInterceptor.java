package edu.olivet.se530.aop;

import edu.olivet.se530.annotations.Repeat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 3:50 PM
 */
public class RepeatInterceptor implements MethodInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        String methodDesc = invocation.getThis().getClass().getSimpleName() + "." + invocation.getMethod().getName();
        Repeat repeat = method.getAnnotation(Repeat.class);
        int times = repeat.times();
        Exception exception = null;
        for (int i = 0; i < times; i++) {
            try {
                Object result = invocation.proceed();
                logger.info("第{}次执行{}成功通过", i + 1, methodDesc);
                return result;
            } catch (Exception e) {
                exception = e;
                logger.error("第{}次执行{}失败:", i + 1, methodDesc, e);
            }
        }
        logger.error("重复{}次执行{}仍告失败", times, methodDesc);
        throw exception;
    }

}
