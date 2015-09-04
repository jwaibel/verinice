package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysExport generated by hbm2java
 */
public class SysExport implements java.io.Serializable {

	private int expId;
	private Date timestamp;
	private SysImport sysImport;
	private short expUid;
	private String expTyp;
	private String expStatus;
	private int metaImpId;
	private String name;
	private String beschreibung;
	private Integer expTiefeMax;
	private String expSignaturQuelle;
	private String expSignaturZiel;
	private Date expDatumAnlage;
	private Date expDatumExport;
	private Date expDatumFrist;
	private Boolean expKomplett;
	private Date loeschDatum;
	private String geloeschtDurch;
	private String erstelltDurch;
	private Integer expOption;
	private Integer expTexttype;
	private boolean expGuid;
	private boolean expRol;
	private boolean expZa;
	private boolean expZ2z;
	private Set sysExportMases = new HashSet(0);
	private Set sysExportItvs = new HashSet(0);
	private Set sysExportBaus = new HashSet(0);
	private Set sysExportNotizs = new HashSet(0);
	private Set sysExportGefs = new HashSet(0);
	private Set sysExportZobs = new HashSet(0);
	private Set dtsTickets = new HashSet(0);
	private Set sysExportZoses = new HashSet(0);
	private Set sysExportZots = new HashSet(0);

	public SysExport() {
	}

	public SysExport(int expId, short expUid, String expTyp, String expStatus,
			int metaImpId, String name, String expSignaturQuelle,
			Date expDatumAnlage, boolean expGuid, boolean expRol,
			boolean expZa, boolean expZ2z) {
		this.expId = expId;
		this.expUid = expUid;
		this.expTyp = expTyp;
		this.expStatus = expStatus;
		this.metaImpId = metaImpId;
		this.name = name;
		this.expSignaturQuelle = expSignaturQuelle;
		this.expDatumAnlage = expDatumAnlage;
		this.expGuid = expGuid;
		this.expRol = expRol;
		this.expZa = expZa;
		this.expZ2z = expZ2z;
	}

	public SysExport(int expId, SysImport sysImport, short expUid,
			String expTyp, String expStatus, int metaImpId, String name,
			String beschreibung, Integer expTiefeMax, String expSignaturQuelle,
			String expSignaturZiel, Date expDatumAnlage, Date expDatumExport,
			Date expDatumFrist, Boolean expKomplett, Date loeschDatum,
			String geloeschtDurch, String erstelltDurch, Integer expOption,
			Integer expTexttype, boolean expGuid, boolean expRol,
			boolean expZa, boolean expZ2z, Set sysExportMases,
			Set sysExportItvs, Set sysExportBaus, Set sysExportNotizs,
			Set sysExportGefs, Set sysExportZobs, Set dtsTickets,
			Set sysExportZoses, Set sysExportZots) {
		this.expId = expId;
		this.sysImport = sysImport;
		this.expUid = expUid;
		this.expTyp = expTyp;
		this.expStatus = expStatus;
		this.metaImpId = metaImpId;
		this.name = name;
		this.beschreibung = beschreibung;
		this.expTiefeMax = expTiefeMax;
		this.expSignaturQuelle = expSignaturQuelle;
		this.expSignaturZiel = expSignaturZiel;
		this.expDatumAnlage = expDatumAnlage;
		this.expDatumExport = expDatumExport;
		this.expDatumFrist = expDatumFrist;
		this.expKomplett = expKomplett;
		this.loeschDatum = loeschDatum;
		this.geloeschtDurch = geloeschtDurch;
		this.erstelltDurch = erstelltDurch;
		this.expOption = expOption;
		this.expTexttype = expTexttype;
		this.expGuid = expGuid;
		this.expRol = expRol;
		this.expZa = expZa;
		this.expZ2z = expZ2z;
		this.sysExportMases = sysExportMases;
		this.sysExportItvs = sysExportItvs;
		this.sysExportBaus = sysExportBaus;
		this.sysExportNotizs = sysExportNotizs;
		this.sysExportGefs = sysExportGefs;
		this.sysExportZobs = sysExportZobs;
		this.dtsTickets = dtsTickets;
		this.sysExportZoses = sysExportZoses;
		this.sysExportZots = sysExportZots;
	}

