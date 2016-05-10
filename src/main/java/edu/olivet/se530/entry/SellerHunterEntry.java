package edu.olivet.se530.entry;

import java.io.IOException;

import com.google.inject.Guice;

import edu.olivet.se530.SellerHunter;
import edu.olivet.se530.annotations.SaveHtml;
import edu.olivet.se530.model.Offer;
import edu.olivet.se530.modules.CrawlerModule;

/**
 * Seller猎手
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 8, 2015 2:11:20 PM
 */
class SellerHunterEntry {

	public static void main(String[] args) throws IOException {

		SellerHunter hunter = Guice.createInjector(new CrawlerModule()).getInstance(SellerHunter.class);
		Offer offer = hunter.huntOffer("0385518927", "New",1);
		System.out.println(offer);
	}	
}
