package edu.olivet.se530.dummy;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	@Override
	public Document getDocument(String isbn, String condition,int page) throws IOException {
		if(isbn.length()!=10){
			isbn = String.format("%10s",isbn).replace(' ','0');
		}
		if(condition.indexOf('-')>-1){
			condition = condition.substring(0,condition.indexOf('-')).trim();
		}

		String filepath = String.format("./Assignment/%s_%s_%s.html",
				isbn, condition.toUpperCase(),page);
		Document doc = Jsoup.parse(new File(filepath),"utf-8");

		return doc;
	}

}
