package edu.olivet.se530.model;


/**
 * 亚马逊商家
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 14, 2015 10:03:14 AM
 */
public class Seller {
	
	private String name;
	private String uuid;
	private String shippingState;
	private String shippingCountry;
	private int rating;
	private int ratingCount;
	private boolean expeditedShippingAvailable;
	private boolean intlShippingAvailable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public boolean isExpeditedShippingAvailable() {
		return expeditedShippingAvailable;
	}
	public void setExpeditedShippingAvailable(boolean expeditedShippingAvailable) {
		this.expeditedShippingAvailable = expeditedShippingAvailable;
	}
	public boolean isIntlShippingAvailable() {
		return intlShippingAvailable;
	}
	public void setIntlShippingAvailable(boolean intlShippingAvailable) {
		this.intlShippingAvailable = intlShippingAvailable;
	}
}
