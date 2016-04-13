package edu.olivet.se530.ioc;

class Singleton {

	private Singleton() {}
	
	private static final Singleton instance = new Singleton();
	
	static Singleton getInstance() {
		return instance;
	}
	
}
