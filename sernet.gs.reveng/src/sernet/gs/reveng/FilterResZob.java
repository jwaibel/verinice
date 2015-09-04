package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

/**
 * FilterResZob generated by hbm2java
 */
public class FilterResZob implements java.io.Serializable {

	private FilterResZobId id;
	private short spid;
	private int zotId;
	private byte recht;
	private String orderStr1;
	private String orderStr2;
	private String orderStr3;
	private byte rechtBau;

	public FilterResZob() {
	}

	public FilterResZob(FilterResZobId id, short spid, int zotId, byte recht,
			byte rechtBau) {
		this.id = id;
		this.spid = spid;
		this.zotId = zotId;
		this.recht = recht;
		this.rechtBau = rechtBau;
	}

	public FilterResZob(FilterResZobId id, short spid, int zotId, byte recht,
			String orderStr1, String orderStr2, String orderStr3, byte rechtBau) {
		this.id = id;
		this.spid = spid;
		this.zotId = zotId;
		this.recht = recht;
		this.orderStr1 = orderStr1;
		this.orderStr2 = orderStr2;
		this.orderStr3 = orderStr3;
		this.rechtBau = rechtBau;
	}

	public FilterResZobId getId() {
		return this.id;
	}

	public void setId(FilterResZobId id) {
		this.id = id;
	}

	public short getSpid() {
		return this.spid;
	}

	public void setSpid(short spid) {
		this.spid = spid;
	}

	public int getZotId() {
		return this.zotId;
	}

	public void setZotId(int zotId) {
		this.zotId = zotId;
	}

	public byte getRecht() {
		return this.recht;
	}

	public void setRecht(byte recht) {
		this.recht = recht;
	}

	public String getOrderStr1() {
		return this.orderStr1;
	}

	public void setOrderStr1(String orderStr1) {
		this.orderStr1 = orderStr1;
	}

	public String getOrderStr2() {
		return this.orderStr2;
	}

	public void setOrderStr2(String orderStr2) {
		this.orderStr2 = orderStr2;
	}

	public String getOrderStr3() {
		return this.orderStr3;
	}

	public void setOrderStr3(String orderStr3) {
		this.orderStr3 = orderStr3;
	}

	public byte getRechtBau() {
		return this.rechtBau;
	}

	public void setRechtBau(byte rechtBau) {
		this.rechtBau = rechtBau;
	}

}
