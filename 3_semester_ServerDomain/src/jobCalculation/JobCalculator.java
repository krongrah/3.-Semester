/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobCalculation;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IUser;
import java.util.ArrayList;
import java.util.List;
import pkg3_semester_serverdomain.ServerDomainFacade;

/**
 *
 * @author ahmadhamid
 */
public class JobCalculator {

    public JobCalculator() {

    }
    
    public double calculateScore(IUser user, IJobPost jobPost) {
        double result = 0.0;
        
        //get pref Score
        IServerDomain domain = new ServerDomainFacade();
        List<Integer> prefScore = domain.getJobPrefScore(jobPost.getId());
        
        //get user Score
        // TODO: Implement calculated userScore
        List<Integer> userScore = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userScore.add((int) (10 + Math.random() * 40));
        }
        
        // calculation algorithm
        for (int i = 0; i < 10; i++) {
            double d = Math.abs(((prefScore.get(i) - userScore.get(i)) / 100));
            result += d;
        }
        
        System.out.println(result);
        
        return result;
    }
    
    public int addExperience(int i) {
        switch (i) {
            case 1:
                return 2;
                
            case 2:
                return 4;
                
            case 3:
                return 8;
                
            case 4:
                return 10;
                
            case 5:
                return 20;
                
            default:
                return 8;
            
        }
            
            
    }
    
}
