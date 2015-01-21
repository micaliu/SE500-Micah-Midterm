package edu.olivet.se530;


import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.AssertJUnit;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import edu.olivet.se530.dummy.DummyModule;
import edu.olivet.se530.model.Offer;

@Guice(modules = DummyModule.class)
public class SellerHunterTest {
	@Inject private SellerHunter hunter;
	String isbn = "0060927585";
	String condition = "Used - Good";
	
	@Test public void test_get_offer_list() throws MalformedURLException, IOException {
		Offer offer = hunter.getOfferList(isbn, condition);
		AssertJUnit.assertEquals("Goodwill Southern California", offer.getSeller().getName());
	}
}
