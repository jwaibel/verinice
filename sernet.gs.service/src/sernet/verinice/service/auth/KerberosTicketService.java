/*******************************************************************************
 * Copyright (c) 2015 verinice.
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
 *     verinice <bw[at]sernet[dot]de> - initial API and implementation
 ******************************************************************************/
package sernet.verinice.service.auth;

/**
 * Interface for Kerberos authentification. Works only on Windows OS.
 * 
 * @author Benjamin Weißenfels <bw[at]sernet[dot]de>
 *
 */
public interface KerberosTicketService {

    /**
     * HTTP-Header parameter, which is send by the server for challenge to
     * authenticate.
     * 
     * For Kerberos-Authentification the header looks like this:
     * 
     * <pre>
     * <code>WWW AUTHENTICATE : Negotiate "hashcode"</code>
     * </pre>
     */
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";

    /**
     * HTTP-Header parameter, which is send by the client and is send by the
     * client. This contains the kerberos token, which is initially retrieved
     * from the windows client and after one round trip updated by the challenge
     * response from the server.
     */
    public static final String HEADER_NAME_AUTHORIZATION = "Authorization";

    public static final String SECURITY_PACKAGE = "NEGOTIATE";

    /**
     * Returns the initial TGS for verinice Kerberos authentification.
     *
     */
    public String getClientToken();

    /**
     * Under circumstances the server sends back an answer string, which is
     * calculated with initial client token and the server response.
     * 
     * @param serviceNegatiationAnswer
     *            The value of the server response parameter
     *            {@link #WWW_AUTHENTICATE}
     * @return Hopefully a valid TSG
     */
    public String updateClientToken(String serviceNegatiationAnswer);

}
