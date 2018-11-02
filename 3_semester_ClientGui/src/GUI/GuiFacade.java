/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.TheJobGUI;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import ProjectInterfaces.IJobPost;
import commondata.JobPost;
import java.util.List;

/**
 * Communcation layer, and Communcates with the 
 * domain layer
 * 
 *
 */
public class GuiFacade implements IClientGui {

    private TheJobGUI starter = new TheJobGUI();
    private static IClientDomain domain;
    private static IClientGui clientGui = null;

    @Override
    public void start(String[] args) {
        starter.launchGui(args);
    }

    @Override
    public void injectdomain(IClientDomain domain) {
        this.domain = domain;
        
    }

    public static IClientDomain getDomain() {
        return domain;
    }
    
    
    @Override
    public IClientGui getInstance() {
        if (clientGui == null) {
            clientGui = new GuiFacade();
        }
        return clientGui;
        
    }

    @Override
    public List<JobPost> getAllJobs() {
        return domain.getAllJobs();
    }
    
    

}
