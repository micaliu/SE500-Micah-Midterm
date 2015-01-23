package edu.olivet.se530.ioc;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class KingOfPigs {
	@Inject private AbstractPig queenOfPigs;
	@Inject private AbstractPig pigPrince;
	@Inject private AbstractPig pigGeneral;
	
	@Override
	public String toString() {
		return "KingOfPigs [queenOfPigs=" + queenOfPigs + ", pigPrince=" + pigPrince + ", pigGeneral=" + pigGeneral + "]";
	}
	
	public void setPigPrince(AbstractPig pigPrince) {
		this.pigPrince = pigPrince;
	}
	public void setPigGeneral(AbstractPig pigGeneral) {
		this.pigGeneral = pigGeneral;
	}
	public void setQueenOfPigs(AbstractPig queenOfPigs) {
		this.queenOfPigs = queenOfPigs;
	}
}
