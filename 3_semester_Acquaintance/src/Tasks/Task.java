/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IServerDomain;

/**
 *
 * @author Sebas
 */
public class Task {
    private IServerDomain sDomain;
    
    public void injectDomain(IServerDomain domain){
        this.sDomain = domain;
    }
    
    IServerDomain getDomain(){
        return sDomain;
    }
}
