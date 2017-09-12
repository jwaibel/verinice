package ITBP2VNA;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import ITBP2VNA.generated.implementationhint.Document.Safeguards;
import ITBP2VNA.generated.module.Document;
import ITBP2VNA.generated.module.Document.Description;
import ITBP2VNA.generated.module.Requirement;
import ITBP2VNA.generated.module.SpecificThreat;
import sernet.gs.ui.rcp.main.common.model.CnAElementFactory;
import sernet.gs.ui.rcp.main.common.model.CnAElementHome;
import sernet.verinice.interfaces.CnATreeElementBuildException;
import sernet.verinice.interfaces.CommandException;
import sernet.verinice.model.bp.elements.BpRequirement;
import sernet.verinice.model.bp.elements.BpThreat;
import sernet.verinice.model.bp.elements.ItNetwork;
import sernet.verinice.model.bp.elements.Safeguard;
import sernet.verinice.model.bp.groups.BpRequirementGroup;
import sernet.verinice.model.bp.groups.BpThreatGroup;
import sernet.verinice.model.bp.groups.SafeguardGroup;
import sernet.verinice.model.common.CnATreeElement;

/*******************************************************************************
 * Copyright (c) 2017 Sebastian Hagedorn.
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
 *     Sebastian Hagedorn sh[at]sernet.de - initial API and implementation
 ******************************************************************************/

/**
 * this tool transform the "New ITBP Compendium", first released in February of 2018 
 * to a vna-file, for the usage with verinice
 * 
 * @author Sebastian Hagedorn sh[at]sernet.de
 *
 */
public class NewITBPToVNA {

    private final static Logger LOG = Logger.getLogger(NewITBPToVNA.class);
    
    private final static Set<String> processIdentifierPrefixes;
    private final static Set<String> systemIdentifierPrefixes;
    
    private static String xmlRootDirectory = null;
    
    private static ItNetwork rootNetwork = null;
    
    private static BpRequirementGroup processReqGroup = null;
    private static BpRequirementGroup systemReqGroup = null;

    private static SafeguardGroup processSafeguardGroup = null;
    private static SafeguardGroup systemSafeguardGroup = null;

    private static BpThreatGroup processThreatGroup = null;
    private static BpThreatGroup systemThreatGroup = null;
    private static BpThreatGroup elementalThreatGroup = null;
    
    
    
    private static NewITBPToVNA instance;
    
    private final static String rootRequirementGroupName = "Bausteine/Anforderungen (GS-Kompendium";
    private final static String processRequirementGroupname = "Prozess-Bausteine";
    private final static String systemRequirementGroupname = "System-Bausteine";
    
    private final static String rootThreatGroupName = "Gefährdungen";
    private final static String elementalThreatGroupName = "Elementare Gefährdungen";
    private final static String specificThreatGroupName = "Spezifische Gefährdungen";
    private final static String specificProcessThreatGroupName = "Zu Prozess-Bausteinen";
    private final static String specificSystemThreatGroupName = "Zu System-Bausteinen";
    
    private final static String SUBDIRECTORY_MODULES = "bausteine";
    private final static String SUBDIRECTORY_MEDIA = "media";
    private final static String SUBDIRECTORY_THREATS = "elementare_gefaehrdungen_1";
    private final static String SUBDIRECTORY_IMPL_HINTS = "umsetzungshinweise";
    
    private static Set<String> addedThreats = new HashSet<>();
    private static Set<String> addedReqs = new HashSet<>();
    
    static {
        processIdentifierPrefixes = new HashSet<>();
        processIdentifierPrefixes.addAll(Arrays.asList(new String[] {
                "CON",
                "DER",
                "ISMS",
                "OPS",
                "ORP"
                
        }));
        systemIdentifierPrefixes = new HashSet<>();
        systemIdentifierPrefixes.addAll(Arrays.asList(new String[] {
                "APP",
                "IND",
                "INF",
                "NET",
                "SYS"
        }));
    }
    