	public int getExpId() {
		return this.expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public SysImport getSysImport() {
		return this.sysImport;
	}

	public void setSysImport(SysImport sysImport) {
		this.sysImport = sysImport;
	}

	public short getExpUid() {
		return this.expUid;
	}

	public void setExpUid(short expUid) {
		this.expUid = expUid;
	}

	public String getExpTyp() {
		return this.expTyp;
	}

	public void setExpTyp(String expTyp) {
		this.expTyp = expTyp;
	}

	public String getExpStatus() {
		return this.expStatus;
	}

	public void setExpStatus(String expStatus) {
		this.expStatus = expStatus;
	}

	public int getMetaImpId() {
		return this.metaImpId;
	}

	public void setMetaImpId(int metaImpId) {
		this.metaImpId = metaImpId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Integer getExpTiefeMax() {
		return this.expTiefeMax;
	}

	public void setExpTiefeMax(Integer expTiefeMax) {
		this.expTiefeMax = expTiefeMax;
	}

	public String getExpSignaturQuelle() {
		return this.expSignaturQuelle;
	}

	public void setExpSignaturQuelle(String expSignaturQuelle) {
		this.expSignaturQuelle = expSignaturQuelle;
	}

	public String getExpSignaturZiel() {
		return this.expSignaturZiel;
	}

	public void setExpSignaturZiel(String expSignaturZiel) {
		this.expSignaturZiel = expSignaturZiel;
	}

	public Date getExpDatumAnlage() {
		return this.expDatumAnlage;
	}

	public void setExpDatumAnlage(Date expDatumAnlage) {
		this.expDatumAnlage = expDatumAnlage;
	}

	public Date getExpDatumExport() {
		return this.expDatumExport;
	}

	public void setExpDatumExport(Date expDatumExport) {
		this.expDatumExport = expDatumExport;
	}

	public Date getExpDatumFrist() {
		return this.expDatumFrist;
	}

	public void setExpDatumFrist(Date expDatumFrist) {
		this.expDatumFrist = expDatumFrist;
	}

	public Boolean getExpKomplett() {
		return this.expKomplett;
	}

	public void setExpKomplett(Boolean expKomplett) {
		this.expKomplett = expKomplett;
	}

	public Date getLoeschDatum() {
		return this.loeschDatum;
	}

	public void setLoeschDatum(Date loeschDatum) {
		this.loeschDatum = loeschDatum;
	}

	public String getGeloeschtDurch() {
		return this.geloeschtDurch;
	}

	public void setGeloeschtDurch(String geloeschtDurch) {
		this.geloeschtDurch = geloeschtDurch;
	}

	public String getErstelltDurch() {
		return this.erstelltDurch;
	}

	public void setErstelltDurch(String erstelltDurch) {
		this.erstelltDurch = erstelltDurch;
	}

	public Integer getExpOption() {
		return this.expOption;
	}

	public void setExpOption(Integer expOption) {
		this.expOption = expOption;
	}

	public Integer getExpTexttype() {
		return this.expTexttype;
	}

	public void setExpTexttype(Integer expTexttype) {
		this.expTexttype = expTexttype;
	}

	public boolean isExpGuid() {
		return this.expGuid;
	}

	public void setExpGuid(boolean expGuid) {
		this.expGuid = expGuid;
	}

	public boolean isExpRol() {
		return this.expRol;
	}

	public void setExpRol(boolean expRol) {
		this.expRol = expRol;
	}

	public boolean isExpZa() {
		return this.expZa;
	}

	public void setExpZa(boolean expZa) {
		this.expZa = expZa;
	}

	public boolean isExpZ2z() {
		return this.expZ2z;
	}

	public void setExpZ2z(boolean expZ2z) {
		this.expZ2z = expZ2z;
	}

	public Set getSysExportMases() {
		return this.sysExportMases;
	}

	public void setSysExportMases(Set sysExportMases) {
		this.sysExportMases = sysExportMases;
	}

	public Set getSysExportItvs() {
		return this.sysExportItvs;
	}

	public void setSysExportItvs(Set sysExportItvs) {
		this.sysExportItvs = sysExportItvs;
	}

	public Set getSysExportBaus() {
		return this.sysExportBaus;
	}

	public void setSysExportBaus(Set sysExportBaus) {
		this.sysExportBaus = sysExportBaus;
	}

	public Set getSysExportNotizs() {
		return this.sysExportNotizs;
	}

	public void setSysExportNotizs(Set sysExportNotizs) {
		this.sysExportNotizs = sysExportNotizs;
	}

	public Set getSysExportGefs() {
		return this.sysExportGefs;
	}

	public void setSysExportGefs(Set sysExportGefs) {
		this.sysExportGefs = sysExportGefs;
	}

	public Set getSysExportZobs() {
		return this.sysExportZobs;
	}

	public void setSysExportZobs(Set sysExportZobs) {
		this.sysExportZobs = sysExportZobs;
	}

	public Set getDtsTickets() {
		return this.dtsTickets;
	}

	public void setDtsTickets(Set dtsTickets) {
		this.dtsTickets = dtsTickets;
	}

	public Set getSysExportZoses() {
		return this.sysExportZoses;
	}

	public void setSysExportZoses(Set sysExportZoses) {
		this.sysExportZoses = sysExportZoses;
	}

	public Set getSysExportZots() {
		return this.sysExportZots;
	}

	public void setSysExportZots(Set sysExportZots) {
		this.sysExportZots = sysExportZots;
	}

}
