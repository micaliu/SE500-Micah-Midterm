package edu.olivet.se530.assignment;


import edu.olivet.se530.HtmlParser;
import edu.olivet.se530.SellerHunter;
import edu.olivet.se530.dummy.DummyHtmlCrawler;
import org.junit.*;

import java.io.IOException;

/**
 * <pre>
 * 每个学生写完自己的SellerHunter之后，应当保证这个单元测试用例全部通过
 * </pre>
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 28, 2015 8:54:18 AM
 */
public class TestSellerHunterAssignment {
	private static SellerHunter sellerHunter;
	
	@BeforeClass public static void init() {
		sellerHunter = new SellerHunter();
		sellerHunter.setHtmlFetcher(new DummyHtmlCrawler());
		sellerHunter.setHtmlParser(new HtmlParser());
	}
	
	@Test public void test_offer_hunt_exclude_ship_from_uk() throws IOException {
		Assert.assertEquals("Free State Books", sellerHunter.huntOffer("0751515736", "Used",1).getSeller().getName());
		Assert.assertEquals("the_book_depository_", sellerHunter.huntOffer("907871496",	"New",1).getSeller().getName());
	}
	
	@Test public void test_offer_hunt_prime_price_greater_than_35() throws IOException {
		Assert.assertEquals("AP", sellerHunter.huntOffer("135157862", "New",1).getSeller().getName());
	}
	
	@Test public void test_offer_hunt_prime_price_less_than_35() throws IOException {
		Assert.assertEquals("BookSeller USA, LLC", sellerHunter.huntOffer("1416532277",	"New",1).getSeller().getName());
	}
	
}
