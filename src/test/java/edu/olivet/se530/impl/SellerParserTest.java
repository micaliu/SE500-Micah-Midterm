package edu.olivet.se530.impl;


import org.jukito.JukitoRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 7, 2015 5:36:16 PM
 */
@RunWith(JukitoRunner.class)
public class SellerParserTest {
	@Inject private SellerParser sellerParser;
	
	@Test
	public void testParseSellers() {
		Assert.assertEquals(sellerParser.parseSellers(null).size(), 0);
	}

}
