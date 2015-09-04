package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.sql.Clob;
import java.util.Date;

/**
 * StgMbZielobjTypTxtId generated by hbm2java
 */
public class StgMbZielobjTypTxtId implements java.io.Serializable {

	private Integer zotId;
	private Integer zotImpId;
	private Short sprId;
	private String name;
	private String name2;
	private Clob beschreibung;
	private Clob htmltext;
	private String guid;
	private Date timestamp;
	private String guidOrg;
	private String abstract_;
	private String changedBy;
	private Date changedOn;

	public StgMbZielobjTypTxtId() {
	}

	public StgMbZielobjTypTxtId(Integer zotId, Integer zotImpId, Short sprId,
			String name, String name2, Clob beschreibung, Clob htmltext,
			String guid, Date timestamp, String guidOrg, String abstract_,
			String changedBy, Date changedOn) {
		this.zotId = zotId;
		this.zotImpId = zotImpId;
		this.sprId = sprId;
		this.name = name;
		this.name2 = name2;
		this.beschreibung = beschreibung;
		this.htmltext = htmltext;
		this.guid = guid;
		this.timestamp = timestamp;
		this.guidOrg = guidOrg;
		this.abstract_ = abstract_;
		this.changedBy = changedBy;
		this.changedOn = changedOn;
	}

	public Integer getZotId() {
		return this.zotId;
	}

	public void setZotId(Integer zotId) {
		this.zotId = zotId;
	}

	public Integer getZotImpId() {
		return this.zotImpId;
	}

	public void setZotImpId(Integer zotImpId) {
		this.zotImpId = zotImpId;
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

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public Clob getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(Clob beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Clob getHtmltext() {
		return this.htmltext;
	}

	public void setHtmltext(Clob htmltext) {
		this.htmltext = htmltext;
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

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedOn() {
		return this.changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgMbZielobjTypTxtId))
			return false;
		StgMbZielobjTypTxtId castOther = (StgMbZielobjTypTxtId) other;

		return ((this.getZotId() == castOther.getZotId()) || (this.getZotId() != null
				&& castOther.getZotId() != null && this.getZotId().equals(
				castOther.getZotId())))
				&& ((this.getZotImpId() == castOther.getZotImpId()) || (this
						.getZotImpId() != null
						&& castOther.getZotImpId() != null && this
						.getZotImpId().equals(castOther.getZotImpId())))
				&& ((this.getSprId() == castOther.getSprId()) || (this
						.getSprId() != null && castOther.getSprId() != null && this
						.getSprId().equals(castOther.getSprId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getName2() == castOther.getName2()) || (this
						.getName2() != null && castOther.getName2() != null && this
						.getName2().equals(castOther.getName2())))
				&& ((this.getBeschreibung() == castOther.getBeschreibung()) || (this
						.getBeschreibung() != null
						&& castOther.getBeschreibung() != null && this
						.getBeschreibung().equals(castOther.getBeschreibung())))
				&& ((this.getHtmltext() == castOther.getHtmltext()) || (this
						.getHtmltext() != null
						&& castOther.getHtmltext() != null && this
						.getHtmltext().equals(castOther.getHtmltext())))
				&& ((this.getGuid() == castOther.getGuid()) || (this.getGuid() != null
						&& castOther.getGuid() != null && this.getGuid()
						.equals(castOther.getGuid())))
				&& ((this.getTimestamp() == castOther.getTimestamp()) || (this
						.getTimestamp() != null
						&& castOther.getTimestamp() != null && this
						.getTimestamp().equals(castOther.getTimestamp())))
				&& ((this.getGuidOrg() == castOther.getGuidOrg()) || (this
						.getGuidOrg() != null && castOther.getGuidOrg() != null && this
						.getGuidOrg().equals(castOther.getGuidOrg())))
				&& ((this.getAbstract_() == castOther.getAbstract_()) || (this
						.getAbstract_() != null
						&& castOther.getAbstract_() != null && this
						.getAbstract_().equals(castOther.getAbstract_())))
				&& ((this.getChangedBy() == castOther.getChangedBy()) || (this
						.getChangedBy() != null
						&& castOther.getChangedBy() != null && this
						.getChangedBy().equals(castOther.getChangedBy())))
				&& ((this.getChangedOn() == castOther.getChangedOn()) || (this
						.getChangedOn() != null
						&& castOther.getChangedOn() != null && this
						.getChangedOn().equals(castOther.getChangedOn())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getZotId() == null ? 0 : this.getZotId().hashCode());
		result = 37 * result
				+ (getZotImpId() == null ? 0 : this.getZotImpId().hashCode());
		result = 37 * result
				+ (getSprId() == null ? 0 : this.getSprId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getName2() == null ? 0 : this.getName2().hashCode());
		result = 37
				* result
				+ (getBeschreibung() == null ? 0 : this.getBeschreibung()
						.hashCode());
		result = 37 * result
				+ (getHtmltext() == null ? 0 : this.getHtmltext().hashCode());
		result = 37 * result
				+ (getGuid() == null ? 0 : this.getGuid().hashCode());
		result = 37 * result
				+ (getTimestamp() == null ? 0 : this.getTimestamp().hashCode());
		result = 37 * result
				+ (getGuidOrg() == null ? 0 : this.getGuidOrg().hashCode());
		result = 37 * result
				+ (getAbstract_() == null ? 0 : this.getAbstract_().hashCode());
		result = 37 * result
				+ (getChangedBy() == null ? 0 : this.getChangedBy().hashCode());
		result = 37 * result
				+ (getChangedOn() == null ? 0 : this.getChangedOn().hashCode());
		return result;
	}

}
