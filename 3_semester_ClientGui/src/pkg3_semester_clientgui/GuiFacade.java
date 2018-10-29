/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientgui;

import GUI.TheJobGUI;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;

/**
 * Communcation layer, and Communcates with the 
 * domain layer
 * 
 *
 */
public class GuiFacade implements IClientGui {

    private TheJobGUI starter = new TheJobGUI();
    private IClientDomain domain;
    private IClientGui clientGui = null;

    @Override
    public void start(String[] args) {
        starter.launchGui(args);
    }

    @Override
    public void injectdomain(IClientDomain domain) {
        this.domain = domain;
        
    }

    @Override
    public IClientDomain getDomain() {
        System.out.println("Domain called");
        return this.domain;
    }
    
    
    @Override
    public IClientGui getInstance() {
        if (clientGui == null) {
            clientGui = new GuiFacade();
            System.out.println("Getinstance GUI");
        }
        return clientGui;
        
    }
    
    

}
