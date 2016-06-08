/*******************************************************************************
 * Copyright (c) 2016 Sebastian Hagedorn.
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
package sernet.verinice.interfaces.report;

import java.security.Permission;

/**
 * Classes implementing this interface should help the 
 * report-security-management to decide how to handle
 * different kind of {@link Permission} inheriting classes
 *
 * @author Sebastian Hagedorn sh[at]sernet.de
 *
 */
public interface IReportPermissionHandler {
    
    public enum PermissionClassname { 
        REFLECT, RUNTIME, OSGI, PROPERTY, FILE, SOCKET, NET, OTHER, NULL
    }
    
    void handlePermission(Permission permission);

}
