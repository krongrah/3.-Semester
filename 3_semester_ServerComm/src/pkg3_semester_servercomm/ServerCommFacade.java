/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;

/**
 *
 * @author Krongrah
 */
public class ServerCommFacade implements IServerComm {

    private IServerDomain domain;

    @Override
    public void injectDomain(IServerDomain domain) {
        this.domain = domain;
    }

    @Override
    public void startServer() {

    }

}
