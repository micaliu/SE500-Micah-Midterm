package edu.olivet.se530;

import edu.olivet.se530.model.Order;
import edu.olivet.se530.model.Seller;

/**
 * Seller猎手接口定义
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 7, 2015 4:45:16 PM
 */
public interface SellerHunter {

	public Seller hunt(Order order);
	
}
