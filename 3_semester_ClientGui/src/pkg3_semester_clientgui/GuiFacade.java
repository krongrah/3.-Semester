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

    @Override
    public void start(String[] args) {
        starter.launchGui(args);
    }

    @Override
    public void injectdomain(IClientDomain domain) {
        this.domain = domain;
        
    }

}
