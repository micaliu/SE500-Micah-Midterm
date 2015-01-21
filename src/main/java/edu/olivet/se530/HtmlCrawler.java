package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;

public interface HtmlCrawler {

	public Document getDocument(String isbn, String condition) throws MalformedURLException, IOException;
}