package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * SysExportBau generated by hbm2java
 */
public class SysExportBau implements java.io.Serializable {

	private SysExportBauId id;
	private Date timestamp;
	private SysExport sysExport;

	public SysExportBau() {
	}

	public SysExportBau(SysExportBauId id, SysExport sysExport) {
		this.id = id;
		this.sysExport = sysExport;
	}

	public SysExportBauId getId() {
		return this.id;
	}

	public void setId(SysExportBauId id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public SysExport getSysExport() {
		return this.sysExport;
	}

	public void setSysExport(SysExport sysExport) {
		this.sysExport = sysExport;
	}

}
