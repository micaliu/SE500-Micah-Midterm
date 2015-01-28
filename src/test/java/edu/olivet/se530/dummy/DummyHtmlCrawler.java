package edu.olivet.se530.dummy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	@Override
	public Document getDocument(String isbn, String condition) throws MalformedURLException, IOException {
		String rootDir = new File(StringUtils.EMPTY).getAbsolutePath();
		File html = new File(rootDir, "Assignment" + File.separator + String.format("%s_%s_1.html", isbn, condition.toUpperCase()));
		return Jsoup.parse(html, "UTF-8");
	}

}
