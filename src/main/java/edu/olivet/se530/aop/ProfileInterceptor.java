package edu.olivet.se530.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;

import edu.olivet.se530.annotations.Profile;

public class ProfileInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start = System.currentTimeMillis();
		Profile profile = invocation.getMethod().getAnnotation(Profile.class);
		try {
			return invocation.proceed();
		} finally {
			String method = invocation.getThis().getClass().getSimpleName() + "#" + invocation.getMethod().getName();
			String desc = StringUtils.defaultIfBlank(profile.desc(), method);
			System.out.println(String.format("%s耗时:%sMS", desc, (System.currentTimeMillis() - start)));
		}
	}
	
}