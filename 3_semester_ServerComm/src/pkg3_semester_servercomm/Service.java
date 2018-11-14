package pkg3_semester_servercomm;

import ProjectInterfaces.IServerDomain;
import Tasks.AllJobsTask;
import Tasks.CalculateScoreTask;
import Tasks.JobApplyPersTask;
import Tasks.JobApplyTask;
import Tasks.LoginTask;
import Tasks.PersonalityAssessmentTask;
import Tasks.QuestionSetTask;
import Tasks.RankingTask;
import Tasks.Task;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class Service implements Runnable {

    private Boolean isLoggedOut;
    private IServerDomain domain;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Security security;

    Service(Socket socket, IServerDomain domain) {
        try {
            security = new Security();
            isLoggedOut = false;
            this.socket = socket;
            this.domain = domain;
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(security.getPublicKey());
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        try {
            //recieves the encrypted secretKey
            security.recieveSecretKey(inputStream.readObject());
            
            while (!isLoggedOut) {
                try {
                    //recieves a task from the client
                    Task task = (Task)inputStream.readObject();
                    //Runs code depending on which type of task is recieved.
                    
                    switch(task.getType()){
                        case LOGIN:
                            LoginTask loginTask=(LoginTask)task;
                            outputStream.writeObject(domain.login(loginTask.getUsername(), loginTask.gethPassword()));
                            break;
                        case LOGOUT:
                            logOut();
                            break;
                        case APPLY:
                            JobApplyTask jobTask=(JobApplyTask)task;
                            domain.applyForJob(jobTask.getJob(), jobTask.getUser());
                            break;
                        case APPLYPERS:
                            JobApplyPersTask jobPersTask=(JobApplyPersTask)task;
                            domain.applyForJob(jobPersTask.getJob(), jobPersTask.getUser(), jobPersTask.getSet());
                            break;
                        case CALC:
                            CalculateScoreTask calcTask=(CalculateScoreTask)task;
                            outputStream.writeObject(domain.calculateScore(calcTask.getUser(), calcTask.getSet()));
                            break;
                        case ALLJOBS:
                            AllJobsTask allJobsTask=(AllJobsTask)task;
                            outputStream.writeObject(domain.getAllJobs());
                            break;
                        case RANKING:
                            RankingTask rankingTask=(RankingTask)task;
                            outputStream.writeObject(domain.getRankings(rankingTask.getJobPost().getId(), rankingTask.getUser()));
                            break;
                        case ASSESSMENT:
                            PersonalityAssessmentTask assessmentTask=(PersonalityAssessmentTask)task;
                            outputStream.writeObject(domain.getPersonalityAssessment(assessmentTask.getUser()));
                            break;
                        case QUESTION:
                            QuestionSetTask questionTask=(QuestionSetTask)task;
                            outputStream.writeObject(domain.getQuestionSet());
                            break;
                            
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Closes the socket and ends the run-loop
     */
    public void logOut() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.isLoggedOut = true;

    }
}
