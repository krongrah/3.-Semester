/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;

/**
 *
 * @author ahmadhamid
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;

    @Override
    public void injectClientComm(IClientComm comm) {
        this.comm = comm;
    }
}
