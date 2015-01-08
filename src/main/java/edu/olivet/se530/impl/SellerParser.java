package edu.olivet.se530.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.olivet.se530.model.Seller;

/**
 * Seller解析类
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 7, 2015 4:45:24 PM
 */
public class SellerParser {
	private static final Logger logger = LoggerFactory.getLogger(SellerParser.class);

	public List<Seller> parseSellers(String html) {
		logger.debug("找到0个可用Seller");
		return new ArrayList<Seller>();
	}
	
}
