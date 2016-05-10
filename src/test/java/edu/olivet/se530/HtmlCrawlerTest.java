package edu.olivet.se530;

import java.io.IOException;
import java.lang.annotation.Repeatable;

import edu.olivet.se530.annotations.Profile;
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

    @Profile
    @Test public void test_get_text() throws IOException {
        String condition = "New";
        String isbn = "031043601X";
        Document document = htmlCrawler.getDocument(isbn, condition,1);
        String selector = "#olpOfferList > div > div > div:nth-child(3) > div.a-column.a-span2.olpSellerColumn > h3 > span > a";
        Assert.assertTrue(document.select(selector).size() > 0);
	}

}
