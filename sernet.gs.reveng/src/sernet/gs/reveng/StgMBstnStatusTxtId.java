package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StgMBstnStatusTxtId generated by hbm2java
 */
public class StgMBstnStatusTxtId implements java.io.Serializable {

	private Byte bstId;
	private Short sprId;
	private String name;
	private String beschreibung;
	private String guid;
	private Date timestamp;

	public StgMBstnStatusTxtId() {
	}

	public StgMBstnStatusTxtId(Byte bstId, Short sprId, String name,
			String beschreibung, String guid, Date timestamp) {
		this.bstId = bstId;
		this.sprId = sprId;
		this.name = name;
		this.beschreibung = beschreibung;
		this.guid = guid;
		this.timestamp = timestamp;
	}

	public Byte getBstId() {
		return this.bstId;
	}

	public void setBstId(Byte bstId) {
		this.bstId = bstId;
	}

	public Short getSprId() {
		return this.sprId;
	}

	public void setSprId(Short sprId) {
		this.sprId = sprId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgMBstnStatusTxtId))
			return false;
		StgMBstnStatusTxtId castOther = (StgMBstnStatusTxtId) other;

		return ((this.getBstId() == castOther.getBstId()) || (this.getBstId() != null
				&& castOther.getBstId() != null && this.getBstId().equals(
				castOther.getBstId())))
				&& ((this.getSprId() == castOther.getSprId()) || (this
						.getSprId() != null && castOther.getSprId() != null && this
						.getSprId().equals(castOther.getSprId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getBeschreibung() == castOther.getBeschreibung()) || (this
						.getBeschreibung() != null
						&& castOther.getBeschreibung() != null && this
						.getBeschreibung().equals(castOther.getBeschreibung())))
				&& ((this.getGuid() == castOther.getGuid()) || (this.getGuid() != null
						&& castOther.getGuid() != null && this.getGuid()
						.equals(castOther.getGuid())))
				&& ((this.getTimestamp() == castOther.getTimestamp()) || (this
						.getTimestamp() != null
						&& castOther.getTimestamp() != null && this
						.getTimestamp().equals(castOther.getTimestamp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBstId() == null ? 0 : this.getBstId().hashCode());
		result = 37 * result
				+ (getSprId() == null ? 0 : this.getSprId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getBeschreibung() == null ? 0 : this.getBeschreibung()
						.hashCode());
		result = 37 * result
				+ (getGuid() == null ? 0 : this.getGuid().hashCode());
		result = 37 * result
				+ (getTimestamp() == null ? 0 : this.getTimestamp().hashCode());
		return result;
	}

}
