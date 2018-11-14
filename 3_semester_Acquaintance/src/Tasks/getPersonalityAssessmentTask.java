/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IUser;

/**
 *
 * @author ahmadhamid
 */
public class getPersonalityAssessmentTask extends Task {

    private IUser user;

    public getPersonalityAssessmentTask(IUser user) {
        super(TaskTypes.ASSESSMENT);
        this.user = user;
    }

    public IUser getUser() {
        return user;
    }

}
