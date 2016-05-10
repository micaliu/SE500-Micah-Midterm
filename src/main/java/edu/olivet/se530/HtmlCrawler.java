package edu.olivet.se530;

import java.io.IOException;

import org.jsoup.nodes.Document;

public interface HtmlCrawler {

	Document getDocument(String isbn, String condition,int page) throws IOException;
}