/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;

/**
 *
 * @author Sebas
 */
public class CalculateScoreTask extends Task implements Runnable {

    private IUser user;
    private IQuestionSet set;

    CalculateScoreTask(IUser user, IQuestionSet set) {
        this.user = user;
        this.set = set;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
