package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * BrFilter generated by hbm2java
 */
public class BrFilter implements java.io.Serializable {

	private BrFilterId id;
	private BrBericht brBericht;

	public BrFilter() {
	}

	public BrFilter(BrFilterId id, BrBericht brBericht) {
		this.id = id;
		this.brBericht = brBericht;
	}

	public BrFilterId getId() {
		return this.id;
	}

	public void setId(BrFilterId id) {
		this.id = id;
	}

	public BrBericht getBrBericht() {
		return this.brBericht;
	}

	public void setBrBericht(BrBericht brBericht) {
		this.brBericht = brBericht;
	}

}
