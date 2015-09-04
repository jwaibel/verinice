package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * StgG20ZosMappingId generated by hbm2java
 */
public class StgG20ZosMappingId implements java.io.Serializable {

	private int alteId;
	private Integer neueId;

	public StgG20ZosMappingId() {
	}

	public StgG20ZosMappingId(int alteId) {
		this.alteId = alteId;
	}

	public StgG20ZosMappingId(int alteId, Integer neueId) {
		this.alteId = alteId;
		this.neueId = neueId;
	}

	public int getAlteId() {
		return this.alteId;
	}

	public void setAlteId(int alteId) {
		this.alteId = alteId;
	}

	public Integer getNeueId() {
		return this.neueId;
	}

	public void setNeueId(Integer neueId) {
		this.neueId = neueId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgG20ZosMappingId))
			return false;
		StgG20ZosMappingId castOther = (StgG20ZosMappingId) other;

		return (this.getAlteId() == castOther.getAlteId())
				&& ((this.getNeueId() == castOther.getNeueId()) || (this
						.getNeueId() != null && castOther.getNeueId() != null && this
						.getNeueId().equals(castOther.getNeueId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getAlteId();
		result = 37 * result
				+ (getNeueId() == null ? 0 : this.getNeueId().hashCode());
		return result;
	}

}
