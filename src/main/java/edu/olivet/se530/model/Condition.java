package edu.olivet.se530.model;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

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

    private String primary;
    private String secondary;

    private int primaryValue;
    private int secondaryValue;

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

	@Override
	public String toString() {
		return String.format("%s - %s", primary, secondary);
	}
	
	@Override
	public int compareTo(Condition o) {
        return ComparisonChain.start().compare(o.getPrimaryValue(), this.getPrimaryValue()).compare(o.getSecondaryValue(), this.getSecondaryValue()).result();
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return  Objects.equal(primary, condition.primary) &&
                Objects.equal(secondary, condition.secondary);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primary, secondary);
    }
}
