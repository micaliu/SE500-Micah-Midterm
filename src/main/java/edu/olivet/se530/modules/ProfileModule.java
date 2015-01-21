package edu.olivet.se530.modules;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import edu.olivet.se530.annotations.Profile;
import edu.olivet.se530.aop.ProfileIntecepter;

public class ProfileModule extends AbstractModule {

	@Override
	protected void configure() {
		ProfileIntecepter intecepter = new ProfileIntecepter();
		this.requestInjection(intecepter);
		this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Profile.class), intecepter);
	}
}
