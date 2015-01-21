package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.olivet.se530.dummy.DummyHtmlCrawler;
import edu.olivet.se530.model.Condition;
import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;

public class HtmlParserTest {
	private HtmlParser htmlParser = new HtmlParser();
	private static Document document;
	
	@BeforeClass public static void prepareDocument() throws MalformedURLException, IOException {
		document = new DummyHtmlCrawler().getDocument("", "");
	}
	
	@Test public void test_parse_seller() {
		Seller seller = htmlParser.parseSeller(document.select("div.a-row.a-spacing-mini.olpOffer").get(3));
		Assert.assertEquals("Silver Arch Books", seller.getName());
		Assert.assertEquals("ANHFDOMMXXZUV", seller.getUuid());
		Assert.assertEquals(97, seller.getRating());
		Assert.assertEquals(176841 , seller.getRatingCount());
		Assert.assertEquals("MO", seller.getShippingState());
		Assert.assertEquals("United States", seller.getShippingCountry());
		Assert.assertTrue(seller.isExpeditedShippingAvailable());
		Assert.assertTrue(seller.isIntlShippingAvailable());
	}
	
	@Test public void test_parse_condtion() {
		Condition cond = htmlParser.parseCondition(document.select("div.a-row.a-spacing-mini.olpOffer").get(3));
		Assert.assertEquals(new Condition("Used", "Acceptable"),  cond);
	}
	
	@Test
	public void testParseOffer() {
		List<Offer> offers = htmlParser.parseOffer(document);
		Assert.assertTrue(3.98f == offers.get(0).getPrice());
		Assert.assertTrue(0.0f == offers.get(0).getShippingPrice());
		Assert.assertTrue(3.99f == offers.get(3).getShippingPrice());
	}

	@Test
	public void testGetText() {
		Assert.assertEquals("internationalbooks", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span2.olpSellerColumn > p.a-spacing-small.olpSellerName > span > a"));
		Assert.assertEquals("In Stock.", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span3.olpDeliveryColumn > ul > li:nth-child(1) > span"));
		Assert.assertEquals("Amazon Prime TM", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div:nth-child(1) > span.supersaver > i"));
	}

}
