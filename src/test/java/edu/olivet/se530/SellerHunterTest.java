package edu.olivet.se530;


import java.io.IOException;

import edu.olivet.se530.annotations.Profile;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.olivet.se530.dummy.DummyModule;
import edu.olivet.se530.model.Offer;

@RunWith(JukitoRunner.class)
@UseModules(value = DummyModule.class)
public class SellerHunterTest {
	@Inject private SellerHunter hunter;

    @Profile
    @Test public void test_get_offer_list2() throws IOException {
        String condition = "Used";
        String isbn = "751515736";
        Offer offer = hunter.huntOffer(isbn, condition,1);
        Assert.assertEquals("Free State Books", offer.getSeller().getName());
    }
    @Profile
    @Test public void test_get_offer_list3() throws IOException {
        String condition = "New";
        String isbn = "907871496";
        Offer offer = hunter.huntOffer(isbn, condition,1);
        Assert.assertEquals("the_book_depository_", offer.getSeller().getName());
    }
    @Profile
    @Test public void test_get_offer_list() throws IOException {
        String condition = "New";
        String isbn = "1416532277";
        Offer offer = hunter.huntOffer(isbn, condition,1);
        Assert.assertEquals("BookSeller USA, LLC", offer.getSeller().getName());
    }
    @Profile
    @Test public void test_get_offer_list4() throws IOException {
        String condition = "New";
        String isbn = "135157862";
        Offer offer = hunter.huntOffer(isbn, condition,1);
        Assert.assertEquals("AP", offer.getSeller().getName());
    }
}