    private NewITBPToVNA(String xmlRoot) {
        this.xmlRootDirectory = xmlRoot;
        try {
            rootNetwork = getRootItNetwork();
        } catch (CommandException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CnATreeElementBuildException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            run();
        } catch (CommandException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CnATreeElementBuildException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static void run() throws CommandException, CnATreeElementBuildException {
        Set<Document> modules = new HashSet<>();
        Set<ITBP2VNA.generated.thread.Document> threats = new HashSet<>();
        Set<ITBP2VNA.generated.implementationhint.Document> implementationHints = new HashSet<>();
        if (xmlRootDirectory == null || xmlRootDirectory.length() == 0) {
           LOG.error("Wrong number of arguments, please provide root-Directory to XML-Archive");
           return;
        } else {
            File rootDir = new File(xmlRootDirectory);
            if (rootDir.exists() && rootDir.isDirectory()) {
                File[] directories = rootDir.listFiles(new FileFilter() {
                    
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isDirectory();
                    }
                });
                File moduleDir = null;
                File threatDir = null;
                File implHintDir = null;
                File mediaDir = null;
                for (File subDirectory : directories) {
                    if (SUBDIRECTORY_IMPL_HINTS.equals(subDirectory.getName())) {
                        if (implHintDir != null) {
                            LOG.warn("more than one directory named:\t" + SUBDIRECTORY_IMPL_HINTS);
                        }
                        implHintDir = subDirectory;
                        
                    } else if (SUBDIRECTORY_MEDIA.equals(subDirectory.getName())) {
                        if (mediaDir != null) {
                            LOG.warn("more than one directory named:\t" + SUBDIRECTORY_MEDIA);
                        }
                        mediaDir = subDirectory;                        
                    } else if (SUBDIRECTORY_MODULES.equals(subDirectory.getName())) {
                        if (moduleDir != null) {
                            LOG.warn("more than one directory named:\t" + SUBDIRECTORY_MODULES);
                        }
                        moduleDir = subDirectory;
                    } else if (SUBDIRECTORY_THREATS.equals(subDirectory.getName())) {
                        if (threatDir != null) {
                            LOG.warn("more than one directory named:\t" + SUBDIRECTORY_THREATS);
                        }
                        threatDir = subDirectory;
                    }
                        
                }
                for (File xmlFile : getXMLFiles(moduleDir)) {
                    modules.add(ITBPParser.getInstance().parseModule(xmlFile));
                }
                for (File xmlFile : getXMLFiles(threatDir)) {
                    threats.add(ITBPParser.getInstance().parseThread(xmlFile));
                }
                for (File xmlFile : getXMLFiles(implHintDir)) {
                    implementationHints.add(ITBPParser.getInstance().parseImplementationHint(xmlFile));
                }
                
            }
        }
        LOG.debug("Successfully parsed modules:\t" + modules.size());
        LOG.debug("Successfully parsed threats:\t" + threats.size());
        LOG.debug("Successfully parsed implementation hints:\t" + implementationHints.size());
        
        prepareITNetwork();
        CnAElementHome.getInstance().update(getRootItNetwork());
        transferModules(modules);
        LOG.debug("Transformation of elements complete");
        CnAElementHome.getInstance().update(getRootItNetwork());
        createSafeguards(implementationHints);
        CnAElementHome.getInstance().update(getRootItNetwork());
        LOG.debug("ItNetwork updated");
    }

    private static List<File> getXMLFiles(File dir){
        File[] directories = dir.listFiles(new FileFilter() {
            
            @Override
            public boolean accept(File pathname) {
                return FilenameUtils.isExtension(pathname.getName(), "xml");
            }
        });
        return Arrays.asList(directories);
    }
    
    
    private static void prepareITNetwork() throws CommandException, CnATreeElementBuildException {

        BpRequirementGroup rootReqGroup = (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, getRootItNetwork());
        rootReqGroup.setTitel(rootRequirementGroupName);;
        
        systemReqGroup =  (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, rootReqGroup);
        processReqGroup =  (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, rootReqGroup);
        
        systemReqGroup.setTitel(systemRequirementGroupname);
        processReqGroup.setTitel(processRequirementGroupname);
        
        BpThreatGroup rootThreatGroup = null;
        SafeguardGroup safeguardRootGroup = null;
        for (CnATreeElement child : getRootItNetwork().getChildren()) {
            if (BpThreatGroup.TYPE_ID.equals(child.getTypeId())) {
                if (rootThreatGroup != null) {
                    LOG.warn("Found more than one root-Threat-Group");
                }
                rootThreatGroup = (BpThreatGroup) child;
            } else if (safeguardRootGroup.TYPE_ID.equals(child.getTypeId())) {
                if (safeguardRootGroup != null) {
                    LOG.warn("Found more than one root-Requirement-Group");
                }
                safeguardRootGroup = (SafeguardGroup) child;                
            }
        } 
        
        rootThreatGroup.setTitel(rootThreatGroupName);

        
        elementalThreatGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, rootThreatGroup);
        elementalThreatGroup.setTitel(elementalThreatGroupName);
        
        BpThreatGroup specificThreatGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, rootThreatGroup);
        specificThreatGroup.setTitel(specificThreatGroupName);
        
        processThreatGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, specificThreatGroup);
        processThreatGroup.setTitel(specificProcessThreatGroupName);
        
        systemThreatGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, specificThreatGroup);
        systemThreatGroup.setTitel(specificSystemThreatGroupName);
        
        processSafeguardGroup = (SafeguardGroup) createNewElement(SafeguardGroup.TYPE_ID, safeguardRootGroup);
        processSafeguardGroup.setTitel(systemRequirementGroupname);
        
        systemSafeguardGroup = (SafeguardGroup) createNewElement(SafeguardGroup.TYPE_ID, safeguardRootGroup);
        systemSafeguardGroup.setTitel(processRequirementGroupname);
        
        
        
        for (String name : systemIdentifierPrefixes ) {
            BpRequirementGroup group = (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, systemReqGroup);
            group.setTitel(name);
            
            BpThreatGroup tGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, systemThreatGroup);
            tGroup.setTitel(name);
            
            BpRequirementGroup sGroup = (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, systemSafeguardGroup);
            sGroup.setTitel(name);
            
        }
        
        
        for (String name : processIdentifierPrefixes ) {
            BpRequirementGroup group = (BpRequirementGroup) createNewElement(BpRequirementGroup.TYPE_ID, processReqGroup);
            group.setTitel(name);
            
            BpThreatGroup tGroup = (BpThreatGroup) createNewElement(BpThreatGroup.TYPE_ID, processThreatGroup);
            tGroup.setTitel(name);
            
            SafeguardGroup sGroup = (SafeguardGroup) createNewElement(SafeguardGroup.TYPE_ID, processSafeguardGroup);
            sGroup.setTitel(name);
        }
        
        
        
        
            
    }
    
    private static void createSafeguards(Set<ITBP2VNA.generated.implementationhint.Document> implementationHints) throws CommandException, CnATreeElementBuildException {
        
        Set<SafeguardGroup> subGroups = new HashSet<>(10);
        
        for (CnATreeElement child : systemSafeguardGroup.getChildren()) {
            if (SafeguardGroup.TYPE_ID.equals(child.getTypeId())) {
                subGroups.add((SafeguardGroup)child );
            }
        }
        
        for (CnATreeElement child : processSafeguardGroup.getChildren()) {
            if (SafeguardGroup.TYPE_ID.equals(child.getTypeId())) {
                subGroups.add((SafeguardGroup)child );
            }
        }
        
        for (ITBP2VNA.generated.implementationhint.Document bsiSafeguard : implementationHints) {
            SafeguardGroup parent = null;
            for (SafeguardGroup candidate : subGroups) {
                if (candidate.getTitle().startsWith(getIdentifierPrefix(bsiSafeguard.getIdentifier()))) {
                    parent = candidate;
                }
            }

            if (parent != null) {
                createSafeguardsForModule(bsiSafeguard.getSafeguards(), parent);
            } else {
                LOG.warn("Could not determine parent for :\t" + bsiSafeguard.getTitle());
            }
        }
    }
    
    private static void transferModules(Set<Document> modules) throws CommandException, CnATreeElementBuildException {

        for (Document bsiModule : modules) {
            if (rootNetwork != null) {
                String groupIdentifier = getIdentifierPrefix(bsiModule.getIdentifier());
                
                BpRequirementGroup parent = getRequirementParentGroup(groupIdentifier);
                
                if (! addedReqs.contains(bsiModule.getFullTitle())) {


                    BpRequirementGroup veriniceModule = (BpRequirementGroup)
                            CnAElementFactory.getInstance().saveNew(
                                    parent, BpRequirementGroup.TYPE_ID, null, false);
                    veriniceModule.setTitel(bsiModule.getFullTitle());
                    veriniceModule.setIdentifier(bsiModule.getIdentifier());
                    veriniceModule.setDescription(getModuleDescriptionText(bsiModule.getFullTitle(), 
                            bsiModule.getDescription()));
                    LOG.debug("Module : \t" + veriniceModule.getTitle()+ " created");
                    addedReqs.add(bsiModule.getFullTitle());
                    
                    createRequirementsForModule(bsiModule, veriniceModule);
                }



                
                for (SpecificThreat threat : bsiModule.getThreatScenario().getSpecificThreats().getSpecificThreat()) {



                    BpThreatGroup tParent = getSpecificThreatParentGroup(groupIdentifier);

                    String title = bsiModule.getIdentifier() + " " + threat.getHeadline();
                    
                    if (! addedThreats.contains(title)) {
                        
                        BpThreat veriniceThreat = (BpThreat) CnAElementFactory.getInstance().saveNew(tParent,
                                BpThreat.TYPE_ID, null, false);
                        veriniceThreat.setTitel(title);
                        veriniceThreat.setDescription(getAnyElementDescription(threat.getHeadline(), threat.getDescription().getAny()));
                        addedThreats.add(title);
                    }

                }

//                for (String threatIdentifier : bsiModule.getElementalThreats().getElementalThreat()) {
//                    DocumentType bsiThreat = null;
//                    for(DocumentType t : threats) {
//                        if (threatIdentifier.equals(t.getIdentifier())) {
//                            bsiThreat = t;
//                            break;
//                        }
//                    }
//                    if (! addedThreats.contains(bsiThreat.getFullTitle())) {
//                        BpThreat veriniceThreat = (BpThreat) CnAElementFactory.getInstance().saveNew(elementalThreatGroup,
//                                BpThreat.TYPE_ID, null, false);
//                        veriniceThreat.setTitel(bsiThreat.getFullTitle());
//                        veriniceThreat.setIdentifier(bsiThreat.getIdentifier());
//                        veriniceThreat.setAbbreviation("E");
//                        //                    veriniceThreat.setDescription(bsiThreat.getDescription());
//                        addedThreats.add(bsiThreat.getFullTitle());
//                        LOG.debug("Threat : \t" + veriniceThreat.getTitle()+ " created");
//                    }
//                }
            }
        }
    }
    
    /**
     * @param groupIdentifier
     */
    private static BpRequirementGroup getRequirementParentGroup(String groupIdentifier) {
        BpRequirementGroup group = null;
        
        if (systemIdentifierPrefixes.contains(groupIdentifier)) {
            
            for (CnATreeElement reqGroup : systemReqGroup.getChildren()) {
                if (reqGroup.getTypeId().equals(BpRequirementGroup.TYPE_ID) && reqGroup.getTitle().equals(groupIdentifier)) {
                    group = (BpRequirementGroup) reqGroup;
                    break;
                }
            }
            
        } else if (processIdentifierPrefixes.contains(groupIdentifier)) {
            for (CnATreeElement reqGroup : processReqGroup.getChildren()) {
                if (reqGroup.getTypeId().equals(BpRequirementGroup.TYPE_ID) && reqGroup.getTitle().equals(groupIdentifier)) {
                    group = (BpRequirementGroup) reqGroup;
                    break;
                }
            }
            
        }
        return group;
    }
    
    private static BpThreatGroup getSpecificThreatParentGroup(String groupIdentifier) {
        BpThreatGroup group = null;
        
        if (systemIdentifierPrefixes.contains(groupIdentifier)) {
            
            for (CnATreeElement threatGroup : systemThreatGroup.getChildren()) {
                if (threatGroup.getTypeId().equals(BpThreatGroup.TYPE_ID) && threatGroup.getTitle().equals(groupIdentifier)) {
                    group = (BpThreatGroup) threatGroup;
                    break;
                }
            }
            
        } else if (processIdentifierPrefixes.contains(groupIdentifier)) {
            for (CnATreeElement threatGroup : processThreatGroup.getChildren()) {
                if (threatGroup.getTypeId().equals(BpThreatGroup.TYPE_ID) && threatGroup.getTitle().equals(groupIdentifier)) {
                    group = (BpThreatGroup) threatGroup;
                    break;
                }
            }
            
        }
        return group;
    }
    
    private static String getIdentifierPrefix(String id) {
        if (id != null && id.length() >= 3 && id.contains(".")) {
            return id.substring(0, id.indexOf("."));
        } else return id;
    }

