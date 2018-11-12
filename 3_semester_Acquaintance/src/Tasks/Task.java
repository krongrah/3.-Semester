/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IServerDomain;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sebas
 */
public class Task {
    private IServerDomain sDomain;
    private ObjectOutputStream output;
    
    public void injectDomain(IServerDomain domain){
        this.sDomain = domain;
    }
    
    public void injectOutputStread(ObjectOutputStream output){
        this.output = output;
    }
    
    ObjectOutputStream getOutputStream(){
        return this.output;
    }   
    
    IServerDomain getDomain(){
        return sDomain;
    }
}
