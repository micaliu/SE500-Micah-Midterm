package edu.olivet.se530.aop;

import java.io.File;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class ProfileModule extends AbstractModule {

	@Override
	protected void configure() {
		ProfileIntecepter intecepter = new ProfileIntecepter();
		this.requestInjection(intecepter);
		this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Profile.class), intecepter);
	}
	
	static class SaveHtmlIntecepter implements MethodInterceptor {

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			Document doc = (Document)invocation.proceed();
			FileUtils.writeStringToFile(new File("", String.valueOf(System.currentTimeMillis())), doc.html(), "UTF-8");
			return doc;
		}
		
	}
	
	static class ProfileIntecepter implements MethodInterceptor {

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			long start = System.currentTimeMillis();
			Profile profile = invocation.getMethod().getAnnotation(Profile.class);
			String clazz = invocation.getMethod().getDeclaringClass().getCanonicalName();
			try {
				invocation.proceed();
			} finally {
				if (clazz.contains("CrawlerImpl")) {
					System.out.println(String.format("%s耗时:%sMS", profile.desc(), (System.currentTimeMillis() - start)));
				}
			}
			return null;
		}
		
	}
}