//    /**
//     * @param bsiModule
//     * @param parent
//     * @throws CommandException
//     * @throws CnATreeElementBuildException
//     */
//    private static void createRequirements(DocumentType bsiModule, BpRequirementGroup parent) throws CommandException, CnATreeElementBuildException {
//        for (RequirementType requirement : bsiModule.getRequirements().getBasicRequirements().getRequirement()) {
//            createRequirement(parent, requirement, "BASIC");
//        }
//        for (RequirementType requirement : bsiModule.getRequirements().getStandardRequirements().getRequirement()) {
//            createSafeguard(parent, requirement, "STANDARD");
//        }
//        for (RequirementType requirement : bsiModule.getRequirements().getHighLevelRequirements().getRequirement()) {
//            createSafeguard(parent, requirement, "HIGH");
//        }
//    }
    
    /**
     * @param bsiModule
     * @param parent
     * @throws CommandException
     * @throws CnATreeElementBuildException
     */
    private static void createSafeguardsForModule(Safeguards bsiModule, SafeguardGroup parent) throws CommandException, CnATreeElementBuildException {
        for (ITBP2VNA.generated.implementationhint.Safeguard bsiSafeguard : bsiModule.getBasicSafeguards().getSafeguard()) {
            createSafeguard(parent, bsiSafeguard, "BASIC");
        }
        for (ITBP2VNA.generated.implementationhint.Safeguard bsiSafeguard : bsiModule.getStandardSafeguards().getSafeguard()) {
            createSafeguard(parent, bsiSafeguard, "STANDARD");
        }
        for (ITBP2VNA.generated.implementationhint.Safeguard bsiSafeguard : bsiModule.getHighLevelSafeguards().getSafeguard()) {
            createSafeguard(parent, bsiSafeguard, "HIGH");
        }
    }

    @SuppressWarnings("unused")
    private static Safeguard createSafeguard(SafeguardGroup parent, 
            ITBP2VNA.generated.implementationhint.Safeguard bsiSafeguard, String qualifier) 
                    throws CommandException, CnATreeElementBuildException {
        Safeguard safeguard = (Safeguard) 
                CnAElementFactory.getInstance().saveNew(parent,
                        Safeguard.TYPE_ID, null, false);
        safeguard.setTitel(bsiSafeguard.getTitle());
        safeguard.setAbbreviation(bsiSafeguard.getIdentifier());
        safeguard.setIdentifier(bsiSafeguard.getIdentifier());
        safeguard.setDescription(getSafeGuardDescription(bsiSafeguard.getTitle(),
                bsiSafeguard.getDescription().getContent()));
        safeguard.setQualifier(qualifier);
        LOG.debug("Safeguard : \t"  + safeguard.getTitle() + "created ");
        return safeguard;
    }
    
    private static void createRequirementsForModule(Document bsiModule, BpRequirementGroup parent) throws CommandException, CnATreeElementBuildException {
        for (Requirement bsiRequirement : bsiModule.getRequirements().getBasicRequirements().getRequirement()) {
            createRequirement(parent, bsiRequirement, "BASIC");
        }
        for (Requirement bsiRequirement : bsiModule.getRequirements().getStandardRequirements().getRequirement()) {
            createRequirement(parent, bsiRequirement, "STANDARD");
        }
        for (Requirement bsiRequirement : bsiModule.getRequirements().getHighLevelRequirements().getRequirement()) {
            createRequirement(parent, bsiRequirement, "HIGH");
        }
        
    }

    private static BpRequirement createRequirement(BpRequirementGroup parent,
            Requirement bsiRequirement, String qualifier) throws CommandException, CnATreeElementBuildException {
        BpRequirement vRequirement = (BpRequirement)
                CnAElementFactory.getInstance().saveNew(parent,
                        BpRequirement.TYPE_ID, null, false);
        vRequirement.setTitel(bsiRequirement.getTitle());
        vRequirement.setIdentifier(bsiRequirement.getIdentifier());
        vRequirement.setDescription(getAnyElementDescription(bsiRequirement.getTitle(), bsiRequirement.getDescription().getAny()));
//        bsiRequirement.getResponsibleRoles(); // TODO
//        bsiRequirement.getCia(); // TODO
        vRequirement.setQualifier(qualifier);
        
        return vRequirement;
    }
    
    private static String getSafeGuardDescription(String title, List<Object> content) {
        StringBuilder sb = new StringBuilder();
        sb.append("<H1>").append(title).append("</H1>");
        for (Object element : content) {
            sb.append(element.toString());
        }
        
        return sb.toString();
    }
    
    
    private static String getAnyElementDescription(String title, List<Element> anyElements) {
        StringBuilder sb = new StringBuilder();
        sb.append("<H1>").append(title).append("</H1>");
        for (Element element : anyElements) {
            sb.append(element.toString());
        }
        
        return sb.toString();
    }
    
    private static String getModuleDescriptionText(String title, Description description) {
        StringBuilder sb = new StringBuilder();
        sb.append("<H1>").append(title).append("</H1>");
        if(description != null) {
            String introduction = (description.getIntroduction() != null ) 
                    ? description.getIntroduction() : null;
            String purpose = (description.getPurpose() != null ) 
                    ? description.getPurpose() : null;
            String differentiation = (description.getDifferentiation() != null ) 
                    ? description.getDifferentiation() : null;
            sb.append((introduction != null) ? introduction : "<p>No Introduction</p>");
            sb.append((purpose != null) ? purpose : "<p>No Purpose</p>");
            sb.append((differentiation != null) ? differentiation : "<p>No differentiation</p>");
        }
        return sb.toString();
    }
    
    private static ItNetwork getRootItNetwork() throws CommandException, CnATreeElementBuildException {
        if(rootNetwork == null) {
            rootNetwork = (ItNetwork)createNewElement(ItNetwork.TYPE_ID, CnAElementFactory.getInstance().getBpModel());
            rootNetwork.setTitel("IT-Grundschutz-Kompendium");
        } 
        return rootNetwork;
    }
    
    private static CnATreeElement createNewElement(String typeId, CnATreeElement container) 
            throws CommandException, CnATreeElementBuildException {
        LOG.debug("creating instanceof " + typeId);
        return CnAElementFactory.getInstance().saveNew(
                container,
                typeId, null, false);
    }
    
    
    public static NewITBPToVNA getInstance(String xmlRootDir) {
        if (instance == null) {
            instance = new NewITBPToVNA(xmlRootDir);
        }
        return instance;
    }
    
    
    

}
