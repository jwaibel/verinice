package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StgMbMassPhaseTxtId generated by hbm2java
 */
public class StgMbMassPhaseTxtId implements java.io.Serializable {

	private Integer phaId;
	private Integer phaImpId;
	private Short sprId;
	private String masTyp;
	private String name;
	private String beschreibung;
	private String guid;
	private Date timestamp;
	private String guidOrg;

	public StgMbMassPhaseTxtId() {
	}

	public StgMbMassPhaseTxtId(Integer phaId, Integer phaImpId, Short sprId,
			String masTyp, String name, String beschreibung, String guid,
			Date timestamp, String guidOrg) {
		this.phaId = phaId;
		this.phaImpId = phaImpId;
		this.sprId = sprId;
		this.masTyp = masTyp;
		this.name = name;
		this.beschreibung = beschreibung;
		this.guid = guid;
		this.timestamp = timestamp;
		this.guidOrg = guidOrg;
	}

	public Integer getPhaId() {
		return this.phaId;
	}

	public void setPhaId(Integer phaId) {
		this.phaId = phaId;
	}

	public Integer getPhaImpId() {
		return this.phaImpId;
	}

	public void setPhaImpId(Integer phaImpId) {
		this.phaImpId = phaImpId;
	}

	public Short getSprId() {
		return this.sprId;
	}

	public void setSprId(Short sprId) {
		this.sprId = sprId;
	}

	public String getMasTyp() {
		return this.masTyp;
	}

	public void setMasTyp(String masTyp) {
		this.masTyp = masTyp;
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

	public String getGuidOrg() {
		return this.guidOrg;
	}

	public void setGuidOrg(String guidOrg) {
		this.guidOrg = guidOrg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgMbMassPhaseTxtId))
			return false;
		StgMbMassPhaseTxtId castOther = (StgMbMassPhaseTxtId) other;

		return ((this.getPhaId() == castOther.getPhaId()) || (this.getPhaId() != null
				&& castOther.getPhaId() != null && this.getPhaId().equals(
				castOther.getPhaId())))
				&& ((this.getPhaImpId() == castOther.getPhaImpId()) || (this
						.getPhaImpId() != null
						&& castOther.getPhaImpId() != null && this
						.getPhaImpId().equals(castOther.getPhaImpId())))
				&& ((this.getSprId() == castOther.getSprId()) || (this
						.getSprId() != null && castOther.getSprId() != null && this
						.getSprId().equals(castOther.getSprId())))
				&& ((this.getMasTyp() == castOther.getMasTyp()) || (this
						.getMasTyp() != null && castOther.getMasTyp() != null && this
						.getMasTyp().equals(castOther.getMasTyp())))
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
						.getTimestamp().equals(castOther.getTimestamp())))
				&& ((this.getGuidOrg() == castOther.getGuidOrg()) || (this
						.getGuidOrg() != null && castOther.getGuidOrg() != null && this
						.getGuidOrg().equals(castOther.getGuidOrg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPhaId() == null ? 0 : this.getPhaId().hashCode());
		result = 37 * result
				+ (getPhaImpId() == null ? 0 : this.getPhaImpId().hashCode());
		result = 37 * result
				+ (getSprId() == null ? 0 : this.getSprId().hashCode());
		result = 37 * result
				+ (getMasTyp() == null ? 0 : this.getMasTyp().hashCode());
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
		result = 37 * result
				+ (getGuidOrg() == null ? 0 : this.getGuidOrg().hashCode());
		return result;
	}

}
