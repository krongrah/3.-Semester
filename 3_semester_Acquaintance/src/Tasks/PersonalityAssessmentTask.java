package Tasks;

import ProjectInterfaces.IUser;

/**
 *
 * @author ahmadhamid
 */
public class PersonalityAssessmentTask extends Task {

    private IUser user;

    public PersonalityAssessmentTask(IUser user) {
        super(TaskTypes.ASSESSMENT);
        this.user = user;
    }

    public IUser getUser() {
        return user;
    }

}
