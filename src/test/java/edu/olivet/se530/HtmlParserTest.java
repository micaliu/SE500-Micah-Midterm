package edu.olivet.se530;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.olivet.se530.dummy.DummyHtmlCrawler;
import edu.olivet.se530.model.Condition;
import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;
import edu.olivet.se530.modules.ProfileModule;

@RunWith(JukitoRunner.class)
@UseModules(value = ProfileModule.class)
public class HtmlParserTest {
	@Inject private HtmlParser htmlParser;
	private static Document document;
	
	@BeforeClass public static void prepareDocument() throws IOException {
		document = new DummyHtmlCrawler().getDocument("0751515736", "USED",1);
	}
	
	@Test public void test_parse_seller() {
		Seller seller = htmlParser.parseSeller(document.select("div.a-row.a-spacing-mini.olpOffer").get(3));
		Assert.assertEquals("greener_books_london", seller.getName());
		Assert.assertEquals("A161AAYHQBTAQT", seller.getUuid());
		Assert.assertEquals(97, seller.getRating());
		Assert.assertEquals(36246 , seller.getRatingCount());
		Assert.assertEquals(null, seller.getShippingState());
		Assert.assertEquals("United Kingdom", seller.getShippingCountry());
		Assert.assertFalse(seller.isExpeditedShippingAvailable());
		Assert.assertTrue(seller.isIntlShippingAvailable());
	}
	
	@Test public void test_parse_condtion() {
		Condition cond = htmlParser.parseCondition(document.select("div.a-row.a-spacing-mini.olpOffer").get(3));
		Assert.assertEquals(new Condition("Used", "Good"),  cond);
	}
	
	@Test
	public void testParseOffer() {
		List<Offer> offers = htmlParser.parseOffer(document);
		Assert.assertTrue(0.77f == offers.get(0).getPrice());
		Assert.assertTrue(3.99f == offers.get(0).getShippingPrice());
		Assert.assertTrue(3.99f == offers.get(3).getShippingPrice());
	}

	@Test
	public void testGetText() {
		Assert.assertEquals("brit-books-usa", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span2.olpSellerColumn > p.a-spacing-small.olpSellerName > span > a"));
		Assert.assertEquals("In Stock.", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span3.olpDeliveryColumn > ul > li:nth-child(1) > span"));
		Assert.assertEquals("97% positive", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(5) > div.a-column.a-span2.olpSellerColumn > p:nth-child(2) > a > b"));
	}

}
