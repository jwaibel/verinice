/*******************************************************************************
 * Copyright (c) 2013 Daniel Murygin.
 *
 * This program is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation, either version 3 
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,    
 * but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. 
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Daniel Murygin <dm[at]sernet[dot]de> - initial API and implementation
 ******************************************************************************/
package sernet.verinice.service.sync;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.bind.JAXB;

import de.sernet.sync.data.SyncData;
import de.sernet.sync.mapping.SyncMapping;
import de.sernet.sync.risk.Risk;
import de.sernet.sync.sync.SyncRequest;
import de.sernet.sync.sync.SyncRequest.SyncVnaSchemaVersion;

/**
 *
 *
 * @author Daniel Murygin <dm[at]sernet[dot]de>
 */
public class PureXml implements IVeriniceArchive, VnaSchemaChecker {

    private byte[] veriniceXml;

    private String sourceId;

    private SyncData syncData;

    private SyncMapping syncMapping;

    private SyncRequest sr;

    private SyncVnaSchemaVersion syncVnaSchemaVersion;

    public PureXml(byte[] veriniceXml) {
        super();
        setVeriniceXml(veriniceXml);
    }

    public PureXml() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.service.sync.IPureXml#getVeriniceXml()
     */
    @Override
    public byte[] getVeriniceXml() {
        return veriniceXml;
    }

    public void setVeriniceXml(byte[] veriniceXml) {
        this.veriniceXml = (veriniceXml != null) ? veriniceXml.clone() : null;
    }

    @Override
    public String getSourceId() {
        if (sourceId == null) {
            unmarshal();
        }
        return sourceId;
    }

    @Override
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public SyncData getSyncData() {
        if (syncData == null) {
            unmarshal();
        }
        return syncData;
    }

    @Override
    public void setSyncData(SyncData syncData) {
        this.syncData = syncData;
    }

    @Override
    public SyncMapping getSyncMapping() {
        if (syncMapping == null) {
            unmarshal();
        }
        return syncMapping;
    }

    @Override
    public void setSyncMapping(SyncMapping syncMapping) {
        this.syncMapping = syncMapping;
    }

    private void unmarshal() {
        sr = JAXB.unmarshal(new ByteArrayInputStream(getVeriniceXml()), SyncRequest.class);
        sourceId = sr.getSourceId();
        syncData = sr.getSyncData();
        syncMapping = sr.getSyncMapping();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * sernet.verinice.service.sync.IVeriniceArchive#getFileData(java.lang.String
     * )
     */
    @Override
    public byte[] getFileData(String fileName) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.service.sync.IVeriniceArchive#clear()
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getTempDirName() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.service.sync.IVeriniceArchive#getSyncRiskAnalysis()
     */
    @Override
    public Risk getSyncRiskAnalysis() {
        // always return null because risk analysis data is stored in a seperate
        // file in a VNA
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.service.sync.IVeriniceArchive#getRiskAnalysisXml()
     */
    @Override
    public byte[] getRiskAnalysisXml() {
        // always return null because risk analysis data is stored in a seperate
        // file in a VNA
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.service.sync.VnaSchemaChecker#checkVnaSchema()
     */
    @Override
    public void checkVnaSchema(VnaSchemaVersion vnaSchemaVersion) throws VnaSchemaException {

        if (sr == null) {
            unmarshal();
        }

        syncVnaSchemaVersion = sr.getSyncVnaSchemaVersion();

        // verinice versions which are older than 1.13 does not export schema
        // information. In order to support imports from older verinice versions
        // we skip the schema check.
        if (syncVnaSchemaVersion == null) {
            return;
        }

        String schemaVersion = vnaSchemaVersion.getVnaSchemaVersion();

        // lookup if the current verinice schema is listed in the compatible
        // versions.
        List<String> compatibleVersions = syncVnaSchemaVersion.getCompatibleVersions();
        for (String compatibleVersion : compatibleVersions) {
            if (schemaVersion.equals(compatibleVersion))
                return;
        }

        // lookup if the compatible schemas of the current verinice is listed in
        // the compatible versions of the vna.
        for(String compatibleSchemaVersion : vnaSchemaVersion.getCompatibleSchemaVersions()){
            for(String syncSchemaVersion : syncVnaSchemaVersion.getCompatibleVersions()){
                if (compatibleSchemaVersion.equals(syncSchemaVersion))
                    return;                
            }
        }

        throw new VnaSchemaException("No compatible version found!", 
                vnaSchemaVersion.getVnaSchemaVersion(), 
                syncVnaSchemaVersion.getCompatibleVersions());
    }
}
