/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import ProjectInterfaces.IUserManager;
import SecuritySystem.SecuritySystemFacade;
import UserSystem.UserManager;
import commondata.JobPost;
import java.util.List;

/**
 * Communication between the other 2 layers, which are the GUI and the
 * ClientComm
 *
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;
    private IUserManager userManager;
    private IClientSecurity security;

   /* public static void main(String[] args) throws NoSuchAlgorithmException, IOException, NoSuchPaddingException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        IClientSecurity security = new SecuritySystemFacade();
        User user = new User("Dude", 24, false, "dude@gmail.com", 28891897, "Odensevej 12", "5200", "Odense", "Danmark", "Fyn");
        SealedObject seal = new SealedObject(user, security.getEncryptCipher()); //Made from a Serializable object. It's serializable content is encrypted.

        System.out.println("Original user: " + user.getUsername());
        System.out.println("Sealed: " + seal.toString());

        User decUser = (User) seal.getObject(security.getDecryptCipher());
        System.out.println("Decrypted: " + decUser.getUsername());
        //User decUser = (User) seal.getObject(security.getDecryptCipher());
        //System.out.println("Decrypted: " + decUser.toString());

    }*/
    
    public ClientDomainFacade(){
    security = new SecuritySystemFacade();
    }

    /**
     * Injects an instance of the Client Communication facade
     *
     * @param comm
     */
    @Override
    public void injectClientComm(IClientComm comm) {
        this.comm = comm;
        userManager = new UserManager(security, comm);
    }

    /**
     * Logs in the user, with a username and a password, the password is first
     * hashed using SHA-256.
     *
     * @param username
     * @param password
     * @return True if successful login, else returns false
     */
    @Override
    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }

    /**
     * Logs out the active user
     */
    @Override
    public void logout() {
        userManager.logout();
        comm.logout();
    }

    /**
     * Gets the active user in the system
     *
     * @return a IUser object
     */
    @Override
    public IUser getActiveUser() {
        return userManager.getActiveUser();
    }

    /**
     * Gets a boolean value of whether a user is logged in already
     *
     * @return true if a user is logged in, false if not.
     */
    @Override
    public boolean isLoggedIn() {
        return userManager.hasActiveUser();
    }

    @Override
    public List<JobPost> getAllJobs() {

        return comm.getAllJobs();
    }

    @Override
    public IQuestionSet getAllQuestions() {
        return comm.getQuestionSet();
    }

    @Override
    public void setExperience(int exp) {
        getActiveUser().setExperience(exp);
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        return comm.calculateScore(user, set);
    }

    /**
     * Used for the first application of a job. This is because, a user is
     * required to fill a personality assessment the fist time, not any other
     * times
     *
     * @param user
     * @param job
     * @param set
     */
    @Override
    public void applyForJob(IUser user, IJobPost job, IQuestionSet set) {
        comm.applyForJob(user, job, set);
        getActiveUser().setLastJob(job);
    }

    /**
     * Used for any applications after the first one
     *
     * @param user
     * @param job
     */
    @Override
    public void applyForJob(IUser user, IJobPost job) {
        comm.applyForJob(user, job);
        getActiveUser().setLastJob(job);
    }

    @Override
    public List<Integer> getPersonalityAssessment(IUser user) {
        return comm.getPersonalityAssessment(user);
    }

    @Override
    public int getRanking(IJobPost jobPost, IUser user) {
        int i = comm.getRanking(jobPost, user);
        return i;
    }

    @Override
    public void setUser(String fullName, String mail, String phonenr, String address, String country, String region, String city, String zipCode, String gender, String username, String password) {
        String hPassword = security.Hash(password);
        comm.setUser(fullName, mail, phonenr, address, country, region, city, zipCode, gender, username, hPassword);
        //userManager.login(username, password);
    }

}
