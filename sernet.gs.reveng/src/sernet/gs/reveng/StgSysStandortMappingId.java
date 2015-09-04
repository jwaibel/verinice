package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * StgSysStandortMappingId generated by hbm2java
 */
public class StgSysStandortMappingId implements java.io.Serializable {

	private String alteId;
	private int neueId;

	public StgSysStandortMappingId() {
	}

	public StgSysStandortMappingId(String alteId, int neueId) {
		this.alteId = alteId;
		this.neueId = neueId;
	}

	public String getAlteId() {
		return this.alteId;
	}

	public void setAlteId(String alteId) {
		this.alteId = alteId;
	}

	public int getNeueId() {
		return this.neueId;
	}

	public void setNeueId(int neueId) {
		this.neueId = neueId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgSysStandortMappingId))
			return false;
		StgSysStandortMappingId castOther = (StgSysStandortMappingId) other;

		return ((this.getAlteId() == castOther.getAlteId()) || (this
				.getAlteId() != null && castOther.getAlteId() != null && this
				.getAlteId().equals(castOther.getAlteId())))
				&& (this.getNeueId() == castOther.getNeueId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAlteId() == null ? 0 : this.getAlteId().hashCode());
		result = 37 * result + this.getNeueId();
		return result;
	}

}
