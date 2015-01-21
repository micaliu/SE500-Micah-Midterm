package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.testng.AssertJUnit;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import edu.olivet.se530.aop.ProfileModule;

@Guice(modules = ProfileModule.class)
public class HtmlCrawlerTest {
	@Inject private HtmlCrawlerImpl htmlCrawler;
	
	private String isbn = "031043601X";
	private String condition = "New";
	
	@Test public void test_get_text() throws MalformedURLException, IOException {
		Document document = htmlCrawler.getDocument(isbn, condition);
		String selector = "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span2.olpSellerColumn > p.a-spacing-small.olpSellerName > span > a";
		AssertJUnit.assertTrue(document.select(selector).size() > 0);
	}

}
