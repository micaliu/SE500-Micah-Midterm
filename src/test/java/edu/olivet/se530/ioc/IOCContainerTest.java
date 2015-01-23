package edu.olivet.se530.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

/**
 * 演示IOC容器的实现原理和基于配置文件、注解的对比
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 23, 2015 10:39:01 AM
 */
public class IOCContainerTest {

	@Test public void test_singleton() {
		for (int i = 0; i < 5; i++) {
			Singleton singleton = Singleton.getInstance();
			System.out.println(singleton);
		}
	}
	
	private Map<String, Integer> config = new HashMap<String, Integer>();
	
	@Before public void init() {
		config.put("queenOfPigs", 30);
		config.put("pigPrince", 60);
		config.put("pigGeneral", 150);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test public void create_instance_from_definition() {
		Map<String, Object> map = new HashMap<String, Object>();
		String className = "edu.olivet.se530.ioc.AbstractPig";
		
		long start = System.currentTimeMillis();
		for (Entry<String, Integer> entry : config.entrySet()) {
			AbstractPig pig = createInstance(className, entry.getValue());
			map.put(entry.getKey(), pig);
		}
		
		try {
			Class clazz = Class.forName("edu.olivet.se530.ioc.KingOfPigs");
			KingOfPigs pigKing = (KingOfPigs)clazz.getConstructors()[0].newInstance();
			
			for (Entry<String, Integer> entry : config.entrySet()) {
				String methodName = "set" + StringUtils.capitalize(entry.getKey());
				Method method = clazz.getMethod(methodName, AbstractPig.class);
				method.invoke(pigKing, map.get(entry.getKey()));
			}
			
			System.out.println("通过反射创建的猪王:" + pigKing);
			System.out.println("反射耗时:" + (System.currentTimeMillis() - start));
			System.out.println("=================================");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Guice is here:");
		KingOfPigs instance = Guice.createInjector().getInstance(KingOfPigs.class);
		System.out.println(instance);
		System.out.println("Guice is gone:");
		
		start = System.currentTimeMillis();
		KingOfPigs pigKing = new KingOfPigs();
		pigKing.setPigGeneral(new GeneralPig(150));
		pigKing.setPigPrince(new AbstractPig(60));
		pigKing.setQueenOfPigs(new AbstractPig(30));
		System.out.println("=================================");
		System.out.println("直接创建猪王:" + pigKing);
		System.out.println("直接创建耗时:" + (System.currentTimeMillis() - start));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private AbstractPig createInstance(String className, int weight) {
		try {
			Class clazz = Class.forName(className);
			Constructor[] constructors = clazz.getConstructors();
			for (Constructor constructor : constructors) {
				// 有多个构造方法，需选择其中以重量为构造参数的方法
				if (constructor.getParameterTypes().length > 0) {
					AbstractPig pig = (AbstractPig)constructor.newInstance(weight);
					System.out.println(pig);
					
					// 实例创建之后，调用其初始化方法
					Method method = clazz.getMethod("init");
					method.invoke(pig);
					return pig;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
