package edu.olivet.se530.modules;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import edu.olivet.se530.annotations.Repeat;
import edu.olivet.se530.aop.RepeatInterceptor;

/**
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 4:12 PM
 */
public class RepeatModule extends AbstractModule {
    @Override
    protected void configure() {
        RepeatInterceptor interceptor = new RepeatInterceptor();
        this.requestInjection(interceptor);
        this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Repeat.class), interceptor);
    }
}
