/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class CalculateScoreTask extends Task {

    private IUser user;
    private IQuestionSet set;

    public CalculateScoreTask(IUser user, IQuestionSet set) {
        this.user = user;
        this.set = set;
    }

    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().calculateScore(user, set));
        } catch (IOException ex) {
            Logger.getLogger(CalculateScoreTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
