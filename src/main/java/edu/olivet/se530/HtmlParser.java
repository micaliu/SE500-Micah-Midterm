package edu.olivet.se530;

import edu.olivet.se530.annotations.Profile;
import edu.olivet.se530.model.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
	
	@Profile(desc = "解析一个给定的html document，返回其中的offer列表")
	List<Offer> parseOffer(Document doc) {
		List<Offer> results = new ArrayList<>();
		Elements rows = doc.select("div.a-row.a-spacing-mini.olpOffer");
		for (Element row : rows) {
			Offer offer = new Offer();
			offer.setPrice(Float.parseFloat(this.getText(row, "span.olpOfferPrice").replace("$", "")));
			String shippingFeeText = this.getText(row, "span.olpShippingPrice").replace("$", "");
			if (shippingFeeText != null && shippingFeeText.trim().length() > 0) {
				offer.setShippingPrice(Float.parseFloat(shippingFeeText));
			}

			Seller seller = this.parseSeller(row);
			Condition condition = parseCondition(row);
			offer.setSeller(seller);
			if(offer.getSeller().getName()=="AP"){
				if(offer.getPrice()<35.00){
					offer.setShippingPrice(Float.parseFloat("3.99"));
				}
			}
			offer.setCondition(condition);

			results.add(offer);
		}
		
		return results;
	}

	@Profile
	Condition parseCondition(Element row) {
		String cond = this.getText(row, "h3.a-spacing-small.olpCondition");
		Condition condition = new Condition();
		if(cond != null && cond.indexOf('-')>-1){
			String[] array = cond.split("-");
			condition.setPrimary(array[0].trim());
			condition.setSecondary(array[1].trim());
		}else{
			condition.setPrimary(cond);
		}

		return condition;
	}

	@Profile
	Seller parseSeller(Element row) {
		Seller seller = new Seller();
		String sellerNameSelector = "p.a-spacing-small.olpSellerName";

		if(this.getText(row, sellerNameSelector)!=null && this.getText(row, sellerNameSelector).length()>0){
			seller.setName(this.getText(row, sellerNameSelector));
			String link = row.select(sellerNameSelector + " a").get(0).attr("href");
			seller.setUuid(link.replaceFirst(".*&seller=", ""));
			String ratingText = this.getText(row, "p.a-spacing-small > a > b");
			if(ratingText!=null){
				int rating = Integer.parseInt(ratingText.replaceAll("[^0-9]", ""));
				seller.setRating(rating);
			}
			String ratingCountText = this.getText(row, "div.a-column.a-span2.olpSellerColumn > p:nth-child(2)");
			if(ratingCountText!=null){
				ratingCountText = ratingCountText.substring(ratingCountText.indexOf('('), ratingCountText.indexOf(')')).replaceAll("[^0-9]", "");
				seller.setRatingCount(Integer.parseInt(ratingCountText));
			}
		}else{
			seller.setName("AP");
			seller.setRating(Integer.MAX_VALUE);
			seller.setRatingCount(Integer.MAX_VALUE);
		}

		
		Elements deliveries = row.select("ul.a-vertical > li > span.a-list-item");
		for (Element element : deliveries) {
			String text = element.text();
			if (text.contains("Expedited shipping available")) {
				seller.setExpeditedShippingAvailable(true);
			} else if (text.contains("International & domestic shipping rates and return policy")) {
				seller.setIntlShippingAvailable(true);
			} else if (text.matches("Ships from [A-Z]{2}, United States[.]")) {
				String[] array = text.replace("Ships from", "").split(",");
				seller.setShippingState(array[0].trim());
				seller.setShippingCountry(array[1].trim().replace(".", ""));
			}else if(text.matches("(.*)United Kingdom(.*)")){
				seller.setShippingCountry("United Kingdom");
			}
		}
		return seller;
	}

	@Profile
	String getText(Element element, String selector) {
		Elements elements = element.select(selector);
		if (elements.size() <= 0) {
			return "";
		}
		return elements.get(0).text();
	}
	
}