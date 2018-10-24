/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverdomain;

import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;

/**
 *
 * @author Krongrah
 */
public class ServerDomainFacade implements IServerDomain {

    IServerPersistence persistence;

    @Override
    public void injectPersistence(IServerPersistence persistence) {
        this.persistence = persistence;
    }

}
