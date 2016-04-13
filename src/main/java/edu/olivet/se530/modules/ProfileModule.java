package edu.olivet.se530.modules;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import edu.olivet.se530.annotations.Profile;
import edu.olivet.se530.aop.ProfileInterceptor;

public class ProfileModule extends AbstractModule {

	@Override
	protected void configure() {
		ProfileInterceptor interceptor = new ProfileInterceptor();
		this.requestInjection(interceptor);
		this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Profile.class), interceptor);
	}
}
