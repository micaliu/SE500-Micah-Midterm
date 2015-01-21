package edu.olivet.se530.dummy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	@Override
	public Document getDocument(String isbn, String condition) throws MalformedURLException, IOException {
		return Jsoup.parse(new File("C:/OrderManRnD/Workspace/SE530Classic/TEST.html"), "UTF-8");
	}

}
