package edu.olivet.se530.ioc;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
class KingOfPigs {
	@Inject private AbstractPig queenOfPigs;
	@Inject private AbstractPig pigPrince;
	@Inject private AbstractPig pigGeneral;
	
	@Override
	public String toString() {
		return "KingOfPigs [queenOfPigs=" + queenOfPigs + ", pigPrince=" + pigPrince + ", pigGeneral=" + pigGeneral + "]";
	}
	
	void setPigPrince(AbstractPig pigPrince) {
		this.pigPrince = pigPrince;
	}
	void setPigGeneral(AbstractPig pigGeneral) {
		this.pigGeneral = pigGeneral;
	}
	void setQueenOfPigs(AbstractPig queenOfPigs) {
		this.queenOfPigs = queenOfPigs;
	}
}
