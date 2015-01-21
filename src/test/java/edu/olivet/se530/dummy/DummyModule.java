package edu.olivet.se530.dummy;

import com.google.inject.AbstractModule;

import edu.olivet.se530.HtmlCrawler;

public class DummyModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(HtmlCrawler.class).to(DummyHtmlCrawler.class);
	}
}
