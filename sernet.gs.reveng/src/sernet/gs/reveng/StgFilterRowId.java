package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * StgFilterRowId generated by hbm2java
 */
public class StgFilterRowId implements java.io.Serializable {

	private Integer fltId;
	private Byte rowId;
	private String sucheId;
	private Integer fflId;
	private String orderBy;

	public StgFilterRowId() {
	}

	public StgFilterRowId(Integer fltId, Byte rowId, String sucheId,
			Integer fflId, String orderBy) {
		this.fltId = fltId;
		this.rowId = rowId;
		this.sucheId = sucheId;
		this.fflId = fflId;
		this.orderBy = orderBy;
	}

	public Integer getFltId() {
		return this.fltId;
	}

	public void setFltId(Integer fltId) {
		this.fltId = fltId;
	}

	public Byte getRowId() {
		return this.rowId;
	}

	public void setRowId(Byte rowId) {
		this.rowId = rowId;
	}

	public String getSucheId() {
		return this.sucheId;
	}

	public void setSucheId(String sucheId) {
		this.sucheId = sucheId;
	}

	public Integer getFflId() {
		return this.fflId;
	}

	public void setFflId(Integer fflId) {
		this.fflId = fflId;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgFilterRowId))
			return false;
		StgFilterRowId castOther = (StgFilterRowId) other;

		return ((this.getFltId() == castOther.getFltId()) || (this.getFltId() != null
				&& castOther.getFltId() != null && this.getFltId().equals(
				castOther.getFltId())))
				&& ((this.getRowId() == castOther.getRowId()) || (this
						.getRowId() != null && castOther.getRowId() != null && this
						.getRowId().equals(castOther.getRowId())))
				&& ((this.getSucheId() == castOther.getSucheId()) || (this
						.getSucheId() != null && castOther.getSucheId() != null && this
						.getSucheId().equals(castOther.getSucheId())))
				&& ((this.getFflId() == castOther.getFflId()) || (this
						.getFflId() != null && castOther.getFflId() != null && this
						.getFflId().equals(castOther.getFflId())))
				&& ((this.getOrderBy() == castOther.getOrderBy()) || (this
						.getOrderBy() != null && castOther.getOrderBy() != null && this
						.getOrderBy().equals(castOther.getOrderBy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFltId() == null ? 0 : this.getFltId().hashCode());
		result = 37 * result
				+ (getRowId() == null ? 0 : this.getRowId().hashCode());
		result = 37 * result
				+ (getSucheId() == null ? 0 : this.getSucheId().hashCode());
		result = 37 * result
				+ (getFflId() == null ? 0 : this.getFflId().hashCode());
		result = 37 * result
				+ (getOrderBy() == null ? 0 : this.getOrderBy().hashCode());
		return result;
	}

}
