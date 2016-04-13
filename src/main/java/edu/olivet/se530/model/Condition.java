package edu.olivet.se530.model;

/**
 * 产品的Condition，比如新、旧(分为四个等级)
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 14, 2015 10:02:54 AM
 * @version 1.0
 */
public class Condition implements Comparable<Condition> {

	public Condition() {}
	public Condition(String primary, String secondary) {
		super();
		this.primary = primary;
		this.secondary = secondary;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	private int getPrimaryValue() {
		return primaryValue;
	}

	public void setPrimaryValue(int primaryValue) {
		this.primaryValue = primaryValue;
	}

	private int getSecondaryValue() {
		return secondaryValue;
	}

	public void setSecondaryValue(int secondaryValue) {
		this.secondaryValue = secondaryValue;
	}

	private String primary;
	private String secondary;
	
	public static final int NEW = 100;
	
	public static final int USED = 50;
	public static final int LIKE_NEW = 10;
	public static final int VERY_GOOD = 5;
	public static final int GOOD = 5;
	public static final int ACCEPTABLE = 0;
	
	private int primaryValue;
	private int secondaryValue;
	
	@Override
	public String toString() {
		return String.format("%s - %s", primary, secondary);
	}
	
	@Override
	public int compareTo(Condition o) {
		int rc = -Integer.compare(this.getPrimaryValue(), o.getPrimaryValue());
		if (rc == 0) {
			return -Integer.compare(this.getSecondaryValue(), o.getSecondaryValue());
		}
		return rc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primary == null) ? 0 : primary.hashCode());
		result = prime * result + ((secondary == null) ? 0 : secondary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (primary == null) {
			if (other.primary != null)
				return false;
		} else if (!primary.equals(other.primary))
			return false;
		if (secondary == null) {
			if (other.secondary != null)
				return false;
		} else if (!secondary.equals(other.secondary))
			return false;
		return true;
	}
	
}
