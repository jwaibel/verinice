package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * StgG20BstId generated by hbm2java
 */
public class StgG20BstId implements java.io.Serializable {

	private String nr;
	private String name;
	private String htxt;
	private String typ;
	private Integer sortnr;
	private Integer importflag;

	public StgG20BstId() {
	}

	public StgG20BstId(String nr) {
		this.nr = nr;
	}

	public StgG20BstId(String nr, String name, String htxt, String typ,
			Integer sortnr, Integer importflag) {
		this.nr = nr;
		this.name = name;
		this.htxt = htxt;
		this.typ = typ;
		this.sortnr = sortnr;
		this.importflag = importflag;
	}

	public String getNr() {
		return this.nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHtxt() {
		return this.htxt;
	}

	public void setHtxt(String htxt) {
		this.htxt = htxt;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Integer getSortnr() {
		return this.sortnr;
	}

	public void setSortnr(Integer sortnr) {
		this.sortnr = sortnr;
	}

	public Integer getImportflag() {
		return this.importflag;
	}

	public void setImportflag(Integer importflag) {
		this.importflag = importflag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgG20BstId))
			return false;
		StgG20BstId castOther = (StgG20BstId) other;

		return ((this.getNr() == castOther.getNr()) || (this.getNr() != null
				&& castOther.getNr() != null && this.getNr().equals(
				castOther.getNr())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getHtxt() == castOther.getHtxt()) || (this.getHtxt() != null
						&& castOther.getHtxt() != null && this.getHtxt()
						.equals(castOther.getHtxt())))
				&& ((this.getTyp() == castOther.getTyp()) || (this.getTyp() != null
						&& castOther.getTyp() != null && this.getTyp().equals(
						castOther.getTyp())))
				&& ((this.getSortnr() == castOther.getSortnr()) || (this
						.getSortnr() != null && castOther.getSortnr() != null && this
						.getSortnr().equals(castOther.getSortnr())))
				&& ((this.getImportflag() == castOther.getImportflag()) || (this
						.getImportflag() != null
						&& castOther.getImportflag() != null && this
						.getImportflag().equals(castOther.getImportflag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNr() == null ? 0 : this.getNr().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getHtxt() == null ? 0 : this.getHtxt().hashCode());
		result = 37 * result
				+ (getTyp() == null ? 0 : this.getTyp().hashCode());
		result = 37 * result
				+ (getSortnr() == null ? 0 : this.getSortnr().hashCode());
		result = 37
				* result
				+ (getImportflag() == null ? 0 : this.getImportflag()
						.hashCode());
		return result;
	}

}
