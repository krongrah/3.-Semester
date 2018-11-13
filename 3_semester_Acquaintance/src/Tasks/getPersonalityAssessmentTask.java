/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmadhamid
 */
public class getPersonalityAssessmentTask extends Task {
    private IUser user;

    public getPersonalityAssessmentTask(IUser user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().getPersonalityAssessment(user));
        } catch (IOException ex) {
            Logger.getLogger(getPersonalityAssessmentTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}