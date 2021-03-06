/*******************************************************************************
 * Copyright (c) 2010 Daniel Murygin <dm[at]sernet[dot]de>.
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *     This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *     You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Daniel Murygin <dm[at]sernet[dot]de> - initial API and implementation
 ******************************************************************************/
package sernet.verinice.rcp;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import sernet.gs.ui.rcp.main.ImageCache;
import sernet.gs.ui.rcp.main.common.model.CnAElementFactory;
import sernet.verinice.iso27k.rcp.action.HideEmptyFilter;
import sernet.verinice.model.common.TagParameter;
import sernet.verinice.model.common.TypeParameter;
import sernet.verinice.model.iso27k.Asset;
import sernet.verinice.model.iso27k.AssetGroup;
import sernet.verinice.model.iso27k.Audit;
import sernet.verinice.model.iso27k.AuditGroup;
import sernet.verinice.model.iso27k.Control;
import sernet.verinice.model.iso27k.ControlGroup;
import sernet.verinice.model.iso27k.Document;
import sernet.verinice.model.iso27k.DocumentGroup;
import sernet.verinice.model.iso27k.Evidence;
import sernet.verinice.model.iso27k.EvidenceGroup;
import sernet.verinice.model.iso27k.ExceptionGroup;
import sernet.verinice.model.iso27k.Finding;
import sernet.verinice.model.iso27k.FindingGroup;
import sernet.verinice.model.iso27k.Incident;
import sernet.verinice.model.iso27k.IncidentGroup;
import sernet.verinice.model.iso27k.IncidentScenario;
import sernet.verinice.model.iso27k.IncidentScenarioGroup;
import sernet.verinice.model.iso27k.Interview;
import sernet.verinice.model.iso27k.InterviewGroup;
import sernet.verinice.model.iso27k.PersonGroup;
import sernet.verinice.model.iso27k.PersonIso;
import sernet.verinice.model.iso27k.Process;
import sernet.verinice.model.iso27k.ProcessGroup;
import sernet.verinice.model.iso27k.Record;
import sernet.verinice.model.iso27k.RecordGroup;
import sernet.verinice.model.iso27k.Requirement;
import sernet.verinice.model.iso27k.RequirementGroup;
import sernet.verinice.model.iso27k.Response;
import sernet.verinice.model.iso27k.ResponseGroup;
import sernet.verinice.model.iso27k.Threat;
import sernet.verinice.model.iso27k.ThreatGroup;
import sernet.verinice.model.iso27k.Vulnerability;
import sernet.verinice.model.iso27k.VulnerabilityGroup;
import sernet.verinice.model.samt.SamtTopic;

/**
 * @author Daniel Murygin <dm[at]sernet[dot]de>
 * @author Alexander Ben Nasrallah an[at]sernet.de
 */
public class ViewFilterAction extends Action {

    private static final Logger LOG = Logger.getLogger(ViewFilterAction.class);

    public static final String[][] ISO_TYPES = new String[][] {
            new String[] { Asset.TYPE_ID, AssetGroup.TYPE_ID },
            new String[] { Audit.TYPE_ID, AuditGroup.TYPE_ID },
            new String[] { Control.TYPE_ID, ControlGroup.TYPE_ID },
            new String[] { SamtTopic.TYPE_ID, ControlGroup.TYPE_ID },
            new String[] { Document.TYPE_ID, DocumentGroup.TYPE_ID },
            new String[] { Evidence.TYPE_ID, EvidenceGroup.TYPE_ID },
            new String[] { sernet.verinice.model.iso27k.Exception.TYPE_ID, ExceptionGroup.TYPE_ID },
            new String[] { Finding.TYPE_ID, FindingGroup.TYPE_ID },
            new String[] { Incident.TYPE_ID, IncidentGroup.TYPE_ID },
            new String[] { Interview.TYPE_ID, InterviewGroup.TYPE_ID },
            new String[] { PersonIso.TYPE_ID, PersonGroup.TYPE_ID },
            new String[] { Process.TYPE_ID, ProcessGroup.TYPE_ID },
            new String[] { Record.TYPE_ID, RecordGroup.TYPE_ID },
            new String[] { Requirement.TYPE_ID, RequirementGroup.TYPE_ID },
            new String[] { Response.TYPE_ID, ResponseGroup.TYPE_ID },
            new String[] { IncidentScenario.TYPE_ID, IncidentScenarioGroup.TYPE_ID },
            new String[] { Threat.TYPE_ID, ThreatGroup.TYPE_ID },
            new String[] { Vulnerability.TYPE_ID, VulnerabilityGroup.TYPE_ID } };

    private String[][] types = ISO_TYPES;

    private TagParameter tagParameter;
    private HideEmptyFilter hideEmptyFilter;
    private TypeParameter typeParameter;

    public ViewFilterAction(String title, TagParameter tagFilter, HideEmptyFilter hideEmptyFilter,
            TypeParameter typeFilter) {
        super(title, SWT.TOGGLE);
        this.tagParameter = tagFilter;
        this.hideEmptyFilter = hideEmptyFilter;
        this.typeParameter = typeFilter;
        setImageDescriptor(ImageCache.getInstance().getImageDescriptor(ImageCache.FILTER));
        setUpCheckStatus();
    }

    public void setUpCheckStatus() {
        this.setChecked(tagParameter.isActive() || hideEmptyFilter.isActive());
    }

    @Override
    public void run() {
        ViewFilterDialog dialog = new ViewFilterDialog(Display.getCurrent().getActiveShell(), this);
        dialog.setTypes(types);
        if (dialog.open() == InputDialog.OK) {
            tagParameter.setPattern(dialog.getCheckedElements());
            tagParameter.setFilterOrgs(dialog.getFilterOrgs());
            hideEmptyFilter.setHideEmpty(dialog.getHideEmpty());
            typeParameter.setVisibleTypeSet(dialog.getVisibleTypes());
            try {
                PlatformUI.getWorkbench().getProgressService()
                        .busyCursorWhile(new IRunnableWithProgress() {
                            public void run(IProgressMonitor monitor)
                                    throws InvocationTargetException, InterruptedException {
                                monitor.beginTask("Activating filter...", IProgressMonitor.UNKNOWN);
                                CnAElementFactory.getInstance().reloadAllModelsFromDatabase();
                                monitor.done();
                            }
                        });
            } catch (Exception e) {
                LOG.error("Error while activating filter", e);
            }
        }
        setUpCheckStatus();
    }

    public TagParameter getTagParameter() {
        return tagParameter;
    }

    public HideEmptyFilter getHideEmptyFilter() {
        return hideEmptyFilter;
    }

    public TypeParameter getTypeParameter() {
        return typeParameter;
    }

    public String[][] getTypes() {
        return types;
    }

    public void setTypes(String[][] types) {
        this.types = types;
    }
}
