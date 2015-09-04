package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * SysExportBauId generated by hbm2java
 */
public class SysExportBauId implements java.io.Serializable {

	private int expId;
	private int bauImpId;
	private int bauId;

	public SysExportBauId() {
	}

	public SysExportBauId(int expId, int bauImpId, int bauId) {
		this.expId = expId;
		this.bauImpId = bauImpId;
		this.bauId = bauId;
	}

	public int getExpId() {
		return this.expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysExportBauId))
			return false;
		SysExportBauId castOther = (SysExportBauId) other;

		return (this.getExpId() == castOther.getExpId())
				&& (this.getBauImpId() == castOther.getBauImpId())
				&& (this.getBauId() == castOther.getBauId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getExpId();
		result = 37 * result + this.getBauImpId();
		result = 37 * result + this.getBauId();
		return result;
	}

}
