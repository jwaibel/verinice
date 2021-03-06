package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MbBaustMassnGsiegel generated by hbm2java
 */
public class MbBaustMassnGsiegel implements java.io.Serializable {

	private MbBaustMassnGsiegelId id;
	private Date timestamp;
	private MbMassn mbMassn;
	private MsZyk msZyk;
	private MbBaust mbBaust;
	private MGsiegel MGsiegel;
	private MMetastatus MMetastatus;
	private Integer prio;
	private Boolean opt;
	private Integer reihenfolge;
	private int metaVers;
	private Integer obsoletVers;
	private String guid;
	private Date loeschDatum;
	private Byte impNeu;
	private String erfasstDurch;
	private String geloeschtDurch;
	private Integer usn;
	private String guidOrg;
	private Set mbBaustMassnGsiegelTxts = new HashSet(0);
	private Set mbPrioritaets = new HashSet(0);
	private Set mbB2mDels = new HashSet(0);

	public MbBaustMassnGsiegel() {
	}

	public MbBaustMassnGsiegel(MbBaustMassnGsiegelId id, MbMassn mbMassn,
			MsZyk msZyk, MbBaust mbBaust, MGsiegel MGsiegel,
			MMetastatus MMetastatus, int metaVers, String guid) {
		this.id = id;
		this.mbMassn = mbMassn;
		this.msZyk = msZyk;
		this.mbBaust = mbBaust;
		this.MGsiegel = MGsiegel;
		this.MMetastatus = MMetastatus;
		this.metaVers = metaVers;
		this.guid = guid;
	}

	public MbBaustMassnGsiegel(MbBaustMassnGsiegelId id, MbMassn mbMassn,
			MsZyk msZyk, MbBaust mbBaust, MGsiegel MGsiegel,
			MMetastatus MMetastatus, Integer prio, Boolean opt,
			Integer reihenfolge, int metaVers, Integer obsoletVers,
			String guid, Date loeschDatum, Byte impNeu, String erfasstDurch,
			String geloeschtDurch, Integer usn, String guidOrg,
			Set mbBaustMassnGsiegelTxts, Set mbPrioritaets, Set mbB2mDels) {
		this.id = id;
		this.mbMassn = mbMassn;
		this.msZyk = msZyk;
		this.mbBaust = mbBaust;
		this.MGsiegel = MGsiegel;
		this.MMetastatus = MMetastatus;
		this.prio = prio;
		this.opt = opt;
		this.reihenfolge = reihenfolge;
		this.metaVers = metaVers;
		this.obsoletVers = obsoletVers;
		this.guid = guid;
		this.loeschDatum = loeschDatum;
		this.impNeu = impNeu;
		this.erfasstDurch = erfasstDurch;
		this.geloeschtDurch = geloeschtDurch;
		this.usn = usn;
		this.guidOrg = guidOrg;
		this.mbBaustMassnGsiegelTxts = mbBaustMassnGsiegelTxts;
		this.mbPrioritaets = mbPrioritaets;
		this.mbB2mDels = mbB2mDels;
	}

	public MbBaustMassnGsiegelId getId() {
		return this.id;
	}

	public void setId(MbBaustMassnGsiegelId id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public MbMassn getMbMassn() {
		return this.mbMassn;
	}

	public void setMbMassn(MbMassn mbMassn) {
		this.mbMassn = mbMassn;
	}

	public MsZyk getMsZyk() {
		return this.msZyk;
	}

	public void setMsZyk(MsZyk msZyk) {
		this.msZyk = msZyk;
	}

	public MbBaust getMbBaust() {
		return this.mbBaust;
	}

	public void setMbBaust(MbBaust mbBaust) {
		this.mbBaust = mbBaust;
	}

	public MGsiegel getMGsiegel() {
		return this.MGsiegel;
	}

	public void setMGsiegel(MGsiegel MGsiegel) {
		this.MGsiegel = MGsiegel;
	}

	public MMetastatus getMMetastatus() {
		return this.MMetastatus;
	}

	public void setMMetastatus(MMetastatus MMetastatus) {
		this.MMetastatus = MMetastatus;
	}

	public Integer getPrio() {
		return this.prio;
	}

	public void setPrio(Integer prio) {
		this.prio = prio;
	}

	public Boolean getOpt() {
		return this.opt;
	}

	public void setOpt(Boolean opt) {
		this.opt = opt;
	}

	public Integer getReihenfolge() {
		return this.reihenfolge;
	}

	public void setReihenfolge(Integer reihenfolge) {
		this.reihenfolge = reihenfolge;
	}

	public int getMetaVers() {
		return this.metaVers;
	}

	public void setMetaVers(int metaVers) {
		this.metaVers = metaVers;
	}

	public Integer getObsoletVers() {
		return this.obsoletVers;
	}

	public void setObsoletVers(Integer obsoletVers) {
		this.obsoletVers = obsoletVers;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getLoeschDatum() {
		return this.loeschDatum;
	}

	public void setLoeschDatum(Date loeschDatum) {
		this.loeschDatum = loeschDatum;
	}

	public Byte getImpNeu() {
		return this.impNeu;
	}

	public void setImpNeu(Byte impNeu) {
		this.impNeu = impNeu;
	}

	public String getErfasstDurch() {
		return this.erfasstDurch;
	}

	public void setErfasstDurch(String erfasstDurch) {
		this.erfasstDurch = erfasstDurch;
	}

	public String getGeloeschtDurch() {
		return this.geloeschtDurch;
	}

	public void setGeloeschtDurch(String geloeschtDurch) {
		this.geloeschtDurch = geloeschtDurch;
	}

	public Integer getUsn() {
		return this.usn;
	}

	public void setUsn(Integer usn) {
		this.usn = usn;
	}

	public String getGuidOrg() {
		return this.guidOrg;
	}

	public void setGuidOrg(String guidOrg) {
		this.guidOrg = guidOrg;
	}

	public Set getMbBaustMassnGsiegelTxts() {
		return this.mbBaustMassnGsiegelTxts;
	}

	public void setMbBaustMassnGsiegelTxts(Set mbBaustMassnGsiegelTxts) {
		this.mbBaustMassnGsiegelTxts = mbBaustMassnGsiegelTxts;
	}

	public Set getMbPrioritaets() {
		return this.mbPrioritaets;
	}

	public void setMbPrioritaets(Set mbPrioritaets) {
		this.mbPrioritaets = mbPrioritaets;
	}

	public Set getMbB2mDels() {
		return this.mbB2mDels;
	}

	public void setMbB2mDels(Set mbB2mDels) {
		this.mbB2mDels = mbB2mDels;
	}

}
