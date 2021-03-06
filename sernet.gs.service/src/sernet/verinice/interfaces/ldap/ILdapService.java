package sernet.verinice.interfaces.ldap;

import java.util.List;

import sernet.verinice.model.common.Domain;
import sernet.verinice.service.ldap.PersonInfo;

public interface ILdapService {

    List<PersonInfo> getPersonList();

    List<PersonInfo> getPersonList(PersonParameter parameter);

    @Deprecated
    default List<PersonInfo> getPersonList(PersonParameter parameter, Domain importDomain) {
        return getPersonList(parameter);
    }
}
