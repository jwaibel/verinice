package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * StgG20MasMappingId generated by hbm2java
 */
public class StgG20MasMappingId implements java.io.Serializable {

	private String alteId;
	private int masId;
	private int masImpId;

	public StgG20MasMappingId() {
	}

	public StgG20MasMappingId(String alteId, int masId, int masImpId) {
		this.alteId = alteId;
		this.masId = masId;
		this.masImpId = masImpId;
	}

	public String getAlteId() {
		return this.alteId;
	}

	public void setAlteId(String alteId) {
		this.alteId = alteId;
	}

	public int getMasId() {
		return this.masId;
	}

	public void setMasId(int masId) {
		this.masId = masId;
	}

	public int getMasImpId() {
		return this.masImpId;
	}

	public void setMasImpId(int masImpId) {
		this.masImpId = masImpId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgG20MasMappingId))
			return false;
		StgG20MasMappingId castOther = (StgG20MasMappingId) other;

		return ((this.getAlteId() == castOther.getAlteId()) || (this
				.getAlteId() != null && castOther.getAlteId() != null && this
				.getAlteId().equals(castOther.getAlteId())))
				&& (this.getMasId() == castOther.getMasId())
				&& (this.getMasImpId() == castOther.getMasImpId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAlteId() == null ? 0 : this.getAlteId().hashCode());
		result = 37 * result + this.getMasId();
		result = 37 * result + this.getMasImpId();
		return result;
	}

}
