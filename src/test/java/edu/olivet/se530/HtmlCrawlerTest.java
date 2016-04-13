package edu.olivet.se530;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.olivet.se530.modules.CrawlerModule;
import edu.olivet.se530.modules.ProfileModule;

@RunWith(JukitoRunner.class)
@UseModules(value = {ProfileModule.class, CrawlerModule.class})
public class HtmlCrawlerTest {
	@Inject private HtmlCrawlerImpl htmlCrawler;

    @Test public void test_get_text() throws IOException {
        String condition = "New";
        String isbn = "031043601X";
        Document document = htmlCrawler.getDocument(isbn, condition);
		String selector = "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span2.olpSellerColumn > p.a-spacing-small.olpSellerName > span > a";
		Assert.assertTrue(document.select(selector).size() > 0);
	}

}
