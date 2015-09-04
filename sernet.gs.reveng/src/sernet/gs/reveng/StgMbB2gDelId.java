package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StgMbB2gDelId generated by hbm2java
 */
public class StgMbB2gDelId implements java.io.Serializable {

	private Integer impId;
	private Integer bauImpId;
	private Integer bauId;
	private Integer gefImpId;
	private Integer gefId;
	private Integer usn;
	private String guid;
	private String guidOrg;
	private Date erstelltAm;
	private String erstelltDurch;

	public StgMbB2gDelId() {
	}

	public StgMbB2gDelId(String erstelltDurch) {
		this.erstelltDurch = erstelltDurch;
	}

	public StgMbB2gDelId(Integer impId, Integer bauImpId, Integer bauId,
			Integer gefImpId, Integer gefId, Integer usn, String guid,
			String guidOrg, Date erstelltAm, String erstelltDurch) {
		this.impId = impId;
		this.bauImpId = bauImpId;
		this.bauId = bauId;
		this.gefImpId = gefImpId;
		this.gefId = gefId;
		this.usn = usn;
		this.guid = guid;
		this.guidOrg = guidOrg;
		this.erstelltAm = erstelltAm;
		this.erstelltDurch = erstelltDurch;
	}

	public Integer getImpId() {
		return this.impId;
	}

	public void setImpId(Integer impId) {
		this.impId = impId;
	}

	public Integer getBauImpId() {
		return this.bauImpId;
	}

	public void setBauImpId(Integer bauImpId) {
		this.bauImpId = bauImpId;
	}

	public Integer getBauId() {
		return this.bauId;
	}

	public void setBauId(Integer bauId) {
		this.bauId = bauId;
	}

	public Integer getGefImpId() {
		return this.gefImpId;
	}

	public void setGefImpId(Integer gefImpId) {
		this.gefImpId = gefImpId;
	}

	public Integer getGefId() {
		return this.gefId;
	}

	public void setGefId(Integer gefId) {
		this.gefId = gefId;
	}

	public Integer getUsn() {
		return this.usn;
	}

	public void setUsn(Integer usn) {
		this.usn = usn;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuidOrg() {
		return this.guidOrg;
	}

	public void setGuidOrg(String guidOrg) {
		this.guidOrg = guidOrg;
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
		if (!(other instanceof StgMbB2gDelId))
			return false;
		StgMbB2gDelId castOther = (StgMbB2gDelId) other;

		return ((this.getImpId() == castOther.getImpId()) || (this.getImpId() != null
				&& castOther.getImpId() != null && this.getImpId().equals(
				castOther.getImpId())))
				&& ((this.getBauImpId() == castOther.getBauImpId()) || (this
						.getBauImpId() != null
						&& castOther.getBauImpId() != null && this
						.getBauImpId().equals(castOther.getBauImpId())))
				&& ((this.getBauId() == castOther.getBauId()) || (this
						.getBauId() != null && castOther.getBauId() != null && this
						.getBauId().equals(castOther.getBauId())))
				&& ((this.getGefImpId() == castOther.getGefImpId()) || (this
						.getGefImpId() != null
						&& castOther.getGefImpId() != null && this
						.getGefImpId().equals(castOther.getGefImpId())))
				&& ((this.getGefId() == castOther.getGefId()) || (this
						.getGefId() != null && castOther.getGefId() != null && this
						.getGefId().equals(castOther.getGefId())))
				&& ((this.getUsn() == castOther.getUsn()) || (this.getUsn() != null
						&& castOther.getUsn() != null && this.getUsn().equals(
						castOther.getUsn())))
				&& ((this.getGuid() == castOther.getGuid()) || (this.getGuid() != null
						&& castOther.getGuid() != null && this.getGuid()
						.equals(castOther.getGuid())))
				&& ((this.getGuidOrg() == castOther.getGuidOrg()) || (this
						.getGuidOrg() != null && castOther.getGuidOrg() != null && this
						.getGuidOrg().equals(castOther.getGuidOrg())))
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
				+ (getImpId() == null ? 0 : this.getImpId().hashCode());
		result = 37 * result
				+ (getBauImpId() == null ? 0 : this.getBauImpId().hashCode());
		result = 37 * result
				+ (getBauId() == null ? 0 : this.getBauId().hashCode());
		result = 37 * result
				+ (getGefImpId() == null ? 0 : this.getGefImpId().hashCode());
		result = 37 * result
				+ (getGefId() == null ? 0 : this.getGefId().hashCode());
		result = 37 * result
				+ (getUsn() == null ? 0 : this.getUsn().hashCode());
		result = 37 * result
				+ (getGuid() == null ? 0 : this.getGuid().hashCode());
		result = 37 * result
				+ (getGuidOrg() == null ? 0 : this.getGuidOrg().hashCode());
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
