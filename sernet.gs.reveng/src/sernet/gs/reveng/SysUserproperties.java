package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * SysUserproperties generated by hbm2java
 */
public class SysUserproperties implements java.io.Serializable {

	private SysUserpropertiesId id;
	private RechteAnwender rechteAnwender;
	private Integer propLong;
	private String propVarc;
	private Boolean propDefault;
	private Boolean registry;
	private String kommentar;
	private Short versionMajor;
	private Short versionMinor;
	private String guid;
	private Date erstelltAm;
	private String erstelltDurch;

	public SysUserproperties() {
	}

	public SysUserproperties(SysUserpropertiesId id,
			RechteAnwender rechteAnwender) {
		this.id = id;
		this.rechteAnwender = rechteAnwender;
	}

	public SysUserproperties(SysUserpropertiesId id,
			RechteAnwender rechteAnwender, Integer propLong, String propVarc,
			Boolean propDefault, Boolean registry, String kommentar,
			Short versionMajor, Short versionMinor, String guid,
			Date erstelltAm, String erstelltDurch) {
		this.id = id;
		this.rechteAnwender = rechteAnwender;
		this.propLong = propLong;
		this.propVarc = propVarc;
		this.propDefault = propDefault;
		this.registry = registry;
		this.kommentar = kommentar;
		this.versionMajor = versionMajor;
		this.versionMinor = versionMinor;
		this.guid = guid;
		this.erstelltAm = erstelltAm;
		this.erstelltDurch = erstelltDurch;
	}

	public SysUserpropertiesId getId() {
		return this.id;
	}

	public void setId(SysUserpropertiesId id) {
		this.id = id;
	}

	public RechteAnwender getRechteAnwender() {
		return this.rechteAnwender;
	}

	public void setRechteAnwender(RechteAnwender rechteAnwender) {
		this.rechteAnwender = rechteAnwender;
	}

	public Integer getPropLong() {
		return this.propLong;
	}

	public void setPropLong(Integer propLong) {
		this.propLong = propLong;
	}

	public String getPropVarc() {
		return this.propVarc;
	}

	public void setPropVarc(String propVarc) {
		this.propVarc = propVarc;
	}

	public Boolean getPropDefault() {
		return this.propDefault;
	}

	public void setPropDefault(Boolean propDefault) {
		this.propDefault = propDefault;
	}

	public Boolean getRegistry() {
		return this.registry;
	}

	public void setRegistry(Boolean registry) {
		this.registry = registry;
	}

	public String getKommentar() {
		return this.kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Short getVersionMajor() {
		return this.versionMajor;
	}

	public void setVersionMajor(Short versionMajor) {
		this.versionMajor = versionMajor;
	}

	public Short getVersionMinor() {
		return this.versionMinor;
	}

	public void setVersionMinor(Short versionMinor) {
		this.versionMinor = versionMinor;
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

}
