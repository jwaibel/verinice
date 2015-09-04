package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * FilterResBauId generated by hbm2java
 */
public class FilterResBauId implements java.io.Serializable {

	private int searchId;
	private int bauImpId;
	private int bauId;
	private int col;

	public FilterResBauId() {
	}

	public FilterResBauId(int searchId, int bauImpId, int bauId, int col) {
		this.searchId = searchId;
		this.bauImpId = bauImpId;
		this.bauId = bauId;
		this.col = col;
	}

	public int getSearchId() {
		return this.searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public int getBauImpId() {
		return this.bauImpId;
	}

	public void setBauImpId(int bauImpId) {
		this.bauImpId = bauImpId;
	}

	public int getBauId() {
		return this.bauId;
	}

	public void setBauId(int bauId) {
		this.bauId = bauId;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilterResBauId))
			return false;
		FilterResBauId castOther = (FilterResBauId) other;

		return (this.getSearchId() == castOther.getSearchId())
				&& (this.getBauImpId() == castOther.getBauImpId())
				&& (this.getBauId() == castOther.getBauId())
				&& (this.getCol() == castOther.getCol());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSearchId();
		result = 37 * result + this.getBauImpId();
		result = 37 * result + this.getBauId();
		result = 37 * result + this.getCol();
		return result;
	}

}
