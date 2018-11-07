/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import commondata.JobPost;
import java.io.Serializable;
import java.util.List;
import javax.crypto.SealedObject;

/**
 * The interface for the Server Domain
 *
 * @author Krongrah
 */
public interface IServerDomain {

    /**
     * The method for injecting the Server Persistence interface
     *
     * @param persistence
     */
    public void injectPersistence(IServerPersistence persistence);

    public SealedObject getUser(String username, String password);

    public IQuestionSet getQuestionSet();

    public void applyForJob(IJobPost jobpost, IUser applicant);

    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet);

    public SealedObject login(String username, String hashedPwd);

    public List<Integer> calculateScore(IUser user, IQuestionSet set);

    public List<JobPost> getAllJobs();

}
