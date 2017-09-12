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
package sernet.verinice.model.bp.groups;

import sernet.hui.common.connect.Entity;
import sernet.verinice.model.bp.IBpGroup;
import sernet.verinice.model.bp.elements.BpRequirement;
import sernet.verinice.model.common.CnATreeElement;
import sernet.verinice.model.iso27k.Group;

/**
 * 
 * this represents the ITBP Module
 * 
 * @author Sebastian Hagedorn sh[at]sernet.de
 */
public class BpRequirementGroup extends Group<BpRequirement> implements IBpGroup {
    
    private static final long serialVersionUID = 7752776589962581995L;
    
    public static final String TYPE_ID = "bp_requirement_group";
    
    private static final String PROP_DESC = "bp_requirement_group_desc"; //$NON-NLS-1$
    private static final String PROP_ID = "bp_requirement_group_id"; //$NON-NLS-1$
    
    private static final String PROP_NAME = "bp_requirement_group_name"; //$NON-NLS-1$
    
    public static final String[] CHILD_TYPES = new String[] {BpRequirement.TYPE_ID, BpRequirementGroup.TYPE_ID};
    
    protected BpRequirementGroup() {}
    
    public BpRequirementGroup(CnATreeElement parent) {
        super(parent);
        setEntity(new Entity(TYPE_ID));
        getEntity().initDefaultValues(getTypeFactory());
        // sets the localized title via HUITypeFactory from message bundle
        setTitel(getTypeFactory().getMessage(TYPE_ID));
    }

    @Override
    public String getTypeId() {
        return TYPE_ID;
    }
    
    @Override
    public boolean canContain(Object object) {
        return object instanceof BpRequirement;
    }
    
    @Override
    public String[] getChildTypes() {
        return CHILD_TYPES;
    }
    
    @Override
    public String getTitle() {
        return getEntity().getSimpleValue(PROP_NAME);
    }
    
    @Override
    public void setTitel(String title) {
        getEntity().setSimpleValue(getEntityType().getPropertyType(PROP_NAME), title);
    }
    
    public String getDescription() {
        return getEntity().getPropertyValue(PROP_DESC);
    }
    
    public void setDescription(String description) {
        getEntity().setSimpleValue(getEntityType().getPropertyType(PROP_DESC), description);
    }
    
    public String getIdentifier() {
        return getEntity().getPropertyValue(PROP_ID);
    }
    
    public void setIdentifier(String id) {
        getEntity().setSimpleValue(getEntityType().getPropertyType(PROP_ID), id);
    }

}
