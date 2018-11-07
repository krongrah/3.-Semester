/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import commondata.JobPost;
import java.util.List;
import javax.crypto.SealedObject;

/**
 * The interface for the Client communication
 *
 * @author Krongrah
 */
public interface IClientComm {

    public SealedObject login(String username, String hashedPwd);

    public void connectToServer();

    public List<JobPost> getAllJobs();

    public IQuestionSet getQuestionSet();

    public List<Integer> calculateScore(IUser user, IQuestionSet set);

    public void applyForJob(IUser user, IJobPost job);

    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet);
}
