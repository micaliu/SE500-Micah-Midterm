package edu.olivet.se530;

/**
 * Html抓取接口定义
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 7, 2015 4:45:30 PM
 */
public interface HtmlCrawler {

	public String getHtml(String isbn, String condition, String countryCode);
	
}
