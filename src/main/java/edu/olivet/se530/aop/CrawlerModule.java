package edu.olivet.se530.aop;

import com.google.inject.AbstractModule;

import edu.olivet.se530.HtmlCrawler;
import edu.olivet.se530.HtmlCrawlerImpl;

public class CrawlerModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(HtmlCrawler.class).to(HtmlCrawlerImpl.class);
	}

}
