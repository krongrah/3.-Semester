package Tasks;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;

/**
 *
 * @author ahmadhamid
 */
public class RankingTask extends Task {

    private IJobPost jobPost;
    private IUser user;

    public RankingTask(IJobPost jobPost, IUser user) {
        super(TaskTypes.RANKING);
        this.jobPost = jobPost;
        this.user = user;
    }

    public IJobPost getJobPost() {
        return jobPost;
    }

    public IUser getUser() {
        return user;
    }

}
