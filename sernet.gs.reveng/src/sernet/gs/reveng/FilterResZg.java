package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * FilterResZg generated by hbm2java
 */
public class FilterResZg implements java.io.Serializable {

	private FilterResZgId id;
	private byte spid;

	public FilterResZg() {
	}

	public FilterResZg(FilterResZgId id, byte spid) {
		this.id = id;
		this.spid = spid;
	}

	public FilterResZgId getId() {
		return this.id;
	}

	public void setId(FilterResZgId id) {
		this.id = id;
	}

	public byte getSpid() {
		return this.spid;
	}

	public void setSpid(byte spid) {
		this.spid = spid;
	}

}
