package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StgMsUnjTxtId generated by hbm2java
 */
public class StgMsUnjTxtId implements java.io.Serializable {

	private Byte unjId;
	private Short sprId;
	private String name1;
	private String name2;
	private String guid;
	private Date erstelltAm;
	private String erstelltDurch;

	public StgMsUnjTxtId() {
	}

	public StgMsUnjTxtId(Byte unjId, Short sprId, String name1, String name2,
			String guid, Date erstelltAm, String erstelltDurch) {
		this.unjId = unjId;
		this.sprId = sprId;
		this.name1 = name1;
		this.name2 = name2;
		this.guid = guid;
		this.erstelltAm = erstelltAm;
		this.erstelltDurch = erstelltDurch;
	}

	public Byte getUnjId() {
		return this.unjId;
	}

	public void setUnjId(Byte unjId) {
		this.unjId = unjId;
	}

	public Short getSprId() {
		return this.sprId;
	}

	public void setSprId(Short sprId) {
		this.sprId = sprId;
	}

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getErstelltAm() {
		return this.erstelltAm;
	}

	public void setErstelltAm(Date erstelltAm) {
		this.erstelltAm = erstelltAm;
	}

	public String getErstelltDurch() {
		return this.erstelltDurch;
	}

	public void setErstelltDurch(String erstelltDurch) {
		this.erstelltDurch = erstelltDurch;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgMsUnjTxtId))
			return false;
		StgMsUnjTxtId castOther = (StgMsUnjTxtId) other;

		return ((this.getUnjId() == castOther.getUnjId()) || (this.getUnjId() != null
				&& castOther.getUnjId() != null && this.getUnjId().equals(
				castOther.getUnjId())))
				&& ((this.getSprId() == castOther.getSprId()) || (this
						.getSprId() != null && castOther.getSprId() != null && this
						.getSprId().equals(castOther.getSprId())))
				&& ((this.getName1() == castOther.getName1()) || (this
						.getName1() != null && castOther.getName1() != null && this
						.getName1().equals(castOther.getName1())))
				&& ((this.getName2() == castOther.getName2()) || (this
						.getName2() != null && castOther.getName2() != null && this
						.getName2().equals(castOther.getName2())))
				&& ((this.getGuid() == castOther.getGuid()) || (this.getGuid() != null
						&& castOther.getGuid() != null && this.getGuid()
						.equals(castOther.getGuid())))
				&& ((this.getErstelltAm() == castOther.getErstelltAm()) || (this
						.getErstelltAm() != null
						&& castOther.getErstelltAm() != null && this
						.getErstelltAm().equals(castOther.getErstelltAm())))
				&& ((this.getErstelltDurch() == castOther.getErstelltDurch()) || (this
						.getErstelltDurch() != null
						&& castOther.getErstelltDurch() != null && this
						.getErstelltDurch()
						.equals(castOther.getErstelltDurch())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUnjId() == null ? 0 : this.getUnjId().hashCode());
		result = 37 * result
				+ (getSprId() == null ? 0 : this.getSprId().hashCode());
		result = 37 * result
				+ (getName1() == null ? 0 : this.getName1().hashCode());
		result = 37 * result
				+ (getName2() == null ? 0 : this.getName2().hashCode());
		result = 37 * result
				+ (getGuid() == null ? 0 : this.getGuid().hashCode());
		result = 37
				* result
				+ (getErstelltAm() == null ? 0 : this.getErstelltAm()
						.hashCode());
		result = 37
				* result
				+ (getErstelltDurch() == null ? 0 : this.getErstelltDurch()
						.hashCode());
		return result;
	}

}
