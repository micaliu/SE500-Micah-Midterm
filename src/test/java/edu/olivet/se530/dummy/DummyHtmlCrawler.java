package edu.olivet.se530.dummy;

import java.io.IOException;

import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	@Override
	public Document getDocument(String isbn, String condition) throws IOException {
		return null;
	}

}
